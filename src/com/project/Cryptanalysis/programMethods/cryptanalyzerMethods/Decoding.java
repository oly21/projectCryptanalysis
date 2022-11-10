package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;


import java.io.IOException;


public class Decoding {
    public String decodingString(String StringDecrypt, int key) throws IOException {
        DecodingAlgorithm decodingAlgorithm = new DecodingAlgorithm();
        String resultString = decodingAlgorithm.decoDecodingAlgorithmMethod(StringDecrypt, key);
        return resultString;
    }


}