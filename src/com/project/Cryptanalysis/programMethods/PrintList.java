package com.project.Cryptanalysis.programMethods;

import java.io.IOException;
import java.util.ArrayList;

public class PrintList {
    public   void PrintListMethod ( ArrayList resultStringKeyFromMethod  ) throws IOException {
        for (int i = 0; i < resultStringKeyFromMethod.size(); i++) {
            System.out.println(resultStringKeyFromMethod.get(i));
        }


    }

}
