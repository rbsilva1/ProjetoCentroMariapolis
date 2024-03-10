package br.upe.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import br.upe.facades.FachadaUsuario;
import br.upe.models.Usuario;
import br.upe.utils.AbrirFXML;
import br.upe.utils.AbrirTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    AbrirTableView.abrirTableView(tabela, getClass().getResource("/br/upe/resources/FXML/PopupPerfil.fxml"));
  }

  private ObservableList<Usuario> listaDeInscricoes() {
    FachadaUsuario fachadaUsuario = new FachadaUsuario();
    List<Usuario> usuarios = fachadaUsuario.mostrarUsuarios();
    return FXCollections.observableArrayList(usuarios);
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
