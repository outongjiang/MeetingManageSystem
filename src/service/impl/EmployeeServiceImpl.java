package service.impl;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import dao.EmployeeDao;
import dao.JDBC2;
import model.Employee;
import model.MeetingRoom;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import service.EmployeeService;

import static dao.JDBC2.*;
import static dao.JDBC2.getDataSource;

public class EmployeeServiceImpl implements EmployeeService {

	//����dao��Ķ���EmployeeDao
	private EmployeeDao employeeDao=new EmployeeDao();


	@Override
	public int updatePassword(String password, String username) {
		String sql="update employee set password=? where username=?";
		List<Object>params=new ArrayList<>();
		params.add(password);
		params.add(username);
		return employeeDao.updateRegister(sql,params);
	}

	@Override
	public int login(String usrname, String password) {
		int loginFlag=0;
		List<Object> params=new  ArrayList<Object>();
		params.add(usrname);
		params.add(password);
		String sql="select * from employee where username=? and password=?";
		try {
			if(employeeDao.selectByUsername(sql, params).next()) {
				loginFlag=1;
				return loginFlag;//�ɹ�����1 
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return loginFlag;//ʧ�ܷ���0
	}


	@Override
	public int register(Employee e) {
		List <Object>params=new ArrayList<Object>();
		try {
			params.add(new String(e.getEmployeename().getBytes(),"GBK"));
		} catch (UnsupportedEncodingException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		params.add(e.getUsername());
		params.add(e.getPhone());
		params.add(e.getEmail());
		params.add(e.getDepartment());
		params.add(e.getPassword());
		String sql="insert into employee values(null,?,?,?,?,'1',?,?,null)";
		return employeeDao.insertByUser(sql, params);
	}


	@Override
	public List<Employee> selectRegiterInfo() {
		String sql="select employeeid,employeename,username,phone,email from employee where status=?";
		List<Object>params=new ArrayList<Object>();
		params.add(new Integer(1));
		ResultSet rs= employeeDao.selectByRegisterInfo(sql, params);
		List<Employee>regiterInfo=new ArrayList<Employee>();
		Employee emp=null;
		
		try {
			while(rs.next()) {
				emp=new Employee();
				emp.setEmployeeid(rs.getInt(1));
				emp.setEmployeename(rs.getString(2));
				emp.setUsername(rs.getString(3));
				emp.setPhone(rs.getString(4));
				emp.setEmail(rs.getString(5));
				regiterInfo.add(emp);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return regiterInfo;
		
	}

	@Override
	public int agreeRegister(Integer empid) {
		String sql="update employee set status='0' where employeeid=?";
		List<Object>params=new ArrayList<Object>();
		params.add(empid);
		return employeeDao.updateRegister(sql,params);
	}

	@Override
	public List<Map<String,Object>> researchEmp(String username, String employeename,Integer pageCode)  {
		String sql="select employeeid,employeename,username,phone,email from employee where username=? and employeename=? limit ?,? ";
		JdbcTemplate jdbctemplate=new JdbcTemplate(JDBC2.getDataSource());
		List<Map<String,Object>>emp=jdbctemplate.queryForList(sql,username,employeename,(pageCode-1)*5,5);
		return emp;
	}
	@Override
	public List<Map<String,Object>> researchEmp(String status,Integer pageCode) {
		String sql="select employeeid,employeename,username,phone,email from employee where status=? limit ?,? ";
		JdbcTemplate jdbctemplate=new JdbcTemplate(JDBC2.getDataSource());
		List<Map<String,Object>>emps=jdbctemplate.queryForList(sql,status,(pageCode-1)*5,5);
		return emps;
	}

	@Override
	public List<Map<String, Object>> researchEmp(Integer pageCode) {
		String sql="select employeeid,employeename,username,phone,email from employee limit ?,?";
		JdbcTemplate jdbctemplate=new JdbcTemplate(JDBC2.getDataSource());
		List<Map<String,Object>>emps=jdbctemplate.queryForList(sql,(pageCode-1)*5,5);
		return emps;
	}

	@Override
	public int updateRegister(Integer employeeid) {
		String sql="update employee set status=? where employeeid=?";
		List<Object>params=new ArrayList<Object>();
		params.add("2");
		params.add(employeeid);
		return employeeDao.updateRegister2(sql, params);
	}

	@Override
	public List<Employee> selectEmpInfo(Integer currPage,String status,String employeename,String username) {
		List<Object>params=new ArrayList<>();
		ResultSet rs=null;
		if(status==null&&employeename==null&&username==null){
			String sql="select * from employee limit ?,?";
			params.add(currPage*5);
			params.add(5);
			rs=employeeDao.selectByUsername(sql,params);
		}else{
			String sql="select * from employee where status=? or employeename=? or username=? limit ?,?";
			params.add(status);
			params.add(employeename);
			params.add(username);
			params.add(currPage*5);
			params.add(5);
			 rs=employeeDao.selectByUsername(sql,params);
		}
		ArrayList<Employee>emps=new ArrayList<Employee>();
		try {
			while(rs.next()) {
				Employee employee=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
				emps.add(employee);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("是不是无记录导致");
		}
		return emps;
	}

	@Override
	public int selectSumPage(String status,String employeename,String username) {
		String sql="";
		ResultSet rs=null;
		if(status==null&&employeename==null&&username==null){
			sql="select count(*) from employee";
			rs=  JDBC2.execStatementQuery(sql,null);
		}else {
			sql = "select count(*) from employee where status=? or employeename=? or username=?";
			List<Object>params=new ArrayList<Object>();
			params.add(status);
			params.add(employeename);
			params.add(username);
			rs=  JDBC2.execStatementQuery(sql,params);
		}

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


	@Override
	public int delRegisterInfo(Integer empid) {
		String sql="delete from employee where employeeid=?";
		List<Object>params=new ArrayList<Object>();
		params.add(new Integer(empid));
		return employeeDao.delRegisterInfo(sql, params);
		
	}

	
}
