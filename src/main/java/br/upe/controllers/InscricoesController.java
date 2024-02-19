package br.upe.controllers;

import java.io.IOException;

import br.upe.utils.AbrirFXML;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InscricoesController {
  @FXML
  private Button historico;

  @FXML
  private Button inscricoes;

  @FXML
  private Button paginaInicial;

  @FXML
  private Button detalhes;

  @FXML
  private Button botaoAtualizar;

  @FXML
  public void mostrarDetalhes(ActionEvent event) throws IOException {
    AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/InscricoesTable.fxml");
  }

  @FXML
  public void abrirInscricoes(ActionEvent event) throws IOException {
    AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Inscricoes.fxml");
  }

  @FXML
  public void abrirHistorico(ActionEvent event) throws IOException {
    AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Historico.fxml");
  }

  @FXML
  public void voltarTelaInicial(ActionEvent event) throws IOException {
    AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Home.fxml");
  }

  @FXML
  public void paginaEventos(ActionEvent event) throws IOException {
    AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Eventos.fxml");
  }

  @FXML
  void abrirPopupCarregando() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/upe/resources/FXML/PopupDeCarregamento.fxml"));
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
