package app;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileHandler {
    public static int randomIndex;
    public static String a;
    public static String chosenCapitalAndCountry;
    public static String chosenCapital;
    public static String hangmanArt;
    public static List<String> splitedHangmanArt;

    public static String getTxtFileString(String FilePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(FilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        a = content;
        randomIndex = getRandomNumberInRange(0, 183);
        stringSpliter();
        return content;
    }

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
    }

    public static String stringSpliter() {
        String[] aArr = a.split("\n");
        List<String> aList = Arrays.asList(aArr);
        chosenCapitalAndCountry = aList.get(randomIndex);
        return chosenCapitalAndCountry;
    }

    public static String countryAndCapitalSplitter() {
        String[] chosenCapitalAndCountryArr = chosenCapitalAndCountry.split(" \\| ");
        List<String> chosenCapitalAndCountryList = Arrays.asList(chosenCapitalAndCountryArr);
        chosenCapital = chosenCapitalAndCountryList.get(1);
        return chosenCapital;
    }

    public static List<String> hangmanArtSpliter() {
        String[] hangmanArtArr = hangmanArt.split("-d-");
        List<String> hangmanArtList = Arrays.asList(hangmanArtArr);
        splitedHangmanArt = hangmanArtList;
        return splitedHangmanArt;
    }

    public static String hangmanArtlist(int playersLife) {
        hangmanArt = splitedHangmanArt.get(playersLife);
        return hangmanArt;
    }

    public static String getHangmanArt(String FilePath) {
        String hangman = "";
        try {
            hangman = new String(Files.readAllBytes(Paths.get(FilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        hangmanArt = hangman;
        return hangman;
    }
}
