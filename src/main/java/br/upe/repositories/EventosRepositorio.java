package br.upe.repositories;

import java.util.List;
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
        JPAUtil.getInstance().getTransaction().begin();
        JPAUtil.getInstance().getEntityManager().persist(evento);
        JPAUtil.getInstance().getTransaction().commit();

        return true;
    }

    // Ler todos os eventos
    public List<Evento> buscarTodos() {
        TypedQuery<Evento> query = JPAUtil.getInstance().getEntityManager().createQuery("SELECT e FROM Evento e",
                Evento.class);
        return query.getResultList();
    }

    // Retornar último ID
    public int ultimoID() {
        TypedQuery<Long> query = JPAUtil.getInstance().getEntityManager().createQuery("SELECT COUNT(e) FROM Evento e",
                Long.class);
        return Math.toIntExact(query.getSingleResult());
    }

    // Atualizar
    public Boolean atualizarEvento(Evento evento) {
        JPAUtil.getInstance().getTransaction().begin();
        JPAUtil.getInstance().getEntityManager().merge(evento);
        JPAUtil.getInstance().getTransaction().commit();

        return true;
    }

    // Deletar
    public Boolean deletarEvento(Evento evento) {
        JPAUtil.getInstance().getTransaction().begin();
        JPAUtil.getInstance().getEntityManager().remove(evento);
        JPAUtil.getInstance().getTransaction().commit();

        return true;
    }

    // Buscar por ID
    public Evento buscarPorID(int id) {
        return JPAUtil.getInstance().getEntityManager().find(Evento.class, id);
    }
}
