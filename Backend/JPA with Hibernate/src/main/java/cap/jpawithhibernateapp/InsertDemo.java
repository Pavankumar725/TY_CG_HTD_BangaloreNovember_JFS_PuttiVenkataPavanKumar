package cap.jpawithhibernateapp;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernateapp.dto.Movie;

public class InsertDemo {
	public static void main(String[] args) {

		Movie movie=new Movie();
		movie.setMid(101);
		movie.setMname("mirchi");
		movie.setRating("Good");
		EntityManager entityManager=null;
		EntityTransaction transaction=null;

		try{
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
		
		 entityManager=entityManagerFactory.createEntityManager();
	  transaction=entityManager.getTransaction();//it is used to do the DML operations
		transaction.begin();
		entityManager.persist(movie);//
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
