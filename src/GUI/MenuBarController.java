/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.User;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *
 * @author Nacef
 */
public class MenuBarController  implements Initializable {
    public static AnchorPane holderPane;

    @FXML
    private ImageView invitation;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
    }

    private HBox userItem(User user) {
        Font prefFont = new Font("System Bold", 12);
        HBox hBox = new HBox();
        hBox.setPrefSize(150, 60);
        /*ImageView userImage = new ImageView(getClass().getResource("../Images/" + user.getImage()).toExternalForm());
        userImage.setFitWidth(60);
        userImage.setFitHeight(60);
        userImage.setPickOnBounds(true);
        userImage.setPreserveRatio(true);
        userImage.setClip(new Circle(30, 30, 30));
        Label userName = new Label(user.getNom() + " " + user.getPrenom());
        userName.setPrefSize(200, 60);
        userName.setFont(prefFont);
       JFXButton sup = new JFXButton("Refuser Demande");
        sup.setFont(new Font("Cambria", 15));
        sup.setStyle("-fx-background-color: #494c62; ");
        sup.setTextFill(Color.web("#e8f8ff"));
        JFXButton accepter = new JFXButton("Accepter Demande");
        accepter.setFont(new Font("Cambria", 15));
        accepter.setStyle("-fx-background-color: #494c62; ");
        accepter.setTextFill(Color.web("#e8f8ff"));

        HBox.setMargin(userName, new Insets(0, 0, 0, 5));
        HBox.setMargin(userImage, new Insets(5, 0, 0, 5));
        HBox.setMargin(accepter, new Insets(10, 0, 0, 5));

        HBox.setMargin(sup, new Insets(15, 0, 0, 5));
 ObservableList<Node> childs = hBox.getChildren();
        childs.add(userImage);
        childs.add(userName);
        childs.add(sup);
        childs.add(accepter);
        accepter.setOnMouseClicked(e -> {
            p1.insertRelation(sd.getUserById(getUserId()), user);
            p.deleteDemande1(sd.getUserById(getUserId()), user);
            hBox.getChildren().clear();

            loadView("/GUI/Journal.fxml");

        });

        sup.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir refuser", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                
                            p.deleteDemande1(sd.getUserById(getUserId()), user);

                hBox.getChildren().clear();        //-------
                try {
                    //---
                    sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(profilGroupeController.class.getName()).log(Level.SEVERE, null, ex);
                }

                //---
            loadView("/GUI/Journal.fxml");
            }

        });
        
*/
        return hBox;
    }


    private void profil(MouseEvent event) {
          loadView("/GUI/Journal.fxml");

    }

      private Object loadView(String path)
    {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource((path)));
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

    @FXML
    private void Recherche(MouseEvent event) {
        
                  loadView("/GUI/RechercheProfile.fxml");

        
    }
    
}
