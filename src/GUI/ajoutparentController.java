/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Service.PasswordUtils;
import javafx.stage.FileChooser;



import entites.parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Service.serviceparent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class ajoutparentController implements Initializable {
   
    @FXML
    private Label welcome;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
     @FXML
    private TextField confirm;
     @FXML
    private TextField login;
     @FXML
    private ImageView imageview;

     private String absolute_path;
    
    serviceparent ps = new serviceparent();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setUsername(String username) {
        welcome.setText("Hello " + username);
        
    }
    
    @FXML
    private void Insert(ActionEvent event) {
        
        if (nom.getText().isEmpty()
                | prenom.getText().isEmpty()
                | email.getText().isEmpty()
                | password.getText().isEmpty()
                | confirm.getText().isEmpty()
                | login.getText().isEmpty() 
                
                 )
        
        {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();

        }
        else{
             if(!nom.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider le Nom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier le Nom ");
            alert1.showAndWait();
         
         
         }
        
        else{
        
        if(!prenom.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider la prenom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier la description ");
            alert1.showAndWait();
         
         
         }
        else{
        
        if(!email.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider la email");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier la email ");
            alert1.showAndWait();
         
         
         }
        else{
        
        if(!password.getText().matches("^[a-zA-Z]+$")){    
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Valider le password");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez verifier la mdp");
            alert.showAndWait();}
        else{
             if(!login.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider le login");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier le login ");
            alert1.showAndWait();
         
         
         }
             else{
             if(!password.getText().equals(confirm.getText())){    
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Verifier  la confirmation de mdp  ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez verifier la confirmation");
            alert.showAndWait();
             
             
         
        
        
        
        
             }
        
            else {   
        parent p = new parent();
        p.setEmail(email.getText());
        p.setNom(nom.getText());
        p.setPrenom(prenom.getText());
        p.setimage(absolute_path);
        p.setlogin(login.getText());
        
        String salt = PasswordUtils.getSalt(30);
        String securePassword = PasswordUtils.generateSecurePassword(password.getText(), salt);
        
        
        
        
        p.setsalt(salt);
        p.setmdp(securePassword);

        
        ps.ajout(p);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Success parent Ajouté!");
            alert.showAndWait();

            
             
             }
    }
        }
        }
        }
        }
             }
        }
    
    @FXML
    private void Affichage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher.fxml"));
            Parent root = loader.load();
            nom.getScene().setRoot(root);
        }
        catch (IOException ex) {
            
            Logger.getLogger(ajoutparentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void selectfile(ActionEvent event) throws FileNotFoundException {
 FileChooser fc = new FileChooser();
 FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");

 fc.getExtensionFilters().add(extFilter);
 File f=fc.showOpenDialog(null);
 if(f!=null){
     absolute_path = f.getAbsolutePath();
     InputStream stream = new FileInputStream(f);
     Image image = new Image(stream);
     imageview.setImage(image);



 
 }
 
 
         
    
    
}
}