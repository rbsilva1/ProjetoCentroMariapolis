package br.upe.repositories;

import java.util.ArrayList;

import br.upe.models.Evento;

public class EventosRepositorio {
    public static EventosRepositorio instance;
    private ArrayList<Evento> eventos = new ArrayList<Evento>();

    static int id = 0;

    public static EventosRepositorio getInstance() {
        if (instance == null) {
            instance = new EventosRepositorio();
        }
        return instance;
    }

    // Criar
    public void CriarEventos(Evento evento) {
        this.eventos.add(evento);
    }

    // Ler
    public ArrayList<Evento> buscarTodos() {
        return this.eventos;
    }

    // Retonar ultimo id
    public static int ultimoID() {
        EventosRepositorio.id += 1;
        return id;
    }

    // Atualizar
    public void AtualizarEvento(Evento eventos) {
        for (int i = 0; i < this.eventos.size(); i++) {
            if (this.eventos.get(i).getId() == eventos.getId()) {
              this.eventos.set(i, eventos);
              break;
            }
          }
    }

    // Deletar
    public void DeletarEvento(Evento evento) {
        this.eventos.remove(evento);
    }

    public Evento buscarPorID(int id) {
        for (int i = 0; i < this.eventos.size(); i++) {
            if (this.eventos.get(i).getId() == id) {
                return this.eventos.get(i);
            }
        }
        return null;
    }
}
