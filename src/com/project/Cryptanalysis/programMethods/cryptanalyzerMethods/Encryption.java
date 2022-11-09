package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;


import com.project.Cryptanalysis.programMethods.GetAlphabet;
import java.io.IOException;


public class Encryption {
    public String encryptionString(String StringEncrypt, int key) throws IOException {
        String resultString = null;
        GetAlphabet getAlphabet = new GetAlphabet();
        char[] alphabet = getAlphabet.GettingAlphabet();
        char[] StringEncryptArray;
        StringEncryptArray = StringEncrypt.toCharArray();

        for (int i = 0; i < StringEncrypt.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (StringEncryptArray[i] == alphabet[j]) {

                    if (j < alphabet.length - key) {
                        StringEncryptArray[i] = alphabet[j + key];

                        j = alphabet.length;
                    } else if (j >= alphabet.length - key) {
                        if (j == alphabet.length - 1) {
                            int k = 0;
                            StringEncryptArray[i] = alphabet[k + key - 1];
                            j = alphabet.length;
                        } else {
                            int k = 0;
                            StringEncryptArray[i] = alphabet[k + (key - (alphabet.length - j))];
                            j = alphabet.length;
                        }
                    }
                }
            }
            resultString = new String(StringEncryptArray);
        }
        return resultString;
    }
}


