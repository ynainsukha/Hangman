package hangman;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
//TODO: add canvas graphics and score

/**
 *
 * @author Yash Nainsukha
 */
public class HangmanPlay {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static StringBuilder guessWord;
    public static String wrongChars;
    public static int tries=8;
    
    private static HangmanCanvas canvas;
    Logger Log = Logger.getLogger(HangmanPlay.class.getName());
    String word;
    

    void play() {

        System.out.println(ANSI_BLUE + "Welcome to Hangman!" + ANSI_RESET);
        HangmanLexicon mHangmanLexicon = new HangmanLexicon();
        Scanner input = new Scanner(System.in);
        HashMap<Character, ArrayList<Integer>> charIndex;
        ArrayList<Character> guessed = new ArrayList<>();

        while (true) {
            try {
                boolean win = false;
                word = mHangmanLexicon.getWord(new Random().nextInt(10));
                //replace every character with "-"
                guessWord = new StringBuilder(word.replaceAll(".", "-"));
                tries = 8;
                wrongChars = "";
                charIndex = indexer();
                guessed.clear();
                /*user input*/
                while (tries != 0 && !win) {
                    System.out.println("The word now looks like this: " + ANSI_PURPLE + guessWord + ANSI_RESET);
                    System.out.println("You have " + ANSI_BLUE + tries + ANSI_RESET + " left.");
                    System.out.println("Your guess? ");
                    
                    //draw word
                    HangmanCanvas.task = 1;
                    canvas.repaint();
                    
                    //trim the leading and trailing spaces
                    String guess = input.nextLine().trim();
                    //check if user provided more then one character
                    if (guess.length() > 1) {
                        System.out.println(ANSI_RED + "Please input only one letter at a time." + ANSI_RESET);
                    } else {
                        char guessedChar = guess.toUpperCase().charAt(0);
                        if (!charIndex.containsKey(guessedChar)) {
                            --tries;
                            wrongChars += guessedChar;
                            System.out.println(ANSI_RED + "There are no " + guessedChar + "'s in word." + ANSI_RESET);
                        } else {
                            if (!guessed.contains(guessedChar)) {
                                for (Integer i : charIndex.get(guessedChar)) {
                                    guessWord.setCharAt(i, guessedChar);
                                }
                                guessed.add(guessedChar);
                                if (guessWord.indexOf("-") == -1) {
                                    win = true;
                                    System.out.println(ANSI_GREEN + "You Won!!!" + ANSI_RESET);
                                    System.out.println("The word was: " + ANSI_PURPLE + guessWord + ANSI_RESET);
                                }
                            }
                        }
                    }
                }

                if (!win) {
                    System.out.println(ANSI_RED + "You lost! Word was " + word + ANSI_RESET);
                }

                System.out.println("Dou you want to play again? (Y/N)");
                guessWord = new StringBuilder("GAME OVER");
                HangmanCanvas.task = 1;
                canvas.repaint();
                if (input.nextLine().trim().equalsIgnoreCase("N")) {
                    System.out.println(ANSI_BLUE + "Good Bye!" + ANSI_RESET);
                    System.exit(0);
                }else{
                    HangmanCanvas.task = 0;
                    canvas.repaint();
                }

            } catch (Exception ex) {
                Log.severe("Exception: " + ex.getMessage());
            }
        }
    }

    /**
     * Indexing the characters in word so that if user guesses the correct
     * character we can directly replace the character in our guessWord string.
     *
     * @param word word characters to be indexed
     * @return HashMap of character as key and ArrayList of indexes
     */
    private HashMap indexer() {
        HashMap<Character, ArrayList<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (indexes.containsKey(word.charAt(i))) {
                indexes.get(word.charAt(i)).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                indexes.put(word.charAt(i), temp);
            }
        }
        return indexes;
    }

    public void init(HangmanPlay play) {
        canvas = new HangmanCanvas();
        canvas.setVisible(true);
        play.play();
    }

    public static void main(String... args) {
        HangmanPlay play = new HangmanPlay();
        play.init(play);
    }
}
