package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.programMethods.FindMostFrequentCharacter;
import com.project.Cryptanalysis.programMethods.Converter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FrequencyAnalysis {
    String StringDecrypt;
    String[] paragraphForCheck;
    char[] StringDencryptArray;
    private final FindMostFrequentCharacter findMostFrequentCharacter = new FindMostFrequentCharacter();
    private final RestartDecodingAlgorithm restartDecodingAlgorithm = new RestartDecodingAlgorithm();
    private final Converter converter = new Converter();




    public ArrayList<String> frequencyAnalysisString(String stringAnalysis, String StringDecrypt) throws IOException {

        ArrayList<String> resultStringKey;
        int key;
        int index;
        int count = 0;
        StringDencryptArray = stringAnalysis.toCharArray();
        index = findMostFrequentCharacter.findMostFrequentCharacterMethodInt(stringAnalysis);

       key =  countKey(index);
        resultStringKey = restartDecodingAlgorithm.RestartDecodingMethod(StringDecrypt, key,this);
        this.StringDecrypt = StringDecrypt;

        while (checkingWorkfrequencyAnalysisStringMethod(this.StringDencryptArray, this.StringDecrypt)) {
            if (count<=4) {
                count++;
                key = converter.converterKeyMethod(count, index);
                resultStringKey = restartDecodingAlgorithm.RestartDecodingMethod(StringDecrypt, key,this);
            } else if (count<8) {
                count++;
                key = converter.converterKeySpaceMethod(count, index);

                resultStringKey = restartDecodingAlgorithm.RestartDecodingMethod(StringDecrypt, key,this);
            } else if (count>8) {
                key++;
                resultStringKey = restartDecodingAlgorithm.RestartDecodingMethod(StringDecrypt, key,this);
            }


        }
        return resultStringKey;
    }


    private boolean checkingWorkfrequencyAnalysisStringMethod(char[] StringDencryptArray, String StringDecrypt) throws IOException {
        boolean keyFound = true;

        while (keyFound) {
            for (int i = 0; i < 2; i++) {

                if (i < StringDencryptArray.length - 1) {

                    if (StringDecrypt.length() > 6) {
                        if (!StringDecrypt.contains(" ")) {
                            return true;
                        }
                    }
                    if (!StringDecrypt.contains(" ")) {

                        return true;

                    } else if (i < paragraphForCheck.length) {
                        if (findMostFrequentCharacter.findMostFrequentCharacterMethod(paragraphForCheck[i])) {

                            return true;

                        }
                    }
                }
            }

            keyFound = false;

        }

        return false;


    }
    private int  countKey(int index){

        if (index - 26 < 1) {
        index = 31 - index;
    }

   int key = index - 26;
        return key;
}

    }


