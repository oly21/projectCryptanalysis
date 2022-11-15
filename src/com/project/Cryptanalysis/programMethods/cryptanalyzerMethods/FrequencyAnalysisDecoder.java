package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.CheckersMethodsJob.CheckerCorrectnessDecodedStr;
import com.project.Cryptanalysis.programMethods.Alphabet;
import com.project.Cryptanalysis.programMethods.Converter;
import com.project.Cryptanalysis.programMethods.messageBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FrequencyAnalysisDecoder {
    private String decodedString;
    private String[] paragraphsDecodedStrArray;
    char[] decodedStringArray;
    private final Decoder decoder = new Decoder();

    private ArrayList<String> decodedStringKAndKey = new ArrayList<>();
    private int indexParagraphDecodedStr = 0;
    private int key;
    private String paragraphDecodedStr;
    private final CheckerCorrectnessDecodedStr checkerCorrectnessDecodedStr = new CheckerCorrectnessDecodedStr();
    private final DecoderByForce decoderByForce = new DecoderByForce();
    int count = 0;
    private List<Character> alphabet;

    public ArrayList<String> frequencyAnalysisDecode(String stringAnalysis, String encodedString) throws IOException {


        if (encodedString.contains("т") || encodedString.contains("и") || encodedString.contains("л")) {
            alphabet = Alphabet.ALPHABET_RU;
        } else {
            alphabet = Alphabet.ALPHABET_EN;
        }


        int MostFrequentCharacterIndex;
        CheckerCorrectnessDecodedStr checkerCorrectnessDecodedStr = new CheckerCorrectnessDecodedStr();
        MostFrequentCharacterIndex = checkerCorrectnessDecodedStr.findMostFrequentCharacterIndex(stringAnalysis);
        key = getKey(MostFrequentCharacterIndex, alphabet.indexOf(messageBox.SYMBOL_SPACE));
        boolean KeyFind;
        StartDecode(key, encodedString);
        KeyFind = checkCorrectnessDecodeJob();


        while (!KeyFind) {
            if (count <= 4) {
                count++;
                restartDecode(count, MostFrequentCharacterIndex);
            } else {
                startDecodeByForce();
            }
            KeyFind = checkCorrectnessDecodeJob();
        }


        decodedStringKAndKey.add(0, decodedString);
        decodedStringKAndKey.add(1, Integer.toString(key));

        return decodedStringKAndKey;
    }

    public boolean checkCorrectnessDecodeJob() throws IOException {
        //According to statistics, the average English word has no more than 6 letters
        boolean DecodedStrContainMultipleWords = decodedString.length() > 6;
        boolean keyLessAllowLimit = key < 30;

        boolean findSpacesDecodedStr = false;
        boolean findSpacesParagraphsDecodedStr = false;
        if (DecodedStrContainMultipleWords && keyLessAllowLimit) {
            findSpacesDecodedStr = findSpacesDecodedStr();
        }

        if (keyLessAllowLimit) {
            findSpacesParagraphsDecodedStr = findSpacesParagraphsDecodedStr();
        }

        if (!checkerCorrectnessDecodedStr.checkCorrectnessDecodedStr(decodedString)) {
            return false;
        }

        return findSpacesDecodedStr && findSpacesParagraphsDecodedStr;
    }

    public boolean findSpacesDecodedStr()  {

        return decodedString.contains(" ");
    }

    public boolean findSpacesParagraphsDecodedStr() {

        int paragraphCheckLimit = Math.min(paragraphsDecodedStrArray.length, 5);
        for (indexParagraphDecodedStr = 0; indexParagraphDecodedStr < paragraphCheckLimit; indexParagraphDecodedStr++) {
            paragraphDecodedStr = paragraphsDecodedStrArray[indexParagraphDecodedStr];
            boolean ParagraphDecodedStrContainMultipleWords = paragraphDecodedStr.length() > 6;
            if (ParagraphDecodedStrContainMultipleWords && !paragraphDecodedStr.contains(" ")) {
                return false;
            }
        }
        return true;
    }

    public void restartDecode(int count, int MostFrequentCharacterDecodedStrIndex) {
        count++;


        int MostFrequentCharacterInEnglishIndex = Converter.GetIndexMostFrequentCharacterInEnglish(count, alphabet);

        key = getKey(MostFrequentCharacterDecodedStrIndex, MostFrequentCharacterInEnglishIndex);

        decodedString = decoder.decode(decodedString, key);
        paragraphsDecodedStrArray = decodedString.split("[\\r\\n]+");
        decodedStringArray = decodedString.toCharArray();
    }

    public void startDecodeByForce() throws IOException {

        decodedStringKAndKey = decoderByForce.decodeByForce(decodedString, 1);

    }


    public void StartDecode(int key, String encodedString) {
        decodedString = decoder.decode(encodedString, key);
        paragraphsDecodedStrArray = decodedString.split("[\\r\\n]+");
        decodedStringArray = decodedString.toCharArray();

    }


    private int getKey(int MostFrequentCharacterDecodedStrIndex, int MostFrequentCharacterInEnglishIndex) {


        if (MostFrequentCharacterDecodedStrIndex - MostFrequentCharacterInEnglishIndex < 1) {
            key = ((alphabet.size() - 1) - MostFrequentCharacterInEnglishIndex) + MostFrequentCharacterDecodedStrIndex;
        } else {
            key = (alphabet.size() - 1) - MostFrequentCharacterInEnglishIndex;
        }


        return key;
    }


}

