/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.JardinEnfant;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import services.ServiceJardinEnfant;

/**
 * FXML Controller class
 *
 * @author lotfi
 */
public class Front_Jardin_EnfantController implements Initializable {

    @FXML
    private AnchorPane AnchorPane_jardin;
    @FXML
    private GridPane grid;
    private final List<JardinEnfant> jardinEnfant = new ArrayList<>();
    ServiceJardinEnfant sJE = new ServiceJardinEnfant();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       jardinEnfant.addAll(sJE.afficher());
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < jardinEnfant.size(); i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("UnJardinEnfant.fxml"));
                AnchorPane anchorPane = fxmlloader.load();

                UnJardinEnfantController AA = fxmlloader.getController();
               //  AA.setData(produit.get(0));
                AA.setData(jardinEnfant.get(i));
                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                }
            
           
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    

     
        
    
}
