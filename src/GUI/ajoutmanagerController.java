/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Service.PasswordUtils;
import javafx.stage.FileChooser;



import entites.manager;
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
import Service.servicemanager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class ajoutmanagerController implements Initializable {
    
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
    
    servicemanager ps = new servicemanager();

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
        manager p = new manager();
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