package br.upe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application {
    private static final String PERSISTENCE_UNIT_NAME = "Projeto";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Exemplo de uso do EntityManager para realizar operações no banco de dados
        try {
            entityManager.getTransaction().begin();

            // Aqui você pode realizar operações de persistência, consulta, etc.

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

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
