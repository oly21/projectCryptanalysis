package com.project.Cryptanalysis.StartMethods;

import java.io.IOException;
import java.nio.file.Path;

public class StartAllStartMethods {
    public void StartingAllStartMethods(int taskNumber, int key, Path file) throws IOException {
        if (taskNumber == 1) {
            StartEncoding startEncoding = new StartEncoding();
            startEncoding.startEncodingMethod(key, file);
        } else if (taskNumber == 2) {
            StartDecoding startDecoding = new StartDecoding();
            startDecoding.startDecodingMethod(key, file);
        } else if (taskNumber == 3) {
            new StartDecryptionByForce().startDecryptionByForceMethod(file);
        } else if (taskNumber == 4) {
            StartFrequencyAnalysis startFrequencyAnalysis = new StartFrequencyAnalysis();
            startFrequencyAnalysis.StartFrequencyAnalysisMethod(file);

        }

    }
}
