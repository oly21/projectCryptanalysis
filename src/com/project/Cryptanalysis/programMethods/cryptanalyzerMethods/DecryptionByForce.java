package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.programMethods.FindMostFrequentCharacter;

import java.io.IOException;
import java.util.ArrayList;

public class DecryptionByForce {

    String StringDecrypt;
    String[] paragraphForCheck;
    private final DecodingAlgorithm decodingAlgorithm = new DecodingAlgorithm();
    private final RestartDecodingAlgorithm restartDecodingAlgorithm = new RestartDecodingAlgorithm();
    private final FindMostFrequentCharacter findMostFrequentCharacter = new FindMostFrequentCharacter();
    private boolean keyFound = true;
    char[] StringDencryptArray;
    public ArrayList<String> DecryptionByForceString(String StringDecrypt, int key) throws IOException {
        this.StringDecrypt = StringDecrypt;
        ArrayList<String> resultStringKey = new ArrayList<>();


        this.StringDecrypt = decodingAlgorithm.decoDecodingAlgorithmMethod(StringDecrypt, key);
        StringDencryptArray = decodingAlgorithm.getStringDencryptArray();
        paragraphForCheck =   this.StringDecrypt.split("[\\r\\n]+");

        while (checkingWorkByForceMethod(this.StringDencryptArray, this.StringDecrypt, key)) {

            key++;
            resultStringKey = restartDecodingAlgorithm.RestartDecodingMethod(StringDecrypt, key,this);

        }
        return resultStringKey;

    }

    private boolean checkingWorkByForceMethod(char[] StringDencryptArray, String StringDecrypt, int key) throws IOException {

        while (keyFound) {
            for (int i = 0; i < 2; i++) {

                if (i < StringDencryptArray.length - 1) {

                    if (StringDecrypt.length() > 6 && key < 30 && i < paragraphForCheck.length) {
                        if (!StringDecrypt.contains(" ") || (!paragraphForCheck[i].contains(" ")
                                || (findMostFrequentCharacter.findMostFrequentCharacterMethod(paragraphForCheck[i])))) {

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







