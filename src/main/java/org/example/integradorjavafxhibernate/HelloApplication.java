package org.example.integradorjavafxhibernate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.integradorjavafxhibernate.models.Equipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        TableView<Equipo> tabla = new TableView<>();

        String[][] columnas = {
                {"ID", "id"}, {"Nombre", "nombre"},
                {"Categoría", "categoria"}, {"Disponible", "disponible"}
        };
        for (String[] c : columnas) {
            TableColumn<Equipo, Object> col = new TableColumn<>(c[0]);
            col.setCellValueFactory(new PropertyValueFactory<>(c[1]));
            tabla.getColumns().add(col);
        }

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession()) {
            tabla.setItems(FXCollections.observableArrayList(
                    session.createQuery("from Equipo", Equipo.class).list()));
        }
        sf.close();

        stage.setTitle("Equipos");
        stage.setScene(new Scene(tabla, 600, 300));
        stage.show();
    }
}