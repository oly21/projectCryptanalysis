package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.programMethods.FinderMostFrequentCharacter;
import com.project.Cryptanalysis.programMethods.Converter;

import java.io.IOException;
import java.util.ArrayList;

public class FrequencyAnalysisDecoder {
    public ArrayList<String> frequencyAnalysisDecode(String stringAnalysis, String StringDecrypt) throws IOException {
        int key;
        int index;
        int count = 0;
        String[] paragraphForCheck;
        Decoder decoder = new Decoder();
        ArrayList<String> resultStringKey = new ArrayList<>();
        char[] StringDencryptArray = stringAnalysis.toCharArray();
        FinderMostFrequentCharacter finderMostFrequentCharacter = new FinderMostFrequentCharacter();
        index = finderMostFrequentCharacter.findMostFrequentCharacterInt(stringAnalysis);
        key = countKey(index);


        String resultString = decoder.decode(StringDecrypt, key);
        StringDecrypt = resultString;
        paragraphForCheck = resultString.split("[\\r\\n]+");
        StringDencryptArray = resultString.toCharArray();
        resultStringKey.add(0, resultString);
        resultStringKey.add(1, Integer.toString(key));


        boolean keyFound = true;
        while (keyFound) {
            for (int i = 0; i < 2; i++) {

                if (count <= 4 && i < StringDencryptArray.length - 1 && (StringDecrypt.length() > 6
                        && (!StringDecrypt.contains(" ")))) {
                    count++;
                    key = new Converter().convertKey(count, index);
                    resultString = decoder.decode(StringDecrypt, key);
                    StringDecrypt = resultString;
                    paragraphForCheck = resultString.split("[\\r\\n]+");
                    StringDencryptArray = resultString.toCharArray();
                    resultStringKey.add(0, resultString);
                    resultStringKey.add(1, Integer.toString(key));

                } else if (count <= 8 && i < paragraphForCheck.length &&
                        (finderMostFrequentCharacter.findMostFrequentCharacter(paragraphForCheck[i]))) {
                    count++;
                    key = new Converter().convertKeySpace(count, index);
                    resultString = decoder.decode(StringDecrypt, key);
                    StringDecrypt = resultString;
                    paragraphForCheck = resultString.split("[\\r\\n]+");
                    StringDencryptArray = resultString.toCharArray();
                    resultStringKey.add(0, resultString);
                    resultStringKey.add(1, Integer.toString(key));
                } else if (count > 8) {
                    key++;
                    resultString = decoder.decode(StringDecrypt, key);
                    StringDecrypt = resultString;
                    paragraphForCheck = resultString.split("[\\r\\n]+");
                    StringDencryptArray = resultString.toCharArray();
                    resultStringKey.add(0, resultString);
                    resultStringKey.add(1, Integer.toString(key));
                }
            }
            keyFound = false;
        }
        return resultStringKey;
    }


    private int countKey(int index) {

        if (index - 26 < 1) {
            index = 31 - index;
        }

        int key = index - 26;
        return key;
    }

}


