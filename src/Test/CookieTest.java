package Test;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        if (req.getCookies() != null) {
            for (Cookie e : req.getCookies()) {
                if ("lastTime".equals(e.getName())) {
                    String value = URLDecoder.decode(e.getValue(), "utf-8");
                    System.out.println(value);
                    String w="<h1>您上次访问" + "," + value + "</h1>";
                    resp.getWriter().write(w);
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String lastTime = sdf.format(date);
                    lastTime = URLEncoder.encode(lastTime, "utf-8");
                    System.out.println(lastTime);
                    e.setValue(lastTime);
                    resp.addCookie(e);
                }
            }
        } else {
            Cookie cookie = new Cookie("lastTime", null);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            resp.getWriter().write("<h1>您首次访问</h1>");
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            String lastTime = sdf.format(date);
            lastTime = URLEncoder.encode(lastTime, "utf-8");
            cookie.setValue(lastTime);
            resp.addCookie(cookie);
        }
    }
}