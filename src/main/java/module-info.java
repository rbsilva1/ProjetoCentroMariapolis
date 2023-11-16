module com.example.projetop3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetop3 to javafx.fxml;
    exports com.example.projetop3;
}