package blackjack;

import java.util.Scanner;

public class PlayGame {
	Action action;
	Rule rule;
	Dealer dealer;
	Player player;
	
	public PlayGame(Action action, Rule rule, Dealer dealer, Player player) {
		super();
		this.action = action;
		this.rule = rule;
		this.dealer = dealer;
		this.player = player;
	}

	public void settingGame() {
		action.settingCard();
		for(int i=0;i<2;i++) {
			action.giveCard(player);
			action.turnCard(player, i);
			action.giveCard(dealer);
		}
		action.turnCard(dealer, 0);
	}
	
	public boolean playerTurn() {
		Scanner scan = new Scanner(System.in);
		int select;
		boolean is_bust=false;
		while(true) {
			System.out.println("카드를 더 뽑으시겠습니까? 1. 예 2. 아니오");
			select = scan.nextInt();
			if(select==2||select!=1) {
				break;
			}
			action.giveCard(player);
			action.turnCard(player, -1);
			is_bust=rule.isBust(player);
			if(is_bust){
				break;
			}
		}
		return is_bust;
	}
	
	public boolean dealerTurn() {
		boolean is_bust=false;
		action.turnCard(dealer, 1);
		while(dealer.getPoint()<17) {
			action.giveCard(dealer);
			action.turnCard(dealer, -1);
		}
		is_bust=rule.isBust(dealer);
		return is_bust;
	}
	
	public void printWinner() {
		if(dealer.getPoint()>player.getPoint()) {
			System.out.println("딜러 승");
		}else if(dealer.getPoint()<player.getPoint()) {
			System.out.println("플레이어 승");
		}else {
			System.out.println("무승부");
		}
	}
}
