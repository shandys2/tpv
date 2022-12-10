package com.example.tpv;

import com.example.tpv.modelos.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private static EntityManager manager;
    private static EntityManagerFactory emf;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnLogin;
    @FXML
    private Label txtAcceso;

    @FXML
    protected void onBtnLogin() throws IOException {

     /*   List<Usuario> lista =(List<Usuario>) TPVApplication.manager.createQuery("FROM USUARIOS").getResultList();
        System.out.println(lista);
        */
        Query q =TPVApplication.manager.createQuery("FROM USUARIOS WHERE username=:user AND password=:pass");
        q.setParameter("user",user.getText());
        q.setParameter("pass",password.getText());
        Usuario usuario =(Usuario)q.getResultList().get(0);
        TPVApplication.changeScene("main-view.fxml", usuario);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}