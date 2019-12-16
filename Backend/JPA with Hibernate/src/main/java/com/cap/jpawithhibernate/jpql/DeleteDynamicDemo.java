package com.cap.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDynamicDemo {
public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
    entityTransaction.begin();
    String jpql="delete from Movie where mname=:nm";
    Query query=entityManager.createQuery(jpql);
    query.setParameter("nm", "ABCD");
	int result=query.executeUpdate();
	System.out.println(result);
	entityTransaction.commit();
	entityManager.close();
}
}


