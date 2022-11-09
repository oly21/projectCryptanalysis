package com.project.Cryptanalysis.StartMethods;

import com.project.Cryptanalysis.programMethods.fileJob.FileWrite;
import com.project.Cryptanalysis.programMethods.fileJob.ReadingFile;
import com.project.Cryptanalysis.programMethods.*;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.DecryptionByForce;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.FrequencyAnalysis;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class StartFrequencyAnalysis {
    UserDecodingScore userDecodingScore = new UserDecodingScore();
    FrequencyAnalysis frequencyAnalysis = new FrequencyAnalysis();
    DecryptionByForce decryptionByForce = new DecryptionByForce();
    PrintList printList = new PrintList();
    Scanner scanner = new Scanner(System.in);

    public void StartFrequencyAnalysisMethod(Path fileDecrypt) throws IOException {
        ArrayList<String> resultStringKeyFromMethod;
        final int FirstKey1;

        System.out.println(messageBox.STATISTICS_FILE_MESSAGE);
        Path fileAnalysis = Path.of(scanner.next());

        resultStringKeyFromMethod = frequencyAnalysis.frequencyAnalysisString(ReadingFile.readingFileMethod(fileAnalysis), ReadingFile.readingFileMethod(fileDecrypt), fileDecrypt);
        FirstKey1 = Integer.parseInt(resultStringKeyFromMethod.get(1));

        printList.PrintListMethod(resultStringKeyFromMethod);

        resultStringKeyFromMethod = checkingWorkStartFrequencyAnalysisMethod(resultStringKeyFromMethod, fileDecrypt, FirstKey1);
        FileWrite.fileWriteMethodKey(resultStringKeyFromMethod.get(0), fileDecrypt, messageBox.NAME_METHOD_FREQUENCYANALYSISI, resultStringKeyFromMethod.get(1));
    }


    public ArrayList<String> checkingWorkStartFrequencyAnalysisMethod(ArrayList<String> resultStringKeyFromMethod, Path fileDecrypt, int FirstKey1) throws IOException {
        int key1;
        while (userDecodingScore.GetUserDecodingScore() != true) {
            key1 = Integer.parseInt(resultStringKeyFromMethod.get(1));
            if (key1 < 30) {
                key1++;
                resultStringKeyFromMethod = decryptionByForce.DecryptionByForceString(ReadingFile.readingFileMethod(fileDecrypt), key1);
                printList.PrintListMethod(resultStringKeyFromMethod);
            } else if (key1 > 30 && key1 > 0) {

                System.out.println(messageBox.PROGRAM_CONTINUES_JOB);
                key1 = FirstKey1;
                key1--;

                resultStringKeyFromMethod = decryptionByForce.DecryptionByForceString(ReadingFile.readingFileMethod(fileDecrypt), key1);
                printList.PrintListMethod(resultStringKeyFromMethod);
            }

        }
        return resultStringKeyFromMethod;
    }


}





