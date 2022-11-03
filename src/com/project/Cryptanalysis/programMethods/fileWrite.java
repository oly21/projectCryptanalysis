package com.project.Cryptanalysis.programMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class fileWrite {
    public static String fileWrite1(String resultString, Path originalFile, String nameMethod ) throws IOException {



        String fileName  = originalFile.getFileName().toString();


        String  fileResultAbsolutePath = originalFile.toString();
        String fileNameResult  = fileResultAbsolutePath + nameMethod ;

        Path fileResult1 = Path.of(fileNameResult);

        if(Files.exists(fileResult1)) {

            Files.delete(fileResult1);
            Files.createFile(fileResult1);
        }
        else{
            Files.createFile(fileResult1);
        }
        Files.writeString(fileResult1, resultString);
        return  resultString;
    }
    public static String fileWrite1(String resultString, Path originalFile, String nameMethod,  String key) throws IOException {



        String fileName  = originalFile.getFileName().toString();
       String  fileResultAbsolutePath = originalFile.toString();
        String fileNameResult  = fileResultAbsolutePath + nameMethod  + key ;

        Path fileResult1 = Path.of(fileNameResult);


       if(Files.exists(fileResult1)) {

            Files.delete(fileResult1);
            Files.createFile(fileResult1);
        }
        else{
            Files.createFile(fileResult1);
        }
        Files.writeString(fileResult1, resultString);
        return  resultString;
    }

    }