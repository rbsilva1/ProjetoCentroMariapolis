package com.example.projeto;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PopupsDeCompraController implements javafx.fxml.Initializable {

    @FXML
    private ComboBox caixaDeEscolha;

    @FXML
    private Button confirm;

    private Stage stage;
    private Scene scene;


    @FXML
    void confirmarCompra(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PopDeCompraEfetuada.fxml"));
        Parent root = loader.load();
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Compra !");
        popupStage.setScene(new Scene(root));
        popupStage.setResizable(false);
        popupStage.show();
    }

    @FXML
    void select(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Cartão de crédito ou débito", "Boleto", "Pix", "Dinheiro");
        caixaDeEscolha.setItems(list);
    }

}

