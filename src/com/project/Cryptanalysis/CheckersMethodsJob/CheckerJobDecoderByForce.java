package com.project.Cryptanalysis.CheckersMethodsJob;

import com.project.Cryptanalysis.programMethods.fileJob.*;
import com.project.Cryptanalysis.programMethods.*;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CheckerJobDecoderByForce {
    public ArrayList<String> checkJobDecoderByForce(Path fileDecrypt) throws IOException {
        DecoderByForce decoderByForce = new DecoderByForce();
        PrinterArrayList printerArrayList = new PrinterArrayList();
        String resultString = ReaderFile.readFile(fileDecrypt);
        ArrayList<String> resultStringKeyFromMethod;
        int key = 0;
        int limitKey = 0;
        boolean alreadyReceivedFirstKey = false;

        resultStringKeyFromMethod = decoderByForce.decodeByForce(resultString, key);
        printerArrayList.PrintArrayList(resultStringKeyFromMethod);

        while (!new CheckerUserDecoderScore().GetUserDecodingScore()) {
            key = Integer.parseInt(resultStringKeyFromMethod.get(1));
            if (key < 30 && limitKey == 0) {
                if (key == 29) {
                    limitKey++;
                }

                if (key < 30) {
                    key++;
                    resultStringKeyFromMethod = decoderByForce.decodeByForce(resultString, key);
                    printerArrayList.PrintArrayList(resultStringKeyFromMethod);
                }
            } else if (key > 0 && limitKey > 0) {
                key--;
                resultStringKeyFromMethod = decoderByForce.decodeByForce(resultString, key);
                printerArrayList.PrintArrayList(resultStringKeyFromMethod);
            }


        }

        return resultStringKeyFromMethod;
    }

}
