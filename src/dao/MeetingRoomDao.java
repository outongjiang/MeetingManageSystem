package dao;

import java.sql.ResultSet;
import java.util.List;

public class MeetingRoomDao {
	//insert
		public int insertMeetingInfo(String sql,List<Object>params) {
			return JDBC2.execStatementUpdate(sql, params);
		}
		
			//update
			
			
			//delete
		
			
			//select
	public ResultSet selectMeetingRoom(String sql,List<Object>params) {
		return JDBC2.execStatementQuery(sql, params);
	}
}
