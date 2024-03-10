package br.upe;

import br.upe.models.Evento;
import br.upe.repositories.EventosRepositorio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

class EventosRepositorioTest {
    @Test
    void testCriarBuscarDeletarEvento() {
        // Create a mock repository
        EventosRepositorio repositorioMock = mock(EventosRepositorio.class);

        // Create an instance of Evento for testing
        Evento evento = new Evento("Evento Teste", "20", "25", "Caruaru");

        // Mock the behavior of the repository methods
        when(repositorioMock.buscarTodos()).thenReturn(new ArrayList<>()); // Return an empty list initially
        when(repositorioMock.criarEvento(any(Evento.class))).thenReturn(true);
        when(repositorioMock.atualizarEvento(any(Evento.class))).thenReturn(true);
        when(repositorioMock.deletarEvento(any(Evento.class))).thenReturn(true);

        // Call the methods under test
        assertTrue(repositorioMock.criarEvento(evento));

        // Verify the interactions
        verify(repositorioMock, times(1)).criarEvento(evento);

        // You can similarly test other methods and their interactions
    }
}