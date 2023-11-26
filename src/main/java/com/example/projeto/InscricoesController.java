package com.example.projeto;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.PauseTransition;

public class InscricoesController {
  @FXML
  private Button historico;

  @FXML
  private Button inscricoes;

  @FXML
  private Button paginainicial;

  @FXML
  private Button detalhes;

  @FXML
  private Button ButaoAtualizar;

  private Scene scene;
  private Stage stage;

  @FXML
  public void mostrarDetalhes(ActionEvent event) throws IOException {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Parent root = FXMLLoader.load(getClass().getResource("InscricoesTable.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void abrirInscricoes(ActionEvent event) throws IOException {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Parent root = FXMLLoader.load(getClass().getResource("Inscricoes.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void abrirHistorico(ActionEvent event) throws IOException {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Parent root = FXMLLoader.load(getClass().getResource("Historico.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void voltarTelaInicial(ActionEvent event) throws IOException {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void paginaEventos(ActionEvent event) throws IOException {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Parent root = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }

  @FXML 
  void abrirPopupCarregando() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("PopupDeCarregamento.fxml"));
    Parent root = loader.load();
    Stage popupStage = new Stage();
    popupStage.initModality(Modality.APPLICATION_MODAL);
    popupStage.setTitle("Carregando !");
    popupStage.setScene(new Scene(root));
    popupStage.setResizable(false);
    popupStage.show();
    PauseTransition delay = new PauseTransition(Duration.seconds(3));
    delay.setOnFinished(event -> popupStage.close());

    delay.play();
  }

}
