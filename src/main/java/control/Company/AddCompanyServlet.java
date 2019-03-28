package control.Company;

import database.DAO.CompanyDAO;
import database.DAO.sql.SqlCompanyDAO;
import database.DAO.sql.SqlDAO;
import database.Entity.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCompany")
public class AddCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addCompany.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idComp = Integer.valueOf(req.getParameter("ID_company"));
        String name = req.getParameter("name");
        CompanyDAO companyDAO = new SqlCompanyDAO(SqlDAO.newInstance());
        Company company = new Company(idComp, name);
        companyDAO.create(company);
        resp.sendRedirect("/company");
    }
}
