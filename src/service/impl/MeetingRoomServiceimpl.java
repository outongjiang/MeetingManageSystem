package service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import dao.JDBC2;
import dao.MeetingRoomDao;
import model.MeetingRoom;
import org.springframework.jdbc.core.JdbcTemplate;
import service.MeetingRoomService;

public class MeetingRoomServiceimpl implements MeetingRoomService{
	private MeetingRoomDao meetingRoomDao=new MeetingRoomDao();
	@Override
	public List<MeetingRoom>selectRoomInfo(Integer currPage) {
		String sql="select * from meetingroom limit ?,?";
		List<Object>params=new ArrayList<>();
		params.add(currPage*5);
		params.add(5);
		ResultSet rs =meetingRoomDao.selectMeetingRoom(sql,params);
		 ArrayList<MeetingRoom>meetingRoomsSet=new ArrayList<MeetingRoom>();
		try {
			while(rs.next()) {
				meetingRoomsSet.add(new MeetingRoom(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),null));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return meetingRoomsSet;
		
	}
	@Override
	public int insertMeetingRoomInfo(MeetingRoom mr) {
		String sql="insert into meetingroom values(null,?,?,?,?,?)";
		List<Object>params=new ArrayList<Object>();
		params.add(String.valueOf(mr.getRoomnum()));
		params.add(mr.getRoomname());
		params.add(mr.getCapacity());
		params.add(mr.getStatus());
		params.add(String.valueOf(mr.getDescription()));
		return meetingRoomDao.insertMeetingInfo(sql, params);
		
	}

	@Override
	public int updateStatus(String status,String roomid) {
		String sql="update meetingroom set status=? where roomid=?";
		JdbcTemplate template=new JdbcTemplate(JDBC2.getDataSource());

		return  template.update(sql,status.equals("1")?"0":"1",roomid);
	}

	@Override
	public int selectSumPage() {
		String sql="select count(*) from meetingroom";

			ResultSet rs=  JDBC2.execStatementQuery(sql,null);
		try {
			rs.next();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		try {
			return rs.getInt(1);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return -1;
	}


}
