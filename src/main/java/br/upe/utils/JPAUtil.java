package br.upe.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
  private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
  private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private static final EntityTransaction transaction = entityManager.getTransaction();

  private static class SingletonHelper {
    private static final JPAUtil INSTANCE = new JPAUtil();
  }

  public static JPAUtil getInstance() {
    return SingletonHelper.INSTANCE;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public EntityTransaction getTransaction() {
    return transaction;
  }
}
