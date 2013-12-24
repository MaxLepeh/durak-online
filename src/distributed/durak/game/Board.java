package distributed.durak.game;

import java.util.ArrayList;

public class Board 
{
	private ArrayList<Card> cardsList;
	
	public Board()
	{
		cardsList = new ArrayList<Card>();
	}
	
	public void addCardToBoard(Card card)
	{
		cardsList.add(card);
	}
	public void removeCardFromBoard(Card card)
	{
		cardsList.remove(card);
	}
	public void removeAllCardOutside()
	{
		cardsList.clear();
	}
	public ArrayList<Card> getCards()
	{
		return cardsList;
	}
}
