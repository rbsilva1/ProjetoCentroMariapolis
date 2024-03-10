package br.upe.utils;

import java.io.IOException;
import java.net.URL;

import br.upe.controllers.PerfilController;
import br.upe.models.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AbrirTableView {
  private AbrirTableView() {

  }

  public static <T> void abrirTableView(TableView<T> tabela, URL fxml) {
    tabela.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if (newSelection != null) {
        try {
          FXMLLoader loader = new FXMLLoader(fxml);
          Parent root = loader.load();
          PerfilController perfilController = loader.getController();

          if (newSelection instanceof Usuario) {
            perfilController.mostrarInformacoesUsuario((Usuario) newSelection);
            Stage popupStage = new Stage();
            popupStage.setTitle("Perfil");
            popupStage.setScene(new Scene(root));
            popupStage.setResizable(false);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.show();
          }

        } catch (IOException e) {
          // e.printStackTrace();
        }
      }
    });
  }
}
