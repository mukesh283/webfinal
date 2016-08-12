package org.cap.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Cap_FLP_Employee")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	@NotEmpty(message="* Please Enter FirstName.")
	private String firstName;
	private String lastName;
	private double salary;
	private Date empDob;
	private Date empDoj;
	private String department;
	
	public Employee(){}
	
	public Employee(int empId, String firstName, String lastName, double salary, Date empDob, Date empDoj) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.empDob = empDob;
		this.empDoj = empDoj;
	}
	
	
	public Employee(int empId, String firstName, String lastName, double salary, Date empDob, Date empDoj,
			String department) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.empDob = empDob;
		this.empDoj = empDoj;
		this.department = department;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public Date getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}
	
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", empDob=" + empDob + ", empDoj=" + empDoj + ", department=" + department + "]";
	}

	

}
