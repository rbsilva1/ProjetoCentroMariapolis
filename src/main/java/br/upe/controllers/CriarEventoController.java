package br.upe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import br.upe.facades.fachadaEvento;
import br.upe.utils.AbrirFXML;

public class CriarEventoController {

    @FXML
    private Button criarEvento;

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
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Historico.fxml");
    }

    @FXML
    void abrirInscricoes(ActionEvent event) throws IOException{
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Inscricoes.fxml");
    }

    @FXML
    public void paginaEventos(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Eventos.fxml");
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Home.fxml");
    }

    @FXML
    public void criarEvento(ActionEvent event) throws IOException {
        try{
            String horaC = horaChegada.getText();
            String esta = estados.getText();
            String horaS = horaSaída.getText();
            String nomeE = nomeEvento.getText();

            fachadaEvento fachadaEvento = new fachadaEvento();

            fachadaEvento.criarNovoEvento(nomeE, horaC, horaS, esta);

            AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Eventos.fxml");
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
}