package com.project.Cryptanalysis.programMethods.fileJob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterFile {
    public static void WriteFile(String resultString, Path originalFile, String nameMethod) throws IOException {

        String fileName = originalFile.getFileName().toString();
        String filePathWithoutFileName = originalFile.getParent().toString();
        String fileNameResult;

        if (fileName.contains("(")) {
            fileName = fileName.replaceAll("(.+?)\\([a-zA-Z]*\\)\\.(.+?)", "$1(" + nameMethod + ").$2");
            fileNameResult = filePathWithoutFileName + "/" + fileName;
        } else {

            fileName = fileName.replaceAll("(.+?)\\.(.+?)", "$1(" + nameMethod + ").$2");
            fileNameResult = filePathWithoutFileName + "/" + fileName;
        }

        Path fileResultPath = Path.of(fileNameResult);

        if (Files.exists(fileResultPath)) {
            Files.delete(fileResultPath);
            Files.createFile(fileResultPath);
        } else {
            Files.createFile(fileResultPath);
        }
        Files.writeString(fileResultPath, resultString);
    }


    public static void WriteFileKey(String resultString, Path originalFile, String nameMethod, String key) throws IOException {

        String fileName = originalFile.getFileName().toString();
        String filePathWithoutFileName = originalFile.getParent().toString();
        String fileNameResult;

        if (fileName.contains("(")) {
            fileName = fileName.replaceAll("(.+?)\\([a-zA-Z]*\\)\\.(.+?)", "$1(" + nameMethod + key + ").$2");
            fileNameResult = filePathWithoutFileName + "/" + fileName;

        } else {

            fileName = fileName.replaceAll("(.+?)\\.(.+?)", "$1(" + nameMethod + key + ").$2");

            fileNameResult = filePathWithoutFileName + "/" + fileName;

        }

        Path fileResultPath = Path.of(fileNameResult);


        if (Files.exists(fileResultPath)) {

            Files.delete(fileResultPath);
            Files.createFile(fileResultPath);
        } else {
            Files.createFile(fileResultPath);
        }
        Files.writeString(fileResultPath, resultString);

    }

}