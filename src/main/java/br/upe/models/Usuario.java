package br.upe.models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usuario {
  private final SimpleStringProperty nome;
  private final SimpleStringProperty cpf;
  private final SimpleIntegerProperty cafe;
  private final SimpleIntegerProperty almoco;
  private final SimpleIntegerProperty janta;
  private Date data;

  public Usuario(String cpf, String nome, int cafe, int almoco, int janta, String data) {
    this.nome = new SimpleStringProperty(nome);
    this.cpf = new SimpleStringProperty(cpf);
    this.cafe = new SimpleIntegerProperty(cafe);
    this.almoco = new SimpleIntegerProperty(almoco);
    this.janta = new SimpleIntegerProperty(janta);
    setData(data);
  }

  public void setData(String data) {
    try {
      this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
    } catch (ParseException e) {
      // System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
    }
  }

  // Setters
  public void setNome(String nome) {
    this.nome.set(nome);
  }

  public void setCpf(String cpf) {
    this.cpf.set(cpf);
  }

  public void setCafe(int cafe) {
    this.cafe.set(cafe);
  }

  public void setAlmoco(int almoco) {
    this.almoco.set(almoco);
  }

  public void setJanta(int janta) {
    this.janta.set(janta);
  }

  // Getters
  public String getNome() {
    return nome.get();
  }

  public String getCpf() {
    return cpf.get();
  }

  public int getCafe() {
    return cafe.get();
  }

  public int getAlmoco() {
    return almoco.get();
  }

  public int getJanta() {
    return janta.get();
  }

  public String getData() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(this.data);
  }

}
