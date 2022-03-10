/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.JardinEnfant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lotfi
 */
public class UnJardinEnfantController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private Label nom;
    @FXML
    private Label description;
    @FXML
    private Button choisir;
    @FXML
    private Label date_creation;
    @FXML
    private Label nb_employes;
    @FXML
    private Label adresse;
    @FXML
    private Label telephone;
    
        private JardinEnfant jree;
    @FXML
    private Label prix;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setData(JardinEnfant jre) {
        jree = jre;
        
        
        nom.setText(jre.getNom());
        description.setText(jre.getDescription());
        String picture ="file:" +  jre.getLogo();
        Image image1 = new Image(picture, 250, 180, false, true);
        logo.setImage(image1);
        nb_employes.setText(String.valueOf(jre.getNb_employes()));
        adresse.setText(jre.getAdresse());
        date_creation .setText(jre.getDate_creation ().toString());
        prix.setText(String.valueOf(jre.getPrix()));
        telephone.setText(String.valueOf(jre.getTelephone()));
        
        
        
       
        Front_EleveFXMLController.getIdJE(jre.getIdj());
    }

    @FXML
    private void Faire_remplir_Eleve(ActionEvent event) throws IOException {
        int x = Front_EleveFXMLController.getIdJE(jree.getIdj());
        System.out.println(x);
        Parent root = FXMLLoader.load(getClass().getResource("Front_EleveFXML.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();    
    }
    
}
