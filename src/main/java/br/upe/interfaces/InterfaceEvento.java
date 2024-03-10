package br.upe.interfaces;

import java.util.List;

import br.upe.models.Evento;
import br.upe.repositories.EventosRepositorio;

public interface InterfaceEvento {

    public EventosRepositorio getInstance();

    public Boolean criarEvento(Evento evento);

    public List<Evento> buscarTodos();

    public int ultimoID();

    public Boolean atualizarEvento(Evento evento);

    public Boolean deletarEvento(Evento evento);

    public Evento buscarPorID(int id);
} 
