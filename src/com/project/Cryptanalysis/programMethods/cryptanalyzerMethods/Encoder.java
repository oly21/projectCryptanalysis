package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;


import com.project.Cryptanalysis.programMethods.Alphabet;
import com.project.Cryptanalysis.programMethods.messageBox;
import java.util.List;


public class Encoder {
    private final String commandNameR = messageBox.COMMAND_NAME_RIGHT;
    private String commandNameB = messageBox.COMMAND_NAME_BEGIN;
    private List<Character> alphabet;

    public String encode(String originalString, int key) {

        if (originalString.contains("т") || originalString.contains("и") || originalString.contains("л")) {
            alphabet = Alphabet.ALPHABET_RU;
        } else {
            alphabet = Alphabet.ALPHABET_EN;
        }


        String encodedString;
        int indexOriginStrArray;
        char[] originStringArray = originalString.toCharArray();
        char symbolOriginalArray;
        int indexAlphabet;


        for (indexOriginStrArray = 0; indexOriginStrArray < originStringArray.length; indexOriginStrArray++) {
            symbolOriginalArray = originStringArray[indexOriginStrArray];

            if (alphabet.contains(symbolOriginalArray)) {
                indexAlphabet = alphabet.indexOf(symbolOriginalArray);
            } else {
                continue;
            }
            //Number of characters remaining until the end of the alphabet
            int numberSymbolsToEndAlphabet = (alphabet.size() - 1) - indexAlphabet;

            if (numberSymbolsToEndAlphabet > key) {

                changeSymbolInOriginalStrArray(
                        indexOriginStrArray,
                        originStringArray,
                        indexAlphabet,
                        commandNameR,
                        key);

            } else if (numberSymbolsToEndAlphabet <= key) {

                changeSymbolInOriginalStrArray(
                        indexOriginStrArray,
                        originStringArray,
                        indexAlphabet,
                        commandNameB,
                        key);
            }

        }
        encodedString = new String(originStringArray);

        return encodedString;
    }


    private char getDisplacedSymbolAlphabetRight(int indexAlphabet, int key) {

        char displacedSymbolAlphabetRight = alphabet.get(indexAlphabet + key);

        return displacedSymbolAlphabetRight;
    }

    private char getDisplacedSymbolAlphabetBegin(int indexAlphabet, int key) {

        int numberSymbolsToEndAlphabet = (alphabet.size() - 1) - indexAlphabet;
        char displaceSymbolAlphabetBegin = alphabet.get(key - numberSymbolsToEndAlphabet);

        return displaceSymbolAlphabetBegin;
    }


    private void changeSymbolInOriginalStrArray(int indexOriginalStrArray, char[] originalStringArray,
                                               int indexAlphabet, String commandName, int key) {

        if (commandName.equals(commandNameR)) {
            originalStringArray[indexOriginalStrArray] = getDisplacedSymbolAlphabetRight(indexAlphabet, key);
        } else {
            originalStringArray[indexOriginalStrArray] = getDisplacedSymbolAlphabetBegin(indexAlphabet, key);
        }
    }
}


