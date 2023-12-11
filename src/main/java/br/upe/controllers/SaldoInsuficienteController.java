package br.upe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import br.upe.utils.AbrirFXML;
import br.upe.utils.AbrirPopup;

public class SaldoInsuficienteController {

    @FXML
    private Button metodoPagamento;

    @FXML
    private Button voltar;

    @FXML
    void abrirPagamentos(ActionEvent event) throws IOException {
        AbrirPopup.abrirPopup(event, "PopupDeCompra.fxml", "Compra !");
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Home.fxml");
    }
}
