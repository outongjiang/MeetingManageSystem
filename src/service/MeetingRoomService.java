package service;

import java.util.List;

import model.MeetingRoom;

public interface MeetingRoomService {
	//查询会议室信息
	List<MeetingRoom>selectRoomInfo(Integer currPage);
	//插入会议室信息
	int insertMeetingRoomInfo(MeetingRoom mr);
	//更新会议室可用状态
	int updateStatus(String status,String roomid);
	//查询数量
	int selectSumPage();
}
