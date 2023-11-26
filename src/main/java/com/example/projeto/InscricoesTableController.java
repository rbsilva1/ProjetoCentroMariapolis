package com.example.projeto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Screen;
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
  
  private Scene scene;
  private Stage stage;

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
    Parent root = FXMLLoader.load(getClass().getResource("Historico.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void voltarTelaInicial(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
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

}
