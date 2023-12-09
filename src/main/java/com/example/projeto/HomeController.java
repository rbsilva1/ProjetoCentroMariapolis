package com.example.projeto;

import com.example.projeto.validacoes.Formatar_CPF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.projeto.validacoes.CPF_Validacao.validarCPF;

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
        AbrirFXML.abrirFXML(event, "Historico.fxml");
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Inscricoes.fxml");
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Home.fxml");
    }

    @FXML
    public void paginaEventos(ActionEvent event) throws IOException {
        AbrirFXML.abrirFXML(event, "Eventos.fxml");
    }

    @FXML
    public void verificarCPF(ActionEvent event) throws IOException {
        String cpf = digitarCPF.getText().trim();
        boolean cpfValido = validarCPF(cpf);
        if (cpfValido) {
            // Se o CPF for válido chamar as funções necessárias!
        } else {
            AbrirPopup.abrirPopup(event, "PopupErroCpf.fxml", "Erro CPF !");
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
