package cap.jpawithhibernateapp.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cap.jpawithhibernateapp.onetoone.Employee;

@Entity
@Table(name="EmployeeExperience")
public class EmployeeExperience {
	@Id
	@Column
	private int empid;
	@Column
	private String company;
	@Column
	private int year;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="eid")
	
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
