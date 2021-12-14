package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.EmployeeServiceImpl;
@WebServlet("/DelEmpRegisterServlet")
public class DelEmpRegisterServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				EmployeeServiceImpl esil=new EmployeeServiceImpl();
				esil.delRegisterInfo(Integer.parseInt(req.getParameter("del_registerInfo")));
				resp.sendRedirect("registerExamine.jsp");
		}
}
