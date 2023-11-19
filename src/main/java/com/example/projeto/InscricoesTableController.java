package com.example.projeto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class InscricoesTableController implements javafx.fxml.Initializable {
  @FXML
  private TableView<Inscricoes> tabela;
  @FXML
  private TableColumn<Inscricoes, Integer> idColuna;
  @FXML
  private TableColumn<Inscricoes, String> nomeColuna;
  @FXML
  private TableColumn<Inscricoes, String> cpfColuna;
  @FXML
  private TableColumn<Inscricoes, String> refeicoesColuna;
  @FXML
  private TableColumn<Inscricoes, String> eventosColuna;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    idColuna.setCellValueFactory(new PropertyValueFactory<>("id"));
    nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
    cpfColuna.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    refeicoesColuna.setCellValueFactory(new PropertyValueFactory<>("refeicoes"));
    eventosColuna.setCellValueFactory(new PropertyValueFactory<>("eventos"));

    tabela.setItems(listaDeInscricoes());
  }

  private ObservableList<Inscricoes> listaDeInscricoes() {
    return FXCollections.observableArrayList(
        new Inscricoes(1, "Daniel", "12345678910", 1, "Evento 1"),
        new Inscricoes(2, "Rodrigo", "12345678910", 1, "Evento 1"),
        new Inscricoes(3, "Kaiky", "12345678910", 1, "Evento 1"),
        new Inscricoes(4, "Vitorio", "12345678910", 1, "Evento 1"),
        new Inscricoes(5, "Anderson", "12345678910", 1, "Evento 1"),
        new Inscricoes(6, "Rodrigo", "12345678910", 1, "Evento 1"));
  }

  private Scene scene;
  private Stage stage;

  @FXML
  public void abrirInscricoes(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Inscricoes.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void abrirHistorico(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Historico.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void voltarTelaInicial(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
