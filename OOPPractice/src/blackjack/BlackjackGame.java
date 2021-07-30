package blackjack;
import java.util.Scanner;

public class BlackjackGame {

	public static void main(String[] args) {
		System.out.println("블랙잭 카드게임");
		Game new_game=new Game();
		Dealer dealer=new Dealer();
		Player player=new Player();
		new_game.setGame();
		for(int i=0;i<2;i++) {
			new_game.giveCard(player);
			new_game.giveCard(dealer);
		}
		System.out.println("player의 카드");
		new_game.turnCard(player, 0);
		new_game.turnCard(player, 1);
		System.out.println("dealer의 카드");
		new_game.turnCard(dealer, 0);
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("카드를 더 뽑으시겠습니까? 1. 예 2. 아니오");
			int select = scan.nextInt();
			if(select==2||select!=1) {
				break;
			}
			new_game.giveCard(player);
			new_game.turnCard(player, -1);
			if(player.getPoint()>21) {
				System.out.println("Bust");
			}
		}
		System.out.println("dealer의 카드");
		new_game.turnCard(dealer, 1);
		while(dealer.getPoint()<17) {
			new_game.giveCard(dealer);
			new_game.turnCard(dealer, -1);
		}
		if(dealer.getPoint()>21) {
			System.out.println("Bust");
		}
		else {
			if(dealer.getPoint()>player.getPoint()) {
				System.out.println("딜러 승");
			}else if(dealer.getPoint()<player.getPoint()) {
				System.out.println("플레이어 승");
			}else {
				System.out.println("무승부");
			}
		}
	}
}
