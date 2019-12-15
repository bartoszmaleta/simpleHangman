package app;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicHandler {
    public static int capitalLength;
    public static String hiddenWord;
    public static List<String> hiddenWordList = new ArrayList<String>();

    public static int capitalLength() {
        capitalLength = Controller.capitol.length();
        return capitalLength;
    }

    public static void hiddenWord() {
        for (int i = 0; i < capitalLength; i++) {
            hiddenWordList.add("-");
        }
    }

    public static String joinedHiddenWord() {
        String joinedHiddenWord = String.join("", hiddenWordList);
        return joinedHiddenWord;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}