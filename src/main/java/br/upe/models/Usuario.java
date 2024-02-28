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
  private final SimpleStringProperty cpf = new SimpleStringProperty();
  private final SimpleStringProperty nome = new SimpleStringProperty();
  private final SimpleIntegerProperty cafe = new SimpleIntegerProperty();
  private final SimpleIntegerProperty almoco = new SimpleIntegerProperty();
  private final SimpleIntegerProperty janta = new SimpleIntegerProperty();
  private Date data;

  public Usuario() {
    // Construtor vazio necessário para o Hibernate
  }

  public Usuario(String cpf, String nome, int cafe, int almoco, int janta, String data) {
    setCpf(cpf);
    setNome(nome);
    setCafe(cafe);
    setAlmoco(almoco);
    setJanta(janta);
    setData(data);
  }

  public void setNome(String nome) {
    this.nome.set(nome);
  }

  @Column(name = "nome")
  public String getNome() {
    return nome.get();
  }

  public void setCpf(String cpf) {
    this.cpf.set(cpf);
  }

  @Column(name = "cpf")
  @Id
  public String getCpf() {
    return cpf.get();
  }

  public void setCafe(int cafe) {
    this.cafe.set(cafe);
  }

  @Column(name = "cafe")
  public int getCafe() {
    return cafe.get();
  }

  public void setAlmoco(int almoco) {
    this.almoco.set(almoco);
  }

  @Column(name = "almoco")
  public int getAlmoco() {
    return almoco.get();
  }

  public void setJanta(int janta) {
    this.janta.set(janta);
  }

  @Column(name = "janta")
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

  @Column(name = "data")
  public String getData() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(this.data);
  }
}