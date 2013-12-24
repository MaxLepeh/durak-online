package distributed.durak.game;

public class GameFactory 
{
	public Game deserialization(User user1, User user2)
	{
		Game game = new Game(36, 2);
		game.addUserToGame(user1);
		game.addUserToGame(user2);
		//game.startGame();
		return game;
	}
}
