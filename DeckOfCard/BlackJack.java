public class BlackJack extends Card {

	public BlackJack(int val, Suit suit) {
		super(val, suit);
	}

	public int getValue() {
		if (isAce()) {
			return 1;
		} else if (isFaceCard()) {
			return 10;
		} else {
			return val;
		}
	}

	public int minValue() {
		if (isAce()) return 1;
		return getValue();
	}

	public int maxValue() {
		if (isAce()) return 11;
		return getValue();
	}

	public boolean isAce() {
		return val == 1;
	}

	public boolean isFaceCard() {
		return val >= 11 && val <= 13;
	}
}