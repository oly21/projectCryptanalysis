package com.project.Cryptanalysis;

import com.project.Cryptanalysis.programMethods.*;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.*;
import com.project.Cryptanalysis.programMethods.fileJob.*;
import com.project.Cryptanalysis.CheckersMethodsJob.*;

import java.io.IOException;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        int key = Integer.parseInt(args[2]);
        Path file = Path.of(args[1]);
        String StringDecrypt = ReaderFile.readFile(file);
        String resultString;

        if (key >= 30) {
            System.out.println(messageBox.KEY_LIMIT);
        } else {
            int taskNumber = new Converter().convertnameTask(args[0]);
            if (taskNumber == 1) {
                Encoder encoder = new Encoder();
                resultString = encoder.encode(StringDecrypt, key);
                WriterFile.WriteFile(resultString, file, messageBox.NAME_METHOD_ENCODE);
                System.out.println(resultString);

            } else if (taskNumber == 2) {
                Decoder decoder = new Decoder();
                resultString = decoder.decode(StringDecrypt, key);
                WriterFile.WriteFile(resultString, file, messageBox.NAME_METHOD_DECODE);
                System.out.println(resultString);
            } else if (taskNumber == 3) {
                CheckerJobDecoderByForce checkerJobDecoderByForce = new CheckerJobDecoderByForce();
                checkerJobDecoderByForce.checkJobDecoderByForce(file);
            } else if (taskNumber == 4) {
                CheckerJobFrequencyAnalysisDecoder checkerJobFrequencyAnalysisDecoder =
               new CheckerJobFrequencyAnalysisDecoder();
                checkerJobFrequencyAnalysisDecoder.checkJobFrequencyAnalysisDecoder(file);

            }


        }
    }

}






