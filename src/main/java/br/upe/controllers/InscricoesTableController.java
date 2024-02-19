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
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InscricoesTableController implements javafx.fxml.Initializable {
  @FXML
  private TableView<Usuario> tabela;
  @FXML
  private TableColumn<Usuario, String> nomeColuna;
  @FXML
  private TableColumn<Usuario, String> cpfColuna;
  @FXML
  private TableColumn<Usuario, String> cafeColuna;
  @FXML
  private TableColumn<Usuario, String> almocoColuna;
  @FXML
  private TableColumn<Usuario, String> jantaColuna;
  @FXML
  private TableColumn<Usuario, Data> dataColuna;


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    nomeColuna.setCellValueFactory(new PropertyValueFactory<>("Nome"));
    cpfColuna.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    cafeColuna.setCellValueFactory(new PropertyValueFactory<>("Cafe"));
    almocoColuna.setCellValueFactory(new PropertyValueFactory<>("Almoco"));
    jantaColuna.setCellValueFactory(new PropertyValueFactory<>("Janta"));
    dataColuna.setCellValueFactory(new PropertyValueFactory<>("Data"));

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
       new Usuario("100.868.754-50", "Vitório Fernandes de Amorim", 3, 3,3,"12/09/2002"),
       new Usuario("08973660420", "Vitório Fernandes de Amorim", 3, 3,3,"12/09/2002")
       );
       
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
