package distributed.durak;

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
import java.util.List;

/**
 * Created by Максим on 24.12.13.
 */
@WebServlet(name="GameServlet", urlPatterns={"/game"})
public class GameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        if (u != null) {
            RunningGame rg = null;
            List<RunningGame> games = OnlineGames.getAllGames();
            int isPlaying = 0;
            for (RunningGame g : games) {
                if (u.name.equals(g.user1name)) {
                    isPlaying = 1;
                }
                if (u.name.equals(g.user2name)) {
                    isPlaying = 2;
                }
                rg = g;
            }

            if (rg != null) {
                if (isPlaying == 1) {
                    request.getSession().setAttribute("userCards", rg.user1.getUsersCards());
                    request.getSession().setAttribute("user2Cards", rg.user2.getUsersCards());
                } else {
                    request.getSession().setAttribute("userCards", rg.user2.getUsersCards());
                    request.getSession().setAttribute("user2Cards", rg.user1.getUsersCards());
                }
                request.getSession().setAttribute("boardCards", rg.game.getBoard().getCards());
                request.getSession().setAttribute("trumpSuite", rg.game.getTrumpSuit());
                request.getSession().setAttribute("trumpCard", rg.game.getcardDeck().trumpCard);

                request.getRequestDispatcher("game.jsp").forward(request, response);

            } else {
                request.getSession().setAttribute("message", "Something went wrong.");
                response.sendRedirect("/error.jsp");
            }

        } else {
            request.getSession().setAttribute("message", "You must login.");
            response.sendRedirect("/error.jsp");
        }
    }
}
