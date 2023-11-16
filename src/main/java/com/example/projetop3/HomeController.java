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

public class HomeController {

    @FXML
    private Button botaoVermais;

    @FXML
    public void abrirHistorico(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Historico.fxml"));
            Parent root = loader.load();
            // Obter o controlador da outra tela
            HistoricoController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            // Fechar tela
            ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            System.out.println("NÃO ENCOTROU O CAMINHO !\n");
        }
    }


}
