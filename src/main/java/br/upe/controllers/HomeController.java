package br.upe.controllers;

import static br.upe.utils.AbrirFXML.abrirFXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Modality;

import static br.upe.utils.CPF_Validacao.validarCPF;

import java.io.IOException;

import br.upe.utils.Formatar_CPF;

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

    @FXML
    public void abrirHistorico(ActionEvent event) throws IOException {
        abrirFXML(event, "/br/upe/resources/FXML/Historico.fxml");
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        abrirFXML(event, "/br/upe/resources/FXML/Inscricoes.fxml");
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        abrirFXML(event, "/br/upe/resources/FXML/Home.fxml");
    }

    @FXML
    public void paginaEventos(ActionEvent event) throws IOException {
        abrirFXML(event, "/br/upe/resources/FXML/Eventos.fxml");
    }

    @FXML
    public void verificarCPF(ActionEvent event) throws IOException {
        String cpf = digitarCPF.getText().trim();
        boolean cpfValido = validarCPF(cpf);
        if (cpfValido) {
            // Se o CPF for válido chamar as funções necessárias!
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/upe/resources/FXML/PopupErroCpf.fxml"));
            Parent root = loader.load();
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Erro CPF !");
            popupStage.setScene(new Scene(root));
            popupStage.setResizable(false);
            popupStage.show();
        }
    }

    @FXML
    public void mascaraCPF() {
        Formatar_CPF verifica_entrada = new Formatar_CPF();
        verifica_entrada.setMask("###.###.###-##");
        verifica_entrada.setCaracteresValidos("0123456789");
        verifica_entrada.setTf(digitarCPF);
        verifica_entrada.formatter();
    }

}
