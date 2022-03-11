/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.PasswordUtils;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


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
    PasswordField mdp;
   
    @FXML
    TextField login;
    
    
    @FXML
    Label error;
    
    @FXML 
    private RadioButton admin;
    @FXML 
    private RadioButton parent;
    @FXML 
    private RadioButton manager;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
 @FXML
    private void login(ActionEvent event) throws IOException {
           final Node source = (Node) event.getSource();
           boolean passwordMatch=false;
           if(parent.isSelected()==true){
               serviceparent sp=new serviceparent();
               
               parent p=sp.recherche(login.getText());

               
                                  
               if(p==null){
               error.setText("CANT FIND LOGIN ..TRY AGAIN...");
               }
               else
               passwordMatch = PasswordUtils.verifyUserPassword(mdp.getText(), p.getmdp(), p.getsalt());      

               {
                   if(passwordMatch){
               
System.out.print(source.getParent().getId());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Singleton_login util = Singleton_login.getInstance(p);

            Parent root = loader.load();
            mdp.getScene().setRoot(root);
           }else
                 error.setText("WRONG PASSWORD ..TRY AGAIN...");
      
               
               
               }

}
           

if(admin.isSelected()==true){
               serviceadmin sp=new serviceadmin();
               
               admin p=sp.recherche(login.getText());

                                  
               if(p==null){
               error.setText("CANT FIND LOGIN ..TRY AGAIN...");
               }
               else
               passwordMatch = PasswordUtils.verifyUserPassword(mdp.getText(), p.getmdp(), p.getsalt());      

               {
                   if(passwordMatch){
               
System.out.print(source.getParent().getId());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Singleton_login util = Singleton_login.getInstance(p);

            Parent root = loader.load();
            mdp.getScene().setRoot(root);
           }else
                 error.setText("WRONG PASSWORD ..TRY AGAIN...");
      
               
               
               }
               

}
if(manager.isSelected()==true){
               servicemanager sp=new servicemanager();
               
               manager p=sp.recherche(login.getText());

               
                                  
               if(p==null){
               error.setText("CANT FIND LOGIN ..TRY AGAIN...");
               }
               else
               passwordMatch = PasswordUtils.verifyUserPassword(mdp.getText(), p.getmdp(), p.getsalt());      

               {
                   if(passwordMatch){
               
System.out.print(source.getParent().getId());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Singleton_login util = Singleton_login.getInstance(p);

            Parent root = loader.load();
            mdp.getScene().setRoot(root);
           }else
                 error.setText("WRONG PASSWORD ..TRY AGAIN...");
      
               
               
               }

}
           
}
    @FXML
    
    public void forgetpassword(MouseEvent event) throws IOException{
String user;
        if (login.getText().isEmpty())
                
                
                         
        {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir le login champ!");
            alert.showAndWait();

        }
else{	

if(parent.isSelected()==true){

    user="parent"; 
   serviceparent sp=new serviceparent();
        parent p =sp.recherche(login.getText());
if(p==null){
               error.setText("CANT FIND LOGIN ..TRY AGAIN...");
               }
else{

FXMLLoader loader = new FXMLLoader(getClass().getResource("forgetpassword.fxml"));

            Parent root = loader.load();
                        ForgetpasswordController controller = loader.getController();
                        controller.setinformation(p.getquestion(), p.getresponde(),login.getText(),user);
                                    login.getScene().setRoot(root);

            

}
}
 if(admin.isSelected()){
user="admin";
serviceadmin sp=new serviceadmin();
       sp.recherche(login.getText());
      admin p =sp.recherche(login.getText());
if(p==null){
               error.setText("CANT FIND LOGIN ..TRY AGAIN...");
               }
else{
FXMLLoader loader = new FXMLLoader(getClass().getResource("forgetpassword.fxml"));

            Parent root = loader.load();
                        ForgetpasswordController controller = loader.getController();
                        controller.setinformation(p.getquestion(), p.getresponde(),login.getText(),user);
                                    login.getScene().setRoot(root);

            

}
}
      
      
      

else {
    user="manager";
servicemanager sp=new servicemanager();
       sp.recherche(login.getText());
       manager p =sp.recherche(login.getText());
if(p==null){
               error.setText("CANT FIND LOGIN ..TRY AGAIN...");
               }
else{
FXMLLoader loader = new FXMLLoader(getClass().getResource("forgetpassword.fxml"));

            Parent root = loader.load();
                        ForgetpasswordController controller = loader.getController();
                        controller.setinformation(p.getquestion(), p.getresponde(),login.getText(),user);
                                    login.getScene().setRoot(root);

            

}
}
}
				

    


}
    @FXML 
     public void click_parent(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutparent.fxml"));

            Parent root = loader.load();
                        
                                    login.getScene().setRoot(root); 
     
     }
     @FXML 
     public void click_admin(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutadmin.fxml"));

            Parent root = loader.load();
                        
                                    login.getScene().setRoot(root); 
     
     }
    @FXML 
     public void click_manager(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutmanager.fxml"));

            Parent root = loader.load();
                        
                                    login.getScene().setRoot(root); 
     
     }
    }				
        
        
        
    

    
    
   