package com.example.projeto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CodigoInvalidoController {

    @FXML
    private Button voltar;

    @FXML
    void onClick(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Home.fxml");
    }

}
