package control.Direction;

import database.DAO.DirectionDAO;
import database.DAO.sql.SqlDAO;
import database.DAO.sql.SqlDirectionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updDirection")
public class UpdDirectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idToUpd = req.getParameter("idToUpd");
        req.setAttribute("idToUpd", idToUpd);
        req.getRequestDispatcher("updDirection.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id_direction = Integer.parseInt(req.getParameter("ID_direction"));
        String from = req.getParameter("directionFrom");
        String to = req.getParameter("directionTo");
        DirectionDAO directionDAO = new SqlDirectionDAO(SqlDAO.newInstance());
        directionDAO.update(id_direction, from, to);
        resp.sendRedirect("/direction");
    }
}
