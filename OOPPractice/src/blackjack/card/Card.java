package blackjack.card;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Card {
	private String suit;//모양
	private String character;//기호
	
	private Card(String suit, String character) {
		super();
		this.suit = suit;
		this.character = character;
	}
	
	public static Card create(String suit,String character) {
		return new Card(suit,character);
	}
	
	public String getSuit() {
		return suit;
	}

	public String getCharacter() {
		return character;
	}

	@Override
	public String toString() {
		return "Card [모양=" + suit + ", 기호=" + character + "]";
	}
	
	public int convertPoint() {
		switch (character) {
		case "A":
			return selectAcePoint();
		case "J":
		case "Q":
		case "K":
			return 10;
		default:
			return Integer.parseInt(character);
		}
	}
	
	public int selectAcePoint() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Ace가 나왔습니다.점수를 선택하세요. 1. 1점 2. 11점");
				int select = scan.nextInt();
				if (select == 1)
					return 1;
				if (select == 2)
					return 11;
				throw new InputMismatchException();
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("숫자 1이나 2만 입력하시오.");
			}
		}
	}
}
