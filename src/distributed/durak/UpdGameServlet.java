package distributed.durak;

import distributed.durak.dao.OnlineGames;
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
@WebServlet(name="UpdGameServlet", urlPatterns={"/updgame"})
public class UpdGameServlet extends HttpServlet {
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

                String action = request.getParameter("action");
                String card = request.getParameter("card");
                if (card != null) {
                    if (isPlaying == 1) {
                        rg.game.setCurrentCard(rg.user1.getUsersCards().get(Integer.parseInt(card)));
                        rg.game.makeMove(rg.user1);
                    } else {
                        rg.game.setCurrentCard(rg.user2.getUsersCards().get(Integer.parseInt(card)));
                        rg.game.makeMove(rg.user2);
                    }
                }
                if (action != null) {
                    if (action.equals("removeAll")) {
                        rg.game.removeAllCardsOutside();
                    } else if (action.equals("takeAll")) {
                        if (isPlaying == 1) {
                            rg.user1.pickUpCardsFromBoard(rg.game.getBoard().getCards());
                        } else {
                            rg.user2.pickUpCardsFromBoard(rg.game.getBoard().getCards());
                        }
                    }
                }

                response.sendRedirect("/game");
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
