package br.upe;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

import br.upe.models.Usuario;
import br.upe.repositories.UsuarioRepositorio;

public class Application extends javafx.application.Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/upe/resources/FXML/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), bounds.getWidth(), bounds.getHeight());
        stage.setMaximized(true);
        stage.setTitle("Projeto Centro Mariápolis!");
        stage.setScene(scene);
        stage.show();

    }
}
