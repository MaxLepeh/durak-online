package distributed.durak.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 23.12.13.
 */
public class Room {
    public List<String> players = new ArrayList<>();
    public String owner;
    public int maxPlayers = 2;
    public String user2;

    public String getUser2() {
        return user2;
    }

    public List<String> getPlayers() {
        return players;
    }

    public Room(String owner, String u2) {
        this.owner = owner;
        user2 = u2;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String getOwner() {
        return owner;
    }
}
