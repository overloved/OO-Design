public class Hand extends Card {

	protected ArrayList<Card> cards;

	public Card() {
		cards = new ArrayList<Card>();
	}

	public int score() {
		int score = 0;
		for (Card c : cards) {
			score += c.getValue();
		}
		return score;
	}

	public void addCard(Card c) {
		cards.add(card);
	}

	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}