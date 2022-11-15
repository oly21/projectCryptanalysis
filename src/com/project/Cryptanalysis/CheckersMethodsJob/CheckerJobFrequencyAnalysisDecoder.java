package com.project.Cryptanalysis.CheckersMethodsJob;


import com.project.Cryptanalysis.programMethods.fileJob.ReaderFile;
import com.project.Cryptanalysis.programMethods.*;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.DecoderByForce;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.FrequencyAnalysisDecoder;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckerJobFrequencyAnalysisDecoder {


    public ArrayList<String> checkJobFrequencyAnalysisDecoder(Path fileDecrypt) throws IOException {
        DecoderByForce decoderByForce = new DecoderByForce();
        PrinterArrayList printerArrayList = new PrinterArrayList();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> resultStringKeyFromMethod;
        String originalString = ReaderFile.readFile(fileDecrypt);
        final int FirstKey;
        int limitKey = 0;
        boolean alreadyReceivedFirstKey = false;
        System.out.println(messageBox.STATISTICS_FILE_MESSAGE);
        Path fileAnalysis = Path.of(scanner.next());
        resultStringKeyFromMethod = new FrequencyAnalysisDecoder().frequencyAnalysisDecode(ReaderFile.readFile(fileAnalysis), originalString);


        String decodedString = resultStringKeyFromMethod.get(0);
        FirstKey = Integer.parseInt(resultStringKeyFromMethod.get(1));

        printerArrayList.PrintArrayList(resultStringKeyFromMethod);
        int key;

        while (!new CheckerUserDecoderScore().GetUserDecodingScore()) {

            key = Integer.parseInt(resultStringKeyFromMethod.get(1));

            if (key < 30 && limitKey == 0) {
                if (key == 29) {
                    limitKey++;
                }
                if (key < 30) {
                    key++;
                    resultStringKeyFromMethod = decoderByForce.decodeByForce(decodedString, key);
                    printerArrayList.PrintArrayList(resultStringKeyFromMethod);
                }
            } else if (key > 0 && limitKey > 0) {

                if (!alreadyReceivedFirstKey) {
                    key = FirstKey;
                    alreadyReceivedFirstKey = true;
                }

                System.out.println(messageBox.PROGRAM_CONTINUES_JOB);
                key--;
                resultStringKeyFromMethod = decoderByForce.decodeByForce(decodedString, key);
                printerArrayList.PrintArrayList(resultStringKeyFromMethod);
            }

        }


        return resultStringKeyFromMethod;
    }
}







