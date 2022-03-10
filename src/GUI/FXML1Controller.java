/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.JardinEnfant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.util.Duration;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import org.controlsfx.control.Notifications;
import services.ServiceJardinEnfant;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author lotfi
 */
public class FXML1Controller implements Initializable {

      @FXML
    private AnchorPane AnchorPane_jardin_enfant;
    @FXML
    private TextField TextField_idj31;
    @FXML
    private TextField TextField_nom3;
    @FXML
    private TextField TextField_description;
    @FXML
    private TextField TextField_logo;
     @FXML
    private TextField TextField_nb_employes;
    @FXML
    private TextField TextField_adresse;
    @FXML
    private DatePicker DatePicker_date_creation;
    @FXML
    private TextField TextField_prix;
    @FXML
    private TextField TextField_telephone;
    @FXML
    private Button Ajouter_jardin;
    @FXML
    private Button Supprimer_jardin;
    @FXML
    private Button Modifier_jardin;
    @FXML
    private TableView<JardinEnfant> Affichage_Jardin_Enfant;
    @FXML
    private TableColumn<JardinEnfant, Integer> idj;
    @FXML
    private TableColumn<JardinEnfant, String> nom;
    @FXML
    private TableColumn<JardinEnfant, String> description;
    @FXML
    private TableColumn<JardinEnfant, String> logo;
    @FXML
    private TableColumn<JardinEnfant, Integer> nb_employes;
    @FXML
    private TableColumn<JardinEnfant, String> adresse;
        @FXML
    private TableColumn<JardinEnfant, Date> date_creation;
    @FXML
    private TableColumn<JardinEnfant, Float> prix;
    @FXML
    private TableColumn<JardinEnfant, Integer> telephone;
@FXML
        ImageView imageview;
    Connection cnx;
    @FXML
    private Circle Button_Clear_Jardin_Enfant;
    @FXML
    private TextField TextField_Recherche_jardin_enfant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cnx = MyDB.getInstance().getConnection();
        Affichage_Jardin_Enfant();
        TextField_idj31.setDisable(true);
        
        idj.setVisible(false);
    }

    @FXML
    private void Ajouter_jardin(ActionEvent event) {

        if (TextField_nom3.getText().isEmpty()
                | TextField_description.getText().isEmpty()
                | TextField_logo.getText().isEmpty()
                | TextField_nb_employes.getText().isEmpty()
                | TextField_adresse.getText().isEmpty()
                | DatePicker_date_creation.getEditor().getText().isEmpty() 
                | TextField_prix.getText().isEmpty()
                | TextField_telephone.getText().isEmpty() )
        
        {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();

        }
        
        else{
        
        if(!TextField_nom3.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider le Nom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier le Nom ");
            alert1.showAndWait();
         
         
         }
        
        else{
        
        if(!TextField_description.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider la description");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier la description ");
            alert1.showAndWait();
         
         
         }
        
        else{
        
        if(!TextField_nb_employes.getText().matches("^([1-9][0-9]{0,10}|1000)$")){    
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Valider le nombre demployes");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez verifier le nombre demployes ");
            alert.showAndWait();}
        
        
        else{
        if (!TextField_adresse.getText().matches("^[a-zA-Z]+$")) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre adresse");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre adresse ");
            alert1.showAndWait();  }
        
        
        else{
        
        if(!TextField_telephone.getText().matches("^([1-9][0-9]{0,10}|1000)$")){    
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Valider le numéro de téléphone");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez verifier que les chiffres qui composent le numéro soient entre 1 et 9 ");
            alert.showAndWait();}
        else {
            
            
            String str7;
            str7 = DatePicker_date_creation.getValue().toString();

           
            String str5 = TextField_nb_employes.getText();
            String str6 = TextField_telephone.getText();
            String str8 = TextField_prix.getText();
    
            int nb_employes1 = parseInt(str5);
            int telephone1 = parseInt(str6);
            Date date1 = Date.valueOf(str7);
            float prix1= Float.valueOf(str8);
            
            ServiceJardinEnfant je = new ServiceJardinEnfant();
            JardinEnfant e2 = new JardinEnfant(1, TextField_nom3.getText(), TextField_description.getText(),TextField_logo.getText(), nb_employes1,TextField_adresse.getText(),date1,prix1, telephone1);
            je.ajouter(e2);
            Notificationmanager(0);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Success jardin enfant Ajouté!");
            alert.showAndWait();

            Affichage_Jardin_Enfant();
            clear();
        }

    }
        }
    }
        } 
    }
}
        
    @FXML
    private void Supprimer_jardin(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez vous supprimer cette jardin?");

            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.OK) {

                ServiceJardinEnfant je = new ServiceJardinEnfant();
                String ide1 = TextField_idj31.getText();
                je.supprimer(parseInt(ide1));

            } else {

                return;

            }
