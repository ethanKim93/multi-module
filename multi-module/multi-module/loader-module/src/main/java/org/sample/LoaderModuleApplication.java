package org.sample;


import org.sample.loader.event.FileWatcherImpl;
import org.sample.loader.event.port.FileWatcher;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LoaderModuleApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            FileWatcher fileWatch = new FileWatcherImpl();
            fileWatch.create("C:/TEST");
            fileWatch.run();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}