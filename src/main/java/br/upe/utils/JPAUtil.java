package br.upe.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
  private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");

  public static EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();
  }
}
