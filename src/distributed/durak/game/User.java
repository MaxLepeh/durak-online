package distributed.durak.game;

import java.util.ArrayList;

public class User 
{
	public final int maxNumOfCard = 6;
	
	private String name;
	private String pass;
	private int playedGames;
	private String mail;
	private int wonGames;
	private ArrayList<Card> usersCards;
	
	public User()
	{
		
	}
	public User(String name, String pass, String mail)
	{
		usersCards = new ArrayList<Card>();
		this.name=name;
		this.pass=pass;
		this.mail=mail;
	}
	public void gamePlayed()
	{
		playedGames+=1;
	}
	public void gameWon()
	{
		wonGames+=1;
	}
	
	public String getName()
	{
		return name;
	}
	public String getPass()
	{
		return pass;
	}
	public int getPlayedGames()
	{
		return playedGames;
	}
	public int getWonGames()
	{
		return wonGames;
	}
	public String getMail()
	{
		return mail;
	}
	public void addCardToUser(Card card)
	{
		usersCards.add(card);
	}
	public void removeCardFromUser(Card card)
	{
		usersCards.remove(card);
	}
	public ArrayList<Card> getUsersCards()
	{
		return usersCards;
	}
	public void pickUpCardsFromBoard(ArrayList<Card> cardList)
	{
		for(int i = 0; i < cardList.size(); i++)
		{
			usersCards.add(cardList.get(i));
		}
	}
	
}
