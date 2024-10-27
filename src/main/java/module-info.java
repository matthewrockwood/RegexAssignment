module com.example.javafxjavadoc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxjavadoc to javafx.fxml;
    exports com.example.javafxjavadoc;
}