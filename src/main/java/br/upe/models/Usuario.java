package br.upe.models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.*;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final SimpleStringProperty cpf;

  private final SimpleStringProperty nome;
  private final SimpleIntegerProperty cafe;
  private final SimpleIntegerProperty almoco;
  private final SimpleIntegerProperty janta;
  private Date data;

  public Usuario(String cpf, String nome, int cafe, int almoco, int janta, String data) {
    this.nome = new SimpleStringProperty(cpf);
    this.cpf = new SimpleStringProperty(nome);
    this.cafe = new SimpleIntegerProperty(cafe);
    this.almoco = new SimpleIntegerProperty(almoco);
    this.janta = new SimpleIntegerProperty(janta);
    setData(data);
  }

  public void setNome(String nome) {
    this.nome.set(nome);
  }

  public String getNome() {
    return nome.get();
  }

  public void setCpf(String cpf) {
    this.cpf.set(cpf);
  }

  public String getCpf() {
    return cpf.get();
  }

  public void setCafe(int cafe) {
    this.cafe.set(cafe);
  }

  public int getCafe() {
    return cafe.get();
  }


  public void setAlmoco(int almoco) {
    this.almoco.set(almoco);
  }
  
  public int getAlmoco() {
    return almoco.get();
  }


  public void setJanta(int janta) {
    this.janta.set(janta);
  }

  public int getJanta() {
    return janta.get();
  }

  public void setData(String data) {
    try {
      this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
    } catch (ParseException e) {
      // Falta implementar
    }
  }

  public String getData() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(this.data);
  }

}