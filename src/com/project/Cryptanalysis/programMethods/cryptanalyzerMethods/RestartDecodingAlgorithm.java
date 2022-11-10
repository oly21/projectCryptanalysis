package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import java.io.IOException;
import java.util.ArrayList;

public class RestartDecodingAlgorithm {
    public ArrayList<String> RestartDecodingMethod(String StringDecrypt, int key,Object  object) throws IOException {
        DecodingAlgorithm decodingAlgorithm = new DecodingAlgorithm();
        ArrayList<String> resultStringKey = new ArrayList<>();
        String resultString;

        resultString = decodingAlgorithm.decoDecodingAlgorithmMethod(StringDecrypt, key);
        if (resultString != null && object instanceof DecryptionByForce decryptionByForce) {

            decryptionByForce.StringDecrypt = resultString;
            decryptionByForce.paragraphForCheck = resultString.split("[\\r\\n]+");
            decryptionByForce.StringDencryptArray = resultString.toCharArray();
            resultStringKey.add(0, resultString);
            resultStringKey.add(1, Integer.toString(key));
        }

        else if (resultString.length() != 0 && object instanceof FrequencyAnalysis ) {
            FrequencyAnalysis frequencyAnalysis = (FrequencyAnalysis)object;


            frequencyAnalysis.StringDecrypt = resultString;
            frequencyAnalysis.paragraphForCheck = resultString.split("[\\r\\n]+");
            frequencyAnalysis.StringDencryptArray = resultString.toCharArray();

            resultStringKey.add(0, resultString);
            resultStringKey.add(1, Integer.toString(key));
        }

        return resultStringKey;
    }
}
