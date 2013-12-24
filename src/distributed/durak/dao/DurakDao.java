package distributed.durak.dao;

import com.mongodb.*;
import distributed.durak.datamodel.Room;
import distributed.durak.datamodel.User;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Максим on 15.12.13.
 */
public class DurakDao {
    private final DB db;
    private final DBCollection users;
    private final DBCollection rooms;

    public DurakDao() throws UnknownHostException {
        db = new Mongo("localhost", 27017).getDB("durak-db");
        users = db.getCollection("users");
        rooms = db.getCollection("rooms");
    }

    public User findUser(String name) {
        DBCursor cursor = users.find(new BasicDBObject("name", name), userMainFields());
        if( cursor.hasNext() ) {
            DBObject user = cursor.next();
            String uName = (String)user.get("name");
            String uPass = (String)user.get("password");
            Integer uPlayed = (Integer) user.get("played");
            Integer uWon =  (Integer) user.get("won");
            return new User(uName, uPass, uPlayed, uWon);
        }
        return null;
    }

    public User registerUser(String name, String password, int played, int won) {
        DBObject newUser = new BasicDBObject();
        newUser.put("name", name);
        newUser.put("password", password);
        newUser.put("played", played);
        newUser.put("won", won);
        DBCursor cursor = users.find(new BasicDBObject("name", name), userMainFields());
        if(! cursor.hasNext() ) {
            users.insert(newUser);
            return new User(name, password, played, won);
        }
        return null;
    }

    private DBObject userMainFields() {
        DBObject fieldsToFetch = new BasicDBObject();
        fieldsToFetch.put("name", "");
        fieldsToFetch.put("password", "");
        fieldsToFetch.put("played", "");
        fieldsToFetch.put("won", "");
        return fieldsToFetch;
    }
/*
    public List<Room> getRooms() {
        List<Room> rms = new ArrayList<>();

        DBCursor cursor = rooms.find();
        while (cursor.hasNext()) {
            DBObject room = cursor.next();
            String u1 = (String) room.get("user1");
            String u2 = (String) room.get("user2");
            String o = (String) room.get("owner");
            List<String> usrs = new ArrayList<>();
            if (u1 != null) usrs.add(u1);
            if (u2 != null) usrs.add(u2);
            rms.add(new Room(o, usrs));
        }

        return rms;
    }

    public Room createRoom(String user) {
        List<String> usrs = new ArrayList<>();
        usrs.add(user);

        DBObject newRoom = new BasicDBObject();
        newRoom.put("owner", user);
        newRoom.put("user1", user);

        rooms.insert(newRoom);

        return new Room(user, usrs);
    }
    */
}
