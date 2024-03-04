module br.upe {
  requires transitive javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  requires org.hibernate.orm.core;
  requires java.persistence;
  requires org.postgresql.jdbc;
  requires java.sql;
  requires java.naming;
  requires java.transaction;
  requires java.instrument;

  opens br.upe.controllers to javafx.fxml;
  opens br.upe.models to javafx.base, org.hibernate.orm.core;
  opens br.upe.utils to javafx.fxml;
  opens br.upe.repositories to br.upe.test;

  exports br.upe;
}