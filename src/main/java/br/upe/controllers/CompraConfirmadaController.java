package br.upe.controllers;

import java.io.IOException;

import br.upe.utils.AbrirFXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CompraConfirmadaController {
    @FXML
    private Button voltar;

    @FXML
    void voltarTelaInicial(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Home.fxml");
    }
}
