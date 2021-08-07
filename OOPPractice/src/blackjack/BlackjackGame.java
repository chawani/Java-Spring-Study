package blackjack;

import java.util.Scanner;

public class BlackjackGame {
	Scanner scan;
	
	public static void main(String[] args) {
		System.out.println("=== 1:1 블랙잭 카드게임 ===");
		PlayGame game = PlayGame.initGame();
		game.doGame();
	}
}
