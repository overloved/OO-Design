public class BlackJackHand extends Hand {

	public int score() {
		ArrayList<Integer> scores = possibleScores();

		int maxUnder21 = Integer.MIN_VALUE;
		int minOver21 = Integer.MAX_VALUE;

		for (int score : scores) {
			if (score > 21 && score < minOver21) {
				minOver21 = score;
			} else if (score <= 21 && score > maxUnder21) {
				maxUnder21 = score;
			}
		}
		return maxUnder21 == Integer.MIN_VALUE ? minOver21 : maxUnder21;
	}

	public ArrayList<Integer> possibleScores() {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		if (cards.size() == 0) {
			return scores;
		}

		for (BlackJack card : cards) {
			addCardToScoreList(card, scores);
		}
		return scores;
	}

	private void addCardToScoreList(BlackJack card, ArrayList<Integer> scores) {
		if (scores.size() == 0) return;
		int length = scores.size();

		for (int i = 0; i < length; i++) {
			int score = scores.get(i);
			scores.set(i, score + card.minValue());
			if (card.minValue() != card.maxValue()) {
				scores.add(score + card.maxValue);
			}
		}
	}

	public boolean busted() {
		return score() > 21;
	}

	public boolean is21() {
		return score() == 21;
	}

	public boolean isBlackJack() {
		if (cards.size() != 2) {
			return false;
		}
		BlackJackCard first = cards.get(0);
		BlackJackCard second = cards.get(1);
		return (first.isAce() && second.isFaceCard()) || (second.isAce() && first.isFaceCard());
	}
}