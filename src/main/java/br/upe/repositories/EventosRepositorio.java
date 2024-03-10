package br.upe.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.upe.models.Evento;

public class EventosRepositorio {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static final EntityTransaction transaction = entityManager.getTransaction();

    private static class SingletonHelper {
        private static final EventosRepositorio INSTANCE = new EventosRepositorio();
    }

    public static EventosRepositorio getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Criar
    public Boolean criarEvento(Evento evento) {
        transaction.begin();
        entityManager.persist(evento);
        transaction.commit();

        return true;
    }

    // Ler todos os eventos
    public List<Evento> buscarTodos() {
        TypedQuery<Evento> query = entityManager.createQuery("SELECT e FROM Evento e", Evento.class);
        return query.getResultList();
    }

    // Retornar último ID
    public int ultimoID() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(e) FROM Evento e", Long.class);
        return Math.toIntExact(query.getSingleResult());
    }

    // Atualizar
    public Boolean atualizarEvento(Evento evento) {
        transaction.begin();
        entityManager.merge(evento);
        transaction.commit();

        return true;
    }

    // Deletar
    public Boolean deletarEvento(Evento evento) {
        transaction.begin();
        entityManager.remove(evento);
        transaction.commit();

        return true;
    }

    // Buscar por ID
    public Evento buscarPorID(int id) {
        return entityManager.find(Evento.class, id);
    }
}
