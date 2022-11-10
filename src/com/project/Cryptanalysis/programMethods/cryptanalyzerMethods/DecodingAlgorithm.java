package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.programMethods.GetAlphabet;
import java.io.IOException;


public class DecodingAlgorithm {
   private char[] StringDencryptArray;

    public String decoDecodingAlgorithmMethod(String StringDecrypt, int key) throws IOException {

        String resultString;
        GetAlphabet getAlphabet = new GetAlphabet();
        char[] alphabet = getAlphabet.GettingAlphabet();


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