package org.sample.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ImageJob implements Job {
    @Override
    public void execute() {
        System.out.println("Image Job Execute");
        getImageMaxLength();
    }

    private void getImageMaxLength() {
        try {
            BufferedImage image1 = ImageIO.read(new File("C:\\aa\\aa.jpg"));
            BufferedImage image2 = ImageIO.read(new File("D:\\aa\\aa.jpg"));
            // 새 이미지의 너비와 높이 계산
            int width = image1.getWidth() + image2.getWidth();
            int height = Math.max(image1.getHeight(), image2.getHeight());

            // 새 이미지 생성
            BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Graphics2D 객체를 사용하여 이미지 그리기
            Graphics2D g = combined.createGraphics();
            g.drawImage(image1, 0, 0, null);
            g.drawImage(image2, image1.getWidth(), 0, null);
            g.dispose();

            // 결과 이미지 저장
            ImageIO.write(combined, "jpg", new File("D:\\aa\\cc.jpg"));

        } catch (IOException e) {
            log.error(e.toString());
        }
        ;

    }
}
