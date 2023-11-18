package com.example.projeto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    public void abrirHistorico(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Historico.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


