package com.example.projeto;

import javafx.beans.property.*;

public class Inscricoes {
  private final SimpleIntegerProperty id;  
  private final SimpleStringProperty nome;
  private final SimpleStringProperty cpf;
  private final SimpleIntegerProperty refeicoes;  
  private final SimpleStringProperty eventos;

  public Inscricoes(Integer id, String nome, String cpf, int refeicoes, String eventos) {
    this.id = new SimpleIntegerProperty(id);
    this.nome = new SimpleStringProperty(nome);
    this.cpf = new SimpleStringProperty(cpf);
    this.refeicoes = new SimpleIntegerProperty(refeicoes);
    this.eventos = new SimpleStringProperty(eventos);
  }

  public int getId() {
    return id.get();
  }

  public String getNome() {
    return nome.get();
  }

  public String getCpf() {
    return cpf.get();
  }

  public int getRefeicoes() {
    return refeicoes.get();
  }

  public String getEventos() {
    return eventos.get();
  }

  public void setId(int id) {
    this.id.set(id);
  }

  public void setNome(String nome) {
    this.nome.set(nome);
  }

  public void setCpf(String cpf) {
    this.cpf.set(cpf);
  }

  public void setRefeicoes(int refeicoes) {
    this.refeicoes.set(refeicoes);
  }

  public void setEventos(String eventos) {
    this.eventos.set(eventos);
  }

  public SimpleIntegerProperty idProperty() {
    return id;
  }

  public SimpleStringProperty nomeProperty() {
    return nome;
  }

  public SimpleStringProperty cpfProperty() {
    return cpf;
  }

  public SimpleIntegerProperty refeicoesProperty() {
    return refeicoes;
  }

  public SimpleStringProperty eventosProperty() {
    return eventos;
  }
}
