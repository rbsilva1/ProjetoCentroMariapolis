package br.upe.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.models.Usuario;
import br.upe.repositories.UsuarioRepositorio;
import br.upe.utils.AbrirFXML;
import br.upe.utils.AbrirTableView;

public class HistoricoController implements javafx.fxml.Initializable {
    @FXML
    public Button botaoInscricoes;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfColuna.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        cafeColuna.setCellValueFactory(new PropertyValueFactory<>("cafe"));
        almocoColuna.setCellValueFactory(new PropertyValueFactory<>("almoco"));
        jantaColuna.setCellValueFactory(new PropertyValueFactory<>("janta"));

        tabela.setItems((historico()));

        AbrirTableView.abrirTableView(tabela, getClass().getResource("/br/upe/resources/FXML/PopupPerfil.fxml"));
    }

    private ObservableList<Usuario> historico() {
        UsuarioRepositorio.getInstance()
                .criarUsuario(new Usuario("100.868.754-50", "Vitório Fernandes ", 4, 3, 3, "12/09/2002"));

        return FXCollections.observableArrayList(UsuarioRepositorio.getInstance().mostrarUsuarios());
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Inscricoes.fxml");
    }

    @FXML
    public void paginaEventos(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Eventos.fxml");
    }

    @FXML
    public void abrirHistorico(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Historico.fxml");
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Home.fxml");
    }

}
