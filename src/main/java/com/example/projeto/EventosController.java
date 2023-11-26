package com.example.projeto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class EventosController {

    private Scene scene;
    private Stage stage;

    @FXML
    private Button botaoHistorico1;

    @FXML
    private Button inscricoes;

    @FXML
    private Button paginaEventos;

    @FXML
    private Button paginainicial;

    public void funcaoAbrirFXML(ActionEvent event, String fxlm) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource(fxlm));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void abrirHistorico(ActionEvent event) throws IOException {
        funcaoAbrirFXML(event, "Historico.fxml");
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        funcaoAbrirFXML(event, "Inscricoes.fxml");
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        funcaoAbrirFXML(event, "Home.fxml");
    }

}
