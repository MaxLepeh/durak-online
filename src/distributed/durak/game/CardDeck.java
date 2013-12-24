package distributed.durak.game;

import java.util.ArrayList;
import java.util.Random;

public class CardDeck 
{
	private ArrayList<Card> cardDeck;
	private int cardDeckSize;
	private int trumpSuit;
	private int countOfCardInCardDeckNow;
    public Card trumpCard;
	
	public CardDeck(int cardDeckSize)
	{
		this.cardDeckSize = cardDeckSize;
		countOfCardInCardDeckNow = cardDeckSize;
		cardDeck = new ArrayList<Card>(cardDeckSize);
		for(int i = 0; i < cardDeckSize; i++)
		{
			cardDeck.add(new Card(i));
		}
		setTrumpSuit();
	}
	public void removeCardFromCardDeck(Card card)
	{
		card.setStatus(false);
		cardDeck.set(card.getNum(), card);
		countOfCardInCardDeckNow-=1;
	}
	public Card chooseTrumpCard()
	{
		Random random = new Random();
		Card card = new Card(0);
		card = cardDeck.get(random.nextInt(cardDeckSize));
		card.setTrumpCard(true);
		card.setTrumpSuit(true);	
		cardDeck.set(card.getNum(), card);
        trumpCard = card;
		return card;
	}
	public void setTrumpSuit()
	{
		Card card = new Card(0);
		card = chooseTrumpCard();
		this.trumpSuit = card.getSuitInt();
		if(this.trumpSuit == 0)
		{
			for(int i = 0; i <= 8; i++)
			{
				cardDeck.get(i).setTrumpSuit(true);
			}
		}
		else if(this.trumpSuit == 1)
		{
			for(int i = 9; i <= 17; i++)
			{
				cardDeck.get(i).setTrumpSuit(true);
			}
		}
		else if(this.trumpSuit == 2)
		{
			for(int i = 18; i <= 26; i++)
			{
				cardDeck.get(i).setTrumpSuit(true);
			}
		}
		else if(this.trumpSuit == 3)
		{
			for(int i = 27; i <= 35; i++)
			{
				cardDeck.get(i).setTrumpSuit(true);
			}
		}
	}
	public int getTrumpSuit()
	{
		return trumpSuit;
	}
	public Card getRandomCard()
	{
		Random random = new Random();
		while(true)
		{
			int rndNum = random.nextInt(cardDeckSize);
			if(cardDeck.get(rndNum).getStatus() == true)
			{
				cardDeck.get(rndNum).setStatus(false);
				countOfCardInCardDeckNow-=1;
				return cardDeck.get(rndNum);
			}
		}
	}
	public ArrayList<Card> getCardDeck()
	{
		return cardDeck;
	}
	public int getCountCardInCardDeck()
	{
		return countOfCardInCardDeckNow;
	}
}

