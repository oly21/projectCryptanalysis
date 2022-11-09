package com.project.Cryptanalysis.StartMethods;

import com.project.Cryptanalysis.programMethods.messageBox;
import com.project.Cryptanalysis.programMethods.Сonverter;

import java.io.IOException;
import java.nio.file.Path;


public class StartProgram {
    StartAllStartMethods startAllStartMethods = new StartAllStartMethods();
    Сonverter сonverter = new Сonverter();

    public void StartProgramMethod(String nameTask, String StringDecrypt, String keyString) throws IOException {

        int key = Integer.parseInt(keyString);
        Path file = Path.of(StringDecrypt);

        if (key >= 30) {
            System.out.println(messageBox.KEY_LIMIT);
        } else {

            int taskNumber = сonverter.converternameTaskMethod(nameTask);
            startAllStartMethods.StartingAllStartMethods(taskNumber, key, file);

        }
    }
}