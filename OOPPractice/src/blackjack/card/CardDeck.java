package blackjack.card;
import java.util.ArrayList;
import java.util.Collections;

enum Suits{ SPADE,HEART,DIAMOND,CLUB }

public class CardDeck {
	private ArrayList<Card> cardDeck=new ArrayList<>();
	private final String[] CHARACTERS= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	private CardDeck() {
		addCard();
	}

	public static CardDeck create() {
		return new CardDeck();
	}
	
	public ArrayList<Card> getCardDeck() {
		return cardDeck;
	}

	public void addCard() {
		for (Suits suit: Suits.values()) {
			for(String character:CHARACTERS) {
				Card card=getCard(suit,character);
				cardDeck.add(card);
			}
        }
	}
	
	public Card getCard(Suits suit,String character) {
		return Card.create(suit.name(), character);
	}
	
	public void suffleCards() {
		Collections.shuffle(cardDeck);
	}
}
