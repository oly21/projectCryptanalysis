package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;


import com.project.Cryptanalysis.programMethods.Alphabet;

import java.io.IOException;


public class Decoder {

    private char[] StringDencryptArray;

    public String decode(String StringDecrypt, int key) throws IOException {

        String resultString;
        char[] alphabet = new Alphabet().GettingAlphabet();

        StringDencryptArray = StringDecrypt.toCharArray();
        char[] StringDencryptArray = new char[StringDecrypt.length()];
        StringDencryptArray = StringDecrypt.toCharArray();
        for (int i = 0; i < StringDecrypt.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (StringDencryptArray[i] == alphabet[j]) {
                    if (j >= key && key < 30) {
                        StringDencryptArray[i] = alphabet[j - key];
                        j = alphabet.length;
                    } else if (j < key && key < 30) {
                        int k = alphabet.length - 1;
                        StringDencryptArray[i] = alphabet[k - key + j + 1];
                        j = alphabet.length;
                    }


                }
            }

        }


        resultString = new String(StringDencryptArray);

        return resultString;
    }

    public char[] getStringDencryptArray() {

        return StringDencryptArray;
    }
}

