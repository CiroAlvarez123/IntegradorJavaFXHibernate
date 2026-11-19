module org.example.integradorjavafxhibernate {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.integradorjavafxhibernate to javafx.fxml;
    exports org.example.integradorjavafxhibernate;
}