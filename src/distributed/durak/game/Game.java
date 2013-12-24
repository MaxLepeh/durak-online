package distributed.durak.game;

import java.util.ArrayList;
import java.util.Random;

public class Game
{
	private int trumpSuit;
	private User firstPlayer;
	private User currentPlayer;
	private CardDeck cardDeck;
	private int id;
	private ArrayList<User> usersList;
	private Board board;
	private Card curCard;
	private int maxPlayers;
	
	public Game(int cardDeckSize, int maxPlayers)
	{
		curCard = new Card();
		this.maxPlayers = maxPlayers;
		board = new Board();
		usersList = new ArrayList<User>(maxPlayers);
		firstPlayer = new User();
		currentPlayer = new User();
		cardDeck = new CardDeck(cardDeckSize);
		trumpSuit = cardDeck.getTrumpSuit();
	}
	public void setFirstPlayer()
	{
		Random random = new Random();
		firstPlayer = usersList.get(random.nextInt(usersList.size()));
	}
	public void addFirstCardsToUsers()
	{
		for(int i = 0; i < usersList.size(); i++)
		{
			for(int j = 0; j < 6; j++)
			{
				usersList.get(i).addCardToUser(cardDeck.getRandomCard());
			}
		}
		/*
		usersList.get(0).addCardToUser(new Card(2));
		usersList.get(0).addCardToUser(new Card(5));
		usersList.get(0).addCardToUser(new Card(10));
		usersList.get(0).addCardToUser(new Card(15));
		usersList.get(0).addCardToUser(new Card(20));
		usersList.get(0).addCardToUser(new Card(25));
		
		usersList.get(1).addCardToUser(new Card(1));
		usersList.get(1).addCardToUser(new Card(6));
		usersList.get(1).addCardToUser(new Card(11));
		usersList.get(1).addCardToUser(new Card(16));
		usersList.get(1).addCardToUser(new Card(21));
		usersList.get(1).addCardToUser(new Card(26));
		
		cardDeck.removeCardFromCardDeck(new Card(2));
		cardDeck.removeCardFromCardDeck(new Card(5));
		cardDeck.removeCardFromCardDeck(new Card(10));
		cardDeck.removeCardFromCardDeck(new Card(15));
		cardDeck.removeCardFromCardDeck(new Card(20));
		cardDeck.removeCardFromCardDeck(new Card(25));
		
		cardDeck.removeCardFromCardDeck(new Card(1));
		cardDeck.removeCardFromCardDeck(new Card(6));
		cardDeck.removeCardFromCardDeck(new Card(11));
		cardDeck.removeCardFromCardDeck(new Card(16));
		cardDeck.removeCardFromCardDeck(new Card(21));
		cardDeck.removeCardFromCardDeck(new Card(26));
		*/
	}
	public ArrayList<User> getUsers()
	{
		return usersList;
	}
	public void startGame()
	{
		setFirstPlayer();
		addFirstCardsToUsers();
		currentPlayer = firstPlayer;
		
	}
	public void addUserToGame(User user)
	{
		usersList.add(user);
	}
	public void removeUserFromGame(User user)
	{
		usersList.remove(user);
	}
	public void makeMove(User user)
	{
		if(board.getCards().size() == 0)
		{
			user.removeCardFromUser(curCard);
			board.addCardToBoard(curCard);
		}
		else if(board.getCards().size() % 2 == 0)
		{
			for(int i = 0; i < board.getCards().size(); i++)
			{
				if(curCard.compareFromDignity(board.getCards().get(i)) == true)
				{
					user.removeCardFromUser(curCard);
					board.addCardToBoard(curCard);
					break;
				}
			}
		}
		else
		{
			if((curCard.getSuitInt() == board.getCards().get(board.getCards().size() - 1).getSuitInt() && curCard.getNum() > board.getCards().get(board.getCards().size() - 1).getNum()) ||
					(curCard.getSuitInt() == trumpSuit))
			{
				user.removeCardFromUser(curCard);
				board.addCardToBoard(curCard);
			}
			else
			{
				System.out.println("You can't to beat this card");
			}
		}
		
	}
	
	public void setCurrentCard(Card card)
	{
		curCard = card;
	}
	public Board getBoard()
	{
		return board;
	}
	public int getTrumpSuit()
	{
		return trumpSuit;
	}
	public void removeAllCardsOutside()
	{
		board.removeAllCardOutside();
		if(cardDeck.getCardDeck().size() > 0)
		{
			for(int i = 0; i < usersList.size(); i++)
			{
				while(usersList.get(i).getUsersCards().size()<6)
				{
					usersList.get(i).addCardToUser(cardDeck.getRandomCard());
				}
			}
		}
		System.out.println("All cards from board outside");
	}
	public CardDeck getcardDeck()
	{
		return cardDeck;
	}
}
