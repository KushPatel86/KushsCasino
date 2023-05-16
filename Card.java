import java.util.*;
/**
 * Represents a single playing card with a rank and suit.
 *
 * @author Rephactor Java
 * @version 1.0
 */
public class Card {
    private String rank;
    private String suit;
    
    /**
     * Sets the rank and suit of this card.
     * @param cardRank the rank of this card
     * @param cardSuit the suit of this card
     */
    public Card(String cardRank, String cardSuit) {
        rank = cardRank;
        suit = cardSuit;
    }

    /**
     * Returns a string describing this card (Ex: "Ace of Spades").
     * @return a string description of this card
     */
    public String toString() {
        return rank + " of " + suit;
    }
    
    public String getRank() {
    	return rank;
    }
}