/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Service.serviceparent;
import entites.parent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author fedi
 */
public class afficherController implements Initializable {
    @FXML
    private FlowPane Flow;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.print(rb);
        
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("entite.fxml"));


   
            serviceparent sp =new serviceparent();
                    List list = sp.afficher();
Iterator<parent> i = list.iterator();



while(i.hasNext()) 
{


   
    try {
        Flow.getChildren().add(shape(i.next()));
    } catch (IOException ex) {
        Logger.getLogger(afficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    

  
     
       
       
       

       
        

   



    }
    }
public Pane shape(parent p) throws IOException{
                Pane root = new Pane();

        Button sup = new Button();
        Button mod = new Button();
        TextField prenom = new TextField();
         TextField nom = new TextField();
          TextField email = new TextField();
           TextField login = new TextField();
           ImageView img =new ImageView();
        sup.setText("supprimer");
        mod.setText("modifier");

        
        sup.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                serviceparent sp =new serviceparent();
                sp.supprimer(p.getId_parent());
                root.getChildren().clear();
                
            }
        });
        mod.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello modifier!");
            }
        });
        
        root.prefHeight(224);
                root.prefWidth(315);

    sup.setLayoutX(242);
    sup.setLayoutY(178);
    
    prenom.setLayoutX(156);
    prenom.setLayoutY(74);
    prenom.setText(p.getPrenom());
    
    nom.setLayoutX(156);
    nom.setLayoutY(33);
        nom.setText(p.getNom());

    login.setLayoutX(20);
    login.setLayoutY(178);
    login.setText(p.getlogin());

    email.setLayoutX(156);
    email.setLayoutY(123);
     email.setText(p.getEmail());

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
    
    
    
    
    
   root.getChildren().addAll(sup,mod,nom,prenom,login,img,email);
   return root;
        
        
    }    
    



}
