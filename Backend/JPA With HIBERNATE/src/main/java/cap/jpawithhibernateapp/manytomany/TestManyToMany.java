package cap.jpawithhibernateapp.manytomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import cap.jpawithhibernateapp.onetoone.Employee;

public class TestManyToMany {
	public static void main(String[] args) {
		
		Employee emp=new Employee();
		emp.setEid(20);
		emp.setEname("Nikhil");
		emp.setEmail("nikhil@gmail.com");
		emp.setPassword("nikhil123");
		
		Employee emp1=new Employee();
		emp1.setEid(201);
		emp1.setEname("sunil");
		emp1.setEmail("sunil@gmail.com");
		emp1.setPassword("sunil123");
		
		
	ArrayList<Employee> e=new ArrayList<Employee>();
	e.add(emp);
	e.add(emp1);
	
	TrainingInfo t=new TrainingInfo();
	t.setId(30);
	t.setName("java");
	t.setElist(e);
	
	
	EntityManager entityManager=null;
	EntityTransaction transaction=null;

	try{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
	
	 entityManager=entityManagerFactory.createEntityManager();
  transaction=entityManager.getTransaction();//it is used to do the DML operations
	transaction.begin();
	entityManager.persist(t);//
	System.out.println("record saved");
	
	transaction.commit();//it will reflect on the database
	}
	catch(Exception e1) {
		e1.printStackTrace();
		transaction.rollback();
	}
	entityManager.close();

	
	
	
		
		
	}

}
