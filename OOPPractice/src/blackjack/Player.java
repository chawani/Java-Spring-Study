package blackjack;
import java.util.ArrayList;

public class Player implements Participant{
	private ArrayList<Card> my_card=new ArrayList<>();
	private int point;
	
	public ArrayList<Card> getMy_card() {
		return my_card;
	}

	public void setMy_card(Card card) {
		my_card.add(card);
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public String getName() {
		return "Player";
	}
}
