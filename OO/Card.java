public class Card {

	public enum Suit {
		CLUBS (1), SPADES (2), HEARTS (3), DIAMONDS(4);
		int val;

		private Suit(int val) {
			this.val = val; 
		}
	}

	private int card;
	private Suit suit;

	public Card(int val, Suit suit) {
		this.card = val;
		this.suit = suit;
	}

	public int getCard() {
		return card;
	}

	public Suit getSuit() {
		return suit;
	}
}
