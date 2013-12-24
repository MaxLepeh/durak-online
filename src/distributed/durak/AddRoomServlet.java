package distributed.durak;

import distributed.durak.dao.DurakDao;
import distributed.durak.dao.OnlineRooms;
import distributed.durak.datamodel.Room;
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
 * Created by Максим on 24.12.13.
 */
@WebServlet(name="AddRoomServlet", urlPatterns={"/addroom"})
public class AddRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        if (u != null) {
            List<Room> rooms = OnlineRooms.getAllRooms();
            boolean failed = false;
            for (Room r : rooms) {
                if (r.getOwner().equals(u.getName())) {
                    request.getSession().setAttribute("message", "Already created room.");
                    failed = true;
                    response.sendRedirect("/error.jsp");
                }
            }
            if (!failed) {
                Room r = new Room(u.getName(), null);
                OnlineRooms.addRoom(r);
                response.sendRedirect("/rooms");
            }

        } else {
            request.getSession().setAttribute("message", "You must login.");
            response.sendRedirect("/error.jsp");
        }
    }
}
