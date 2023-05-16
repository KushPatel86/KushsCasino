import java.util.*;

/**
 * Represents a standard 52-card deck of playing cards.
 *
 * @author Rephactor Java
 * @version 1.0
 */
public class DeckOfCards {
    private Stack<Card> deck = new Stack<Card>();

    /**
     * Fills the list with 52 unique Card objects with the standard ranks and suits.
     * Creates the Value map
     */
    public DeckOfCards() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"};

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        for (String rank : ranks)
            for (String suit : suits)
                deck.push(new Card(rank, suit));
    }

    /**
     * Shuffles the cards in the deck into a random order.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Removes and returns the card from the top of the deck.
     * @return the Card object at index 0, or null if the deck is empty
     */
    public Card dealCard() {
        Card card = null;

        if (deck.size() > 0)
            card = deck.pop();

        return card;
    }

    /**
     * Returns the number of cards currently in the deck.
     * @return the number of cards currently in the deck
     */
    public int numCards() {
        return deck.size();
    }

    /**
     * Returns a string listing the contents of the deck, one card per line.
     * @return a string representation of the current deck
     */
    public String toString() {
        String deckString = "";

        for (Card card : deck)
            deckString += card + "\n";

        return deckString;
    }
}
