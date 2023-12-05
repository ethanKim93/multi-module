package org.sample;


import lombok.RequiredArgsConstructor;
import org.sample.loader.event.FileWatcherImpl;
import org.sample.loader.event.port.FileWatcher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@RequiredArgsConstructor
@SpringBootApplication
public class LoaderModuleApplication implements CommandLineRunner {

    private final FileWatcher fileWatcher;

    public static void main(String[] args) {
        SpringApplication.run(LoaderModuleApplication.class, args);
    }

    //    public static void main(String[] args) throws IOException, InterruptedException {
//        try {
//            FileWatcher fileWatch = new FileWatcherImpl();
//            fileWatch.create("C:/TEST");
//            fileWatch.run();
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//    }
    @Override
    public void run(String... strings) throws Exception {

        FileWatcher fileWatch = new FileWatcherImpl();
        fileWatch.create("C:/TEST");
        fileWatch.run();
    }

}