package service;

import java.util.List;

import model.Department;

public interface DepartmentService {
	//查询部门信息
	List<Department> selectDept();
	//添加部门
	int appDept(String deptname);
	//删除部门
	int delDept(String deptname);
	//更新部门
	int updDept(String deptname,Integer id);
}
