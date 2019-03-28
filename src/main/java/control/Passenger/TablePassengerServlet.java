package control.Passenger;

import database.DAO.PassengerDAO;
import database.DAO.sql.SqlDAO;
import database.DAO.sql.SqlPassengerDAO;
import database.Entity.Passenger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/passenger")
public class TablePassengerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Passenger> passengers = (new SqlPassengerDAO(SqlDAO.newInstance())).getAll();
        request.setAttribute("pagename","Passenger");
        request.setAttribute("passengers", passengers);
        request.getRequestDispatcher("passenger.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            PassengerDAO passengerDAO = new SqlPassengerDAO(SqlDAO.newInstance());
            passengerDAO.delete(passengerDAO.getByID(id));
            resp.sendRedirect("/passenger");
        }
        doGet(req,resp);
    }
}
