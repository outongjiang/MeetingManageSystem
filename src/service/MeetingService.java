package service;

import java.util.List;

import model.Meeting;

public interface MeetingService {
	//查询会议信息
	List<Meeting> selectMeeting();
	//查询取消的会议
	List<Meeting> selectCancelMeeting();
	//预定会议
	int reserveMeeting(Meeting m);

	//根据roomid找roomname
	String searchRoomname(Integer roomid);
}
