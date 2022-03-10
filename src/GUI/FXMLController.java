/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Eleve;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import org.controlsfx.control.Notifications;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import services.ServiceEleve;
import services.mail;
import static services.mail.prepareMessage;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author lotfi
 */
public class FXMLController implements Initializable {

    
    
    @FXML
    private AnchorPane AnchorPane_eleve;
    @FXML
    private TextField TextField_ide;
    @FXML
    private TextField TextField_nom;
    @FXML
    private TextField TextField_prenom;
    @FXML
    private TextField TextField_age;
    @FXML
    private TextField TextField_idp;
    @FXML
    private TextField TextField_idj;
    @FXML
    private Button Ajouter_eleve;
    @FXML
    private Button Supprimer_eleve;
    @FXML
    private Button Modifier_eleve;
    @FXML
    private TableView<Eleve> Affichage_Eleve;
    @FXML
    private TableColumn<Eleve, Integer> ide;
    @FXML
    private TableColumn<Eleve, String> nom;
    @FXML
    private TableColumn<Eleve, String> prenom;
    @FXML
    private TableColumn<Eleve, Integer> age;
    @FXML
    private TableColumn<Eleve, Integer> idp;
    @FXML
    private TableColumn<Eleve, Integer> idj;

    Connection cnx;
    @FXML
    private TextField TextField_Recherche_eleve;
    @FXML
    private Circle Button_Clear_Eleve;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cnx = MyDB.getInstance().getConnection();
        Affichage_Eleve();
        TextField_ide.setDisable(true);
        ide.setVisible(false);
    }

    @FXML
    private void Ajouter_eleve(ActionEvent event) {

        if (TextField_nom.getText().isEmpty()
                | TextField_prenom.getText().isEmpty()
                | TextField_age.getText().isEmpty()
                | TextField_idp.getText().isEmpty()
                | TextField_idj.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();

        } 
        else{
        
      
        if(!TextField_nom.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre Nom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre Nom ");
            alert1.showAndWait();
         
         
         }
        else{
        if(!TextField_prenom.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre Prenom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre Prenom ");
            alert1.showAndWait();
         
         
         }else{
         String str1 = TextField_age.getText();
            String str2 = TextField_idp.getText();
            String str3 = TextField_idj.getText();
            int age1 = parseInt(str1);
            int idp1 = parseInt(str2);
            int idj1 = parseInt(str3);

            ServiceEleve je = new ServiceEleve();
            Eleve el = new Eleve(1, TextField_nom.getText(), TextField_prenom.getText(), age1, idp1, idj1);
            
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Success eleve Ajouté!");
            alert.showAndWait();

            
            
            je.ajouter(el);
            String txt = "eleve ajouter ";
        String sub = "Ajouter avec succes";
        String destinataire = "lotfica92@gmail.com";
        mail m = new mail(txt,sub,destinataire);   
        Message msg = prepareMessage(m.getSession(),m.getMail(),destinataire,txt,sub);
        System.out.println(msg);
            try {
                Transport.send(msg);
            } catch (MessagingException ex) {
              //  Logger.getLogger(.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("MAIL ENVOYEE");
            
            
            
            
            Notificationmanager(0);
            
            Affichage_Eleve();
            clear();
        
        
        
        }
         
        }}
                

             
        

    }

    @FXML
    private void Supprimer_eleve(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez vous supprimer eleve ?");

            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.OK) {

                ServiceEleve je = new ServiceEleve();
                String ide1 = TextField_ide.getText();
                je.supprimer(parseInt(ide1));

            } else {

                return;

            }
Notificationmanager(1);
            Affichage_Eleve();
            clear();
    }

    @FXML
    private void Modifier_eleve(ActionEvent event) {

        if (TextField_nom.getText().isEmpty()
                | TextField_prenom.getText().isEmpty()
                | TextField_age.getText().isEmpty()
                | TextField_idp.getText().isEmpty()
                | TextField_idj.getText().isEmpty()) 

        
        {Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();}
        
        else{
        if(!TextField_nom.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre Nom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre Nom ");
            alert1.showAndWait();
            
            
         }
         
         
        else{
        if(!TextField_prenom.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre Prenom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre Prenom ");
            alert1.showAndWait();
         
         
         }
        
        
        
        else {

            String str1 = TextField_age.getText();
            String str2 = TextField_idp.getText();
            String str3 = TextField_idj.getText();
            String str4 = TextField_ide.getText();
            int age1 = parseInt(str1);
            int idp1 = parseInt(str2);
            int idj1 = parseInt(str3);
            int ide1 = parseInt(str4);

            
            
            
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez vous modifier eleve ?");

            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.OK) {

               ServiceEleve je = new ServiceEleve();
            Eleve el = new Eleve(ide1, TextField_nom.getText(), TextField_prenom.getText(), age1, idp1, idj1);
            je.modifier(el);
            Notificationmanager(2);

            } else {

                return;

            }
            

   



            Affichage_Eleve();
            clear();

        }
        
    }}}

    @FXML
    private void Affichage_Eleve() {

        ObservableList<Eleve> EleveList = EleveList();

        ide.setCellValueFactory(new PropertyValueFactory<>("ide"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        idp.setCellValueFactory(new PropertyValueFactory<>("idp"));
        idj.setCellValueFactory(new PropertyValueFactory<>("idj"));

        Affichage_Eleve.setItems(EleveList);
        
        FilteredList<Eleve> filteredData = new FilteredList<>(EleveList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        TextField_Recherche_eleve.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eleve -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (eleve.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (eleve.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                else if (String.valueOf(eleve.getAge()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                else if (String.valueOf(eleve.getIdp()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                else if (String.valueOf(eleve.getIdj()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                
                else {
                    return false;
                }
            });
        });

        SortedList<Eleve> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(Affichage_Eleve.comparatorProperty());
        Affichage_Eleve.setItems(sortedData);

    }
     public void Notificationmanager(int mode )
     
     {
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
                 not.text("Ajout terminer" );
                 not.showInformation();
    break;
  case 1:
    
    not.title("Success ");
                 not.text("Suppression terminer");
                 not.showWarning();
    break;
    case 2:
     
                 not.text("Modification terminer");
                 not.title("Success");
                 not.showInformation();
    break;

  default:
   
}  
           
    }


    public ObservableList<Eleve> EleveList() {

        cnx = MyDB.getInstance().getConnection();

        ObservableList<Eleve> EleveList = FXCollections.observableArrayList();

        String req = "SELECT * FROM Eleve";

        try {

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            Eleve eleve;

            while (rs.next()) {

                eleve = new Eleve(rs.getInt("ide"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("age"), rs.getInt("idp"), rs.getInt("idj"));

                EleveList.add(eleve);

            }

        } catch (SQLException e) {
        }

        return EleveList;

    }

    @FXML
    public void clear() {

        TextField_ide.setText("");
        TextField_nom.setText("");
        TextField_prenom.setText("");
        TextField_age.setText("");
        TextField_idp.setText("");
        TextField_idj.setText("");

    }
    
    @FXML
    public void selectEleve() {

        Eleve eleve = Affichage_Eleve.getSelectionModel().getSelectedItem();

        int num = Affichage_Eleve.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        TextField_ide.setText(String.valueOf(eleve.getIde()));
        TextField_nom.setText(eleve.getNom());
        TextField_prenom.setText(eleve.getPrenom());
        TextField_age.setText(String.valueOf(eleve.getAge()));
        TextField_idp.setText(String.valueOf(eleve.getIdp()));
        TextField_idj.setText(String.valueOf(eleve.getIdj()));

    }

   
    }


