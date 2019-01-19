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
    
    static void run(){
        HangmanLexicon mHangmanLexicon = new HangmanLexicon();
        while(true){
            try {
                String word = mHangmanLexicon.getWord(new Random().nextInt(10));
                HashMap<Character,ArrayList<Integer>> indexer = new HashMap<>();
                for(int i=0; i<word.length()-1;i++){
                    if(indexer.containsKey(word.charAt(i))){
                        indexer.get(word.charAt(i)).add(i);
                    }
                }
            } catch (Exception ex) {
                System.out.println("Exception: "+ex.getMessage());
            }
        }
    }
    
    public static void main(String... args){
        run();
    }
}
