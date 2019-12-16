package com.cap.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cap.jpawithhibernateapp.dto.Movie;

public class JpqlDemo {
	
	public static void main(String[] args) {
		
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		 
		//String jpql="from Movie";
		 String jpql="select mname from Movie";
		 Query query=entityManager.createQuery(jpql);
		 List<String> record=query.getResultList();
		
		 for (String movie : record) {
			// System.out.println("Movie id:"+movie.getMid());
			 //System.out.println("Movie Name :"+movie.getMname());
			 //System.out.println("Movie Rating"+movie.getRating());
			System.out.println(movie);
		}
		 entityManager.close();
		 
		 
	}

}
