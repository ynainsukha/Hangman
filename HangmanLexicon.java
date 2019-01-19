package hangman;

/**
 *
 * @author Yash Nainsukha
 */
public class HangmanLexicon {

    /**
     * Returns the number of words.
     */
    public int getWordCount() {
        return 10;
    }

    /**
     * Returns the word at the specified index.
     *
     * @param index Index of word you want to get.
     * @return Words at index provided.
     */
    public String getWord(int index) throws Exception {
        switch (index) {
            case 0:
                return "BUOY";
            case 1:
                return "COMPUTER";
            case 2:
                return "CONNOISSEUR";
            case 3:
                return "DEHYDRATE";
            case 4:
                return "FUZZY";
            case 5:
                return "HUBBUB";
            case 6:
                return "KEYHOLE";
            case 7:
                return "QUAGMIRE";
            case 8:
                return "SLITHER";
            case 9:
                return "ZIRCON";
            default:
                throw new Exception("getWord: Illegal index");
        }
    };

}
