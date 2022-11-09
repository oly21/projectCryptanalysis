package com.project.Cryptanalysis.programMethods.fileJob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class ReadingFile {
    public static String readingFileMethod (Path file) throws IOException {


        return Files.readString(file);
    }
}
