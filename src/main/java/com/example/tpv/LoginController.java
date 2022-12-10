package com.example.tpv;

import com.example.tpv.modelos.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LoginController {

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
    protected void onBtnLogin() {

     /*   List<Usuario> lista =(List<Usuario>) TPVApplication.manager.createQuery("FROM USUARIOS").getResultList();
        System.out.println(lista);
        */
        Query q =TPVApplication.manager.createQuery("FROM USUARIOS WHERE username=:user AND password=:pass");
        q.setParameter("user",user.getText());
        q.setParameter("pass",password.getText());
        Usuario usuario =(Usuario)q.getResultList().get(0);
        if(usuario.getAdmin()==true){
            txtAcceso.setText("Acceso permitido MODO ADMIN");
        }
        if(usuario.getAdmin()==false){
            txtAcceso.setText("Acceso permitido MODO USUARIO");
        }



    }
}