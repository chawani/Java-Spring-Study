package blackjack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Action {
	private ArrayList<Card> game_card_deck;
	
	public void settingCard() {
		CardDeck cardDeck=new CardDeck();
		game_card_deck=cardDeck.getCard_deck();
		Collections.shuffle(game_card_deck);
	}
	
	public void giveCard(Participant participant) {
		 Card card=game_card_deck.remove(0);
		 participant.setMy_card(card);
	}
	
	public void turnCard(Participant participant,int index) {
		Rule rule=new Rule();
		ArrayList<Card> p_card=participant.getMy_card();
		Card open_card;
		System.out.println(participant.getName()+"의 카드");
		if(index==-1) {
			open_card=p_card.get(p_card.size()-1);
			System.out.println(open_card.toString());
		}
		else{
			open_card=p_card.get(index);
			System.out.println(open_card.toString());
		}
		rule.setPoint(participant,open_card);
	}
}
