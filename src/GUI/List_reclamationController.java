/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import Service.servicereclamation;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class List_reclamationController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<reclamation> tableview;
    @FXML
    private TableColumn<reclamation, Integer> id_parent;
    @FXML
    private TableColumn<reclamation, String> contenu;
    @FXML
    private TableColumn<reclamation, String> nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

        servicereclamation sp = new servicereclamation();
        List personnes = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(personnes);
        tableview.setItems(list);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        id_parent.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
        contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));

//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajout.fxml"));
//            Parent root = loader.load();
//            pane.getChildren().add(root);
//            // TODO
//        } catch (IOException ex) {
//            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    }
