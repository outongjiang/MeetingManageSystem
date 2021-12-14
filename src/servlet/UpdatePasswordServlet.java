package servlet;
import service.impl.EmployeeServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeServiceImpl esl = new EmployeeServiceImpl();
            String oldpassword=req.getParameter("oldpassword");
            String newpassword=req.getParameter("newpassword");
            String newpassword2=req.getParameter("newpassword2");
        System.out.println(newpassword);
            String username= String.valueOf(req.getSession().getAttribute("username"));
            if(esl.login(username, oldpassword)>=1){
                System.out.println("bbb");
                req.getSession().setAttribute("password", newpassword);
                esl.updatePassword(newpassword,username);
            }else{
                req.getSession().removeAttribute("password");
            }

            resp.sendRedirect("./Welcome.jsp");
    }
}
