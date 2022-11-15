package com.project.Cryptanalysis;


import com.project.Cryptanalysis.programMethods.Handlers.*;
import com.project.Cryptanalysis.programMethods.messageBox;

import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {

        CommandHandler commandHandler = new CommandHandler();
        if (args.length < 3) {
            commandHandler.handleCommand(args[0], args[1], messageBox.PROGRAM_NOT_REQUIRE_KEY);
        } else {
            commandHandler.handleCommand(args[0], args[1], args[2]);
        }
    }
}








