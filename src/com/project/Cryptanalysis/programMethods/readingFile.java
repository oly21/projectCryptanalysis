package com.project.Cryptanalysis.programMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class readingFile {
    public static String readingFileMethod (Path file) throws IOException {


        return Files.readString(file);
    }
}
