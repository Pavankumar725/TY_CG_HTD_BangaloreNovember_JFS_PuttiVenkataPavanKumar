package com.cap.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

public class UpdateDemo {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
		String jpql="update Movie set mname='mirchi' where mid=104";
		Query query=entityManager.createQuery(jpql);
		query.executeUpdate();
          entityTransaction.commit();
		entityManager.close();
		
		
		
		
	}

}