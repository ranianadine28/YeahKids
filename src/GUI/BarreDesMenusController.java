/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;





/**
 * FXML Controller class
 *
 * @author lotfi
 */
public class BarreDesMenusController implements Initializable {

    @FXML
    private Button Button_Gestion_JardinE;
    @FXML
    private Button Button_Gestion_EleveJ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private void Gestion_JardinE(MouseEvent event) {
          try {
           
            root = FXMLLoader.load(getClass().getResource("../GUI/FXML1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }

    @FXML
    private void Gestion_EleveJ(MouseEvent event) {
        
         try {
           
            root = FXMLLoader.load(getClass().getResource("../GUI/FXML.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
        
        
        
    }
  

    
}
