package br.upe.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;

public class Evento {
    private Long id;
    
    private String nome;
    private String dataInicio;
    private String dataFim;
    private String local;
    private String createAt;

    private transient SimpleStringProperty nomeProperty;
    private transient SimpleStringProperty dataInicioProperty;
    private transient SimpleStringProperty dataFimProperty;
    private transient SimpleStringProperty localProperty;
    private transient SimpleStringProperty createAtProperty;

    public Evento() {
        // Construtor vazio necessário para o Hibernate
    }

    public Evento(String nome, String dataInicio, String dataFim, String local) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.createAt = dataAtual();
        this.local = local;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    // Método para obter a data atual formatada
    private String dataAtual() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formato);
    }


    public SimpleStringProperty nomeProperty() {
        if (nomeProperty == null) {
            nomeProperty = new SimpleStringProperty(nome);
        }
        return nomeProperty;
    }

    public SimpleStringProperty dataInicioProperty() {
        if (dataInicioProperty == null) {
            dataInicioProperty = new SimpleStringProperty(dataInicio);
        }
        return nomeProperty;
    }

    public SimpleStringProperty dataFimProperty() {
        if (dataFimProperty == null) {
            dataFimProperty = new SimpleStringProperty(dataFim);
        }
        return nomeProperty;
    }

    public SimpleStringProperty localProperty() {
        if (localProperty == null) {
            localProperty = new SimpleStringProperty(local);
        }
        return nomeProperty;
    }

    public SimpleStringProperty createAtProperty() {
        if (createAtProperty == null) {
            createAtProperty = new SimpleStringProperty(createAt);
        }
        return nomeProperty;
    }


}
