package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.programMethods.FindMostFrequentCharacter;
import com.project.Cryptanalysis.programMethods.Сonverter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FrequencyAnalysis {
    String StringDecrypt;
    String[] paragraphForСheck;
    char[] StringDencryptArray;
    FindMostFrequentCharacter findMostFrequentCharacter = new FindMostFrequentCharacter();
    RestartDecodingАlgorithm restartDecodingАlgorithm = new RestartDecodingАlgorithm();
    Сonverter сonverter = new Сonverter();

    boolean chekIf = false;
    boolean chekIf2 = false;

    public ArrayList<String> frequencyAnalysisString(String stringAnalysis, String StringDecrypt, Path fileResult) throws IOException {

        ArrayList<String> resultStringKey;
        int key;
        int index;
        int count = 0;
        StringDencryptArray = stringAnalysis.toCharArray();
        index = findMostFrequentCharacter.findMostFrequentCharacterMethodInt(stringAnalysis);

       key =  countKey(index);
        resultStringKey = restartDecodingАlgorithm.RestartDecodingMethod(StringDecrypt, key,this);
        this.StringDecrypt = StringDecrypt;

        while (checkingWorkfrequencyAnalysisStringMethod(this.StringDencryptArray, this.StringDecrypt, key, index, resultStringKey) == true) {
            if (chekIf == false && count<=4) {
                count++;
                key = сonverter.converterKeyMethod(count, index);
                resultStringKey = restartDecodingАlgorithm.RestartDecodingMethod(StringDecrypt, key,this);
            } else if (count>4 &&  count<8) {
                count++;
                key = сonverter.converterKeySpaceMethod(count, index);

                resultStringKey = restartDecodingАlgorithm.RestartDecodingMethod(StringDecrypt, key,this);
            } else if (count>8) {
                key++;
                resultStringKey = restartDecodingАlgorithm.RestartDecodingMethod(StringDecrypt, key,this);
            }


        }
        return resultStringKey;
    }


    public boolean checkingWorkfrequencyAnalysisStringMethod(char[] StringDencryptArray, String StringDecrypt, int key, int index, ArrayList<String> resultStringKey) throws IOException {
        boolean keyFound = true;

        while (keyFound) {
            for (int i = 0; i < 2; i++) {

                if (i < StringDencryptArray.length - 1) {
                    chekIf = false;
                    if (StringDecrypt.length() > 6) {
                        if (!StringDecrypt.contains(" ")) {
                            return true;
                        }
                    }
                    if (!StringDecrypt.contains(" ")) {
                       chekIf = true;
                        return true;

                    } else if (i < paragraphForСheck.length) {
                        if (findMostFrequentCharacter.findMostFrequentCharacterMethod(paragraphForСheck[i])) {
                         chekIf2 = true;
                            return true;

                        }
                    }
                }
            }

            keyFound = false;

        }

        return false;


    }
    public int  countKey(int index){

        if (index - 26 < 1) {
        index = 31 - index;
    }

   int key = index - 26;
        return key;
}

    }


