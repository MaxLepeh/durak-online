package distributed.durak.dao;

import distributed.durak.datamodel.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 24.12.13.
 */
public class OnlineRooms {
    private static List<Room> rooms = new ArrayList<>();

    public static List<Room> getAllRooms() {
        return rooms;
    }

    public static void addRoom(Room r) {
        rooms.add(r);
    }
}
