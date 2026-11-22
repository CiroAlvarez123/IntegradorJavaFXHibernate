module org.example.integradorjavafxhibernate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens org.example.integradorjavafxhibernate to javafx.fxml;
    opens org.example.integradorjavafxhibernate.models to javafx.base, org.hibernate.orm.core;
    exports org.example.integradorjavafxhibernate;
}