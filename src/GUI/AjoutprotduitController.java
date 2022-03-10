/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.Serviceproduit;
import Service.servicemanager;
import entites.manager;
import entites.produit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author test
 */
public class AjoutprotduitController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Label welcome;
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private TextField quantite;
     @FXML
    private ImageView imageview;

     private String absolute_path;
    
    Serviceproduit ps = new Serviceproduit();

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
    
    /*@FXML
    private void Insert(ActionEvent event) {
        produit p = new produit ();
        p.setNom(nom.getText());
        p.setPrix(Integer.parseInt(prix.getText()));
        p.setQuantite(Integer.parseInt(quantite.getText()));
        p.setImage(absolute_path);

        
        ps.ajout(p);
    }*/
    
    
    @FXML
    private void Insert(ActionEvent event) {

        if (nom.getText().isEmpty()
                | prix.getText().isEmpty()
                | quantite.getText().isEmpty()
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
        
        if(!quantite.getText().matches("^([1-9][0-9]{0,10}|1000)$")){    
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Valider la quantite");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez verifier la quantite ");
            alert.showAndWait();}
        
        
        
        
        
        else {
            
            
             produit p = new produit ();
        p.setNom(nom.getText());
        p.setPrix(Integer.parseInt(prix.getText()));
        p.setQuantite(Integer.parseInt(quantite.getText()));
        p.setImage(absolute_path);

            ps.ajout(p);
           

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Felicitation");
            alert.setHeaderText(null);
            alert.setContentText("Le produit est ajouté  !");
            alert.showAndWait();

            
            
        }

    }
        }
    
        
}

    @FXML
    private void Affichage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_produit.fxml"));
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
