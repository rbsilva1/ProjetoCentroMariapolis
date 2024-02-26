package br.upe.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.*;


@Table(name = "Evento")// Criando a tabela com o nome de Eventos
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty dataInicio;
    private final SimpleStringProperty dataFim;
    private final SimpleStringProperty local;
    private final String createAt;

    public Evento(Integer id, String nome, String dataInicio, String dataFim, String local) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.dataInicio = new SimpleStringProperty(dataInicio);
        this.dataFim = new SimpleStringProperty(dataFim);
        this.createAt = dataAtual();
        this.local = new SimpleStringProperty(local);
    }

    public int getId() {
        return id.get();
    }

    public String getNome() {
        return nome.get();
    }

    public String getDataInicio() {
        return dataInicio.get();
    }

    public String getDataFim() {
        return dataFim.get();
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getLocal() {
        return local.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio.set(dataInicio);
    }

    public void setDataFim(String dataFim) {
        this.dataFim.set(dataFim);
    }

    public void setLocal(String local) {
        this.local.set(local);
    }

    public String dataAtual() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formato);
    }
}
