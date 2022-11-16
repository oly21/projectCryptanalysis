package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;


import com.project.Cryptanalysis.programMethods.Alphabet;
import com.project.Cryptanalysis.programMethods.messageBox;
import java.util.List;


public class Decoder {


    private List<Character> alphabet;

    private final String commandNameB = messageBox.COMMAND_NAME_BEGIN;
    private final String commandNameE = messageBox.COMMAND_NAME_END;


    public String decode(String encodedString, int key) {


        if (encodedString.contains("т") || encodedString.contains("и") || encodedString.contains("л")) {
            alphabet = Alphabet.ALPHABET_RU;
        } else {
            alphabet = Alphabet.ALPHABET_EN;
        }

        char[] encodedStringArray;
        String decodedString;
        int indexEncodedStrArray;
        encodedStringArray = encodedString.toCharArray();
        char symbolOriginalArray;
        int indexAlphabet;


        for (indexEncodedStrArray = 0; indexEncodedStrArray < encodedStringArray.length; indexEncodedStrArray++) {
            symbolOriginalArray = encodedStringArray[indexEncodedStrArray];
            if (alphabet.contains(symbolOriginalArray)) {
                indexAlphabet = alphabet.indexOf(symbolOriginalArray);
            } else {
                continue;
            }

            //Number of characters remaining at the beginning  of the alphabet
            int numberSymbolsToBeginAlphabet = indexAlphabet;
            if (numberSymbolsToBeginAlphabet >= key) {
                changeSymbolInEncodedStrArray(
                        indexEncodedStrArray,
                        encodedStringArray,
                        indexAlphabet,
                        commandNameB,
                        key);

            } else if (numberSymbolsToBeginAlphabet < key) {


                changeSymbolInEncodedStrArray(
                        indexEncodedStrArray,
                        encodedStringArray,
                        indexAlphabet,
                        commandNameE,
                        key);
            }
        }

        decodedString = new String(encodedStringArray);

        return decodedString;
    }

    private char getDisplacedSymbolAlphabetBegin(int indexAlphabet, int key) {

        char displacedSymbolAlphabetBegin = alphabet.get(indexAlphabet - key);

        return displacedSymbolAlphabetBegin;
    }

    private char getDisplacedSymbolAlphabetEnd(int indexAlphabet, int key) {

        int numberSymbolsToBeginAlphabet = indexAlphabet;
        //A number indicating the number of remaining Symbols offsets in the alphabet
        int RemainingNumberOfOffsetsInAlphabet = (key - numberSymbolsToBeginAlphabet);
        char displaceSymbolAlphabetEnd = alphabet.get((alphabet.size() - 1) - RemainingNumberOfOffsetsInAlphabet);

        return displaceSymbolAlphabetEnd;
    }

    private void changeSymbolInEncodedStrArray(
            int indexEncodedStrArray,
            char[] encodedStringArray,
            int indexAlphabet,
            String commandName,
            int key) {

        if (commandName.equals(commandNameB)) {
            encodedStringArray[indexEncodedStrArray] = getDisplacedSymbolAlphabetBegin(indexAlphabet, key);
        } else {
            encodedStringArray[indexEncodedStrArray] = getDisplacedSymbolAlphabetEnd(indexAlphabet, key);
        }
    }
}

