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

@WebServlet("/updFlight")
public class UpdFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idToUpd = req.getParameter("idToUpd");
        req.setAttribute("idToUpd", idToUpd);
        //DirectionDAO directionDAO = DirectionDAO.getByID
        Flight flight = (new SqlFlightDAO(SqlDAO.newInstance())).getByID(Integer.parseInt(req.getParameter("idToUpd")));
        req.setAttribute("flightToUpd", flight);
        List<Airplane> airplanes = (new SqlAirplaneDAO(SqlDAO.newInstance())).getAll();
        req.setAttribute("airplanes", airplanes);
        /*Airplane airplane = (new SqlAirplaneDAO(SqlDAO.newInstance())).getByID(flight.getIDAir());
        req.setAttribute("airpl", airplane);*/
        List<Direction> directions = (new SqlDirectionDAO(SqlDAO.newInstance())).getAll();
        req.setAttribute("directions", directions);
        /*Direction direction = (new SqlDirectionDAO(SqlDAO.newInstance())).getByID(flight.getIDDirection());
        req.setAttribute("direct", direction);*/
        req.getRequestDispatcher("updFlight.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id_flight = Integer.parseInt(req.getParameter("ID_flight"));
        int id_airplane = Integer.parseInt(req.getParameter("ID_airplane"));
        int id_direction = Integer.parseInt(req.getParameter("id_Direction"));
        /*int index = req.getParameter("Direction").indexOf(" - ");
        String directionTo = req.getParameter("Direction").substring(index + 3);
        String directionFrom = req.getParameter("Direction").substring(0, index);
        int id_direction = (new SqlDirectionDAO(SqlDAO.newInstance())).getByDirection(directionFrom, directionTo);*/
        Time timeArrival = Time.valueOf(req.getParameter("time_arrival"));
        Time timeDeparture = Time.valueOf(req.getParameter("time_departure"));
        Date dateArrival = Date.valueOf(req.getParameter("date_arrival"));
        Date dateDeparture = Date.valueOf(req.getParameter("date_departure"));
        int cost = Integer.valueOf(req.getParameter("cost"));
        FlightDAO flightDAO = new SqlFlightDAO(SqlDAO.newInstance());
        flightDAO.update(id_flight,id_airplane,id_direction,cost,timeArrival,timeDeparture,dateArrival,dateDeparture);
        resp.sendRedirect("/flight");
    }
}
