package distributed.durak.datamodel;

import distributed.durak.game.Game;

/**
 * Created by Максим on 24.12.13.
 */
public class RunningGame {
    public String user1name;
    public String user2name;
    public Game game;
    public distributed.durak.game.User user1;
    public distributed.durak.game.User user2;


    public RunningGame(String u1, String u2) {
        game = new Game(36, 2);
        user1name = u1;
        user2name = u2;
        user1 = new distributed.durak.game.User(u1, "", "");
        user2 = new distributed.durak.game.User(u2, "", "");

        game.addUserToGame(user1);
        game.addUserToGame(user2);

        game.startGame();
    }

}
