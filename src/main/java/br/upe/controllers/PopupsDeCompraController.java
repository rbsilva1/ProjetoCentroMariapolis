package br.upe.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.utils.AbrirPopup;

public class PopupsDeCompraController implements javafx.fxml.Initializable {

    @FXML
    private ComboBox caixaDeEscolha;

    @FXML
    private Button confirm;

    @FXML
    void confirmarCompra(ActionEvent event) throws IOException {
        AbrirPopup.abrirPopup(event, "/br/upe/resources/FXML/PopDeCompraEfetuada.fxml", "Compra !");
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

