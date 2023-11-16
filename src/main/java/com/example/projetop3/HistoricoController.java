package com.example.projetop3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HistoricoController {

    @FXML
    private Button historico;

    @FXML
    private Button inscricoes;

    @FXML
    private Button paginainicial;
    @FXML
    public void abrirHistorico(ActionEvent event) { // Função de Abir a tela de Histórico
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Historico.fxml"));
            Parent root = loader.load();
            // Obter o controlador da outra tela
            HistoricoController controller = loader.getController();

            // Obtendo a referência do Stage atual
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Mudando a cena do Stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
    @FXML
    public void voltarTelaInicial(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            // Obter o controlador da outra tela
            HistoricoController controller = loader.getController();

            // Obtendo a referência do Stage atual
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Mudando a cena do Stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
