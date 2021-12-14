package servlet;
import model.Employee;
import model.MeetingRoom;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.EmployeeServiceImpl;
import service.impl.MeetingRoomServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
@WebServlet("/researchEmpServlet")
public class researchEmpServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(new String("进入doGet".getBytes(),"utf-8"));
        EmployeeServiceImpl empSimpl=new EmployeeServiceImpl();
        Integer currPage=null;
        Integer sumPage=empSimpl.selectSumPage(req.getParameter("status"),req.getParameter("employeename"),req.getParameter("username"));
        Integer maxPage=(sumPage%5==0?sumPage/5:sumPage/5+1)-1;
        System.out.println("req.getParameter(\"currPage\") =\t"+req.getParameter("currPage") );
        if(req.getParameter("currPagetext")!=null&&!"".equals(req.getParameter("currPagetext"))){
          currPage= Integer.parseInt( req.getParameter("currPagetext"))-1;
            System.out.println("aa");
        }else{
            System.out.println("cc");
        if("max".equals(req.getParameter("currPage"))){
            currPage=maxPage;
            System.out.println("末页");
            System.out.println("bb");
        }else {
            System.out.println("ee");
            if (req.getParameter("currPage") != null) {
                currPage = Integer.parseInt(req.getParameter("currPage"));
                System.out.println("ff");
            } else {
                currPage = 0;
                System.out.println("tt");
            }
            if (currPage > maxPage) {
                currPage = maxPage;
            } else if (currPage < 0) {
                currPage = 0;
            }
        }}
        System.out.println("currPage"+currPage);
        List<Employee> employee=empSimpl.selectEmpInfo(currPage,req.getParameter("status"),req.getParameter("employeename"),req.getParameter("username"));
        req.setAttribute("employee", employee);
        req.setAttribute("sumPage",String.valueOf(sumPage));
        req.setAttribute("currPage",currPage==0?"0":String.valueOf(currPage));
        req.getRequestDispatcher("researchEmp.jsp").forward(req, resp);




    }



}
