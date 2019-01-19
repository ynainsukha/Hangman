/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

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

    static void run() {
        HangmanLexicon mHangmanLexicon = new HangmanLexicon();
        while (true) {
            try {
                String word = mHangmanLexicon.getWord(new Random().nextInt(10));

                //replace every character with "-"
                String guessWord = word.replaceAll(".", "-");
                HashMap<Character, ArrayList<Integer>> indexer = new HashMap<>();

                /*Indexing the characters in word so that if user gusses the correct character
                  we can directly replace the character in our guessWord string.
                 */
                for (int i = 0; i < word.length() - 1; i++) {
                    if (indexer.containsKey(word.charAt(i))) {
                        indexer.get(word.charAt(i)).add(i);
                    } else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        indexer.put(word.charAt(i), temp);
                    }
                }

                /*user input*/
                
                
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    public static void main(String... args) {
        run();
    }
}
