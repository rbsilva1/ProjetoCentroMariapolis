package com.example.projeto;

import javafx.beans.property.*;

public class Historico {
  private final SimpleStringProperty nome;
  private final SimpleStringProperty cpf;
  private final SimpleStringProperty evento;
  private final SimpleIntegerProperty refeicoes;  

  public Historico(String nome, String cpf, int refeicoes, String evento) {
    this.nome = new SimpleStringProperty(nome);
    this.cpf = new SimpleStringProperty(cpf);
    this.evento = new SimpleStringProperty(evento);
    this.refeicoes = new SimpleIntegerProperty(refeicoes);
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

  public String getEvento() {
    return evento.get();
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

  public void setEvento(String eventos) {
    this.evento.set(eventos);
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
    return evento;
  }
}
