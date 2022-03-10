/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.servicereclamation;
import entites.admin;
import entites.reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author fedi
 */
public class ajoutreclamationController implements Initializable {
    @FXML
    private TextArea contenu;
    
    servicereclamation ps = new servicereclamation();

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
@FXML
    private void Insert(ActionEvent event) {
        reclamation p = new reclamation();
        p.set_contenu(contenu.getText());
        p.set_idparent(10);
        /*
        p.setid_parent(id);
        */
        
        
        ps.ajout(p);
    }



}
