package com.project.Cryptanalysis.programMethods;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class DecryptionByForce {
    public static ArrayList<String>  DecryptionByForceString(String StringDecrypt, int key, Path fileResult  ) throws IOException {
        String nameMethod = "DecryptionByForceString";
        ArrayList<String> resultStringKey  = new ArrayList<String>();
        String resultString;

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', ':',
                '-', '!', '?'};

       char [] StringDencryptArray = new char[StringDecrypt.length()];
        StringDencryptArray = StringDecrypt.toCharArray();
        boolean keyFound = true;



            for (int i = 0; i < StringDecrypt.length(); i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (StringDencryptArray[i] == alphabet[j]) {
                        if (j >= key && key<30) {
                            StringDencryptArray[i] = alphabet[j - key];
                            j = alphabet.length;
                        } else if(j < key && key<30){
                            int k = alphabet.length - 1;
                            StringDencryptArray[i] = alphabet[k - key+j+1];
                            j = alphabet.length;
                        }
                    }
                }

            }
        resultString  = new String(StringDencryptArray);
        String[] paragraphForСheck = resultString.split("[\\r\\n]+");
       char[] paragraphForСheckArray = paragraphForСheck[0].toCharArray();
            while (keyFound) {
            for (int i = 0; i < StringDencryptArray.length; i++) {

                 if (i < StringDencryptArray.length - 1) {

                  if(StringDecrypt.length() >6 ) {
                         if (!resultString.contains(" ") && key < 30) {
                             key++;
                             resultStringKey =   DecryptionByForce.DecryptionByForceString(StringDecrypt, key, fileResult);

                             resultString  = resultStringKey.get(0);
                             StringDencryptArray = resultString.toCharArray();
                             paragraphForСheck = resultString.split("[\\r\\n]+");
                         }

                     }
                      if ( StringDencryptArray[i] == ' ' && !Character.isLetter(StringDencryptArray[i + 1])&& !Character.isDigit(StringDencryptArray[i + 1]) && key<30 ) {

                            key ++;
                          resultStringKey =  DecryptionByForce.DecryptionByForceString(StringDecrypt,key,fileResult);
                          resultString  = resultStringKey.get(0);
                        StringDencryptArray = resultString.toCharArray();
                          paragraphForСheck = resultString.split("[\\r\\n]+");



                }
                      else if(i<paragraphForСheck.length && StringDecrypt.length() >6) {

                          if (!paragraphForСheck[i].contains(" ") && key < 30) {

                            key++;
                            resultStringKey = DecryptionByForce.DecryptionByForceString(StringDecrypt, key, fileResult);
                            resultString  = resultStringKey.get(0);
                            StringDencryptArray = resultString.toCharArray();

                            paragraphForСheck = resultString.split("[\\r\\n]+");


                        } else if (findMostFrequentCharacter.findMostFrequentCharacterMethod(paragraphForСheck[i]) == true) {

                            key++;
                            resultStringKey = DecryptionByForce.DecryptionByForceString(StringDecrypt, key, fileResult);
                            resultString  = resultStringKey.get(0);
                            StringDencryptArray = resultString.toCharArray();

                            paragraphForСheck = resultString.split("[\\r\\n]+");


                        }

                        else {

                            keyFound = false;
                            i = StringDencryptArray.length;
                        }

                      }

                      else {

                          keyFound = false;
                          i = StringDencryptArray.length;
                      }
            }

        }
            resultString = new String(StringDencryptArray);

    }


        resultStringKey.add( 0,resultString);
        resultStringKey.add( 1,Integer.toString(key));
        return resultStringKey;
    }

    }
