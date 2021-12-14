package dao;

import java.sql.ResultSet;
import java.util.List;

public class MeetingDao {
	//insert
	public int insertMeetingInfo(String sql,List<Object>params){
		return JDBC2.execStatementUpdate(sql,params);
	}
	
	//update
	
	
	//delete

	
	//select
	public ResultSet selectMeeting(String sql,List<Object>params) {
		return JDBC2.execStatementQuery(sql, params);
	}
}
