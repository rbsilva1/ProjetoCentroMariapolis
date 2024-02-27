package br.upe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.upe.models.Evento;

class EventoTest {

    @Test
    void testGettersAndSetters() {
        Evento evento = new Evento(1, "Evento Teste", "01/01/2024 10:00:00", "02/01/2024 12:00:00", "Local Teste");

        assertEquals(1, evento.getId());
        assertEquals("Evento Teste", evento.getNome());
        assertEquals("01/01/2024 10:00:00", evento.getDataInicio());
        assertEquals("02/01/2024 12:00:00", evento.getDataFim());
        assertEquals("Local Teste", evento.getLocal());

        // Test setters
        evento.setId(2);
        evento.setNome("Novo Evento");
        evento.setDataInicio("03/01/2024 08:00:00");
        evento.setDataFim("04/01/2024 14:00:00");
        evento.setLocal("Novo Local");

        assertEquals(2, evento.getId());
        assertEquals("Novo Evento", evento.getNome());
        assertEquals("03/01/2024 08:00:00", evento.getDataInicio());
        assertEquals("04/01/2024 14:00:00", evento.getDataFim());
        assertEquals("Novo Local", evento.getLocal());
    }
}
