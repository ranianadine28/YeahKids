/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Eleve;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import org.controlsfx.control.Notifications;
import services.ServiceEleve;
import services.mail;
import static services.mail.prepareMessage;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author lotfi
 */
public class Front_EleveFXMLController implements Initializable {

    @FXML
    private TextField TextField_nom;
    @FXML
    private TextField TextField_prenom;
    @FXML
    private TextField TextField_age;
    @FXML
    private TextField TextField_idp;
    @FXML
    private Button Ajouter_eleve1;
     

    private Connection cnx;
    private PreparedStatement prepare;
    private Statement statement;
    private static int idJE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cnx = MyDB.getInstance().getConnection();
    }

    public static int getIdJE(int id) {
        idJE = id;
        return idJE;
    }

    @FXML
    private void Ajouter_eleve1(ActionEvent event) {
        if (TextField_idp.getText().isEmpty()
                | TextField_nom.getText().isEmpty()
                | TextField_prenom.getText().isEmpty()
                | TextField_age.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();

        } else if (!TextField_nom.getText().matches("^[a-zA-Z]+$")) {

            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre Nom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre Nom ");
            alert1.showAndWait();

        } else if (!TextField_prenom.getText().matches("^[a-zA-Z]+$")) {

            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre Prenom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre Prenom ");
            alert1.showAndWait();

        } else {
            String str1 = TextField_age.getText();
            String str2 = TextField_idp.getText();

            int age1 = parseInt(str1);
            int idp1 = parseInt(str2);

            ServiceEleve je = new ServiceEleve();
            Eleve el = new Eleve(1, TextField_nom.getText(), TextField_prenom.getText(), age1, idp1,idJE);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Success eleve Ajouté!");
            alert.showAndWait();

            je.ajouter(el);
            Notificationmanager(0);
            TextField_idp.setText("");
        TextField_nom.setText("");
        TextField_prenom.setText("");
        TextField_age.setText("");
           
        }
    }
        public void Notificationmanager(int mode) {
           Notifications not = Notifications.create()      
                 .graphic(null)
                 .hideAfter(Duration.seconds(10))
                 .position(Pos.BOTTOM_RIGHT)
                 .onAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle (ActionEvent event) {
             System.out.println("clicked on notification");
         }
         }) ;
           not.darkStyle();
          switch(mode) {
  case 0:
   
   not.title("Success");
                 not.text("Eleve ajouté" );
                 not.showInformation();
    break;

 default:
   
}  
           
    }
        

}
