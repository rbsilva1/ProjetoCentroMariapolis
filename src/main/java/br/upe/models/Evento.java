package br.upe.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Evento {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty dataInicio;
    private final SimpleStringProperty dataFim;
    private final SimpleStringProperty createAt;

    public Evento(Integer id, String nome, String dataInicio, String dataFim, String createAt) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.dataInicio = new SimpleStringProperty();
        this.dataFim = new SimpleStringProperty();
        this.createAt = new SimpleStringProperty();
    }

    public SimpleIntegerProperty getId() {
        return id;
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public SimpleStringProperty getDataInicio() {
        return dataInicio;
    }

    public SimpleStringProperty getDataFim() {
        return dataFim;
    }

    public SimpleStringProperty getCreateAt() {
        return createAt;
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

    public void setCreateAt(String createAt) {
        this.createAt.set(createAt);
    }
    
}
