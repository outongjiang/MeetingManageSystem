package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MeetingRoom;
import service.impl.MeetingRoomServiceimpl;
@WebServlet("/servlet/appMeetingRoomInfo")
public class appMeetingRoomInfo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MeetingRoomServiceimpl mrsi=new MeetingRoomServiceimpl();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		int i=mrsi.insertMeetingRoomInfo(new MeetingRoom(null,Integer.parseInt(req.getParameter("roomnum")),req.getParameter("roomname"),Integer.parseInt(req.getParameter("opacity")),req.getParameter("status"),req.getParameter("description")));
		if(i>0) {
			resp.getWriter().write("添加成功");
		}else {
			resp.getWriter().write("添加成功");
		}
	}
	
	
	
	
}
