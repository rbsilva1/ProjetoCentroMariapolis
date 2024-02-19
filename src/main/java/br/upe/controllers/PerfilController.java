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
  private Label cafeLabel;
  @FXML
  private Label almocoLabel;
  @FXML
  private Label jantaLabel;

  @FXML
  private Button voltar;

  @FXML
  void voltarTela(ActionEvent event) throws IOException {
    // Falta Implementar
  }

  public void mostrarInformacoesUsuario(Usuario usuario) {

    nomeLabel.setText(usuario.getNome());
    cpfLabel.setText(usuario.getCpf());
    cafeLabel.setText(String.valueOf(usuario.getCafe()));
    almocoLabel.setText(String.valueOf(usuario.getAlmoco()));
    jantaLabel.setText(String.valueOf(usuario.getJanta()));
  }
}
