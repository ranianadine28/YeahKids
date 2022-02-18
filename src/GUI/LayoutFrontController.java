/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Nayer Ben Jaber
 */
public class LayoutFrontController implements Initializable {

    @FXML
    private ImageView home;
    @FXML
    private ImageView espace;
    @FXML
    private ImageView evenement;
    @FXML
    private ImageView profile;
    @FXML
    private ImageView interaction;
    @FXML
    private AnchorPane holderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MenuBarController.holderPane = holderPane;
        loadView("/GUI/ajouter_event_1.fxml");
    }

    @FXML
    private void home() throws IOException {
        loadView("/GUI/ajouter_event_1.fxml");

    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    private Object loadView(String path) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource((path)));
        AnchorPane parentContent = null;
        try {
            parentContent = fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(LayoutFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setNode(parentContent);
        System.gc();
        return fxmlLoader.getController();
    }

    @FXML
    private void searchAction(MouseEvent event) {
    }

    @FXML
    private void matchingAction(MouseEvent event) {
    }

    @FXML
    private void eventAction(MouseEvent event) {
                loadView("/GUI/ajouter_event_1.fxml");

    }

    @FXML
    private void espaceAction(MouseEvent event) {
                loadView("/GUI/ajouter_pub.fxml");

    }

    @FXML
    private void forumAction(MouseEvent event) {
    }
}
