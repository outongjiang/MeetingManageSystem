package service;

import java.util.List;

import model.Department;

public interface DepartmentService {
	//��ѯ������Ϣ
	List<Department> selectDept();
	//��Ӳ���
	int appDept(String deptname);
	//ɾ������
	int delDept(String deptname);
	//���²���
	int updDept(String deptname,Integer id);
}
