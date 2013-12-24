package distributed.durak.game;

public class Card 
{
	private int num;
	private boolean isPlayed;
	private boolean isTrumpSuit;
	private boolean isTrumpCard;
	
	public Card() {}
	public Card(int num)
	{
		this.num = num;
		isPlayed = true;
		isTrumpSuit = false;
		isTrumpCard = false;
	}
	
	public String getSuitString()
	{
		if(((int)num % 9) == 0)
			return "Clubs";
		else if(((int)num % 9) == 1)
			return "Spades";
		else if(((int)num % 9) == 2)
			return "Hearts";
		else if(((int)num % 9) == 3)
			return "Diamonds";
		else 
			return "Error";
	}
	public int getSuitInt()
	{ 
		return (int)num / 9;
	}
	public int getNum()
	{
		return num;
	}
	public int getDignity()
	{
		
		return 0;
	}
	public boolean getStatus()
	{
		return isPlayed;
	}
	public void setStatus(boolean status)
	{
		isPlayed=status;
	}
	public boolean isTrumpSuit()
	{
		return isTrumpSuit;
	}
	public boolean isTrumpCard()
	{
		return isTrumpCard;
	}
	public void setTrumpSuit(boolean isTrumpSuit)
	{
		this.isTrumpSuit = isTrumpSuit;
	}
	public void setTrumpCard(boolean isTrumpCard)
	{
		this.isTrumpCard = isTrumpCard;
	}
	public boolean compareFromDignity(Card card)
	{
		for(int i = 0; i < 4; i++)
		{
			if((card.getNum() - 9 * i) >= 0)
			{
				if(num == card.getNum() - 9 * i)
				{
					return true;
				}
			}
			if((card.getNum() + 9 * i) <= 35)
			{
				if(num == card.getNum() + 9 * i)
				{
					return true;
				}
			}
		}
		return false;
	}
}
