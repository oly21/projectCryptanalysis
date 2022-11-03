package com.project.Cryptanalysis.programMethods;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class frequencyAnalysis {
    int count1 = 0;

    public static ArrayList<String> frequencyAnalysisString(String  stringAnalysis, String StringDecrypt, Path fileResult) throws IOException {
        String nameMethod = "frequencyAnalysisString";
        ArrayList<String> resultStringKey  = new ArrayList<String>();
        int count = 0;
        boolean keyFound = true;
        String resultString = null;
        int indexE = 4;
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', ':',
                '-', '!', '?'};
        char[] StringDencryptArray  = new char[stringAnalysis.length()];
        StringDencryptArray = stringAnalysis.toCharArray();

        frequencyAnalysis[] numberCharacters1 = new frequencyAnalysis[alphabet.length];
        for (int i = 0; i < numberCharacters1.length; i++) {
            numberCharacters1[i] = new frequencyAnalysis();

        }

        int[] numberCharactersInt = new int[alphabet.length];


        int key;



        for (int i = 0; i < StringDencryptArray.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {



                if (StringDencryptArray[i] == alphabet[j]) {
                 numberCharacters1[j].count1++;
                    numberCharactersInt[j] =   numberCharacters1[j].count1;
                }

            }
        }
        int index = 0;

        for (int i = 0; i<numberCharactersInt.length; i++) {
            if (numberCharactersInt[i] > numberCharactersInt[index] ) {
                index = i;

            }
        }


         if( index - 26< 1){
            index = 31-index;
         }
       key =  index - 26;

        resultStringKey.add(0, decoding.decodingString(StringDecrypt, key,fileResult));

        resultString =   resultStringKey.get(0);
        String[] paragraphForСheck = resultString.split("[\\r\\n]+");
        while (keyFound) {
            for (int i = 0; i < StringDencryptArray.length; i++) {

                if (i < StringDencryptArray.length - 1) {


                    if(StringDecrypt.length() >6 ) {
                        if (!resultString.contains(" ")) {
                            count++;

                            key = switch (count) {
                                case 1 -> index - indexE ;
                                case 2 -> index - 19;
                                case 3 -> index - 0;
                                default -> 4;
                            };

                            resultStringKey.remove(0);
                            resultStringKey.add(0,decoding.decodingString(StringDecrypt, key, fileResult));

                            resultString =   resultStringKey.get(0);


                            StringDencryptArray = resultString.toCharArray();
                            paragraphForСheck = resultString.split("[\\r\\n]+");
                        }
                    }
                        if (StringDencryptArray[i] == ' ' && !Character.isLetter(StringDencryptArray[i + 1])&& !Character.isDigit(StringDencryptArray[i + 1]))  {

                            count++;

                            key = switch (count) {
                                case 1 -> index - 26;
                                case 2 -> index - 19;
                                case 3 -> index - 0;
                                default -> 4;
                            };

                            resultStringKey.remove(0);
                            resultStringKey.add(0,decoding.decodingString(StringDecrypt, key, fileResult));

                            resultString =   resultStringKey.get(0);


                            StringDencryptArray = resultString.toCharArray();

                            paragraphForСheck = resultString.split("[\\r\\n]+");
                        }

                        else if(i<paragraphForСheck.length ) {
                            if (findMostFrequentCharacter.findMostFrequentCharacterMethod(paragraphForСheck[i])) {

                                key++;

                                resultStringKey.remove(0);
                                resultStringKey.add(0,decoding.decodingString(StringDecrypt, key, fileResult));

                                resultString =   resultStringKey.get(0);

                                StringDencryptArray = resultString.toCharArray();

                                paragraphForСheck = resultString.split("[\\r\\n]+");


                            }


                            if (findMostFrequentCharacter.findMostFrequentCharacterMethod(paragraphForСheck[i])) {

                                key++;
                                resultStringKey.remove(0);
                                resultStringKey.add(0,decoding.decodingString(StringDecrypt, key, fileResult));

                                resultString =   resultStringKey.get(0);

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

            }


        resultStringKey.remove(0);
        resultStringKey.add( 0,resultString);
        resultStringKey.add( 1,Integer.toString(key));
        return resultStringKey;

        }


    }

