package control.Passenger;

import database.DAO.PassengerDAO;
import database.DAO.sql.SqlDAO;
import database.DAO.sql.SqlFlightDAO;
import database.DAO.sql.SqlPassengerDAO;
import database.Entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updPassenger")
public class UpdPassengerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idToUpd = req.getParameter("idToUpd");
        req.setAttribute("idToUpd", idToUpd);
        List<Flight> flights = (new SqlFlightDAO(SqlDAO.newInstance())).getAll();
        req.setAttribute("flights", flights);
        req.getRequestDispatcher("updPassenger.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id_passenger = Integer.parseInt(req.getParameter("ID_passenger"));
        int id_flight = Integer.parseInt(req.getParameter("ID_flight"));
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        PassengerDAO passengerDAO = new SqlPassengerDAO(SqlDAO.newInstance());
        passengerDAO.update(id_passenger, id_flight, lastname, firstname);
        resp.sendRedirect("/passenger");
    }
}
