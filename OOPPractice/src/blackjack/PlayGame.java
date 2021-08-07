package blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import blackjack.action.CardAction;
import blackjack.action.PrintAction;
import blackjack.card.Card;
import blackjack.card.CardDeck;
import blackjack.participant.Dealer;
import blackjack.participant.Participant;
import blackjack.participant.Player;

public class PlayGame {
	Scanner scan = new Scanner(System.in);
	private CardAction cardAction;
	private PrintAction printAction;
	private ArrayList<Participant> participants;
	private ArrayList<Player> players;
	private Dealer dealer;
	private CardDeck cardDeck;
	
	private PlayGame() {
		initParticipants();
		prepareCards();
	}
	
	public static PlayGame initGame() {
		return new PlayGame();
	}
	
	public void initParticipants(){
		createPlayers();
		dealer=Dealer.create();
		participants=new ArrayList<Participant>();
		for(Player player:players) {
			participants.add(player);
		}
		participants.add(dealer);
	}
	
	public void createPlayers() {
		String[] playerNames=inputAllPlayerNames();
		players=new ArrayList<>();
		for(String name:playerNames) {
			Player player=Player.createByName(name);
			players.add(player);
		}
	}
	
	public String[] inputAllPlayerNames() {
		String allPlayerName;
		while (true) {
			System.out.println("참여하는 Player의 이름을 쉼표로 구분하여 입력해주십시오. (최대 6명)");
			allPlayerName = scan.nextLine();
			if (isPossiblePlayerNumber(allPlayerName)) break;
		}
		return splitPlayerNames(allPlayerName);
	}
	
	public boolean isPossiblePlayerNumber(String allPlayerName) {
		String[] names=allPlayerName.split(",");
		if(names.length>6||names.length<=0||names[0].equals("")) return false;
		return true;
	}
	
	public String[] splitPlayerNames(String allPlayerName) {
		return allPlayerName.split(",");
	}
	
	public void prepareCards() {
		cardDeck=CardDeck.create();
		cardDeck.suffleCards();
	}
	
	public void doGame() {
		cardAction=CardAction.settingAction(cardDeck);
		printAction=new PrintAction();
		cardAction.giveCards(participants);
		cardAction.openInitialCards(participants);
		startPlayersTurn();
		startDealerTurn();
		finishGame();
		retryGame();
	}
	
	public void startPlayersTurn() {
		for(Player player:players) {
			System.out.println(player.getName()+"님의 턴");
			askHit(player);
		}
	}
	
	public void askHit(Player player) {
		int select;
		while (true) {
			try {
				System.out.println("카드를 더 뽑으시겠습니까? 1. 예 2. 아니오");
				select = scan.nextInt();
				if (select == 2)
					break;
				if (select != 1)
					throw new InputMismatchException();
				if (cardAction.hitMoreCard(player))
					break;
			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("숫자 1이나 2만 입력하시오.");
			}
		}
	}
	
	public void startDealerTurn() {
		Card secondCard=dealer.getMyCards().get(1);
		System.out.println("Dealer의 카드:");
		printAction.printCard(secondCard);
		dealer.addMyPoint(secondCard);
		while(dealer.getMyPoint()<17) {
			cardAction.hitMoreCard(dealer);
		}
	}
	
	public void finishGame() {
		printAction.printResult(dealer,players);
	}
	
	public void retryGame() {
		while (true) {
			try {
				System.out.println("새 게임을 시작하시겠습니까? 1.예 2. 아니오");
				int select = scan.nextInt();
				if (select == 2){
					System.out.println("게임을 종료합니다.");
					break;
				}
				if (select != 1)
					throw new InputMismatchException();
				PlayGame game = PlayGame.initGame();
				game.doGame();
			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("숫자 1이나 2만 입력하시오.");
			}
		}
	}
}
