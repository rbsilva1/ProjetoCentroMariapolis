module br.upe {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens br.upe to javafx.fxml;
    exports br.upe;
}