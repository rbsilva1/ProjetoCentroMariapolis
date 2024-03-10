package br.upe.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.upe.models.Evento;
import br.upe.utils.JPAUtil;

public class EventosRepositorio {

    private static class SingletonHelper {
        private static final EventosRepositorio INSTANCE = new EventosRepositorio();
    }

    public static EventosRepositorio getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Criar
    public Boolean criarEvento(Evento evento) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(evento);
        entityManager.getTransaction().commit();

        return true;
    }

    // Ler todos os eventos
    public List<Evento> buscarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<Evento> query = entityManager.createQuery("SELECT e FROM Evento e",
                Evento.class);
        return query.getResultList();
    }

    // Retornar último ID
    public int ultimoID() {
        EntityManager entityManager = JPAUtil.getEntityManager();

        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(e) FROM Evento e",
                Long.class);
        return Math.toIntExact(query.getSingleResult());
    }

    // Atualizar
    public Boolean atualizarEvento(Evento evento) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(evento);
        entityManager.getTransaction().commit();
        return true;
    }

    // Deletar
    public Boolean deletarEvento(Evento evento) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(evento);
        entityManager.getTransaction().commit();

        return true;
    }

    // Buscar por ID
    public Evento buscarPorID(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Evento evento = entityManager.find(Evento.class, id);

        return evento;
    }
}
