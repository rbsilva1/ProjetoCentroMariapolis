package br.upe.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

@Entity
@Access(AccessType.PROPERTY)
public class Evento {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty nome = new SimpleStringProperty();
    private final SimpleStringProperty dataInicio = new SimpleStringProperty();
    private final SimpleStringProperty dataFim = new SimpleStringProperty();
    private final SimpleStringProperty local = new SimpleStringProperty();
    private final SimpleStringProperty createAt = new SimpleStringProperty();

    public Evento() {
        // Construtor vazio necessário para o Hibernate
    }

    public Evento(String nome, String dataInicio, String dataFim, String local) {
        setNome(nome);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setLocal(local);
        setCreateAt(dataAtual());
    }

    // Getters e setters
    public void setId(Integer id) {
        this.id.set(id);
    }

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id.get();
    }

    @Column(name = "nome")
    public String getNome() {
        return this.nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    @Column(name = "dataInicio")
    public String getDataInicio() {
        return this.dataInicio.get();
    }

    @Column(name = "dataFim")
    public String getDataFim() {
        return this.dataFim.get();
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio.set(dataInicio);
    }

    public void setDataFim(String dataFim) {
        this.dataFim.set(dataFim);
    }

    @Column(name = "local")
    public String getLocal() {
        return this.local.get();
    }

    @Column(name = "createAt")
    public String getCreateAt() {
        return this.createAt.get();
    }

    public void setCreateAt(String createAt) {
        this.createAt.set(createAt);
    }

    public void setLocal(String local) {
        this.local.set(local);
    }

    // Método para obter a data atual formatada
    public String dataAtual() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formato);
    }

}