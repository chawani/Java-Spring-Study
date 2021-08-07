package blackjack.participant;
import java.util.ArrayList;

import blackjack.card.Card;

public interface Participant {
	public void initMyCards(Card card1,Card card2);
	public ArrayList<Card> getMyCards();
	public void addMyCard(Card card);
	public void addMyPoint(Card card);
	public int getMyPoint();
	public String getName();
	public void setState(String state);
	public String getState();
}
