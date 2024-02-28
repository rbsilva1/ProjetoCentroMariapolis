package br.upe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;
import br.upe.models.*;
import javax.persistence.*;

public class Main extends Application {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            Usuario usuario = new Usuario();
            usuario.setCpf("100.868.754-50");
            usuario.setNome("Vitório Fernandes de Amorim");
            usuario.setCafe(3);
            usuario.setAlmoco(3);
            usuario.setJanta(3);
            usuario.setData("12/09/2002");
            tx.begin();
            em.persist(usuario);
            tx.commit();
            em.close();
            entityManagerFactory.close();
            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");

        } catch (Exception e) {
            System.err.println("Erro ao tentar conectar ao banco de dados: " + e.getMessage());
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
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
