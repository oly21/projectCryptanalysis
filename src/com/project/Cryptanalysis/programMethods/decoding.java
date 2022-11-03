package com.project.Cryptanalysis.programMethods;

import java.io.IOException;
import java.nio.file.Path;

public class decoding {
    public static String decodingString(String StringDecrypt, int key,Path fileResult) throws IOException {
        String nameMethod = "decoding";
        String resultString = null;

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', ':',
                '-', '!', '?'};


        char[] StringDencryptArray = new char[StringDecrypt.length()];
        StringDencryptArray = StringDecrypt.toCharArray();
        for (int i = 0; i < StringDecrypt.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (StringDencryptArray[i] == alphabet[j] ) {
                    if (j >= key && key<30 ) {
                        StringDencryptArray[i] = alphabet[j - key];
                        j = alphabet.length;
                    } else if(j < key && key<30) {
                        int k = alphabet.length - 1;
                        StringDencryptArray[i] = alphabet[k - key+j+1];
                        j = alphabet.length;
                    }




                }
            }

        }

        resultString = new String(StringDencryptArray);



        return fileWrite.fileWrite1(resultString,fileResult, nameMethod );
    }


}