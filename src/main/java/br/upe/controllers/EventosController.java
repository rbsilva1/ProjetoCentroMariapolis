package br.upe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import br.upe.utils.AbrirFXML;

public class EventosController {

    @FXML
    private Button botaoHistorico1;

    @FXML
    private Button inscricoes;

    @FXML
    private Button paginaEventos;

    @FXML
    private Button paginainicial;

    @FXML
    private Button criarEvento;

    @FXML
    public void abrirHistorico(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Historico.fxml");
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Inscricoes.fxml");
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Home.fxml");
    }

    @FXML
    public void criarEvento(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "CriarEvento.fxml");
    }

}
