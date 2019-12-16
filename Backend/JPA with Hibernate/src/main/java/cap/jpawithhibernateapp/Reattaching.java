package cap.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernateapp.dto.Movie;

public class Reattaching {
	public static void main(String[] args) {

		EntityManager entityManager=null;
		EntityTransaction transaction=null;

		try{
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");

			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();//it is used to do the DML operations
			transaction.begin();
			Movie record=entityManager.find(Movie.class, 103);
			System.out.println(entityManager.contains(record));
			entityManager.detach(record);//it is use seperate the data from the table
			System.out.println(entityManager.contains(record));
			Movie reattachMovie=entityManager.merge(record);//after detaching we want to get that means we want to merge
			
		reattachMovie.setMname("Darling");
			System.out.println("record update");

			transaction.commit();//it will reflect on the database
		}
		catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
	}




}


