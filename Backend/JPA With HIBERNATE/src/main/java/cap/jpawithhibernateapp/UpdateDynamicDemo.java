package cap.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateDynamicDemo {
	public static void main(String[] args) {
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	    entityTransaction.begin();
		String jpql="update Movie set mname=:nm where mid=:id";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("id", 103);
		query.setParameter("nm", "ABCD");
		int result=query.executeUpdate();
		System.out.println(result);
		entityTransaction.commit();
		entityManager.close();
	}

}
