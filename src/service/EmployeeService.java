package service;

import java.util.List;
import java.util.Map;

import model.Employee;

public interface EmployeeService {
	//��������
	int updatePassword(String password,String username);
	//login,��¼��ҵ�񷽷�   ��¼�ɹ�����1
	
	int login(String usrname,String password);
	
	//register
	int register(Employee e);
	
	//search
	
	//delete
	int delRegisterInfo(Integer empid);
	//��ѯ����ע����Ϣ
	List<Employee>selectRegiterInfo();
	//ͨ������������statusΪ0
	int agreeRegister(Integer empid);
	//�����û���������Ա��
	List<Map<String,Object>> researchEmp(String username, String employeename,Integer pageCode);
	//����״̬����Ա��
	List<Map<String,Object>> researchEmp(String status,Integer pageCode);
	//����Ա����ʼ��
	List<Map<String,Object>> researchEmp(Integer pageCode);
	//�ر��˺ţ�����status=2
	int updateRegister(Integer employeeid);
	//��ҳ��ѯԱ��
	List<Employee> selectEmpInfo(Integer currPage,String status,String employeename,String username);
	//��ѯ��ҳ��
	int selectSumPage(String status,String employeename,String username);
}
