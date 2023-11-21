package com.example.projeto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoricoController implements javafx.fxml.Initializable {

    public Button botaoInscrições;
    @FXML
    private Button botaoHistorico1;

    @FXML
    private Button botaoPaginaEventos;

    @FXML
    private Button botaoPaginaInicial;

    @FXML
    private TextField campoCPF1;

    @FXML
    private TextField campoEvento1;

    @FXML
    private Text campoFiltro;

    @FXML
    private TextField campoNome1;

    @FXML
    private TextField campoRefeicoes1;

    @FXML
    private ScrollBar scrollBar;
    private Scene scene;
    private Stage stage;

    @FXML
    private TableView<Historico> tabela;
    @FXML
    private TableColumn<Historico, String> nomeColuna;
    @FXML
    private TableColumn<Historico, String> cpfColuna;
    @FXML
    private TableColumn<Historico, String> refeicoesColuna;
    @FXML
    private TableColumn<Historico, String> eventoColuna;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfColuna.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        eventoColuna.setCellValueFactory(new PropertyValueFactory<>("evento"));
        refeicoesColuna.setCellValueFactory(new PropertyValueFactory<>("refeicoes"));

        tabela.setItems(historico());
    }

    private ObservableList<Historico> historico() {
        return FXCollections.observableArrayList(
                new Historico("Daniel", "12345678910", 1, "Evento 1"),
                new Historico("Rodrigo", "12345678910", 1, "Evento 1"),
                new Historico("Kaiky", "12345678910", 1, "Evento 1"),
                new Historico("Vitorio", "12345678910", 1, "Evento 1"),
                new Historico("Anderson", "12345678910", 1, "Evento 1"),
                new Historico("Rodrigo", "12345678910", 1, "Evento 1"));
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Inscricoes.fxml"));
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
}
