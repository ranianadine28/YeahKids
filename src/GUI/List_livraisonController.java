/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.livraison;
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
import Service.Servicelivraison;
import entites.livraison;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class List_livraisonController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<livraison> tableview;
    @FXML
    private TableColumn<livraison, Integer> id_produit;
    @FXML
    private TableColumn<livraison, Integer> prix;
    @FXML
    private TableColumn<livraison, String> quantite;
    @FXML
    private TableColumn<livraison, String> id_parent;
    @FXML
    private TableColumn<livraison, String> adresse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

        Servicelivraison sp = new Servicelivraison();
        List personnes = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(personnes);
        tableview.setItems(list);
        id_produit.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        id_parent.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));

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
