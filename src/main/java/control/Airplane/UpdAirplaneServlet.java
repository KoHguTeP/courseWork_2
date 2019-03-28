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

@WebServlet("/updAirplane")
public class UpdAirplaneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Airplane airplane = (new SqlAirplaneDAO(SqlDAO.newInstance())).getByID(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("pagename","Airplane");
        req.setAttribute("air",airplane);*/
        List<Company> companies = (new SqlCompanyDAO(SqlDAO.newInstance())).getAll();
        req.setAttribute("companies", companies);
        String idToUpd = req.getParameter("idToUpd");
        req.setAttribute("idToUpd", idToUpd);
        Airplane airplane   = (new SqlAirplaneDAO(SqlDAO.newInstance())).getByID(Integer.parseInt(req.getParameter("idToUpd")));
        req.setAttribute("airplaneToUpd", airplane);
        req.getRequestDispatcher("updAirplane.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //if (req.getParameter("action").equals("update")) {
            int id_airplane = Integer.parseInt(req.getParameter("ID_airplane"));
            String name = req.getParameter("name");
            int id_company = Integer.parseInt(req.getParameter("ID_comp"));
            AirplaneDAO airplaneDAO = new SqlAirplaneDAO(SqlDAO.newInstance());
            airplaneDAO.update(id_airplane, name, id_company);
            resp.sendRedirect("/airplane");
        //}
    }
}
