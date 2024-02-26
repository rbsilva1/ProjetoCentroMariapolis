package br.upe.models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.*;

@Entity

@Access(AccessType.PROPERTY)

public class Usuario {
  private final SimpleStringProperty nome;
  private final SimpleStringProperty cpf;
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

  @Column(name="nome")
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public void setNome(String nome) {
    this.nome.set(nome);
  }

  public String getNome() {
    return nome.get();
  }

  @Column(name="cpf")
  public void setCpf(String cpf) {
    this.cpf.set(cpf);
  }

  public String getCpf() {
    return cpf.get();
  }

  @Column(name="cafe")
  public void setCafe(int cafe) {
    this.cafe.set(cafe);
  }

  public int getCafe() {
    return cafe.get();
  }

  @Column(name="almoco")
  public void setAlmoco(int almoco) {
    this.almoco.set(almoco);
  }
  
  public int getAlmoco() {
    return almoco.get();
  }

  @Column(name="janta")
  public void setJanta(int janta) {
    this.janta.set(janta);
  }

  public int getJanta() {
    return janta.get();
  }

  @Column(name="data")
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
