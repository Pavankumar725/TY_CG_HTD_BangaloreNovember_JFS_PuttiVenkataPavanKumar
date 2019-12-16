package cap.jpawithhibernateapp.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToOne {
	
	public static void main(String[] args) {
		
		
//		Employee emp=new Employee();
//		emp.setEid(725);
//	   emp.setEname("pavan");
//		emp.setEmail("pavan123@gmail.com");
//        emp.setPassword("pavan123");
//        
//        EmployeeOther other =new EmployeeOther();
//        other.setId(12);
//        other.setPancard("pavan12344");
//        other.setFathername("rambabu");
//        other.setMothername("nagalakshmi");
//        other.setEmployee(emp);
		
		
		
		EntityManager entityManager=null;
		EntityTransaction transaction=null;

		try{
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
		
		 entityManager=entityManagerFactory.createEntityManager();
	  transaction=entityManager.getTransaction();//it is used to do the DML operations
		transaction.begin();
		//entityManager.persist(other);
		Employee emp1=entityManager.find(Employee.class, 12);
		System.out.println(emp1.getOther().getFathername());
		
	
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
