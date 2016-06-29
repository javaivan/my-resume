package com.ivanmix.resume.component.impl;

import com.ivanmix.resume.component.ImageComponent;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Component
public class ImageComponentImpl implements ImageComponent{

    @Override
    public void PngToJpeg(Path inPath, Path outPath) throws IOException {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(inPath.toFile());
            BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
            ImageIO.write(newBufferedImage, "jpq", outPath.toFile());
        } finally {
            if(bufferedImage != null)
                bufferedImage.flush();
        }
    }

    @Override
    public String getBigImageName() {
        return UUID.randomUUID().toString() + ".jpg";
    }

    @Override
    public String getSmallImageName(String bigImage) {
        return bigImage.replace(".jpg", "-sm.jpg");
    }


}
