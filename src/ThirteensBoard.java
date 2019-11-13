import java.util.List;
import java.util.ArrayList;
/**
 * The ThirteensBoard class represents the board in a game of Elevens.
 */
public class ThirteensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 10;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS
            = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS
            = {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES
            = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

    /**
     * The cards on this board.
     */
    private Card[] cards;

    /**
     * The deck of cards being used to play the current game.
     */
    private Deck deck;

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;

    /**
     * Creates a new <code>ThirteensBoard</code> instance.
     */
    public ThirteensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal. In
     * Elevens, the legal groups are (1) a pair of non-face cards whose values
     * add to 13, and a king.
     *
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal; false
     * otherwise.
     */
    public boolean isLegal(List<Integer> selectedCards) {
        // if there are two cards.. return containsPairSum13
        if(selectedCards.size() == 2) return containsPairSum13(selectedCards);
        // if there are three cards.. return containsKing
        if(selectedCards.size() == 1) return containsKing(selectedCards);
        // else return false
        else return false;
    }

    /**
     * Determine if there are any legal plays left on the board. In Elevens,
     * there is a legal play if the board contains (1) a pair of non-face cards
     * whose values add to 13, or a king.
     *
     * @return true if there is a legal play left on the board; false otherwise.
     */
    public boolean anotherPlayIsPossible() {
        //gets all cards on the board
        List<Integer> cardsLeftOnBoard = cardIndexes();
        return this.containsPairSum13(cardsLeftOnBoard) ||
                this.containsKing(cardsLeftOnBoard);
    }

    /**
     * Check for an 11-pair in the selected cards.
     *
     * @param selectedCards selects a subset of this board. It is list of
     * indexes into this board that are searched to find an 13-pair.
     * @return true if the board entries in selectedCards contain an 13-pair;
     * false otherwise.
     */
    private boolean containsPairSum13(List<Integer> selectedCards) {
        for(int x = 0; x < selectedCards.size(); x++){
            int firstCardIndex = selectedCards.get(x).intValue();
            Card outer = this.cardAt(firstCardIndex);
            for(int i = 0; i < selectedCards.size(); i++){
                int secondCardIndex = selectedCards.get(i).intValue();
                Card inner = this.cardAt(secondCardIndex);
                if(firstCardIndex != secondCardIndex && 
                        outer.pointValue() + inner.pointValue() == 13)
                            return true;
            }
        }
        return false;
        
    }

    /**
     * Check for a King in the selected cards.
     *
     * @param selectedCards selects a subset of this board. It is list of
     * indexes into this board that are searched to find a King.
     * @return true if the board entries in selectedCards include a king; 
     * false otherwise.
     */
    private boolean containsKing(List<Integer> selectedCards) {
        boolean king = false;
        //loop through cards on board
        for(Integer i : selectedCards){
            if(cardAt(i).rank().equals("king"))king = true;
        }
        return king;
    }
}
