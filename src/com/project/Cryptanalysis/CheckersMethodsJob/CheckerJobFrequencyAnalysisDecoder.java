package com.project.Cryptanalysis.CheckersMethodsJob;

import com.project.Cryptanalysis.programMethods.fileJob.WriterFile;
import com.project.Cryptanalysis.programMethods.fileJob.ReaderFile;
import com.project.Cryptanalysis.programMethods.*;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.DecoderByForce;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.FrequencyAnalysisDecoder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckerJobFrequencyAnalysisDecoder {


    public void checkJobFrequencyAnalysisDecoder(Path fileDecrypt) throws IOException {
        DecoderByForce decoderByForce = new DecoderByForce();
        PrinterArrayList printerArrayList = new PrinterArrayList();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> resultStringKeyFromMethod;
        String DecryptString = ReaderFile.readFile(fileDecrypt);
        final int FirstKey1;

        System.out.println(messageBox.STATISTICS_FILE_MESSAGE);
        Path fileAnalysis = Path.of(scanner.next());

        resultStringKeyFromMethod = new FrequencyAnalysisDecoder().frequencyAnalysisDecode(ReaderFile.readFile(fileAnalysis), DecryptString);
        FirstKey1 = Integer.parseInt(resultStringKeyFromMethod.get(1));

        printerArrayList.PrintArrayList(resultStringKeyFromMethod);

        int key1;
        while (!new CheckerUserDecoderScore().GetUserDecodingScore()) {
            key1 = Integer.parseInt(resultStringKeyFromMethod.get(1));
            if (key1 < 30) {
                key1++;
                resultStringKeyFromMethod = decoderByForce.DecodeByForce(DecryptString, key1);
                printerArrayList.PrintArrayList(resultStringKeyFromMethod);
            } else if (key1 > 0) {

                System.out.println(messageBox.PROGRAM_CONTINUES_JOB);
                key1 = FirstKey1;
                key1--;

                resultStringKeyFromMethod = decoderByForce.DecodeByForce(DecryptString, key1);
                printerArrayList.PrintArrayList(resultStringKeyFromMethod);
            }

        }

        WriterFile.WriteFileKey(resultStringKeyFromMethod.get(0), fileDecrypt, messageBox.NAME_METHOD_FREQUENCYANALYSISI,
                resultStringKeyFromMethod.get(1));
    }


}







