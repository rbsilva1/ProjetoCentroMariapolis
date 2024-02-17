package br.upe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

import br.upe.models.Usuario;

public class PerfilController {
  @FXML
  private Label nomeLabel;
  @FXML
  private Label cpfLabel;
  @FXML
  private Label eventoLabel;
  @FXML
  private Label refeicaoLabel;

  @FXML
  private Button voltar;

  @FXML
  void voltarTela(ActionEvent event) throws IOException {

  }

  public void mostrarInformacoesUsuario(Usuario usuario) {
    int almoco = usuario.getAlmoco();
    int janta = usuario.getJanta();
    int cafeManha = usuario.getCafe();

    int somaRefeicoes = (cafeManha+almoco+janta);

    nomeLabel.setText(usuario.getNome());
    cpfLabel.setText(usuario.getCpf());
    refeicaoLabel.setText(String.valueOf(somaRefeicoes));
  }
}
