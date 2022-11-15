package com.project.Cryptanalysis.programMethods;


import java.util.List;

public class Converter {
    public static int convertNameTask(String nameTask) {
        int taskNumber = switch (nameTask) {
            case messageBox.NAME_METHOD_ENCODE -> 1;
            case messageBox.NAME_METHOD_DECODE -> 2;
            case messageBox.NAME_METHOD_BRUTEFORCE -> 3;
            case messageBox.NAME_METHOD_FREQUENCYANALYSISI -> 4;
            default -> 1;
        };
        return taskNumber;

    }

    public static int GetIndexMostFrequentCharacterInEnglish(int count, List<Character> alphabet) {

        int indexSpase;
        int indexE;
        int indexA;
        int indexRuIorEnT;
        int indexO;
        if (alphabet.contains('т') || alphabet.contains('и') || alphabet.contains('л')) {

            indexSpase = alphabet.indexOf(messageBox.SYMBOL_SPACE);
            indexE = alphabet.indexOf(messageBox.LETTER_RU_E);
            indexA = alphabet.indexOf(messageBox.LETTER_RU_A);
            indexRuIorEnT = alphabet.indexOf(messageBox.LETTER_RU_I);
            indexO = alphabet.indexOf(messageBox.LETTER_RU_O);
        } else {

            indexSpase = alphabet.indexOf(messageBox.SYMBOL_SPACE);
            indexE = alphabet.indexOf(messageBox.LETTER_E);
            indexA = alphabet.indexOf(messageBox.LETTER_A);
            indexRuIorEnT = alphabet.indexOf(messageBox.LETTER_T);
            indexO = alphabet.indexOf(messageBox.LETTER_O);
        }

        int taskNumber = switch (count) {
            case 1 -> indexSpase;
            case 2 -> indexE;
            case 3 -> indexRuIorEnT;
            case 4 -> indexA;
            default -> indexO;

        };


        return taskNumber;
    }
}