package control.Flight;

import database.DAO.FlightDAO;
import database.DAO.sql.SqlAirplaneDAO;
import database.DAO.sql.SqlDAO;
import database.DAO.sql.SqlDirectionDAO;
import database.DAO.sql.SqlFlightDAO;
import database.Entity.Airplane;
import database.Entity.Direction;
import database.Entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@WebServlet("/addFlight")
public class AddFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airplane> airplanes = (new SqlAirplaneDAO(SqlDAO.newInstance())).getAll();
        req.setAttribute("airplanes", airplanes);
        List<Direction> directions = (new SqlDirectionDAO(SqlDAO.newInstance())).getAll();
        req.setAttribute("directions", directions);
        req.getRequestDispatcher("addFlight.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idFlight = Integer.valueOf(req.getParameter("ID_flight"));
        int idAirplane = Integer.valueOf(req.getParameter("ID_airplane"));
        int idDirection = Integer.valueOf(req.getParameter("ID_direction"));
        /*int index = req.getParameter("Direction").indexOf(" - ");
        String directionTo = req.getParameter("Direction").substring(index + 3);
        String directionFrom = req.getParameter("Direction").substring(0, index);*/
        Time timeArrival = Time.valueOf(req.getParameter("time_arrival"));
        Time timeDeparture = Time.valueOf(req.getParameter("time_departure"));
        Date dateArrival = Date.valueOf(req.getParameter("date_arrival"));
        Date dateDeparture = Date.valueOf(req.getParameter("date_departure"));
        /*int idDirection = (new SqlDirectionDAO(SqlDAO.newInstance())).getByDirection(directionFrom, directionTo);*/
        int cost = Integer.valueOf(req.getParameter("cost"));
        FlightDAO flightDAO = new SqlFlightDAO(SqlDAO.newInstance());
        Flight flight = new Flight(idFlight, idAirplane, idDirection, cost, timeArrival, timeDeparture, dateArrival, dateDeparture);
        flightDAO.create(flight);
        resp.sendRedirect("/flight");
    }
}
