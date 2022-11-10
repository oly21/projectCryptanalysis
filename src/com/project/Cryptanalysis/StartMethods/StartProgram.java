package com.project.Cryptanalysis.StartMethods;

import com.project.Cryptanalysis.programMethods.messageBox;
import com.project.Cryptanalysis.programMethods.Converter;

import java.io.IOException;
import java.nio.file.Path;


public class StartProgram {
    private final StartAllStartMethods startAllStartMethods = new StartAllStartMethods();
    private final Converter converter = new Converter();

    public void StartProgramMethod(String nameTask, String StringDecrypt, String keyString) throws IOException {

        int key = Integer.parseInt(keyString);
        Path file = Path.of(StringDecrypt);

        if (key >= 30) {
            System.out.println(messageBox.KEY_LIMIT);
        } else {

            int taskNumber = converter.converternameTaskMethod(nameTask);
            startAllStartMethods.StartingAllStartMethods(taskNumber, key, file);

        }
    }
}