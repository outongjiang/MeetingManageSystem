package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MeetingRoom;
import service.impl.MeetingRoomServiceimpl;
@WebServlet("/MeetingRoomServlet")
public class MeetingRoomServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("utf-8");
		
		
	}	
	
}
