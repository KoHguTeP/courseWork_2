package control.Direction;

import database.DAO.DirectionDAO;
import database.DAO.sql.SqlDAO;
import database.DAO.sql.SqlDirectionDAO;
import database.Entity.Direction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDirection")
public class AddDirectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addDirection.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idDirection = Integer.valueOf(req.getParameter("ID_direction"));
        String placeFrom = req.getParameter("placeFrom");
        String placeTo = req.getParameter("placeTo");
        DirectionDAO directionDAO = new SqlDirectionDAO(SqlDAO.newInstance());
        Direction direction = new Direction(idDirection,placeFrom, placeTo);
        directionDAO.create(direction);
        resp.sendRedirect("/direction");
    }
}
