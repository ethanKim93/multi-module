package org.sample.loader.event.port;

import java.io.IOException;

public interface FileWatcher {

    public void create(String filePath) throws IOException;

    public void run() throws IOException, InterruptedException;

}
