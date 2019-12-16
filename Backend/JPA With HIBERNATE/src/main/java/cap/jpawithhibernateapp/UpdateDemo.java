package cap.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernateapp.dto.Movie;

public class UpdateDemo {
	public static void main(String[] args) {
		
	
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
	try {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
	 entityManager=entityManagerFactory.createEntityManager();
	 transaction=entityManager.getTransaction();
	     transaction.begin();
	    Movie record=entityManager.find(Movie.class, 101);
	     record.setMname("dil To Pagal hai");
	     System.out.println("record update");
	     
	    transaction.commit();
	}
	catch(Exception e) {
		e.printStackTrace();
		transaction.rollback();
	}
	entityManager.close();

	
	
}
}