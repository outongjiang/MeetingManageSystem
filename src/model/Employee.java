package model;

public class Employee {
	@Override
	public String toString() {
		return "Employee{" +
				"employeeid=" + employeeid +
				", employeename='" + employeename + '\'' +
				", username='" + username + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", status='" + status + '\'' +
				", department=" + department +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				'}';
	}

	public Employee() {}
	
	public Employee(Integer employeeid, String employeename, String username, String phone, String email, String status,
			Integer department, String password, String role) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.department = department;
		this.password = password;
		this.role = role;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String statu) {
		this.status = statu;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private Integer employeeid;
	private  String employeename;
	private String username;
	private String phone;
	private String email;
	private String status;
	private Integer department;
	private String password;
	private String role;
	
}
