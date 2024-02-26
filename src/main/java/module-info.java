module br.upe {
  requires transitive javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  requires java.sql;

  // Adicione as dependências necessárias para o Hibernate e persistência em banco de dados
  requires java.persistence;
  requires org.hibernate.orm.core;
  

  opens br.upe.controllers to javafx.fxml;
  opens br.upe.models to javafx.base;
  opens br.upe.utils to javafx.fxml;

  exports br.upe;
}