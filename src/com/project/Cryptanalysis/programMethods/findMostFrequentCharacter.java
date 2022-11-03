package com.project.Cryptanalysis.programMethods;

import com.project.Cryptanalysis.programMethods.frequencyAnalysis;

import java.io.IOException;

public class findMostFrequentCharacter {
    public static boolean  findMostFrequentCharacterMethod(String  stringAnalysis) throws IOException {
        int count = 0;
        boolean keyFound = true;
        boolean wrongText = false;
        int index = 0;
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


        for (int i = 0; i<numberCharactersInt.length; i++) {
            if (numberCharactersInt[i] > index ) {
                index = i;

            }
        }


        if(alphabet[index] != ' ' &&  alphabet[index] != 'e' && alphabet[index] !=  't' && alphabet[index] != 'a' ){
            wrongText = true;
        }



        return  wrongText;

    }

    }
