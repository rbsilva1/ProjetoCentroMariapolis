package br.upe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import br.upe.utils.AbrirFXML;

public class CodigoInvalidoController {

    @FXML
    private Button voltar;

    @FXML
    void onClick(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "/br/upe/resources/FXML/Home.fxml");
    }

}
