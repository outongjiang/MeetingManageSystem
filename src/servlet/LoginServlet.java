package servlet;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
import util_checkCode.CheckCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	//创建service层对象employeeServiceImpl
	private EmployeeService EmployeeServiceImpl = new EmployeeServiceImpl();

	@Override
	public void destroy() {
		System.out.println("销毁");
		super.destroy();
		System.out.println("销毁");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet的初始化方法。。。。");


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//调用service

		req.setCharacterEncoding("utf-8");
		Map<String, String[]> paras = req.getParameterMap();
		for (String key : paras.keySet()) {
			System.out.print(key + ":");
			for (String v : paras.get(key)) {
				System.out.print(v + " ");
			}
			System.out.println();
		}


	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
//		doPost(req, resp);
		System.out.println(req.getServerName());
		try {
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e3) {
			// TODO 自动生成的 catch 块
			e3.printStackTrace();
		}

		String code = req.getParameter("checkcode");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		EmployeeServiceImpl esl = new EmployeeServiceImpl();
		int flag = esl.login(username, password);

			if (flag == 1 && code.equals(CheckCode.code)) {
				try {
					System.out.println(req.getParameter("msg"));
					if(req.getParameter("msg")!=null){
						Cookie cookie=new Cookie("username",username);
						cookie.setMaxAge(60*60*24*7);
						resp.addCookie(cookie);
						}
					req.getSession().setAttribute("username", username);
//					resp.getWriter().write("登录成功。。。");
//					resp.sendRedirect("welcome.html");
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}


		}
		try {
			resp.sendRedirect("/VD/jsp/home.jsp");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}