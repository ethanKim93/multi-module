package org.sample.adapter.port.in.watcher;

import org.springframework.scheduling.annotation.Async;


public interface FileWatcher {

    public void initWatchService(String watcherPath, String queueName);

    @Async
    public void run();

}
