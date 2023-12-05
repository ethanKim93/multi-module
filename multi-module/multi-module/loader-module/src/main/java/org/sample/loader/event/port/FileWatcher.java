package org.sample.loader.event.port;

import java.io.IOException;

public interface FileWatcher {

    public void create(String filePath);

    public void run();

}
