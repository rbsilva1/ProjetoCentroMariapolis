package com.example.projeto;

import com.example.projeto.validacoes.Formatar_CPF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.stage.Modality;
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

    private Scene scene;
    private Stage stage;
    private Popup popup;

    @FXML
    public void abrirHistorico(ActionEvent event) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("Historico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void abrirInscricoes(ActionEvent event) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("Inscricoes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void paginaEventos(ActionEvent event) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("Eventos.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void verificarCPF(ActionEvent event) throws IOException {
        String cpf = digitarCPF.getText().trim();
        boolean cpfValido = validarCPF(cpf);
        if (cpfValido) {
            // Se o CPF for válido chamar as funções necessárias!
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PopupErroCpf.fxml"));
            Parent root = loader.load();
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Erro CPF !");
            popupStage.setScene(new Scene(root));
            popupStage.setResizable(false);
            popupStage.show();
        }
    }
    @FXML // Metódo que adiciona pontos e traços ao digitar o CPF e restringi para apenas números
    public void mascaraCPF(){
        Formatar_CPF verifica_entrada = new Formatar_CPF();
        verifica_entrada.setMask("###.###.###-##");
        verifica_entrada.setCaracteresValidos("0123456789");
        verifica_entrada.setTf(digitarCPF);
        verifica_entrada.formatter();
    }

}
