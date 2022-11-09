package com.project.Cryptanalysis.programMethods;

import java.io.IOException;

public class Сonverter {
    public int converternameTaskMethod(String nameTask) throws IOException {
        int taskNumber = switch (nameTask) {
            case "encode" -> 1;
            case "decode" -> 2;
            case "bruteForce" -> 3;
            case "frequencyAnalysis" -> 4;
            default -> 1;
        };
        return taskNumber;
    }

    public int converterKeyMethod(int count, int index) throws IOException {
        int indexE = 4;
        int key = switch (count) {
            case 1 -> index - indexE;
            case 2 -> index - 19;
            case 3 -> index - 0;
            default -> 4;
        };
        return key;
    }

    public int converterKeySpaceMethod(int count, int index) throws IOException {
        int key = switch (count) {
            case 5 -> index - 26;
            case 6 -> index - 19;
            case 7 -> index - 0;
            default -> 7;
        };
        return key;
    }

}
