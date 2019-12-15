package app;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Controller {
    static Scanner reader = new Scanner(System.in);
    public static int playersLife = 0;
    public static int life = 5;
    public static String countryAndCapital;
    public static String capitol;
    public static String guess;
    public static String hiddenWord;
    public static String joinedHiddenWord;

    public static void mainController() {
        long startTime = System.nanoTime();
        List<String> usedLetters = new ArrayList<>();
        LogicHandler.clearScreen();
        FileHandler
                .getTxtFileString("src/app/countries_and_capitals.txt");
        FileHandler.getHangmanArt("src/app/hangman.txt");
        countryAndCapital = FileHandler.stringSpliter();
        capitol = FileHandler.countryAndCapitalSplitter().toUpperCase();
        LogicHandler.capitalLength();
        LogicHandler.hiddenWord();
        FileHandler.hangmanArtSpliter();
        while (life > 0) {
            joinedHiddenWord = LogicHandler.joinedHiddenWord();
            System.out.println("HANGMAN\n");
            System.out.println("Used letters: " + usedLetters + "\n");
            System.out.println(FileHandler.hangmanArtlist(playersLife));
            System.out.println(LogicHandler.joinedHiddenWord() + "\n");
            System.out.println(capitol);
            System.out.println("\nTake a guess: ");
            guess = reader.nextLine().toUpperCase();
            LogicHandler.clearScreen();

            if (guess.length() == 1) {
                if (capitol.contains(guess)) {
                    LogicHandler.clearScreen();
                    System.out.println("Thats a good letter!\n");
                    int playerGuess = capitol.indexOf(guess);
                    while (playerGuess >= 0) {
                        LogicHandler.hiddenWordList.set(playerGuess, guess);
                        playerGuess = capitol.indexOf(guess, playerGuess + 1);
                        joinedHiddenWord = LogicHandler.joinedHiddenWord();
                        if (joinedHiddenWord.equals(capitol)) {
                            long endTime = System.nanoTime();
                            long totalTime = (endTime - startTime) / 1000000000;
                            LogicHandler.clearScreen();
                            System.out.println("You have guessed! Congratulations!\n");
                            System.out.println("The word is: " + capitol + "\n");
                            System.out.println("Your game time: " + totalTime + " seconds\n");
                            System.exit(0);
                        }
                    }
                } else {
                    LogicHandler.clearScreen();
                    System.out.println("Not this time!\n");
                    usedLetters.add(guess);
                    playersLife += 1;
                    life -= 1;
                }
            } else {
                System.out.println("Single letter only!\n");
            }
        }
        LogicHandler.clearScreen();
        System.out.println(FileHandler.hangmanArtlist(5));
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000000;
        System.out.println("Game over\n");
        System.out.println("Try later\n");
        System.out.println("Your game time: " + totalTime + " seconds\n");
    }
}