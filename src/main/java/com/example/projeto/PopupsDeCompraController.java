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
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("PopDeCompraEfetuada.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
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

