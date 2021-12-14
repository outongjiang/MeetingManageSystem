package servlet;

import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ExamEmpRegisterServlet")
public class ExamEmpRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("............");
        EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
        employeeService.agreeRegister(Integer.parseInt(req.getParameter("Exam_registerInfo")));
        resp.sendRedirect("registerExamine.jsp");
    }
}
