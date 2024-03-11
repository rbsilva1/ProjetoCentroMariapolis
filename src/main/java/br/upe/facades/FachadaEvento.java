package br.upe.facades;

import java.util.List;

import br.upe.models.Evento;
import br.upe.repositories.EventosRepositorio;

public class FachadaEvento {
    private EventosRepositorio eventosRepositorio = EventosRepositorio.getInstance();

    public void criarNovoEvento(String nomeEvento1, String dataChegada, String dataSaida) {
        Evento evento = new Evento(nomeEvento1, dataChegada, dataSaida);

        eventosRepositorio.criarEvento(evento);
    }

    public List<Evento> buscarEventos() {
        return eventosRepositorio.buscarTodos();
    }
}
