package com.ivanmix.resume.component;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by ivan on 28.06.2016.
 */
public interface ImageComponent {

    void PngToJpeg(Path inPath, Path outPath) throws IOException;

    String getBigImageName();

    String getSmallImageName(String bigImage);

    Path getUploadPath(String bigImageUrl);
}
