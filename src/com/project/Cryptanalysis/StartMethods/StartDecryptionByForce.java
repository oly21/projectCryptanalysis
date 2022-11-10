package com.project.Cryptanalysis.StartMethods;

import com.project.Cryptanalysis.programMethods.fileJob.FileWrite;
import com.project.Cryptanalysis.programMethods.fileJob.ReadingFile;
import com.project.Cryptanalysis.programMethods.*;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.DecryptionByForce;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class StartDecryptionByForce {
    private DecryptionByForce decryptionByForce = new DecryptionByForce();

    private PrintList printList = new PrintList();

    private UserDecodingScore userDecodingScore = new UserDecodingScore();

    public void startDecryptionByForceMethod(Path fileDecrypt) throws IOException {
        ArrayList<String> resultStringKeyFromMethod;
        int key = 1;

        resultStringKeyFromMethod = decryptionByForce.DecryptionByForceString(ReadingFile.readingFileMethod(fileDecrypt), key);
        printList.PrintListMethod(resultStringKeyFromMethod);
        resultStringKeyFromMethod = this.checkingWorkStartByForceMethod(resultStringKeyFromMethod, fileDecrypt);
        FileWrite.fileWriteMethodKey(resultStringKeyFromMethod.get(0), fileDecrypt, messageBox.NAME_METHOD_BRUTEFORCE,
                resultStringKeyFromMethod.get(1));

    }


    private ArrayList<String> checkingWorkStartByForceMethod(ArrayList<String> resultStringKeyFromMethod,
                                                             Path fileDecrypt) throws IOException {

        while (userDecodingScore.GetUserDecodingScore() != true) {
            int key = Integer.parseInt(resultStringKeyFromMethod.get(1));
            key++;
            resultStringKeyFromMethod = decryptionByForce.DecryptionByForceString(ReadingFile.readingFileMethod(fileDecrypt), key);
            printList.PrintListMethod(resultStringKeyFromMethod);
        }

        return resultStringKeyFromMethod;
    }

}
