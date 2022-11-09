package com.project.Cryptanalysis.programMethods;



import java.io.IOException;

public class FindMostFrequentCharacter {
    private int count1;


    GetAlphabet getAlphabet = new GetAlphabet();

    public int findMostFrequentCharacterMethodInt(String stringAnalysis) throws IOException {

        char[] alphabet = getAlphabet.GettingAlphabet();
        int[] numberCharactersInt;
        FindMostFrequentCharacter[] findMostFrequentCharacterArray = new FindMostFrequentCharacter[alphabet.length];

        findMostFrequentCharacterArray = findMostFrequentCharacterFillListObjectsMethod(findMostFrequentCharacterArray);
        numberCharactersInt = countSameCharacters(findMostFrequentCharacterArray, stringAnalysis);

        int index = findMaxtCharacter(numberCharactersInt);

        return index;
    }


    public FindMostFrequentCharacter[] findMostFrequentCharacterFillListObjectsMethod(FindMostFrequentCharacter[] findMostFrequentCharacterArray) throws IOException {
        for (int i = 0; i < findMostFrequentCharacterArray.length; i++) {
            findMostFrequentCharacterArray[i] = new FindMostFrequentCharacter();
        }
        return findMostFrequentCharacterArray;
    }


    public int[] countSameCharacters(FindMostFrequentCharacter[] findMostFrequentCharacterArray, String stringAnalysis) throws IOException {
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


    public int findMaxtCharacter(int[] numberCharactersInt) throws IOException {
        int index = 0;
        for (int i = 0; i < numberCharactersInt.length; i++) {
            if (numberCharactersInt[i] > numberCharactersInt[index]) {
                index = i;

            }
        }
        return index;
    }


    public boolean findMostFrequentCharacterMethod(String stringAnalysis) throws IOException {
        boolean wrongText = false;
        GetAlphabet getAlphabet = new GetAlphabet();
        char[] alphabet = getAlphabet.GettingAlphabet();

        int index = findMostFrequentCharacterMethodInt(stringAnalysis);
        if (alphabet[index] != ' ' && alphabet[index] != 'e' && alphabet[index] != 't' && alphabet[index] != 'a') {
            wrongText = true;
        }
        return wrongText;
    }
}
