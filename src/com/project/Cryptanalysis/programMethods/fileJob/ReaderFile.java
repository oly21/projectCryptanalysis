package com.project.Cryptanalysis.programMethods.fileJob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class ReaderFile {
    public static String readFile (Path file) throws IOException {

        return Files.readString(file);
    }
}
