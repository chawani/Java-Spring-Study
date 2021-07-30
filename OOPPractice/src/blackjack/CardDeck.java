package blackjack;
import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private ArrayList<Card> card_deck=new ArrayList<>();
	
	public CardDeck() {
		String[] suit={"SPADE","HEART","DIAMOND","CLUB"};
		Card card;
        for (String s : suit) {
            for(int j=1;j<14;j++) {
            	switch(j){
            		case 1:
            			card=new Card(s,"A");
            			break;
            		case 11:
            			card=new Card(s,"J");
            			break;
            		case 12:
            			card=new Card(s,"Q");
            			break;
            		case 13:
            			card=new Card(s,"K");
            		default:
            			card=new Card(s,Integer.toString(j));
            			break;
            	}
            	card_deck.add(card);
            }
        }
	}

	public ArrayList<Card> getCard_deck() {
		return card_deck;
	}
}
