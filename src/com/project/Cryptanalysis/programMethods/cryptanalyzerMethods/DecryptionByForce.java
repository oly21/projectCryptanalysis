package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.programMethods.FindMostFrequentCharacter;

import java.io.IOException;
import java.util.ArrayList;

public class DecryptionByForce {

    String StringDecrypt;
    String[] paragraphForСheck;
    DecodingАlgorithm decodingАlgorithm = new DecodingАlgorithm();
    RestartDecodingАlgorithm restartDecodingАlgorithm = new RestartDecodingАlgorithm();
    final FindMostFrequentCharacter findMostFrequentCharacter = new FindMostFrequentCharacter();
    boolean keyFound = true;
    char[] StringDencryptArray;
    public ArrayList<String> DecryptionByForceString(String StringDecrypt, int key) throws IOException {
        this.StringDecrypt = StringDecrypt;
        ArrayList<String> resultStringKey = new ArrayList<String>();


        this.StringDecrypt = decodingАlgorithm.decoDecodingАlgorithmMethod(StringDecrypt, key);
        StringDencryptArray = decodingАlgorithm.getStringDencryptArray();
        paragraphForСheck =   this.StringDecrypt.split("[\\r\\n]+");

        while (checkingWorkByForceMethod(this.StringDencryptArray, this.StringDecrypt, key) != false) {

            key++;
            resultStringKey = restartDecodingАlgorithm.RestartDecodingMethod(StringDecrypt, key,this);

        }
        return resultStringKey;

    }

    public boolean checkingWorkByForceMethod(char[] StringDencryptArray, String StringDecrypt, int key) throws IOException {

        while (keyFound) {
            for (int i = 0; i < 2; i++) {

                if (i < StringDencryptArray.length - 1) {

                    if (StringDecrypt.length() > 6 && key < 30 && i < paragraphForСheck.length) {
                        if (!StringDecrypt.contains(" ") || (!paragraphForСheck[i].contains(" ")
                                || (findMostFrequentCharacter.findMostFrequentCharacterMethod(paragraphForСheck[i]) == true))) {

                            return true;

                        }
                    }

                }
            }
            keyFound = false;

        }
        return false;


    }
}







