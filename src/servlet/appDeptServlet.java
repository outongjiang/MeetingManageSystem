package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartmentService;
import service.impl.DepartmentServiceImpl;
@WebServlet("/appDeptServlet")
public class appDeptServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("utf-8");	
		String deptname=req.getParameter("deptname");
		DepartmentServiceImpl dpImpl=new DepartmentServiceImpl();
		dpImpl.appDept(deptname);
		resp.sendRedirect("deptManage.jsp");
	}
	
	
}
