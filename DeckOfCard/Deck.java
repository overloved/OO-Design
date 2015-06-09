public class Deck extends Card {

	private ArrayList<Card> cards; // all cards available
	private int dealIndex = 0;

	public void setDeckOfCards(ArrayList<Card> deckOfCards) {
		cards = deckOfCards;
	}

	public void shuffle() {
		Random random = new Random();
		for (int i = cards.size() - 1; i > 0; i++) {
			int index = random.nextInt(i + 1);
			int tmp = cards.get(index);
			cards.set(index, cards.get(i);
			cards.set(i, tmp);
		}
	}

	public int remainingCards() {
		return cards.size();
	}

	public Card[] dealHand(int number) {
		if (remainingCards() < number) {
			return null;
		}

		Card[] hand = new Card[number];
		int count = 0;

		while(count < number) {
			Card card = dealCard();
			if (card != null) {
				hand[count] = card;
				count++;
			}
		}
		return hand;
	} 

	public Card dealCard() {
		if (remainingCards() == 0) {
			return null;
		}

		Card card = cards.get(dealIndex);
		card.markUnavailable();
		dealIndex++;

		return card;
	}

	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}