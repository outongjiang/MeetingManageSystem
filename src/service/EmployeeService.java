package service;

import java.util.List;
import java.util.Map;

import model.Employee;

public interface EmployeeService {
	//更新密码
	int updatePassword(String password,String username);
	//login,登录的业务方法   登录成功返回1
	
	int login(String usrname,String password);
	
	//register
	int register(Employee e);
	
	//search
	
	//delete
	int delRegisterInfo(Integer empid);
	//查询待审注册信息
	List<Employee>selectRegiterInfo();
	//通过审批，更新status为0
	int agreeRegister(Integer empid);
	//根据用户名称搜索员工
	List<Map<String,Object>> researchEmp(String username, String employeename,Integer pageCode);
	//根据状态搜索员工
	List<Map<String,Object>> researchEmp(String status,Integer pageCode);
	//搜索员工初始化
	List<Map<String,Object>> researchEmp(Integer pageCode);
	//关闭账号，设置status=2
	int updateRegister(Integer employeeid);
	//分页查询员工
	List<Employee> selectEmpInfo(Integer currPage,String status,String employeename,String username);
	//查询总页数
	int selectSumPage(String status,String employeename,String username);
}
