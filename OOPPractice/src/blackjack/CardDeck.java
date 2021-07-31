package blackjack;
import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private ArrayList<Card> card_deck=new ArrayList<>();
	
	public CardDeck() {
		card_deck=makeCard();
	}

	public ArrayList<Card> getCard_deck() {
		return card_deck;
	}
	
	public ArrayList<Card> makeCard() {
		String[] suit={"SPADE","HEART","DIAMOND","CLUB"};
		ArrayList<Card> deck=new ArrayList<>();
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
            	deck.add(card);
            }
        }
        return deck;
	}
}
