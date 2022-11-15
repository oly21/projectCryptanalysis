package com.project.Cryptanalysis.CheckersMethodsJob;

import com.project.Cryptanalysis.programMethods.messageBox;

import java.io.IOException;
import java.util.Scanner;

public class CheckerUserDecoderScore {
    public boolean GetUserDecodingScore()  {

        Scanner scanner = new Scanner(System.in);
        System.out.println(messageBox.PROGRAM_EVALUATION_MESSAGE);
        int userEvaluation = scanner.nextInt();
        if (userEvaluation == 1) {
            System.out.println(messageBox.THANKS_EVALUATION_MESSAGE);
            return true;

        } else {
            System.out.println(messageBox.PROGRAM_CONTINUES_JOB);
            return false;
        }
    }
}


