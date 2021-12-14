package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.DepartmentServiceImpl;
@WebServlet("/UpdDeptnameServlet")

public class UpdDeptnameServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		DepartmentServiceImpl dsi=new DepartmentServiceImpl();
		System.out.println("�����ˣ�����");
		System.out.println(req.getParameter("deptinfo"));
		String deptid=req.getParameter("deptinfo").split(":")[0];
		String deptname=req.getParameter("deptinfo").split(":")[1];
		System.out.println(deptid);
		System.out.println(deptname);
		dsi.updDept(deptname,Integer.parseInt(deptid));
		resp.sendRedirect("deptManage.jsp");
	}
	
}
