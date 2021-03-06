package control.Company;

import database.DAO.CompanyDAO;
import database.DAO.sql.SqlCompanyDAO;
import database.DAO.sql.SqlDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updCompany")
public class UpdCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idToUpd = req.getParameter("idToUpd");
        req.setAttribute("idToUpd", idToUpd);
        req.getRequestDispatcher("updCompany.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id_company = Integer.parseInt(req.getParameter("ID_company"));
        String name = req.getParameter("name");
        CompanyDAO companyDAO = new SqlCompanyDAO(SqlDAO.newInstance());
        companyDAO.update(id_company, name);
        resp.sendRedirect("/company");
    }
}
