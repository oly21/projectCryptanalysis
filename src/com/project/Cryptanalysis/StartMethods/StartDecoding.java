package com.project.Cryptanalysis.StartMethods;

import com.project.Cryptanalysis.programMethods.fileJob.FileWrite;
import com.project.Cryptanalysis.programMethods.fileJob.ReadingFile;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.Decoding;
import com.project.Cryptanalysis.programMethods.messageBox;
import java.io.IOException;
import java.nio.file.Path;

public class StartDecoding {
    public void startDecodingMethod(int key, Path fileDecrypt) throws IOException {
        Decoding decoding = new Decoding();
        String resultString = decoding.decodingString(ReadingFile.readingFileMethod(fileDecrypt), key);
        FileWrite.fileWriteMethod(resultString, fileDecrypt, messageBox.NAME_METHOD_DECODE);

        System.out.println(resultString);

    }
}