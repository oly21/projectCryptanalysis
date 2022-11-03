package com.project.Cryptanalysis;

import com.project.Cryptanalysis.programMethods.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


/* 
Проверка присутствия
*/

public class Solution {


    public static void main(String[] args) throws IOException {


        if (Integer.parseInt(args[2]) >= 30) {
            System.out.println("ключ должен быть меньше 30");

        } else {
            ArrayList<String> resultStringKeyFromMethod = new ArrayList<String>();
            boolean rightProgram = false;

            Scanner scanner = new Scanner(System.in);

            int taskNumber = switch (args[0]) {
                case "encode" -> 1;
                case "decode" -> 2;
                case "bruteForce" -> 3;
                case "frequencyAnalysis" -> 4;
                default -> 1;
            };
            int key;

            if (taskNumber == 1) {
                key = Integer.parseInt(args[2]);
                Path fileEncrypt = Path.of(args[1]);


                System.out.println(encryption.encryptionString(readingFile.readingFileMethod(fileEncrypt), key, fileEncrypt));

            } else if (taskNumber == 2) {

                key = Integer.parseInt(args[2]);
                Path fileDecrypt = Path.of(args[1]);

                System.out.println(decoding.decodingString(readingFile.readingFileMethod(fileDecrypt), key, fileDecrypt));

            } else if (taskNumber == 3) {

                Path fileDecrypt = Path.of(args[1]);
                key = 1;

                resultStringKeyFromMethod = DecryptionByForce.DecryptionByForceString(readingFile.readingFileMethod(fileDecrypt), key, fileDecrypt);

                for (int i = 0; i < resultStringKeyFromMethod.size(); i++) {
                    System.out.println(resultStringKeyFromMethod.get(i));

                }
                while (rightProgram == false) {
                    System.out.println("Правильно ли произошла расшифровка файла? Если правильно  введите 1, если нет то 2 ");
                    int userEvaluation = scanner.nextInt();
                    if (userEvaluation == 1) {
                        System.out.println("Спасибо за оценку");
                        rightProgram = true;
                        fileWrite.fileWrite1(resultStringKeyFromMethod.get(0), Path.of(args[1]), "bruteForce", resultStringKeyFromMethod.get(1));
                    } else {
                        System.out.println("Программа продолжит расшифровывать текст");
                        key = Integer.parseInt(resultStringKeyFromMethod.get(1));
                        key++;
                        resultStringKeyFromMethod = DecryptionByForce.DecryptionByForceString(readingFile.readingFileMethod(fileDecrypt), key, fileDecrypt);
                        for (int i = 0; i < resultStringKeyFromMethod.size(); i++) {
                            System.out.println(resultStringKeyFromMethod.get(i));

                        }

                    }
                }
            } else if (taskNumber == 4) {
                int key1;
                final int FirstKey1;
                System.out.println("Введите путь к  закодированному большому файлу для сбора статистики");
                Path fileAnalysis = Path.of(scanner.next());

                Path fileDecrypt = Path.of(args[1]);

                resultStringKeyFromMethod = frequencyAnalysis.frequencyAnalysisString(readingFile.readingFileMethod(fileAnalysis), readingFile.readingFileMethod(fileDecrypt), fileDecrypt);
                FirstKey1 = Integer.parseInt(resultStringKeyFromMethod.get(1));

                for (int i = 0; i < resultStringKeyFromMethod.size(); i++) {
                    System.out.println(resultStringKeyFromMethod.get(i));

                }

                while (rightProgram == false) {
                    System.out.println("Правильно ли произшла расшифровка файла? Если правилтно  введите 1, если нет то 2 ");
                    int userEvaluation = scanner.nextInt();
                    if (userEvaluation == 1) {
                        System.out.println("Спасибо за оценку");
                        rightProgram = true;
                        fileWrite.fileWrite1(resultStringKeyFromMethod.get(0), Path.of(args[1]), "bruteForce", resultStringKeyFromMethod.get(1));

                    } else {

                        key1 = Integer.parseInt(resultStringKeyFromMethod.get(1));
                        if (key1 < 31) {

                            System.out.println("Программа продолжит расшифровывать текст");
                            key1++;
                            for (int i = 0; i < resultStringKeyFromMethod.size(); i++) {
                                System.out.println(resultStringKeyFromMethod.get(i));

                            }

                            resultStringKeyFromMethod = DecryptionByForce.DecryptionByForceString(readingFile.readingFileMethod(fileDecrypt), key1, fileDecrypt);
                        } else if (key1 < 31 && key1 > 0) {


                            System.out.println("Программа продолжит расшифровывать текст");
                            key1 = FirstKey1;
                            key1--;
                            for (int i = 0; i < resultStringKeyFromMethod.size(); i++) {
                                System.out.println(resultStringKeyFromMethod.get(i));

                            }
                            resultStringKeyFromMethod = DecryptionByForce.DecryptionByForceString(readingFile.readingFileMethod(fileDecrypt), key1, fileDecrypt);
                        }


                    }
                }
            }


        }
    }
}





