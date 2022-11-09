package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;


import java.io.IOException;


public class Decoding {
    public String decodingString(String StringDecrypt, int key) throws IOException {
        DecodingАlgorithm decodingАlgorithm = new DecodingАlgorithm();
        String resultString = decodingАlgorithm.decoDecodingАlgorithmMethod(StringDecrypt, key);
        return resultString;
    }


}