package org.sample;


import org.sample.adapter.port.in.watcher.FileWatcherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.sample.adapter.port.in.watcher.FileWatcher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@RequiredArgsConstructor
@EnableAsync
@SpringBootApplication
public class LoaderModuleApplication implements CommandLineRunner {

    //    private final FileWatcher fileWatcher;
    private final FileWatcherServiceImpl fileWatcherService;

    // Constructor injection

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

        fileWatcherService.runAsyncWatcher("C:/WATCHER_TEST/BP_TEST", "TEST_BP");
        fileWatcherService.runAsyncWatcher("C:/WATCHER_TEST/EVEN_TEST", "TEST_EVEN");
        fileWatcherService.runAsyncWatcher("C:/WATCHER_TEST/ADC_TEST", "ADC_QUEUE_OUT");

        fileWatcherService.runAsyncWatcher("C:/WATCHER_TEST/REVIEW_TEST", "REVIEW_CLIENT_QUEUE");
        fileWatcherService.runAsyncWatcher("C:/WATCHER_TEST/DL_TEST", "DL_QUEUE_OUT");

//        fileWatcherService.runAsyncWatcher("C:/WATCHER_TEST/REVIEW_TEST", "REVIEW_CLIENT_QUEUE");

//        FileWatcher bpFileWatch = fileWatcher.create("C:/WATCHER_TEST/BP_TEST");
//        FileWatcher evenFileWatch = fileWatcher.create("C:/WATCHER_TEST/EVEN_TEST");
//        FileWatcher adcFileWatch = fileWatcher.create("C:/WATCHER_TEST/ADC_TEST");
//        FileWatcher dlFileWatch = fileWatcher.create("C:/WATCHER_TEST/DL_TEST");

//        bpFileWatch.run();
//        evenFileWatch.run();
//        adcFileWatch.run();
//        dlFileWatch.run();


    }

}