package blackjack.action;
import java.util.ArrayList;

import blackjack.Rule;
import blackjack.card.Card;
import blackjack.card.CardDeck;
import blackjack.participant.Dealer;
import blackjack.participant.Participant;
import blackjack.participant.Player;

public class CardAction {
	private ArrayList<Card> cardList;
	private Rule rule;
	private PrintAction printAction;
	
	private CardAction(CardDeck cardDeck) {
		this.cardList=cardDeck.getCardDeck();
		this.rule=new Rule();
		this.printAction=new PrintAction();
	}
	
	public static CardAction settingAction(CardDeck cardDeck) {
		return new CardAction(cardDeck);
	}
	
	public void giveCards(ArrayList<Participant> participants) {
		Card card1,card2;
		for(Participant participant:participants) {
			card1=cardList.remove(0);
			card2=cardList.remove(1);
			participant.initMyCards(card1,card2);
		}
	}
	
	public void openInitialCards(ArrayList<Participant> participants) {
		for (Participant participant : participants) {
			if(participant.getName().equals("Dealer")) {
				openDealerInitialCard((Dealer)participant);
				continue;
			}
			openPlayerInitialCards((Player)participant);
			rule.checkBlackjack(participant);
		}
	}
	
	public void openDealerInitialCard(Dealer dealer) {
		Card firstCard=dealer.getMyCards().get(0);
		System.out.println("Dealer의 카드:");
		printAction.printCard(firstCard);
		dealer.addMyPoint(firstCard);
	}
	
	public void openPlayerInitialCards(Player player) {
		printAction.printCards(player);
		for(Card card:player.getMyCards())
			player.addMyPoint(card);
	}
	
	public boolean hitMoreCard(Participant participant) {
		Card card=giveCard(participant);
		openCard(participant,card);
		return rule.checkBust(participant);
	}
	
	public Card giveCard(Participant participant) {
		Card card=cardList.remove(0);
		participant.addMyCard(card);
		return card;
	}
	
	public void openCard(Participant participant,Card card) {
		printAction.printCard(card);
		participant.addMyPoint(card);
	}
	
	
}
