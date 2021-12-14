package servlet;
import java.io.IOException;
import java.util.List;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MeetingRoom;
import service.impl.MeetingRoomServiceimpl;
@WebServlet("/servlet/allmeetingroomsServlet")
public class allmeetingroomsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MeetingRoomServiceimpl mrsi=new MeetingRoomServiceimpl();
		Integer currPage=null;
		Integer sumPage=mrsi.selectSumPage();
		Integer maxPage=(sumPage%5==0?sumPage/5:sumPage/5+1)-1;
		if("max".equals(req.getParameter("currPage"))){
			currPage=maxPage;
			System.out.println("末页");
		}else {
			if (req.getParameter("currPage") != null) {
				currPage = Integer.parseInt(req.getParameter("currPage"));
			} else {
				currPage = 0;
			}
			if (currPage > maxPage) {
				currPage = maxPage;
			} else if (currPage < 0) {
				currPage = 0;
			}
		}
		System.out.println(currPage);
		List<MeetingRoom> meetrRoom=mrsi.selectRoomInfo(currPage);
    	req.setAttribute("meetrRoom", meetrRoom);
    	req.setAttribute("sumPage",String.valueOf(sumPage));
    	req.setAttribute("currPage",currPage==0?"0":String.valueOf(currPage));
    	req.getRequestDispatcher("/jsp/allmeetingrooms.jsp").forward(req, resp);
	}
	
}
