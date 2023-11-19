package com.example.projeto;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InscricoesTableController {
  private Scene scene;
  private Stage stage;

  @FXML
  public void voltarTelaInicial(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
