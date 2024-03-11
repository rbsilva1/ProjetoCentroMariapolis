package br.upe.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.facades.FachadaEvento;
import br.upe.models.Evento;
import br.upe.utils.AbrirFXML;
import br.upe.utils.AbrirTableView;

public class EventosController implements javafx.fxml.Initializable {
    @FXML
    private TableView<Evento> tabela;

    @FXML
    private TableColumn<Evento, String> nomeColuna;

    @FXML
    private TableColumn<Evento, String> horaChegadaColuna;

    @FXML
    private TableColumn<Evento, String> horaSaidaColuna;

    @FXML
    private Button botaoHistorico1;

    @FXML
    private Button inscricoes;

    @FXML
    private Button paginaEventos;

    @FXML
    private Button paginainicial;

    @FXML
    private Button adicionarEvento;

    @FXML
    public void abrirHistorico(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Historico.fxml");
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Inscricoes.fxml");
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Home.fxml");
    }

    @FXML
    public void criarEvento(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/CriarEvento.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
        horaChegadaColuna.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
        horaSaidaColuna.setCellValueFactory(new PropertyValueFactory<>("dataFim"));

        tabela.setItems(FXCollections.observableArrayList(new FachadaEvento().buscarEventos()));

        AbrirTableView.abrirTableView(tabela, getClass().getResource("/br/upe/resources/FXML/PopupPerfil.fxml"));
    }
}
