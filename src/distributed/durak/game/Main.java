package distributed.durak.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static ArrayList<User> usersList;
	public static ArrayList<Card> usersCards;
	public static ArrayList<Card> boardCards;
	public static Game game;
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
		User user1 = new User("Zheka", "pass123", "zheka04@gmail.com");
		User user2 = new User("Max", "pass123", "max@gmail.com");
		/*User user3 = new User("Max", "pass123", "max@gmail.com");
		User user4 = new User("Max", "pass123", "max@gmail.com");
		User user5 = new User("Max", "pass123", "max@gmail.com");
		User user6 = new User("Max", "pass123", "max@gmail.com");*/
		GameFactory gameFactory = new GameFactory();
		game = gameFactory.deserialization(user1, user2);
		
		boardCards = new ArrayList<Card>();
		game.startGame();
		
		usersList = new ArrayList<User>();
		usersCards = new ArrayList<Card>();
		usersList = game.getUsers();
		
		System.out.println("TrumpSuit " + game.getTrumpSuit());
		
		while(true)
		{
			System.out.println(game.getcardDeck().getCountCardInCardDeck());
			if(user1.getUsersCards().size() <= 0)
			{
				System.out.println("User1 win");
				break;
			}
			else if(user2.getUsersCards().size() <= 0)
			{
				System.out.println("User2 win");
				break;
			}
			showUsersCards();
			System.out.println("Please enter the action:");
			a = in.nextInt();
			if(a == 100)
			{
				game.removeAllCardsOutside();
			}
			else if(a == 99)
			{
				user1.pickUpCardsFromBoard(boardCards);
			}
			else if(a == 98)
			{
				user2.pickUpCardsFromBoard(boardCards);
			}
			else if(a == 97)
			{
				System.out.println("Please enter the card:");
				b = in.nextInt();
				game.setCurrentCard(user1.getUsersCards().get(b));
				game.makeMove(user1);
			}
			else if(a == 96)
			{
				System.out.println("Please enter the card");
				b = in.nextInt();
				game.setCurrentCard(user2.getUsersCards().get(b));
				game.makeMove(user2);
			}
				
			showBoardCards();
		}
	}
	public static void showUsersCards()
	{
		for(int i = 0; i < usersList.size(); i++)
		{
			System.out.print(usersList.get(i).getName() + " cards ");
			usersCards = usersList.get(i).getUsersCards();
			for(int j = 0; j < usersCards.size(); j++)
			{
				System.out.print(usersCards.get(j).getNum()+" ");
			}
			System.out.println();
		}
	}
	public static void showBoardCards()
	{
		boardCards = game.getBoard().getCards();
		System.out.print("Boards cards ");
		for(int i = 0; i < boardCards.size(); i++)
		{
			System.out.print(boardCards.get(i).getNum() + " ");
		}
		System.out.println();
	}

}
