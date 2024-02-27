package br.upe.models;
import javax.persistence.Entity;

import javax.persistence.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;



@Entity
public class Evento {
    private long id;
    private String nome;
    private String dataInicio;
    private String dataFim;
    private String local;
    private String createAt;

    private  SimpleStringProperty nomeProperty;
    private  SimpleStringProperty dataInicioProperty;
    private  SimpleStringProperty dataFimProperty;
    private  SimpleStringProperty localProperty;
    private  SimpleStringProperty createAtProperty;

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
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
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


    public String getDataFim() {
        return dataFim;
    }

    public String getLocal() {
        return local;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    // Método para obter a data atual formatada
    public String dataAtual() {
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
