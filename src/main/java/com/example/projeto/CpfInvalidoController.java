package com.example.projeto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CpfInvalidoController {

    @FXML
    private Button voltar;

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) voltar.getScene().getWindow();
        // Fecha a janela atual
        stage.close();
    }

}
