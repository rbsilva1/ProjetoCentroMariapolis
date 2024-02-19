package br.upe.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.models.Usuario;
import br.upe.repositories.UsuarioRepositorio;
import br.upe.utils.AbrirFXML;

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

        tabela.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/br/upe/resources/FXML/PopupPerfil.fxml"));
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

    private ObservableList<Usuario> historico() {
        // Corrigir o jeito de adicionar no histórico e nas inscrições
        UsuarioRepositorio.getInstance()
                .criarUsuario(new Usuario("100.868.754-50", "Vitório Fernandes de Amorim", 3, 3, 3, "12/09/2002"));
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
