package org.sample.adapter.port.in.watcher;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.nio.file.WatchEvent.Kind;

//@RequiredArgsConstructor
@Service
public class FileWatcherImpl implements FileWatcher {
    private WatchService watchService;
    //    private String filePath;
    private Path path;

    public void create(String filePath) {
        try {
            watchService = FileSystems.getDefault().newWatchService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        path = Paths.get(filePath);

        try {
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

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
                    System.out.println("생성 : " + pth.getFileName());
                } else if (kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {
                    //파일이 삭제되었을 때 실행되는 코드
                    System.out.println("삭제 : " + pth.getFileName());
                } else if (kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
                    //파일이 수정되었을 때 실행되는 코드
                    System.out.println("수정 : " + pth.getFileName());
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