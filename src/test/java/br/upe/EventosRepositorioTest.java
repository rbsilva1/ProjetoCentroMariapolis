package br.upe;

import br.upe.models.Evento;
import br.upe.repositories.EventosRepositorio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class EventosRepositorioTest {

    @Test
    void testCriarBuscarDeletarEvento() {
        EventosRepositorio repositorio = EventosRepositorio.getInstance();

        // Criar evento
        Evento evento = new Evento("Evento Teste", "20", "25", "Caruaru");
        repositorio.criarEventos(evento);

        // Buscar evento
        List<Evento> eventos = repositorio.buscarTodos();
        assertTrue(eventos.contains(evento));

        // Buscar evento por ID
        // Evento eventoEncontrado = repositorio.buscarPorID(evento.getId());
        // assertEquals(evento, eventoEncontrado);

        // Atualizar evento
        evento.setNome("Evento Atualizado");
        repositorio.atualizarEvento(evento);

        // Verificar se o evento foi atualizado
        eventos = repositorio.buscarTodos();
        assertTrue(eventos.contains(evento));

        // Deletar evento
        repositorio.deletarEvento(evento);

        // Verificar se o evento foi removido
        eventos = repositorio.buscarTodos();
        assertFalse(eventos.contains(evento));
    }
}
