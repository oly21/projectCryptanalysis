package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.programMethods.FinderMostFrequentCharacter;

import java.io.IOException;
import java.util.ArrayList;

public class DecoderByForce {

    public ArrayList<String> DecodeByForce(String OriginalStringDecrypt, int key) throws IOException {
        String[] paragraphForCheck;
        char[] StringDencryptArray;
        boolean keyFound = true;
        Decoder decoder = new Decoder();
        ArrayList<String> resultStringKey = new ArrayList<>();

        String resultString = decoder.decode(OriginalStringDecrypt, key);
        StringDencryptArray = resultString.toCharArray();
        paragraphForCheck = resultString.split("[\\r\\n]+");

        while (keyFound) {
            for (int i = 0; i < 30; i++) {
                if (i < StringDencryptArray.length - 1 && resultString.length() > 6
                        && i < paragraphForCheck.length && !resultString.contains(" ") ||
                        (!paragraphForCheck[i].contains(" ")
                                || (new FinderMostFrequentCharacter().findMostFrequentCharacter(resultString)))) {

                    key++;
                    resultString = decoder.decode(OriginalStringDecrypt, key);
                    paragraphForCheck = resultString.split("[\\r\\n]+");
                    StringDencryptArray = resultString.toCharArray();

                }
            }
            keyFound = false;
        }
        resultStringKey.add(0, resultString);
        resultStringKey.add(1, Integer.toString(key));
        return resultStringKey;

    }


}










