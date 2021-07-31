package blackjack;

public class BlackjackGame {

	public static void main(String[] args) {
		System.out.println("=== 1:1 블랙잭 카드게임 ===");
		
		Action action=new Action();
		Rule rule=new Rule();
		Dealer dealer=new Dealer();
		Player player=new Player();
		PlayGame game=new PlayGame(action,rule,dealer,player);
		
		boolean p_bust;
		boolean d_bust;
		
		game.settingGame();
		p_bust=game.playerTurn();
		if(p_bust) {
			System.out.println("딜러 승");
		}else{
			d_bust=game.dealerTurn();
			if(d_bust) {
				System.out.println("플레이어 승");
			}else {
				game.printWinner();
			}
		}
	}
}
