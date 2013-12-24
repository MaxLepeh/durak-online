package distributed.durak;

import distributed.durak.dao.DurakDao;
import distributed.durak.dao.OnlineGames;
import distributed.durak.dao.OnlineRooms;
import distributed.durak.datamodel.Room;
import distributed.durak.datamodel.RunningGame;
import distributed.durak.datamodel.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 23.12.13.
 */
@WebServlet(name="RoomsServlet", urlPatterns={"/rooms"})
public class RoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> rooms = OnlineRooms.getAllRooms();
        User u = (User) request.getSession().getAttribute("user");

        List<Room> otherRooms = new ArrayList<>();
        if (u != null) {
            for (Room r : rooms) {
                if (r.getOwner().equals(u.getName())) {
                    request.getSession().setAttribute("ownedRoom", r);
                } else {
                    otherRooms.add(r);
                }
            }

            List<RunningGame> games = OnlineGames.getAllGames();
            boolean isPlaying = false;
            for (RunningGame g : games) {
                if (u.name.equals(g.user1name)) {
                    isPlaying = true;
                }
                if (u.name.equals(g.user2name)) {
                    isPlaying = true;
                }
            }

            if (isPlaying) {
                response.sendRedirect("/game");
            } else {
                request.getSession().setAttribute("rooms", otherRooms);
                request.getRequestDispatcher("rooms.jsp").forward(request, response);
            }


            //response.sendRedirect("/rooms.jsp");
        } else {
            request.getSession().setAttribute("message", "You must login.");
            response.sendRedirect("/error.jsp");
        }


    }
}
