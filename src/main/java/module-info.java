module br.upe {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens br.upe.controllers to javafx.fxml;
    opens br.upe.models to javafx.base;
    opens br.upe.utils to javafx.fxml;
    exports br.upe;
}