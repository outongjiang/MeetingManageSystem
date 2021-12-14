package servlet;

import model.MeetingRoom;
import service.impl.MeetingRoomServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatemeetingroomsServlet")
public class updatemeetingroomsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MeetingRoomServiceimpl mrsl=new MeetingRoomServiceimpl();
        String status=req.getParameter("status");
        String roomid=req.getParameter("roomid");
        mrsl.updateStatus(status,roomid);
        resp.sendRedirect("allmeetingroomsServlet");
    }
}

