package br.upe.facades;

import java.util.List;

import br.upe.models.Evento;
import br.upe.repositories.EventosRepositorio;

public class FachadaEvento {
    private EventosRepositorio eventosRepositorio = EventosRepositorio.getInstance();

    public void criarNovoEvento(String nomeE, String horaC, String horaS, String esta) {
        int id = EventosRepositorio.ultimoID();

        Evento evento = new Evento(id, nomeE, horaC, horaS, esta);

        eventosRepositorio.criarEventos(evento);
    }

    public List<Evento> buscarEventos() {
        return eventosRepositorio.buscarTodos();
    }
}
