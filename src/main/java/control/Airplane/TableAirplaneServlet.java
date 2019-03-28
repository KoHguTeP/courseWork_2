package control.Airplane;

import database.DAO.AirplaneDAO;
import database.DAO.sql.SqlAirplaneDAO;
import database.DAO.sql.SqlDAO;
import database.Entity.Airplane;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/airplane")
public class TableAirplaneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Airplane> airplanes = (new SqlAirplaneDAO(SqlDAO.newInstance())).getAll();
        request.setAttribute("pagename","Airplane");
        request.setAttribute("airs",airplanes);
        AirplaneDAO airplaneDAO = new SqlAirplaneDAO(SqlDAO.newInstance());
        request.setAttribute("airDAO", airplaneDAO);
        request.getRequestDispatcher("airplane.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            AirplaneDAO airplaneDAO = new SqlAirplaneDAO(SqlDAO.newInstance());
            airplaneDAO.delete(airplaneDAO.getByID(id));
            resp.sendRedirect("/airplane");
        }
        doGet(req,resp);
    }
}
