package model;

public class Department {
	public Department(Integer departmentid, String departmentname) {
		this.departmentid = departmentid;
		this.departmentname = departmentname;
	}

	private Integer departmentid;
	private String  departmentname;

	public Department() {
	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	@Override
	public String toString() {
		return "Department{" +
				"departmentid=" + departmentid +
				", departmentname='" + departmentname + '\'' +
				'}';
	}
}
