package com.project.Cryptanalysis.CheckersMethodsJob;

import com.project.Cryptanalysis.programMethods.fileJob.*;
import com.project.Cryptanalysis.programMethods.*;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CheckerJobDecoderByForce {
    public void checkJobDecoderByForce(Path fileDecrypt) throws IOException {
        DecoderByForce decoderByForce = new DecoderByForce();

        PrinterArrayList printerArrayList = new PrinterArrayList();

        String resultString = ReaderFile.readFile(fileDecrypt);
        ArrayList<String> resultStringKeyFromMethod;
        int key = 1;

        resultStringKeyFromMethod = decoderByForce.DecodeByForce(resultString, key);
        printerArrayList.PrintArrayList(resultStringKeyFromMethod);

        while (new CheckerUserDecoderScore().GetUserDecodingScore() != true) {
            key = Integer.parseInt(resultStringKeyFromMethod.get(1));
            key++;
            resultStringKeyFromMethod = decoderByForce.DecodeByForce(resultString, key);
            printerArrayList.PrintArrayList(resultStringKeyFromMethod);
        }

        WriterFile.WriteFileKey(resultStringKeyFromMethod.get(0), fileDecrypt, messageBox.NAME_METHOD_BRUTEFORCE,
                resultStringKeyFromMethod.get(1));

    }


}
