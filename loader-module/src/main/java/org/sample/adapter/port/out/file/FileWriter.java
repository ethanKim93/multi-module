package org.sample.adapter.port.out.file;

import java.io.File;
import java.io.IOException;

public class FileWriter {

    public void writeResultFile(String filePath) {
        try {
            // 파일 객체 생성
            File file = new File(filePath);

            // 파일이 존재하지 않으면 새로 생성
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
