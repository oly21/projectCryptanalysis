package com.project.Cryptanalysis.CheckersMethodsJob;


import com.project.Cryptanalysis.programMethods.Alphabet;
import com.project.Cryptanalysis.programMethods.messageBox;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

import java.util.LinkedHashMap;
import java.util.Collections;

public class CheckerCorrectnessDecodedStr {
    private int count1;
    private List<Character> alphabet;

    public int findMostFrequentCharacterIndex(String stringAnalysis) {


        if (stringAnalysis.contains("т") || stringAnalysis.contains("и") || stringAnalysis.contains("л")) {
            alphabet = Alphabet.ALPHABET_RU;
        } else {
            alphabet = Alphabet.ALPHABET_EN;
        }


        Map<Character, Integer> letterAndCounterLetters = new HashMap<>();

        char[] stringAnalysArray = stringAnalysis.toCharArray();
        int indexStrAnalysArray;
        char symbolOriginalArray;
        int indexAlphabet;
        int indexMostCommonSymbol;
        char mostMostCommonSymbol = 0;
        int value;
        for (indexStrAnalysArray = 0; indexStrAnalysArray < stringAnalysArray.length; indexStrAnalysArray++) {
            symbolOriginalArray = stringAnalysArray[indexStrAnalysArray];

            if (alphabet.contains(symbolOriginalArray)) {
                indexAlphabet = alphabet.indexOf(symbolOriginalArray);
            } else {
                continue;
            }

            if (!letterAndCounterLetters.containsKey(symbolOriginalArray)) {
                value = 1;
            } else {
                value = letterAndCounterLetters.get(symbolOriginalArray);
                value++;

            }

            letterAndCounterLetters.put(symbolOriginalArray, value);

        }

        Map<Character, Integer> sortedLetterAndCounterLetter = letterAndCounterLetters
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));


        for (Map.Entry<Character, Integer> entry : sortedLetterAndCounterLetter.entrySet()) {
            mostMostCommonSymbol = entry.getKey();
            break;
        }

        indexMostCommonSymbol = alphabet.indexOf(mostMostCommonSymbol);

        return indexMostCommonSymbol;
    }



        /*int[] numberCharactersInt;
            CheckerCorrectnessDecodedStr[] findMostFrequentCharacterArray = new CheckerCorrectnessDecodedStr[alphabet.size()];

            int index;

            for (int i = 0; i < findMostFrequentCharacterArray.length; i++) {
                findMostFrequentCharacterArray[i] = new CheckerCorrectnessDecodedStr();
            }

            numberCharactersInt = countSameCharacters(findMostFrequentCharacterArray, stringAnalysis);
            index = findMaxCharacter(numberCharactersInt);
            return index;

        }


        private int[] countSameCharacters( CheckerCorrectnessDecodedStr [] findMostFrequentCharacterArray, String stringAnalysis)  {
            char[] stringAnalysArray = stringAnalysis.toCharArray();
            int indexStrAnalysArray = 0;
            char symbolOriginalArray = stringAnalysArray[indexStrAnalysArray];
            int indexAlphabet = alphabet.indexOf(symbolOriginalArray);
            int[] numberCharactersInt = new int[alphabet.size()];
            for (indexStrAnalysArray = 0; indexStrAnalysArray < stringAnalysArray.length; indexStrAnalysArray++) {

                findMostFrequentCharacterArray[indexAlphabet].count1++;
                numberCharactersInt[indexAlphabet] = findMostFrequentCharacterArray[indexAlphabet].count1;

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
            return index*/


    public boolean checkCorrectnessDecodedStr(String decodedString) throws IOException {
        boolean correctStr = true;


        int index = findMostFrequentCharacterIndex(decodedString);
        char mostFrequentCharacterDecodedStr = alphabet.get(index);

        if (mostFrequentCharacterDecodedStr != messageBox.SYMBOL_SPACE
                && mostFrequentCharacterDecodedStr != messageBox.LETTER_E
                && mostFrequentCharacterDecodedStr != messageBox.LETTER_A
                && mostFrequentCharacterDecodedStr != messageBox.LETTER_T
                && mostFrequentCharacterDecodedStr != messageBox.LETTER_RU_A
                && mostFrequentCharacterDecodedStr != messageBox.LETTER_RU_E
                && mostFrequentCharacterDecodedStr != messageBox.LETTER_RU_I
                && mostFrequentCharacterDecodedStr != messageBox.LETTER_RU_O) {

            correctStr = false;
        }
        return correctStr;
    }
}


