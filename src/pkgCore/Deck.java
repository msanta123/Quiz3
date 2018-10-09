package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}
	public int getRemaining(Object card) {
		int numCards = 0;
		for(int i = 0; i < cardsInDeck.size();i++) {
			if(card instanceof eRank) {
				if(cardsInDeck.get(i).geteRank() == card) {
					numCards++;
				}
			}
			if(card instanceof eSuit) {
				if(cardsInDeck.get(i).geteSuit() == card) {
					numCards++;
				}
			}
			else {
				System.out.print("Invalid input");
				return 0;
			}
		}
		return numCards;
	}
}
