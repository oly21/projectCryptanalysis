package com.project.Cryptanalysis.programMethods.cryptanalyzerMethods;

import com.project.Cryptanalysis.CheckersMethodsJob.CheckerCorrectnessDecodedStr;
import java.io.IOException;
import java.util.ArrayList;

public class DecoderByForce {
    private String decodedString;
    private String[] paragraphsDecodedStrArray;
    char[] decodedStringArray;
    private final Decoder decoder = new Decoder();
    private ArrayList<String> decodedStringKAndKey = new ArrayList<>();
    private int indexParagraphDecodedStr = 0;
    private int key = 0;
    String paragraphDecodedStr;
    CheckerCorrectnessDecodedStr checkerCorrectnessDecodedStr = new CheckerCorrectnessDecodedStr();
    String encodedString;

    public ArrayList<String> decodeByForce(String encodedString, int key) throws IOException {
        this.key = key;
        this.encodedString = encodedString;
        StartDecode(key, encodedString);
        checkCorrectnessDecodeJob();


        if (decodedStringKAndKey.size() > 0) {
            decodedStringKAndKey.remove(0);
            decodedStringKAndKey.remove(0);
            decodedStringKAndKey.add(0, decodedString);
            decodedStringKAndKey.add(1, Integer.toString(this.key));
        } else {
            decodedStringKAndKey.add(0, decodedString);
            decodedStringKAndKey.add(1, Integer.toString(this.key));
        }


        return decodedStringKAndKey;
    }

    public void checkCorrectnessDecodeJob() throws IOException {
        //According to statistics, the average English word has no more than 6 letters
        boolean DecodedStrContainMultipleWords = decodedString.length() > 6;
        boolean keyLessAllowLimit = key < 30;

        if (DecodedStrContainMultipleWords && keyLessAllowLimit) {
            findSpacesDecodedStr();
        }

        if (keyLessAllowLimit) {
            findSpacesParagraphsDecodedStr();
        }

        if (encodedString.length() > 2000) {
            if (!checkerCorrectnessDecodedStr.checkCorrectnessDecodedStr(decodedString)) {
                restartDecode();
                checkCorrectnessDecodeJob();
            }
        }
    }

    public void findSpacesDecodedStr() throws IOException {

        if (!decodedString.contains(" ")) {
            restartDecode();
            checkCorrectnessDecodeJob();
        }
    }

    public void findSpacesParagraphsDecodedStr() throws IOException {
        int paragraphCheckLimit = Math.min((paragraphsDecodedStrArray.length - 1), 5);
        paragraphDecodedStr = paragraphsDecodedStrArray[0];
        for (indexParagraphDecodedStr = 0; indexParagraphDecodedStr < paragraphCheckLimit; indexParagraphDecodedStr++) {
            paragraphDecodedStr = paragraphsDecodedStrArray[indexParagraphDecodedStr];
            boolean ParagraphDecodedStrContainMultipleWords = paragraphDecodedStr.length() > 6;
            if (ParagraphDecodedStrContainMultipleWords && !paragraphDecodedStr.contains(" ")) {
                restartDecode();
                checkCorrectnessDecodeJob();
            }
        }
    }

    public void restartDecode() {

        key++;
        decodedString = decoder.decode(encodedString, key);
        paragraphsDecodedStrArray = decodedString.split("[\\r\\n]+");
        decodedStringArray = decodedString.toCharArray();

    }

    public void StartDecode(int key, String encodedString) {
        decodedString = decoder.decode(encodedString, key);
        paragraphsDecodedStrArray = decodedString.split("[\\r\\n]+");
        decodedStringArray = decodedString.toCharArray();

    }
}























