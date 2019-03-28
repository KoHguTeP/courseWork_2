package control.Flight;

import database.DAO.FlightDAO;
import database.DAO.sql.SqlDAO;
import database.DAO.sql.SqlFlightDAO;
import database.Entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/flight")
public class TableFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flight> flights = (new SqlFlightDAO(SqlDAO.newInstance())).getAll();
        request.setAttribute("pagename","Flight");
        request.setAttribute("flights", flights);
        FlightDAO flightDAO = new SqlFlightDAO(SqlDAO.newInstance());
        request.setAttribute("flightDAO", flightDAO);
        request.getRequestDispatcher("flight.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            FlightDAO flightDAO = new SqlFlightDAO(SqlDAO.newInstance());
            flightDAO.delete(flightDAO.getByID(id));
            resp.sendRedirect("/flight");
        }
        doGet(req,resp);
    }
}
