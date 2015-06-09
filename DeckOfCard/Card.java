public abstract class Card {

	private boolean availale = true;

	protected int val;
	protected Suit suit;

	public Card(int val, Suit suit) {
		this.val = val;
		this.suit = suit;
	}

	public abstract int getValue();

	public Suit getSuit() {
		return suit;
	}

	/* check if the card is available to give out to someone */

	public boolean isAvailable() {
		return available;
	}

	public boolean markUnavailable() {
		available = false;
	}

	public boolean markAvailable() {
		available = true;
	}

	public void print() {
		String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		System.out.print(faceValues[val - 1]);

		switch (suit) {
		case Club:
			System.out.print("c");
			break;
		case Heart:
			System.out.print("h");
			break;
		case Diamond:
			System.out.print("d");
			break;
		case Spade:
			System.out.print("s");
			break;			
		}
		System.out.print(" ");
	}
}