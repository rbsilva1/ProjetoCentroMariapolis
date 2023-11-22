module com.example.projeto {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.projeto to javafx.fxml;
    exports com.example.projeto;
}