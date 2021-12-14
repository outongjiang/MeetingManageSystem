package service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDao;
import model.Department;
import service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao=new DepartmentDao();
//	public static ArrayList<Department>deptSet=new ArrayList<Department>();
	@Override
	public List<Department> selectDept() {
		String sql="select * from department";
		ResultSet rs =departmentDao.selectDeptInfo(sql,null);
		 ArrayList<Department>deptSet=new ArrayList<Department>();
		try {
			while(rs.next()) {
				deptSet.add(new Department(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return deptSet;
	}
	@Override
	public int appDept(String deptname) {
		String sql="insert into department values(null,?)";
		List<Object>parames=new ArrayList<Object>();
		parames.add(deptname);
		return departmentDao.insertDept(sql,parames);
	}
	@Override
	public int delDept(String deptid) {
		List<Object>params=new ArrayList<Object>();
		params.add(deptid);
		String sql="delete from department where departmentid=?";
		return departmentDao.deleteDept(sql,params);
	}
	@Override
	public int updDept(String deptname,Integer id) {
		String sql="update department set departmentname=? where departmentid=?";
		List<Object>parames=new ArrayList<Object>();
		parames.add(deptname);
		parames.add(id);
		return departmentDao.updateDept(sql, parames);
	}
	
	
}
