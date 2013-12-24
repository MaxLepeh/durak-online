package distributed.durak.datamodel;

/**
 * Created by Максим on 15.12.13.
 */
public class User {
    public String name;
    public String password;
    public int gamesWon;
    public int gamesPlayed;

    public User(String name, String pass, int gamesPlayed, int gamesWon) {
        this.name = name;
        password = pass;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }
}
