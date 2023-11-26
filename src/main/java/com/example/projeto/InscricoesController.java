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

  public void funcaoAbrirFXML(ActionEvent event, String fxlm) throws IOException {
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Parent root = FXMLLoader.load(getClass().getResource(fxlm));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void mostrarDetalhes(ActionEvent event) throws IOException {
    funcaoAbrirFXML(event, "InscricoesTable.fxml");
  }

  @FXML
  public void abrirInscricoes(ActionEvent event) throws IOException {
    funcaoAbrirFXML(event, "Inscricoes.fxml");
  }

  @FXML
  public void abrirHistorico(ActionEvent event) throws IOException {
    funcaoAbrirFXML(event, "Historico.fxml");
  }

  @FXML
  public void voltarTelaInicial(ActionEvent event) throws IOException {
    funcaoAbrirFXML(event, "Home.fxml");
  }

  @FXML
  public void paginaEventos(ActionEvent event) throws IOException {
    funcaoAbrirFXML(event, "Eventos.fxml");
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
