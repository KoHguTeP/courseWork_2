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
import java.util.List;

@WebServlet("/company")
public class TableCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> companies = (new SqlCompanyDAO(SqlDAO.newInstance())).getAll();
        request.setAttribute("pagename","Company");
        request.setAttribute("companies", companies);
        request.getRequestDispatcher("company.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            CompanyDAO companyDAO = new SqlCompanyDAO(SqlDAO.newInstance());
            companyDAO.delete(companyDAO.getByID(id));
            resp.sendRedirect("/company");
        }
        doGet(req,resp);
    }
}
