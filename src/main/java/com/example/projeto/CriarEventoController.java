package com.example.projeto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CriarEventoController {

    @FXML
    private Button CriarEvento;

    @FXML
    private Button botaoHistorico1;

    @FXML
    private TextField estados;

    @FXML
    private TextField horaChegada;

    @FXML
    private TextField horaSaída;

    @FXML
    private Button inscricoes;

    @FXML
    private TextField nomeEvento;

    @FXML
    private Button paginaEventos;

    @FXML
    private Button paginainicial;

    @FXML
    void abrirHistorico(ActionEvent event) throws IOException{
        AbrirFXML.abrirFXML(event, "Historico.fxml");
    }

    @FXML
    void abrirInscricoes(ActionEvent event) throws IOException{
        AbrirFXML.abrirFXML(event, "Incricoes.fxml");
    }

    @FXML
    public void paginaEventos(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Eventos.fxml");
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Home.fxml");
    }

}
