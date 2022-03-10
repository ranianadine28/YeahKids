/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.serviceadmin;
import Service.servicemanager;
import Service.serviceparent;
import entites.Singleton_login;
import entites.admin;
import entites.manager;
import entites.parent;
import entites.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author fedi
 */
 

public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    PasswordField mdp_p;
     @FXML
    PasswordField mdp_a;
     @FXML
    PasswordField mdp_m;
    @FXML
    TextField login_m;
    @FXML
    TextField login_a;
    @FXML
    TextField login_p;
    @FXML
    Label error_p;
    @FXML
    Label error_m;
    @FXML
    Label error_a;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
 @FXML
    private void login(ActionEvent event) throws IOException {
           final Node source = (Node) event.getSource();
           if("parent".equals(source.getParent().getId())){
               serviceparent sp=new serviceparent();
               
               parent p=sp.recherche(mdp_p.getText(),login_p.getText());

               
                                  
               if(p==null){
               error_p.setText("TRY AGAIN...");
               }
               else
               {
               
System.out.print(source.getParent().getId());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Singleton_login util = Singleton_login.getInstance(p);

            Parent root = loader.load();
            mdp_p.getScene().setRoot(root);
           }

}
           

if("admin".equals(source.getParent().getId())){
               serviceadmin sp=new serviceadmin();
               
               admin p=sp.recherche(mdp_a.getText(),login_a.getText());

               
                                  
               if(p==null){
               error_a.setText("TRY AGAIN...");
               }
               else
               {
               
System.out.print(source.getParent().getId());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Singleton_login util = Singleton_login.getInstance(p);

            Parent root = loader.load();
            mdp_p.getScene().setRoot(root);
           }

}
if("manager".equals(source.getParent().getId())){
               servicemanager sp=new servicemanager();
               
               manager p=sp.recherche(mdp_m.getText(),login_m.getText());

               
                                  
               if(p==null){
               error_m.setText("TRY AGAIN...");
               }
               else
               {
              System.out.print(source.getParent().getId());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Singleton_login util = Singleton_login.getInstance(p);

            Parent root = loader.load();
            mdp_p.getScene().setRoot(root);
           }

}
           
}
}