package com.example.projeto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.application.Application;
import javafx.stage.Modality;
import java.io.IOException;

public class HomeController {

    @FXML
    private Button botaoHistorico;

    @FXML
    private Button botaoVerMais;

    @FXML
    private Button buscar;

    @FXML
    private TextField digitarCPF;

    @FXML
    private Button inscricoes;

    @FXML
    private Button lupa;

    @FXML
    private Button paginainicial;

    private Scene scene;
    private Stage stage;
    private Popup popup;

    @FXML
    public void abrirHistorico(ActionEvent event) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("Historico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("Inscricoes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void paginaEventos(ActionEvent event) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void abrirPopupTeste(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PopupSaldoInsuficiente.fxml"));
        Parent root = loader.load();

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Pop-up");
        popupStage.setScene(new Scene(root));
        popupStage.show();
    }

}
