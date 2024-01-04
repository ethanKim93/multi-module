package org.sample.adapter.port.in.watcher;

import lombok.RequiredArgsConstructor;
import org.sample.adapter.port.in.watcher.FileWatcher;
import org.sample.adapter.port.in.watcher.FileWatcherImpl;
import org.sample.adapter.port.out.messageQue.MqProducer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileWatcherFactory {
    private final MqProducer mqProducer;

    public FileWatcher createFileWatcher(String filePath, String queueName) {
        FileWatcher fileWatcher = new FileWatcherImpl(mqProducer);
        fileWatcher.initWatchService(filePath, queueName);
        return fileWatcher;
    }
}