package com.project.Cryptanalysis.programMethods;


public class Converter {
    public int convertnameTask(String nameTask) {
        int taskNumber = switch (nameTask) {
            case "encode" -> 1;
            case "decode" -> 2;
            case "bruteForce" -> 3;
            case "frequencyAnalysis" -> 4;
            default -> 1;
        };
        return taskNumber;
    }

    public int convertKey(int count, int index) {
        int indexE = 4;
        int key = switch (count) {
            case 1 -> index - indexE;
            case 2 -> index - 19;
            case 3 -> index;
            default -> 4;
        };
        return key;
    }

    public int convertKeySpace(int count, int index) {
        int key = switch (count) {
            case 5 -> index - 26;
            case 6 -> index - 19;
            case 7 -> index;
            default -> 7;
        };
        return key;
    }

}
