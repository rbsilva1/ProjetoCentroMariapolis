package br.upe.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.upe.facades.FachadaEvento;
import br.upe.facades.FachadaUsuario;
import br.upe.models.Usuario;
import br.upe.utils.AbrirFXML;
import br.upe.utils.AbrirPopup;
import br.upe.utils.ImportarCSV;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InscricoesController {
  @FXML
  private Button BotaoImportar;

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
  public void importarCSV(ActionEvent event) throws IOException {
    try {
      List<Usuario> usuarios = ImportarCSV.ImportarCSVUsuario();
      FachadaUsuario fachadaUsuario = new FachadaUsuario();
      for (Usuario usuario : usuarios) {
        fachadaUsuario.criarUsuario(usuario.getCpf(), usuario.getNome(), usuario.getCafe(), usuario.getAlmoco(),
            usuario.getJanta(), usuario.getData());
      }
    } catch (Exception e) {
      e.printStackTrace(); // tirar stack trace e criar popup de erro
      // AbrirPopup.abrirPopup();
    }
  }

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
