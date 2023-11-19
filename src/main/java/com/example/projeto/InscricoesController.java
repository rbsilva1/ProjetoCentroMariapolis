package com.example.projeto;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InscricoesController {
  @FXML
  private Button historico;

  @FXML
  private Button inscricoes;

  @FXML
  private Button paginainicial;

  @FXML
  private Button detalhesCafe;

  @FXML
  private Button detalhesAlmoco;

  @FXML
  private Button detalhesJanta;

  private Scene scene;
  private Stage stage;

  @FXML
  public void mostrarDetalhes(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("InscricoesTable.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void abrirInscricoes(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Inscricoes.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void abrirHistorico(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Historico.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void voltarTelaInicial(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
