package cap.jpawithhibernateapp.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import cap.jpawithhibernateapp.onetoone.Employee;

public class TestManyToOne {
	public static void main(String[] args) {
		
		Employee emp=new Employee();
		emp.setEid(12);
		emp.setEname("sathi");
		emp.setEmail("sathi123@");
		emp.setPassword("sathi123");
		
		
		EmployeeExperience employeeExperience=new EmployeeExperience();
		employeeExperience.setEmpid(734);
		employeeExperience.setCompany("infosys");
		employeeExperience.setYear(2019);
		employeeExperience.setEmployee(emp);
		
		EmployeeExperience employeeExperience1=new EmployeeExperience();
		employeeExperience1.setEmpid(735);
		employeeExperience1.setCompany("wipro");
		employeeExperience1.setYear(2018);
		employeeExperience1.setEmployee(emp);
		
		
		
		EntityManager entityManager=null;
		EntityTransaction transaction=null;

		try{
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
		
		 entityManager=entityManagerFactory.createEntityManager();
	  transaction=entityManager.getTransaction();//it is used to do the DML operations
		transaction.begin();
		entityManager.persist(employeeExperience);
		entityManager.persist(employeeExperience1);
		System.out.println("record saved");
		
		transaction.commit();//it will reflect on the database
		}
		catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();

		
		
		
		
		
		
	}

}
