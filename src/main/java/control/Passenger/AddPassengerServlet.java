package control.Passenger;

import database.DAO.PassengerDAO;
import database.DAO.sql.SqlDAO;
import database.DAO.sql.SqlFlightDAO;
import database.DAO.sql.SqlPassengerDAO;
import database.Entity.Flight;
import database.Entity.Passenger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addPassenger")
public class AddPassengerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flight> flights = (new SqlFlightDAO(SqlDAO.newInstance())).getAll();
        req.setAttribute("flights", flights);
        req.getRequestDispatcher("addPassenger.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idPassenger = Integer.valueOf(req.getParameter("ID_passenger"));
        int idFlight = Integer.valueOf(req.getParameter("ID_flight"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        PassengerDAO passengerDAO = new SqlPassengerDAO(SqlDAO.newInstance());
        Passenger passenger = new Passenger(idPassenger, firstName, lastName, idFlight);
        passengerDAO.create(passenger);
        resp.sendRedirect("/passenger");
    }
}
