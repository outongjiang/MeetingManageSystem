package dao;

import java.sql.ResultSet;
import java.util.List;

public class DepartmentDao {
		//insert
	public int insertDept(String sql,List<Object> params) {
		return JDBC2.execStatementUpdate(sql, params);
		
	}
	
		//update
	public int updateDept(String sql,List<Object>params) {
		return JDBC.execStatementUpdate(sql, params);
	}
		
		//delete
	public int deleteDept(String sql,List<Object> params) {
		return JDBC.execStatementUpdate(sql, params);
	}
		
		//select
		public ResultSet selectDeptInfo(String sql,List<Object>params) {
			return JDBC2.execStatementQuery(sql, params);
		}

		

		
}
