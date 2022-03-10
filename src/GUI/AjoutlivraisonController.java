/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.Servicelivraison;
import Service.servicemanager;
import entites.manager;
import entites.livraison;
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


/**
 * FXML Controller class
 *
 * @author test
 */
public class AjoutlivraisonController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
     @FXML
    private Label welcome;
      @FXML
    private TextField id_produit;
    @FXML
    private TextField prix;
    @FXML
    private TextField quantite;
     @FXML
    private TextField adresse;
      @FXML
    private TextField id_parent;
     
     Servicelivraison ps = new Servicelivraison();
     
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
 
    /*private void Insert(ActionEvent event) {
        livraison p = new livraison ();
        p.setId_produit(Integer.parseInt(id_produit.getText()));
        p.setPrix(Integer.parseInt(prix.getText()));
        p.setQuantite(Integer.parseInt(quantite.getText()));
        p.setAdresse(adresse.getText());
        p.setId_parent(Integer.parseInt(id_parent.getText()));
     ps.ajout(p);
}*/
         @FXML
    private void Insert(ActionEvent event) {

        if (id_produit.getText().isEmpty()
                | prix.getText().isEmpty()
                | quantite.getText().isEmpty()
                | adresse.getText().isEmpty()
                | id_parent.getText().isEmpty()

              )
        
        {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();

        }
        
        else{
        
        if(!id_produit.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider le id_produit");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier le id_produit ");
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
            
            
             livraison p = new livraison ();
        p.setId_produit(Integer.parseInt(id_produit.getText()));
        p.setPrix(Integer.parseInt(prix.getText()));
        p.setQuantite(Integer.parseInt(quantite.getText()));
        

            ps.ajout(p);
           

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Felicitation");
            alert.setHeaderText(null);
            alert.setContentText("La livraison est ajouté  !");
            alert.showAndWait();

            
            
        }

    }
        }
    
        
}
 @FXML
    private void Affichage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_livraison.fxml"));
            Parent root = loader.load();
            id_produit.getScene().setRoot(root);
        }
        catch (IOException ex) {
            Logger.getLogger(ajoutparentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}