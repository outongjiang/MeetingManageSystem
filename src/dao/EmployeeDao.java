package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;





public class EmployeeDao {
	
	//insert
	public int insertByUser(String sql,List<Object> params) {
		return JDBC2.execStatementUpdate(sql, params);
		
	}
	
	//update
	public  int updateRegister(String sql,List<Object> params){
		return JDBC2.execStatementUpdate(sql,params);
	}
	public  int updateRegister2(String sql,List<Object> params){
		return JDBC2.execStatementUpdate(sql,params);
	}
	//delete
	public int delRegisterInfo(String sql,List<Object> params) {
		return JDBC2.execStatementUpdate(sql, params);
	}
	
	//select
	public ResultSet selectByUsername(String sql,List<Object> params) {
			//Connection conn=JDBC.getConnection();
			//String sql="select * from employee where username=? and password=?";
//			param.add(username);
//			param.add(password);
			return  JDBC2.execStatementQuery(sql, params);
	}
	public ResultSet selectByRegisterInfo(String sql,List<Object> params) {
		//Connection conn=JDBC.getConnection();
		//String sql="select * from employee where username=? and password=?";
//		param.add(username);
//		param.add(password);
		return  JDBC2.execStatementQuery(sql, params);
}


	


	
}
