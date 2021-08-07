package blackjack.participant;
import java.util.ArrayList;

import blackjack.card.Card;

public class Player implements Participant{
	private String name;
	private ArrayList<Card> myCards=new ArrayList<>();
	private int myPoint=0;
	private String state=null;
	
	private Player(String name) {
		this.name=name;
	}
	
	static public Player createByName(String name) {
		return new Player(name);
	}
	
	public void initMyCards(Card card1,Card card2) {
		myCards.add(card1);
		myCards.add(card2);
	}
	
	public ArrayList<Card> getMyCards() {
		return myCards;
	}

	public void addMyCard(Card card) {
		myCards.add(card);
	}
	
	public void addMyPoint(Card card) {
		myPoint+=card.convertPoint();
	}
	
	public int getMyPoint() {
		return myPoint;
	}
	
	public String getName() {
		return name;
	}
	
	public void setState(String state) {
		this.state=state;
	}
	
	public String getState() {
		return state;
	}
}
