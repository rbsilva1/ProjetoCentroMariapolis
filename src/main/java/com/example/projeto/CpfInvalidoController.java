package com.example.projeto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class CpfInvalidoController {

    @FXML
    private Button voltar;

    private Scene scene;
    private Stage stage;
    private Popup popup;
    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        Stage stage = (Stage) voltar.getScene().getWindow();
        // Fecha a janela atual
        stage.close();
    }

}
