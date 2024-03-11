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

import static br.upe.utils.CpfValidacao.validarCPF;

import java.io.IOException;

import br.upe.facades.FachadaUsuario;
import br.upe.models.Usuario;
import br.upe.utils.AbrirPopup;
import br.upe.utils.FormatarCPF;

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
            FachadaUsuario fachadaUsuario = new FachadaUsuario();
            Usuario usuario = fachadaUsuario.buscarUsuario(cpf);
            if (usuario == null) {
                AbrirPopup.abrirPopup("/br/upe/resources/FXML/PopupErroCpf.fxml", "Erro CPF !");
            }

            AbrirPopup.abrirPopup("/br/upe/resources/FXML/PopDeCompraEfetuada.fxml", "Perfil");
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
        FormatarCPF verificaEntrada = new FormatarCPF();
        verificaEntrada.setMask("###.###.###-##");
        verificaEntrada.setCaracteresValidos("0123456789");
        verificaEntrada.setTf(digitarCPF);
        verificaEntrada.formatter();
    }

}