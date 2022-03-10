/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.Serviceproduit;
import entites.produit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author test
 */
public class Afficher_produitController implements Initializable {

@FXML
    private FlowPane Flow;
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        



   
            Serviceproduit sp =new Serviceproduit();
                    List list = sp.afficher();
Iterator<produit> i = list.iterator();


while(i.hasNext()) 
{


   
    try {
        Flow.getChildren().add(shape(i.next()));
    }
    catch (IOException ex) {
        Logger.getLogger(afficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }
public Pane shape(produit p) throws IOException{
                Pane root = new Pane();

        Button sup = new Button();
        Button mod = new Button();
         TextField nom = new TextField();
          TextField prix = new TextField();
           TextField quantite = new TextField();
           ImageView img =new ImageView();
        sup.setText("supprimer");
        mod.setText("modifier");

        
        sup.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
              
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez vous supprimer cette produit?");

            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.OK) {

                Serviceproduit sp =new Serviceproduit();
                sp.supprimer(p.getId_produit());
                                root.getChildren().clear();


            } else {

                return;

            }
                
                
                
                
            }
        });
        mod.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez vous modifier cette produit?");

            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.OK) {

                Serviceproduit sp =new Serviceproduit();
                produit c=new produit(p.getId_produit(),Integer.parseInt(prix.getText()),nom.getText(),Integer.parseInt(quantite.getText()));        
                sp.modifier(c);


            } else {

                return;

            }
            
            
            
            }
        });
        
        root.prefHeight(224);
                root.prefWidth(315);

    sup.setLayoutX(242);
    sup.setLayoutY(178);
    
   
    
    nom.setLayoutX(156);
    nom.setLayoutY(33);
        nom.setText(p.getNom());

    prix.setLayoutX(20);
    prix.setLayoutY(178);
    prix.setText(String.valueOf(p.getPrix()));

    quantite.setLayoutX(156);
    quantite.setLayoutY(123);
    quantite.setText(String.valueOf(p.getQuantite()));

    mod.setLayoutX(181);
    mod.setLayoutY(178);
    
    img.setLayoutX(14);
    img.setLayoutY(24);
  img.setFitHeight(124);
    img.setFitWidth(134);

    WritableImage image = new WritableImage(157,105);
        ByteArrayInputStream bis = new ByteArrayInputStream(p.getimg());
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
                 img.setImage(image);
    
    
    
    
    
   root.getChildren().addAll(sup,mod,nom,prix,img,quantite);
   return root;
        
        
    }

    @FXML
    private void retour(ActionEvent event) {
    }

   
}