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
import java.util.List;

@WebServlet("/direction")
public class TableDirectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Direction> directions = (new SqlDirectionDAO(SqlDAO.newInstance())).getAll();
        request.setAttribute("pagename","Direction");
        request.setAttribute("directions",directions);
        request.getRequestDispatcher("direction.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            DirectionDAO directionDAO = new SqlDirectionDAO(SqlDAO.newInstance());
            directionDAO.delete(directionDAO.getByID(id));
            resp.sendRedirect("/direction");
        }
        doGet(req,resp);
    }
}
