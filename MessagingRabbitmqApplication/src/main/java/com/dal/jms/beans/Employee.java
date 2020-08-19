package com.dal.jms.beans;

public class Employee {
	
	private String empId;
	private String empName;

	public Employee(String empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	public String getEmpName() {		
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + "]";
	}
	
}
