package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Rule {
	
	public void setPoint(Participant participant,Card card) {
		int point;
		point=convertPoint(card.getCharacter());
		participant.setPoint(participant.getPoint()+point);
	}
	
	public int convertPoint(String c) {
		int result=0;
		switch(c){
		case "A":
			Scanner scan = new Scanner(System.in);
			System.out.println("A카드 점수 선택? 1. 1점 2. 11점");
			int select = scan.nextInt();
			if (select==1) {
				result=1;
			}else if(select==2) {
				result=11;
			}
			break;
		case "J":
		case "Q":
		case "K":
			result=10;
			break;
		default:
			result=Integer.parseInt(c);
			break;
		}
		return result;
	}
	
	public boolean isBust(Participant participant) {
		boolean bust=false;
		if(participant.getPoint()>21) {
			bust=true;
			System.out.println(participant.getName()+"의 Bust");
		}
		return bust;
	}
}
