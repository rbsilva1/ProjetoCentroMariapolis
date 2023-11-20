package com.example.projeto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PopupsController{

    @FXML
    private ComboBox caixaDeEscolha;

    @FXML
    private Button confirm;

    @FXML
    void confirmarCompra(ActionEvent event) {

    }

    @FXML
    void select(ActionEvent event) {

    }

    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Cartão de crédito ou débito", "Boleto", "Pix", "Dinheiro");
        caixaDeEscolha.setItems(list);
    }

}

