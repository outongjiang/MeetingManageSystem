package servlet;

import model.Meeting;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.MeetingRoomServiceimpl;
import service.impl.MeetingServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Map;

@WebServlet("/appRserveMeetingServlet")
public class appRserveMeetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MeetingServiceimpl msil=new MeetingServiceimpl();
        String roomname=req.getParameter("roomname");
       String numberofparticipants=req.getParameter("numberofparticipants");
       String starttime=req.getParameter("starttime");
       String endtime=req.getParameter("endtime");

       starttime=starttime+":00";
       endtime=endtime+":00";
      starttime= starttime.replace("T"," ");
        endtime=endtime.replace("T"," ");
        System.out.println(starttime);
        System.out.println(endtime);
        Meeting m=new Meeting();
        System.out.println(m);
       m.setRoomname(roomname);
       m.setNumberofparticipants(Integer.parseInt(numberofparticipants));
       m.setStarttime(Timestamp.valueOf(starttime));
       m.setEndtime(Timestamp.valueOf(endtime));
       msil.reserveMeeting(m);







    }
}
