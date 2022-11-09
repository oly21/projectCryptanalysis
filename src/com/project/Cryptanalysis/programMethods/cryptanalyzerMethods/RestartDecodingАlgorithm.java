package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import java.io.IOException;
import java.util.ArrayList;

public class RestartDecodingАlgorithm {
    public ArrayList<String> RestartDecodingMethod(String StringDecrypt, int key,Object  object) throws IOException {
        DecodingАlgorithm decodingАlgorithm = new DecodingАlgorithm();
        ArrayList<String> resultStringKey = new ArrayList<>();
        String resultString;

        resultString = decodingАlgorithm.decoDecodingАlgorithmMethod(StringDecrypt, key);
        if (resultString != null && object instanceof DecryptionByForce  ) {
            DecryptionByForce decryptionByForce = (DecryptionByForce)object;

            decryptionByForce.StringDecrypt = resultString;
            decryptionByForce.paragraphForСheck = resultString.split("[\\r\\n]+");
            decryptionByForce.StringDencryptArray = resultString.toCharArray();
            resultStringKey.add(0, resultString);
            resultStringKey.add(1, Integer.toString(key));
        }

        else if (resultString.length() != 0 && object instanceof FrequencyAnalysis ) {
            FrequencyAnalysis frequencyAnalysis = (FrequencyAnalysis)object;


            frequencyAnalysis.StringDecrypt = resultString;
            frequencyAnalysis.paragraphForСheck = resultString.split("[\\r\\n]+");
            frequencyAnalysis.StringDencryptArray = resultString.toCharArray();

            resultStringKey.add(0, resultString);
            resultStringKey.add(1, Integer.toString(key));
        }

        return resultStringKey;
    }
}
