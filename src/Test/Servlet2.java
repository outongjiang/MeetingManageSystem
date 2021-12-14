package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet2")
public class Servlet2  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Servlet2");
        System.out.println(req.getSession().getAttribute("name"));
        //       req.setCharacterEncoding("utf-8");
//        Cookie cookie[]=req.getCookies();
//       for(Cookie c:cookie){
//           System.out.println(req.getServletPath()+";"+c.getName()+":"+c.getValue());
//       }

    }
}
