package com.project.Cryptanalysis.programMethods;


import java.io.IOException;

public class FinderMostFrequentCharacter {
    private int count1;
    private final Alphabet getAlphabet = new Alphabet();

    public int findMostFrequentCharacterInt(String stringAnalysis) throws IOException {

        char[] alphabet = getAlphabet.GettingAlphabet();
        int[] numberCharactersInt;
        FinderMostFrequentCharacter[] findMostFrequentCharacterArray = new FinderMostFrequentCharacter[alphabet.length];


        int index = 0;
        for (int i = 0; i < findMostFrequentCharacterArray.length; i++) {
            findMostFrequentCharacterArray[i] = new FinderMostFrequentCharacter();
        }

        numberCharactersInt = countSameCharacters(findMostFrequentCharacterArray, stringAnalysis);
        index = findMaxCharacter(numberCharactersInt);
        return index;

    }


    private int[] countSameCharacters(FinderMostFrequentCharacter[] findMostFrequentCharacterArray, String stringAnalysis) throws IOException {
        char[] StringDencryptArray = stringAnalysis.toCharArray();
        char[] alphabet = getAlphabet.GettingAlphabet();
        int[] numberCharactersInt = new int[alphabet.length];
        for (int i = 0; i < StringDencryptArray.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {

                if (StringDencryptArray[i] == alphabet[j]) {
                    findMostFrequentCharacterArray[j].count1++;
                    numberCharactersInt[j] = findMostFrequentCharacterArray[j].count1;
                }
            }

        }
        return numberCharactersInt;
    }

    private int findMaxCharacter(int[] numberCharactersInt) {
        int index = 0;
        for (int i = 0; i < numberCharactersInt.length; i++) {
            if (numberCharactersInt[i] > numberCharactersInt[index]) {
                index = i;

            }

        }
        return index;
    }


    public boolean findMostFrequentCharacter(String stringAnalysis) throws IOException {
        boolean wrongText = false;
        Alphabet getAlphabet = new Alphabet();
        char[] alphabet = getAlphabet.GettingAlphabet();

        int index = findMostFrequentCharacterInt(stringAnalysis);
        if (alphabet[index] != ' ' && alphabet[index] != 'e' && alphabet[index] != 't' && alphabet[index] != 'a') {
            wrongText = true;
        }
        return wrongText;
    }
}
