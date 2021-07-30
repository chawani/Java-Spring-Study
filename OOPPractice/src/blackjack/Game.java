package blackjack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	private ArrayList<Card> card_deck;
	
	public void setGame() {
		CardDeck cardDeck=new CardDeck();
		card_deck=cardDeck.getCard_deck();
		Collections.shuffle(card_deck);
	}
	public void giveCard(Participant participant) {
		 Card card=card_deck.remove(0);
		 participant.setMy_card(card);
	}
	public void turnCard(Participant participant,int index) {
		ArrayList<Card> p_card=participant.getMy_card();
		Card open_card;
		if(index==-1) {
			open_card=p_card.get(p_card.size()-1);
			System.out.println(open_card.toString());
		}
		else{
			open_card=p_card.get(index);
			System.out.println(open_card.toString());
		}
		int point=participant.getPoint()+convertPoint(open_card.getCharacter());
		participant.setPoint(point);
	}
	public int convertPoint(String c) {
		int result=0;
		switch(c){
		case "A":
			Scanner scan = new Scanner(System.in);
			System.out.println("A카드 점수 선택? 1. 1점 2. 11점");
			int select = scan.nextInt();
			if (select==1) {
				result=1;
			}else if(select==2) {
				result=11;
			}
			break;
		case "J":
		case "Q":
		case "K":
			result=10;
			break;
		default:
			result=Integer.parseInt(c);
			break;
		}
		return result;
	}
	
}
