import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BlackJack {
	// Maps card ranks to numeric values for BlackJack
	public static Map<String, Integer> valueMap = new HashMap<String, Integer>();

	public static void main(String[] args) {
		fillMap(); // Fills the map with values for each of the ranks

		/** @todo: set up the two empty hands using LinkedLists */
		LinkedList<Card> myHand = new LinkedList<Card>();
		LinkedList<Card> dealerHand = new LinkedList<Card>();

		// Makes the Scanner object
		Scanner sc = new Scanner(System.in);

		// PLAY BLACKJACK
		System.out.println("Welcome to Blackjack!");
		DeckOfCards deck = new DeckOfCards();

		// shuffle the cards
		System.out.println("Shuffling and dealing");
		deck.shuffle();

		/**
		 * @todo Deal the initial two cards to each player. Print the player's hand and
		 *       the dealer's first card.
		 */
		myHand.add(deck.dealCard());
		myHand.add(deck.dealCard());
		dealerHand.add(deck.dealCard());
		dealerHand.add(deck.dealCard());
		System.out.println("Your hand: " + myHand);
		System.out.println("The dealer: " + dealerHand.peek());

		// goes into the loop once and cuts it after the first iteration if either hand
		// exceeds 21
		do {
			/**
			 * @todo implement player logic 1) Print current hand value for player 2) Ask
			 *       hit or stay 3) If hit draw card and repeat unless over 21 4) If stay,
			 *       move on to dealer
			 */
			System.out.println("Your hand is best valued at: " + countHand(myHand));
			System.out.println("Would you like to Hit (H) or Stay (S)?");
			if (sc.next().equalsIgnoreCase("H")) {
				Card temp = deck.dealCard();
				myHand.add(temp);
				System.out.println("You drew the " + temp);
				System.out.println("Your hand is best valued at: " + countHand(myHand));
			} else {
				System.out.println("Your hand is best valued at: " + countHand(myHand));
				dealerHand.add(deck.dealCard());
				System.out.println("The dealer drew " + dealerHand.peekLast() + " and the dealer's hand is best worth "
						+ countHand(dealerHand));
				break;
			}

			/**
			 * @todo If player went over 21 print loser message and exit the game Otherwise
			 *       print the current hand value for the player
			 */
			if (countHand(myHand) > 21) {
				System.out.println("You lose! The house always wins!");
				return;
			} else {
				System.out.println("Your hand value: " + countHand(myHand));
			}

			/** @todo Draw dealer cards until dealer is >= 17 */
			while (countHand(dealerHand) < 17) {
				dealerHand.add(deck.dealCard());
			}

			/** @todo Print dealer's hand and value of the hand */
			System.out.println("Dealer's hand: " + dealerHand);
			System.out.println("Dealer's hand value: " + countHand(dealerHand));

		} while (countHand(myHand) < 21 && countHand(dealerHand) < 21);

		/** @todo Determine win or tie and print message */
		if (countHand(dealerHand) > 21 || countHand(myHand) > countHand(dealerHand)) {
			System.out.println("You win!");
		} else if (countHand(dealerHand) > countHand(myHand)) {
			System.out.println("You lose! The house always wins!");
		} else {
			System.out.println("It's a tie.");
		}

	}

	/**
	 * Method to fill the map of values. (Excludes Ace)
	 */
	public static void fillMap() {
		valueMap.put("2", 2);
		valueMap.put("3", 3);
		valueMap.put("4", 4);
		valueMap.put("5", 5);
		valueMap.put("6", 6);
		valueMap.put("7", 7);
		valueMap.put("8", 8);
		valueMap.put("9", 9);
		valueMap.put("10", 10);
		valueMap.put("Jack", 10);
		valueMap.put("Queen", 10);
		valueMap.put("King", 10);
		// Finish filling in the map of values
		// Up to King, excluding Ace

	}

	/**
	 * Get the value of a hand of cards
	 * 
	 * @param hand the current hand of cards
	 * @return The value of the cards (highest under 21 given an ace)
	 */
	public static int countHand(List<Card> hand) {
		// Fill in the logic to count the value of a hand
		// Carefully consider how ace(s) change the value of a hand
		// Use the getRank method and the valueMap to find the numeric value
		// for non-ace cards.
		int sum = 0;
		int numAces = 0;

		for (Card card : hand) {
			if (card.getRank() == "Ace") {
				numAces++;
			} else {
				sum += valueMap.get(card.getRank());
			}
		}

		for (int i = 0; i < numAces; i++) {
			if (sum + 11 <= 21) {
				sum += 11;
			} else {
				sum += 1;
			}
		}

		return sum;

	}

}