package com.project.Cryptanalysis.programMethods.Handlers;

import com.project.Cryptanalysis.CheckersMethodsJob.*;

import com.project.Cryptanalysis.programMethods.Converter;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.*;
import com.project.Cryptanalysis.programMethods.fileJob.ReaderFile;
import com.project.Cryptanalysis.programMethods.fileJob.WriterFile;
import com.project.Cryptanalysis.programMethods.messageBox;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;



public class CommandHandler {

    private String commandName;
    private String originalString;
    int key;
    private Path file;

    public void argumentHandle(String commandName, String filePath, String keyString) throws IOException {

        if (!commandName.equals(messageBox.NAME_METHOD_ENCODE)
                && !commandName.equals(messageBox.NAME_METHOD_DECODE)
                && !commandName.equals(messageBox.NAME_METHOD_BRUTEFORCE)
                && !commandName.equals(messageBox.NAME_METHOD_FREQUENCYANALYSISI)) {

                 System.out.println(messageBox.WRONG_COMMAND_NAME);
                 throw new IOException();
        }

        this.commandName = commandName;

        if (commandName.equals(messageBox.NAME_METHOD_ENCODE)
                && keyString == null
                || commandName.equals(messageBox.NAME_METHOD_DECODE)
                && keyString == null) {

                System.out.println(messageBox.FORGOT_WRIGHT_KEY);
                throw new IOException();
        }

        else if (commandName.equals(messageBox.NAME_METHOD_BRUTEFORCE)
                && keyString == null
                || commandName.equals(messageBox.NAME_METHOD_FREQUENCYANALYSISI)
                && keyString == null) {


        }

        else if (commandName.equals(messageBox.NAME_METHOD_ENCODE)
                && keyString != null
                || commandName.equals(messageBox.NAME_METHOD_DECODE)
                && keyString != null) {

                key = Integer.parseInt(keyString);
        }


        try {
               file = Path.of(filePath);
               originalString = ReaderFile.readFile(file);
        } catch (Exception e) {
               System.out.println(messageBox.WRONG_FILE_PATH);
               throw new IOException();
        }
    }

    public void handleCommand(String CommandName, String filePath, String keyString) throws IOException {
        String resultString;
        argumentHandle(CommandName, filePath, keyString);
        ArrayList<String> resultStringKeyFromMethod;

        if (key >= 30) {
            System.out.println(messageBox.KEY_LIMIT);
        } else {
            int taskNumber = Converter.convertNameTask(CommandName);
            if (taskNumber == 1) {
                Encoder encoder = new Encoder();
                resultString = encoder.encode(originalString, key);
                WriterFile.WriteFile(resultString, file, messageBox.NAME_METHOD_ENCODE);
                System.out.println(resultString);

            } else if (taskNumber == 2) {
                Decoder decoder = new Decoder();
                resultString = decoder.decode(originalString, key);
                WriterFile.WriteFile(resultString, file, messageBox.NAME_METHOD_DECODE);
                System.out.println(resultString);
            } else if (taskNumber == 3) {
                CheckerJobDecoderByForce checkerJobDecoderByForce = new CheckerJobDecoderByForce();
                resultStringKeyFromMethod =  checkerJobDecoderByForce.checkJobDecoderByForce(file);
                WriterFile.WriteFileKey(resultStringKeyFromMethod.get(0), file, messageBox.NAME_METHOD_BRUTEFORCE,
                        resultStringKeyFromMethod.get(1));

            }


            else if (taskNumber == 4) {
                CheckerJobFrequencyAnalysisDecoder checkerJobFrequencyAnalysisDecoder = new CheckerJobFrequencyAnalysisDecoder();
                resultStringKeyFromMethod = checkerJobFrequencyAnalysisDecoder.checkJobFrequencyAnalysisDecoder(file);
                WriterFile.WriteFileKey(resultStringKeyFromMethod.get(0), file, messageBox.NAME_METHOD_FREQUENCYANALYSISI,
                        resultStringKeyFromMethod.get(1));
            }

        }
    }
}