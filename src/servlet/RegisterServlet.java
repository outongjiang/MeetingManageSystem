package servlet;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.sun.org.apache.bcel.internal.generic.Select;

import model.Employee;
import service.impl.EmployeeServiceImpl;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("GBK");
			resp.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e3) {
			// TODO �Զ����ɵ� catch ��
			e3.printStackTrace();
		}
		
		EmployeeServiceImpl esl=new EmployeeServiceImpl();
		Map<String , String[]>user=req.getParameterMap();
		Employee emp=new Employee();
		try {
			BeanUtils.populate(emp,user);
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
//		System.out.println(req.getParameter("employeename"));
		int i=esl.register(emp);
		
		if(i>0) {
			resp.getWriter().write("ע��ɹ�������");
		}else {
			resp.getWriter().write("ע��ʧ�ܡ�����");
		}
	}
	
}
