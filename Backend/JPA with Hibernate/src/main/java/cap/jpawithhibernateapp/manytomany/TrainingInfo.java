package cap.jpawithhibernateapp.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cap.jpawithhibernateapp.onetoone.Employee;

@Entity
@Table(name="TrainingInfo")
public class TrainingInfo {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name="training_employee",
	joinColumns = @JoinColumn(name="tid"),
	inverseJoinColumns = @JoinColumn(name="eid"))
	private List<Employee> elist;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getElist() {
		return elist;
	}
	public void setElist(List<Employee> elist) {
		this.elist = elist;
	}

}
