package br.upe.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.models.Usuario;
import br.upe.utils.AbrirFXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InscricoesTableController implements javafx.fxml.Initializable {
  @FXML
  private TableView<Usuario> tabela;
  @FXML
  private TableColumn<Usuario, Integer> idColuna;
  @FXML
  private TableColumn<Usuario, String> nomeColuna;
  @FXML
  private TableColumn<Usuario, String> cpfColuna;
  @FXML
  private TableColumn<Usuario, String> refeicoesColuna;
  @FXML
  private TableColumn<Usuario, String> eventosColuna;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    idColuna.setCellValueFactory(new PropertyValueFactory<>("id"));
    nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
    cpfColuna.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    refeicoesColuna.setCellValueFactory(new PropertyValueFactory<>("refeicoes"));
    eventosColuna.setCellValueFactory(new PropertyValueFactory<>("eventos"));

    tabela.setItems(listaDeInscricoes());

    tabela.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if (newSelection != null) {
        try {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("PopupPerfil.fxml"));
          Parent root = loader.load();
          PerfilController perfilController = loader.getController();

          perfilController.mostrarInformacoesUsuario(newSelection);

          Stage popupStage = new Stage();
          popupStage.setTitle("Perfil");
          popupStage.setScene(new Scene(root));
          popupStage.setResizable(false);
          popupStage.initModality(Modality.APPLICATION_MODAL);
          popupStage.show();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }

  private ObservableList<Usuario> listaDeInscricoes() {
    return FXCollections.observableArrayList(
        new Usuario(1, "Daniel", "12345678910", 1, "Evento 1"),
        new Usuario(2, "Rodrigo", "12345678910", 1, "Evento 1"),
        new Usuario(3, "Kaiky", "12345678910", 1, "Evento 1"),
        new Usuario(4, "Vitorio", "12345678910", 1, "Evento 1"),
        new Usuario(5, "Anderson", "12345678910", 1, "Evento 1"),
        new Usuario(6, "Rodrigo", "12345678910", 1, "Evento 1"));
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

}
