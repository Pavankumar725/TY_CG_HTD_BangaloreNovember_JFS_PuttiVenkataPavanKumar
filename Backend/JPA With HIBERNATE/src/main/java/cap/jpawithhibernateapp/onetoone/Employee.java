package cap.jpawithhibernateapp.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.bytebuddy.build.ToStringPlugin.Exclude;

@Entity
@Table(name="employee_info")
public class Employee {
	
	public EmployeeOther getOther() {
		return other;
	}
	public void setOther(EmployeeOther other) {
		this.other = other;
	}
	@Id
	@Column
	private int eid;
	@Column
	private String ename;
	@Column
	private String email;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	@Exclude
	@OneToOne(cascade=CascadeType.ALL ,mappedBy="employee")
	private EmployeeOther other;
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", password=" + password + ", other="
				+ other + "]";
	}
	
	
	

}
