package org.sample.adapter.port.in.watcher;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sample.adapter.port.out.messageQue.MqProducer;
import org.sample.adapter.port.out.messageQue.TestProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.nio.file.WatchEvent.Kind;

//@RequiredArgsConstructor
@Service
@RequiredArgsConstructor
public class FileWatcherImpl implements FileWatcher {
    private WatchService watchService;
    private String queueName;
    private final MqProducer mqProducer;

    @Override
    public void initWatchService(String watcherPath, String queueName) {
        this.queueName = queueName;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(watcherPath);
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE
//                    StandardWatchEventKinds.ENTRY_DELETE,
//                    StandardWatchEventKinds.ENTRY_MODIFY
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//
//    @Override
//    public FileWatcher getInstance() {
//        return new FileWatcherImpl();
//    }

    @Async
    public void run() {

        while (true) {
            WatchKey key = null;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            List<WatchEvent<?>> list = key.pollEvents(); //이벤트를 받을 때까지 대기
            for (WatchEvent<?> event : list) {

                Kind<?> kind = event.kind();
                Path pth = (Path) event.context();
                if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
                    //파일이 생성되었을 때 실행되는 코드
                    System.out.println("파일 생성 감지 : " + pth.getFileName());
                    mqProducer.sendMqMessage(queueName, "watcher");
                } else if (kind.equals(StandardWatchEventKinds.OVERFLOW)) {
                    //운영체제에서 이벤트가 소실되었거나 버려질 경우 실행되는 코드
                    System.out.println("OVERFLOW");
                }
            }
            if (!key.reset()) break; //키 리셋
        }
        try {
            watchService.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
