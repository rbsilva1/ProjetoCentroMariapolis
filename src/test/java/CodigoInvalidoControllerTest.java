import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;

import org.testfx.framework.junit5.*;

import br.upe.controllers.CodigoInvalidoController;

import org.junit.jupiter.api.extension.ExtendWith;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

@ExtendWith(ApplicationExtension.class)
public class CodigoInvalidoControllerTest {

  @Start
  private void start(Stage stage) throws Exception {
    Parent root = null;
    FXMLLoader loader = new FXMLLoader(
        CodigoInvalidoController.class.getResource("/br/upe/resources/FXML/CodigoInvalido.fxml"));
    root = loader.load();
    stage.setScene(new Scene(root));
    stage.show();
    stage.toFront();
  }

  @Test
  public void testCodigoInvalido(FxRobot robot) {
    FxAssert.verifyThat("#voltar", hasText("Voltar"));
  }
}
