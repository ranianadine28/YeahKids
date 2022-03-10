/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Service.serviceparent;
import javax.swing.*;
import entites.parent;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

/**
 * FXML Controller class
 *
 * @author fedi
 */
public class entiteController implements Initializable {
    
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField login;
     @FXML
    private ImageView imageview;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
 public void setUser(parent p) throws IOException {
        nom.setText(p.getNom());
        prenom.setText(p.getPrenom());
        login.setText(p.getlogin());
        email.setText(p.getEmail());
        WritableImage image = new WritableImage(157,105);
        ByteArrayInputStream bis = new ByteArrayInputStream(p.getimg());
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
                 imageview.setImage(image);

 }    
    
public void setNom(String p){
           nom.setText(p);
           System.out.print("100");
     
} 
    
}
