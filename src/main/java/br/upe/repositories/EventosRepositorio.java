package br.upe.repositories;

import java.util.ArrayList;
import java.util.List;

import br.upe.models.Evento;

public class EventosRepositorio {
    private ArrayList<Evento> eventos = new ArrayList<>();

    static int id = 0;

    // Criar
    public void criarEventos(Evento evento) {
        this.eventos.add(evento);
    }

    // Ler
    public List<Evento> buscarTodos() {
        return this.eventos;
    }

    // Retonar ultimo id
    public static int ultimoID() {
        EventosRepositorio.id += 1;
        return id;
    }

    // Atualizar
    public void atualizarEvento(Evento eventos) {
        for (int i = 0; i < this.eventos.size(); i++) {
            if (this.eventos.get(i).getId() == eventos.getId()) {
              this.eventos.set(i, eventos);
              break;
            }
          }
    }

    // Deletar
    public void deletarEvento(Evento evento) {
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
