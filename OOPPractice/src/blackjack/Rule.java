package blackjack;

import java.util.ArrayList;

import blackjack.participant.Dealer;
import blackjack.participant.Participant;
import blackjack.participant.Player;

public class Rule {
	public boolean checkBust(Participant participant) {
		if(participant.getMyPoint()>21) {
			System.out.println(participant.getName()+"님의 Bust");
			participant.setState("Bust");
			return true;
		}
		return false;
	}
	
	public void checkBlackjack(Participant participant) {
		if(participant.getMyPoint()==21) {
			System.out.println(participant.getName()+"님의 Blackjack");
			participant.setState("Blackjack");
		}
	}
	
	public void judgeAllMatch(Dealer dealer, ArrayList<Player> players) {
		int dealerPoint = dealer.getMyPoint();
		for (Player player : players) {
			int playerPoint = player.getMyPoint();
			if (player.getState() != null)
				continue;
			if (dealer.getState().equals("Bust")) {
				player.setState("Win");
				continue;
			}
			String state = (playerPoint > dealerPoint) ? "Win" : (playerPoint < dealerPoint) ? "Lose" : "Draw";
			player.setState(state);
		}
	}
}