Notificationmanager(1);
            Affichage_Jardin_Enfant();
            clear();
    }

    @FXML
    private void Modifier_jardin(ActionEvent event) {

        if (TextField_nom3.getText().isEmpty()
                | TextField_description.getText().isEmpty()
                | TextField_logo.getText().isEmpty()
                | TextField_nb_employes.getText().isEmpty()
                | TextField_adresse.getText().isEmpty()
                | DatePicker_date_creation.getValue().toString().isEmpty()
                | TextField_prix.getText().isEmpty()
                | TextField_telephone.getText().isEmpty() ) {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();

        }  else{
        
        if(!TextField_nom3.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre Nom");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre Nom ");
            alert1.showAndWait();
         
         
         }
        
        
        
        
        else{
        
        if(!TextField_description.getText().matches("^[a-zA-Z]+$") )
         {
             
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider la description");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier la description ");
            alert1.showAndWait();
         
         
         }
        
        else{
        
        if(!TextField_nb_employes.getText().matches("^([1-9][0-9]{0,10}|1000)$")){    
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Valider le nombre demployes");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez verifier le nombre demployes ");
            alert.showAndWait();}
        
        
        
        else{
        if (!TextField_adresse.getText().matches("^[a-zA-Z]+$")) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider votre adresse");
            alert1.setHeaderText(null);
            alert1.setContentText("Merci de bien vouloir vérifier votre adresse ");
            alert1.showAndWait();  }
        
        
        else{
        
        if(!TextField_telephone.getText().matches("^([1-9][0-9]{0,10}|1000)$")){    
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Valider le numéro de téléphone");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez verifier que les chiffres qui composent le numéro soient entre 1 et 9 ");
            alert.showAndWait();}
        else {

             String str7;
            str7 = DatePicker_date_creation.getValue().toString();

           
            String str5 = TextField_nb_employes.getText();
            String str6 = TextField_telephone.getText();
            String str8 = TextField_prix.getText();
    
            int nb_employes1 = parseInt(str5);
            int telephone1 = parseInt(str6);
            Date date1 = Date.valueOf(str7);
            float prix1 = Float.valueOf(str8);
            int id_j = parseInt(TextField_idj31.getText());
            
            
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez vous modifier cette jardin ?");

            Optional<ButtonType> buttonType = alert.showAndWait();
            
             if (buttonType.get() == ButtonType.OK) {

               ServiceJardinEnfant je = new ServiceJardinEnfant();
            JardinEnfant el = new JardinEnfant(id_j, TextField_nom3.getText(), TextField_description.getText(),TextField_logo.getText(), nb_employes1,TextField_adresse.getText(),date1,prix1 , telephone1);
            je.modifier(el);
            Notificationmanager(2);

            } else {

                return;

            }
           

            Affichage_Jardin_Enfant();
            clear();

        }
        }}}
    }
        }}

    @FXML
    private void Affichage_Jardin_Enfant() {

        ObservableList<JardinEnfant> JardinEnfantList = JardinEnfantList();

        idj.setCellValueFactory(new PropertyValueFactory<>("idj"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        logo.setCellValueFactory(new PropertyValueFactory<>("logo"));
        nb_employes.setCellValueFactory(new PropertyValueFactory<>("nb_employes"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        date_creation.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        
        
        
        

        Affichage_Jardin_Enfant.setItems(JardinEnfantList);

         FilteredList<JardinEnfant> filteredData = new FilteredList<>(JardinEnfantList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        TextField_Recherche_jardin_enfant.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(JardinEnfant -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                
                String lowerCaseFilter = newValue.toLowerCase();

                if (JardinEnfant.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }
                else
                if (JardinEnfant.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }
                
                else if (String.valueOf(JardinEnfant.getIdj()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                
                 else if (String.valueOf(JardinEnfant.getNb_employes()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                 
                 else if (String.valueOf(JardinEnfant.getPrix()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                 else if (String.valueOf(JardinEnfant.getTelephone()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                else {
                    return false;
                }
            });
        });

        SortedList<JardinEnfant> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(Affichage_Jardin_Enfant.comparatorProperty());
        Affichage_Jardin_Enfant.setItems(sortedData);
        
        
        
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


    public ObservableList<JardinEnfant> JardinEnfantList() {

        cnx = MyDB.getInstance().getConnection();

        ObservableList<JardinEnfant> JardinEnfantList = FXCollections.observableArrayList();

        String req = "SELECT * FROM JardinEnfant";

        try {

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            JardinEnfant JardinEnfant;

            while (rs.next()) {

                JardinEnfant = new JardinEnfant(rs.getInt("idj"), rs.getString("nom"), rs.getString("description"), rs.getString("logo"), rs.getInt("nb_employes"), rs.getString("adresse"), rs.getDate("date_creation"), rs.getFloat("prix"), rs.getInt("telephone"));

                
   

                JardinEnfantList.add(JardinEnfant);

            }

        } catch (SQLException e) {
        }

        return JardinEnfantList;

    }

    @FXML
    public void clear() {

        TextField_idj31.setText("");
        TextField_nom3.setText("");
        TextField_description.setText("");
        TextField_logo.setText("");
        TextField_nb_employes.setText("");
        TextField_adresse.setText("");
        DatePicker_date_creation.getEditor().setText("");
        TextField_prix.setText("");
        TextField_telephone.setText("");

    }
    
    @FXML
    public void selectJardinEnfant() {

        JardinEnfant JardinEnfant = Affichage_Jardin_Enfant.getSelectionModel().getSelectedItem();

        int num = Affichage_Jardin_Enfant.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        TextField_idj31.setText(String.valueOf(JardinEnfant.getIdj()));
        TextField_nom3.setText(JardinEnfant.getNom());
        TextField_description.setText(JardinEnfant.getDescription());
        TextField_logo.setText(String.valueOf(JardinEnfant.getLogo()));
        TextField_nb_employes.setText(String.valueOf(JardinEnfant.getNb_employes()));
        TextField_adresse.setText(String.valueOf(JardinEnfant.getAdresse()));
        DatePicker_date_creation.getEditor().setText(String.valueOf(JardinEnfant.getDate_creation()));
        TextField_prix.setText(String.valueOf(JardinEnfant.getPrix()));
        TextField_telephone.setText(String.valueOf(JardinEnfant.getTelephone()));

    }


 @FXML 
private void selectfile(ActionEvent event) throws FileNotFoundException {
 FileChooser fc = new FileChooser();
 FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");

 fc.getExtensionFilters().add(extFilter);
 File f=fc.showOpenDialog(null);
 if(f!=null){
     System.out.print(f.getAbsolutePath());
      TextField_logo.setText(f.getAbsolutePath());
     /*
      InputStream stream = new FileInputStream(f);
     Image image = new Image(stream) ;
     imageview.setImage(image);
*/


 
 }
}
    

}