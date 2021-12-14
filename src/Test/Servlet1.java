package Test;

import util.DownloadUtils;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
@WebServlet("/Servlet1")
public class Servlet1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Cookie c:req.getCookies()) {
            if("lastTime".equals(c.getName()))
                c.setMaxAge(0);
        }
        //        resp.getWriter().write("Servlet1");
////        req.getSession().setAttribute("name",new String("张三".getBytes(),"utf-8"));
//        Cookie cookie[]=req.getCookies();
//       for(Cookie c:cookie){
//           System.out.println(req.getServletPath()+";"+c.getName()+":"+c.getValue());
//       }
//
//       Cookie cookie=new Cookie("name",new String("欧桐江".getBytes(),"utf-8"));
//        resp.addCookie(cookie);
//         doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename=req.getParameter("filename");
        String path=this.getServletContext().getRealPath("/images/"+filename);

       // String type=this.getServletContext().getMimeType(path);
        //resp.setContentType(type);
        try {
            filename= DownloadUtils.filenameEncoding(filename,req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(filename);


        resp.setHeader("content-disposition","attachment;filename="+filename);
        FileInputStream fis=new FileInputStream(path);
        OutputStream os =resp.getOutputStream();
        byte b[]=new byte[1024];
        int len=0;
        while((len=fis.read(b))!=-1){
            os.write(b,0,len);
        }
        fis.close();
    }
}
