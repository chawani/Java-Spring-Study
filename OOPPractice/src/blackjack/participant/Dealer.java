package blackjack.participant;
import java.util.ArrayList;

import blackjack.card.Card;

public class Dealer implements Participant{
	private String name;
	private ArrayList<Card> myCards=new ArrayList<>();
	private int myPoint=0;
	private String state="";
	
	private Dealer(String name) {
		this.name=name;
	}
	
	public static Dealer create() {
		return new Dealer("Dealer");
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
