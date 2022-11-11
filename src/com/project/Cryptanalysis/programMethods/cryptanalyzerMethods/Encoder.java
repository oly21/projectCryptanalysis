package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;


import com.project.Cryptanalysis.programMethods.Alphabet;

import java.io.IOException;


public class Encoder {
    public String encode(String StringEncrypt, int key) throws IOException {
        String resultString = null;
        char[] alphabet = new Alphabet().GettingAlphabet();
        char[] StringEncryptArray;
        StringEncryptArray = StringEncrypt.toCharArray();

        for (int i = 0; i < StringEncrypt.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (StringEncryptArray[i] == alphabet[j]) {

                    if (j < alphabet.length - key) {
                        StringEncryptArray[i] = alphabet[j + key];
                        j = alphabet.length;
                    } else if (j >= alphabet.length - key) {
                        int k = 0;
                        if (j == alphabet.length - 1) {
                            StringEncryptArray[i] = alphabet[k + key - 1];
                        } else {
                            StringEncryptArray[i] = alphabet[k + (key - (alphabet.length - j))];
                        }
                        j = alphabet.length;
                    }
                }
            }
            resultString = new String(StringEncryptArray);
        }
        return resultString;
    }
}


