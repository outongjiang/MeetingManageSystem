package service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MeetingDao;
import model.Meeting;
import service.MeetingService;

public class MeetingServiceimpl implements MeetingService{
	private MeetingDao meetingDao=new MeetingDao();
	//��ѯ������Ϣ
	@Override
	public List<Meeting> selectMeeting() {
		String sql="select meetingname,roomname,starttime,endtime,reservationtime from meeting m,meetingroom r where m.roomid=r.roomid";
		List<Meeting>meetings=new ArrayList<Meeting>();
		ResultSet rs=meetingDao.selectMeeting(sql, null);
		try {
			while(rs.next()) {
				meetings.add(new Meeting(rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4),rs.getTimestamp(5)));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return meetings;
	}
	//��ѯȡ���Ļ���
	@Override
	public List<Meeting> selectCancelMeeting() {
		String sql="select meetingname,roomname,starttime,endtime from meeting m,meetingroom r where m.roomid=r.roomid and m.status='1'";
		List<Meeting>meetings=new ArrayList<Meeting>();
		ResultSet rs=meetingDao.selectMeeting(sql, null);
		try {
			while(rs.next()) {
				meetings.add(new Meeting(rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4),null));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return meetings;
	}

	@Override
	public int reserveMeeting(Meeting m) {
		String sql="insert into meeting values(?,?,?,?,?,?,?,?,?,?,?)";
		List<Object>params=new ArrayList<Object>();
		params.add(m.getMeetingid());
		params.add(m.getMeetingname());
		params.add(searchRoomname(m.getRoomid()));
		params.add(m.getReservationistid());
		params.add(m.getNumberofparticipants());
		params.add(m.getStarttime());
		params.add(m.getEndtime());
		params.add(m.getReservationtime());
		params.add(m.getCanceledtime());
		params.add(m.getDescription());
		params.add(m.getStatus());
		return meetingDao.insertMeetingInfo(sql,params);

	}

	@Override
	public String searchRoomname(Integer roomid) {
		String sql="select roomname from meetingroom where roomid=?";
		List<Object>params=new ArrayList<Object>();
		params.add(roomid);
		ResultSet rs=meetingDao.selectMeeting(sql,params);
		try {
			rs.next();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		try {
			return rs.getString(1);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}


}
