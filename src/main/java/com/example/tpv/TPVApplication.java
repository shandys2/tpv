package com.example.tpv;

import com.example.tpv.modelos.Producto;
import com.example.tpv.modelos.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class TPVApplication extends Application {
    public static EntityManager manager;
    public static EntityManagerFactory emf;

    private static Stage stagePrimary;
    @Override
    public void start(Stage stage) throws IOException {

        iniciarDB();

        this.stagePrimary=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(TPVApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 900);
        stagePrimary.setTitle("DANI TPV SYSTEMS");
        stagePrimary.setScene(scene);
        stagePrimary.show();
    }

    public static void main(String[] args) throws InterruptedException {launch();}


    public static void changeScene(String fxml) throws IOException {
        stagePrimary.setTitle("SALA DE CHAT");

        Parent pane = FXMLLoader.load(TPVApplication.class.getResource(fxml));
       // pane.resize(1300,400);
        stagePrimary.getScene().setRoot(pane);

    }
    public void iniciarDB(){

        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();
        Repository repository = new Repository(); //inicializamos el repositorio para cargar los datos
       manager.getTransaction().begin();
        for (Usuario usuario: Repository.listaUsuarios) {
            manager.persist(usuario);
            //Thread.sleep(10);
        }
        for (Producto producto: Repository.listaProductos) {
            manager.persist(producto);
            // Thread.sleep(10);
        }
        manager.getTransaction().commit();

    }
}