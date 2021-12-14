package servlet;

import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/closeUserServlet")
public class closeUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("......");
        EmployeeServiceImpl esil=new EmployeeServiceImpl();
      //  System.out.println(req.getParameter("empid_f"));
        System.out.println(Integer.parseInt((String) req.getParameter("empid_f")));
       esil.updateRegister( Integer.parseInt((String) req.getParameter("empid_f")));
        resp.sendRedirect("researchEmpServlet");
    }
}
