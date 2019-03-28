package control.Airplane;

import database.DAO.AirplaneDAO;
import database.DAO.sql.SqlAirplaneDAO;
import database.DAO.sql.SqlCompanyDAO;
import database.DAO.sql.SqlDAO;
import database.Entity.Airplane;
import database.Entity.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addAirplane")
public class AddAirplaneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = (new SqlCompanyDAO(SqlDAO.newInstance())).getAll();
        req.setAttribute("companies", companies);
        req.getRequestDispatcher("addAirplane.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idAirplane = Integer.valueOf(req.getParameter("ID_airplane"));
        int idComp = Integer.valueOf(req.getParameter("ID_comp"));
        String name = req.getParameter("name");
        AirplaneDAO airplaneDAO = new SqlAirplaneDAO(SqlDAO.newInstance());
        //Airplane airplane = new Airplane(Integer.valueOf(req.getParameter("ID_airplane")), Integer.valueOf(req.getParameter("ID_comp")), req.getParameter("name"));
        Airplane airplane = new Airplane(idAirplane, idComp, name);
        airplaneDAO.create(airplane);
        resp.sendRedirect("/airplane");
    }
}
