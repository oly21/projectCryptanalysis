package com.project.Cryptanalysis.StartMethods;

import java.io.IOException;
import java.nio.file.Path;
import com.project.Cryptanalysis.programMethods.fileJob.FileWrite;
import com.project.Cryptanalysis.programMethods.fileJob.ReadingFile;
import com.project.Cryptanalysis.programMethods.cryptanalyzerMethods.Encryption;
import com.project.Cryptanalysis.programMethods.messageBox;


public class StartEncoding {

    public void startEncodingMethod(int key, Path fileEncrypt) throws IOException {
        Encryption encryption = new Encryption();
        String resultString = encryption.encryptionString(ReadingFile.readingFileMethod(fileEncrypt), key);
        FileWrite.fileWriteMethod(resultString, fileEncrypt, messageBox.NAME_METHOD_ENCODE);
        System.out.println(resultString);


    }
}
