package blackjack;
import java.util.ArrayList;

public interface Participant {
	public ArrayList<Card> getMy_card();
	public void setMy_card(Card card);
	public int getPoint();
	public void setPoint(int point);
	public String getName();
}
