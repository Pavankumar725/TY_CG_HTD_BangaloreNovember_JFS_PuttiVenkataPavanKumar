package cap.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cap.jpawithhibernateapp.dto.Movie;

public class GetReference {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Movie record=entityManager.getReference(Movie.class, 101);

		Movie record1=entityManager.getReference(Movie.class, 102);//to retrieve the data from the database for the primary key
		System.out.println(record.getClass());
		System.out.println("id is :"+record.getMid());
		System.out.println("name is :"+record.getMname());
		System.out.println("rating is :"+record.getRating());
		entityManager.close();


	}
}
