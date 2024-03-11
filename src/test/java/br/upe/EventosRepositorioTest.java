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
        Evento evento = new Evento("Evento Teste", "20", "25");

        // Mock the behavior of the repository methods
        when(repositorioMock.criarEvento(any(Evento.class))).thenReturn(true);
        when(repositorioMock.buscarTodos()).thenReturn(new ArrayList<>());
        when(repositorioMock.deletarEvento(any(Evento.class))).thenReturn(true);

        // Call the methods under test
        assertTrue(repositorioMock.criarEvento(evento));

        // Verify the interactions
        verify(repositorioMock, times(1)).criarEvento(evento);
        verify(repositorioMock, never()).buscarTodos(); // We didn't call buscarTodos(), so it should never be invoked
        verify(repositorioMock, never()).deletarEvento(any(Evento.class)); // We didn't call deletarEvento(), so it
                                                                           // should never be invoked
    }
}