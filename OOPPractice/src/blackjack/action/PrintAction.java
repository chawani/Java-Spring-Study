package blackjack.action;

import java.util.ArrayList;

import blackjack.Rule;
import blackjack.card.Card;
import blackjack.participant.Dealer;
import blackjack.participant.Participant;
import blackjack.participant.Player;

public class PrintAction {
	public void printCards(Participant participant) {
		System.out.println(participant.getName()+"의 카드:");
		for (Card card : participant.getMyCards())
			printCard(card);
	}
	
	public void printCard(Card card) {
		System.out.println(card.toString());
	}
	
	public void printResult(Dealer dealer,ArrayList<Player> players) {
		Rule rule=new Rule();
		rule.judgeAllMatch(dealer, players);
		System.out.println("===게임 결과===");
		printDealerResult(dealer);
		printPlayerResult(players);
	}
	
	public void printDealerResult(Dealer dealer) {
		System.out.println("Dealer:");
		System.out.println("점수:"+dealer.getMyPoint());
		if(!dealer.getState().equals("")) 
			System.out.println("결과:"+dealer.getState());
	}
	
	public void printPlayerResult(ArrayList<Player> players) {
		for(Player player:players) {
			System.out.println("Player 이름:"+player.getName());
			System.out.println("점수:"+player.getMyPoint());
			System.out.println("결과:"+player.getState());
		}
	}
}
