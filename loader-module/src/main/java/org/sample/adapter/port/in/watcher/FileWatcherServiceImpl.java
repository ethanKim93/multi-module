package org.sample.adapter.port.in.watcher;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class FileWatcherServiceImpl {
    private final FileWatcherFactory fileWatcherFactory;

    // Constructor injection of factory
    public FileWatcherServiceImpl(FileWatcherFactory fileWatcherFactory) {
        this.fileWatcherFactory = fileWatcherFactory;
    }

    @Async
    public void runAsyncWatcher(String path, String queueName) {
        FileWatcher watcher = fileWatcherFactory.createFileWatcher(path, queueName);
        watcher.run();
    }
}