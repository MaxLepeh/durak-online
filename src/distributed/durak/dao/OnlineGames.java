package distributed.durak.dao;

import distributed.durak.datamodel.RunningGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 24.12.13.
 */
public class OnlineGames {
    private static List<RunningGame> games = new ArrayList<>();

    public static List<RunningGame> getAllGames() {
        return games;
    }

    public static void addGame(RunningGame r) {
        games.add(r);
    }
}
