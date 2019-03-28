package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* ArrayList<ArrayList<String>> res = SqlDAO.getFlights("Самара", "Москва", "2018-12-05 +04");
        request.setAttribute("res",res);*/
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
