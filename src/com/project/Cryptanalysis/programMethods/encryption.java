package com.project.Cryptanalysis.programMethods;

import java.io.IOException;
import java.nio.file.Path;

public   class encryption {
    public static String encryptionString(String  StringEncrypt, int key, Path fileResult ) throws IOException {
        String nameMethod = "encryption";
        String resultString = null;
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' ,' ', ':',
                '-', '!', '?'};



        char [] StringEncryptArray = new char[StringEncrypt.length()];
        StringEncryptArray = StringEncrypt.toCharArray();
        for (int i = 0; i < StringEncrypt.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (StringEncryptArray[i] == alphabet[j]) {

                    if (j < alphabet.length - key ) {
                        StringEncryptArray[i] = alphabet[j + key];

                   j = alphabet.length;
                    } else if(j >= alphabet.length - key ) {
                        if(j==alphabet.length - 1){
                            int k = 0;
                            StringEncryptArray[i] = alphabet[k + key-1];
                            j = alphabet.length;
                        }
                        else {
                            int k = 0;
                            StringEncryptArray[i] = alphabet[k + (key-(alphabet.length-j))];
                            j = alphabet.length;
                        }
                    }
                }
            }
            resultString = new String(StringEncryptArray);
        }
    return fileWrite.fileWrite1(resultString,  fileResult,   nameMethod );
    }
}


