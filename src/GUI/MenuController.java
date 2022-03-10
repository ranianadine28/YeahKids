/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Singleton_login;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author fedi
 */
public class MenuController implements Initializable {
    
    @FXML
    private Label login;
    @FXML 
    private ImageView img;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Singleton_login util = Singleton_login.getInstance();
         
         System.out.print(util.get_util());
         
         login.setText(util.get_util().getlogin());
    WritableImage image = new WritableImage(120,120);
        ByteArrayInputStream bis = new ByteArrayInputStream(util.get_util().getimg());
            BufferedImage read = null;
        try {
            read = ImageIO.read(bis);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
            image = SwingFXUtils.toFXImage(read, null);
                 
            img.setImage(image);
    
    }    
    
}
