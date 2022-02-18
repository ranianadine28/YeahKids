/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Service.EventService;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author rania
 */
public class AjouterEvent1Controller implements Initializable {
private final EventService es = new EventService();
    FileChooser saveFileChooser = new FileChooser();
    File saveFile;
    File srcFile, destFile;
    @FXML
    private AnchorPane ajouteventpane;
    
    @FXML
    private TextField titree;
    @FXML
    private DatePicker dateEvenement;
    @FXML
    private TextArea descriptionn;
    @FXML
    private JFXButton Image;
    @FXML
    private Label alertetitre;
    @FXML
    private Label alertetypeevent;
    @FXML
    private Label alertedescription;
    @FXML
    private Label alertedatedebut;
    
    @FXML
    private JFXButton retour;
    @FXML
    private DatePicker datefinn;
    @FXML
    private TextField adr;
    @FXML
    private TextField prixx;
    @FXML
    private TextField nbreplace;
    @FXML
    private Label alertedatefin;
    @FXML
    private Label alertenbreplace;
    @FXML
    private Label alertelieu;
    @FXML
    private Label alerteprix;
     private String typeEventt="";
    @FXML
    private RadioButton culturelle;
    @FXML
    private RadioButton aventure;
    @FXML
    private RadioButton sport;
    
    @FXML
    private Label alerteprixennombre;
    @FXML
    private Label alertenbreplacennombre1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 // This DatePicker is shown to user
DatePicker maxDate = new DatePicker(); // DatePicker, used to define max date available, you can also create another for minimum date
maxDate.setValue(LocalDate.now()); // Max date available will be 2015-01-01
final Callback<DatePicker, DateCell> dayCellFactory;

dayCellFactory = (final DatePicker datePicker) -> new DateCell() {
    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (item.isBefore(maxDate.getValue())) { //Disable all dates after required date
            setDisable(true);
            setStyle("-fx-background-color: #7f7a7a;"); //To set background on different color
        }
    }
};

dateEvenement.setDayCellFactory(dayCellFactory);
         //assert btn_ajouter != null : "fx:id=\"btn_ajouter\" was not injected: check your FXML file 'Item.fxml'.";
    DatePicker maxDatefin = new DatePicker();
    
 
// DatePicker, used to define max date available, you can also create another for minimum date
        
        // TODO
         
    }    

    @FXML
    private void UploadImage(ActionEvent event) {
              File file = saveFileChooser.showOpenDialog(null);
        if (file != null) {
            srcFile = file;
            if (srcFile != null) {
                try {
                    String p = System.getProperty("user.dir") + "/src/images/" + srcFile.getName();
                    copyFile(srcFile, new File(p));
                } catch (IOException ex) {
                    Logger.getLogger(AjouterEvent1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        try (
                FileChannel in = new FileInputStream(sourceFile).getChannel();
                FileChannel out = new FileOutputStream(destFile).getChannel();) {

            out.transferFrom(in, 0, in.size());
        }
    }

       

    @FXML
    private void ajouter(ActionEvent event) {
        
        
        
        if(aventure.isSelected())
                    {
                        typeEventt="Aventure";
                       
                        
                    }
            if(sport.isSelected())
            {
                        typeEventt="Sport";
                        
                    }
            if(culturelle.isSelected())
            {
                        typeEventt="Culturelle";
                        
                    }
  
        
            //datedebut
            LocalDate localDateDebut = dateEvenement.getValue();
            Instant instant = Instant.from(localDateDebut.atStartOfDay(ZoneId.systemDefault()));
            java.util.Date date = Date.from(instant);
            java.sql.Date dtdebut = new java.sql.Date(date.getTime());
            //datefin
             LocalDate localDateFin = datefinn.getValue();
            Instant instant1 = Instant.from(localDateFin.atStartOfDay(ZoneId.systemDefault()));
            java.util.Date datefin = Date.from(instant1);
            java.sql.Date dtfin = new java.sql.Date(datefin.getTime());
            Event e = new Event(titree.getText(), typeEventt, dtdebut,  dtfin,adr.getText(), Integer.valueOf(nbreplace.getText()),descriptionn.getText(),srcFile.getName(),   Integer.valueOf(prixx.getText()));
            e.setIdUser(1);
            es.insertEvenement(e);
      
            nbreplace.setText(null);
            titree.setText(null);
            descriptionn.setText(null);
          //  typeEventt.setText(null);
            dateEvenement.getEditor().setText(null);
            datefinn.getEditor().setText(null);
            adr.setText(null);
            prixx.setText(null);

         
    }
    public boolean ValidateFields() {

        int alertetitre1 = 0, alertetypeevent1 = 0, alertedescription1 = 0 , alertedatedebut1 = 0 , alertenbreplace1 = 0, alertelieu1 = 0, alertedatefin1 =0,alerteprix1 =0 ;

        if (titree.getText().isEmpty()) {
            /*alertetitre1 = 1;
            alertetitre.setVisible(true);*/
            titree.setStyle("-fx-border-color: rgb(192,0,0);");
        } else {
            //alertetitre.setVisible(false);
            titree.setStyle("-fx-border-color: none;");
        }
       
       
        if(nbreplace.getText().isEmpty())
      {/*alertenbreplace1 = 1;
            alertenbreplace.setVisible(true);*/
          nbreplace.setStyle("-fx-border-color: rgb(192,0,0);");
          
      }
    
    else{
    nbreplace.setStyle("-fx-border-color: none;");
    //alertenbreplace.setVisible(false);
        }
         if(descriptionn.getText().isEmpty())
      {/*alertedescription1 = 1;
            alertedescription.setVisible(true);*/
          descriptionn.setStyle("-fx-border-color: rgb(192,0,0);");
          
      }
    
    else{
    descriptionn.setStyle("-fx-border-color: none;");
   // alertedescription.setVisible(false);
        }
         
     
        if (adr.getText().isEmpty()) {
           /* alertelieu1 = 1;
            alertelieu.setVisible(true);*/
            adr.setStyle("-fx-border-color: rgb(192,0,0);");
        } else {
           // alertelieu.setVisible(false);
            adr.setStyle("-fx-border-color: none;");
        }
        if (prixx.getText().isEmpty()) {
           /* alerteprix1 = 1;
            alerteprix.setVisible(true);*/
            prixx.setStyle("-fx-border-color: rgb(192,0,0);");
        } else {
           // alerteprix.setVisible(false);
            prixx.setStyle("-fx-border-color: none;");
        }
        
        //test date fin
        if ((this.datefinn.getEditor().getText().isEmpty()) ) {
           /* alertedatefin1 = 1 ;
         alertedatefin.setVisible(true);*/
            datefinn.setStyle("-fx-border-color: rgb(192,0,0);");
             } else {
           // alertedatefin.setVisible(false);
            datefinn.setStyle("-fx-border-color: none;");
        }
         
        
        
        //teste date debut
        if (this.dateEvenement.getEditor().getText().isEmpty()) {
            /* alertedatedebut1 = 1;
            alertedatedebut.setVisible(true);*/
             dateEvenement.setStyle("-fx-border-color: rgb(192,0,0);");
             }
            
            else {
            /*alertedatedebut1 = 1;
            alertedatedebut.setVisible(false);*/
            dateEvenement.setStyle("-fx-border-color: none;");
            
        
        }
return (true);      

    }
   

    @FXML
    private void retourclicked(ActionEvent event) throws IOException {
         System.out.println("test");
        ajouteventpane.getChildren().clear();
       ajouteventpane.getChildren().add(new FXMLLoader().load(getClass().getResource("/GUI/ListeEvent.fxml")));
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        System.out.println("test");
           nbreplace.setText(null);
            titree.setText(null);
            descriptionn.setText(null);
            dateEvenement.getEditor().setText(null);
            datefinn.getEditor().setText(null);
            adr.setText(null);
            prixx.setText(null);
    }

    @FXML
    private void changedCulture(ActionEvent event) {
        culturelle.setSelected(true);
        aventure.setSelected(false);
        sport.setSelected(false);
        
    }

    @FXML
    private void changedSport(ActionEvent event) {
        culturelle.setSelected(false);
        aventure.setSelected(false);
        sport.setSelected(true);
    }

    @FXML
    private void changedAventure(ActionEvent event) {
        culturelle.setSelected(false);
        aventure.setSelected(true);
        sport.setSelected(false);
    }

    @FXML
    private void setdatedebut(ActionEvent event) {
        DatePicker maxDatefin = new DatePicker();
    
LocalDate localDatedebut = dateEvenement.getValue();

   maxDatefin.setValue(localDatedebut);

final Callback<DatePicker, DateCell> dayCellFactoryfin;
dayCellFactoryfin = (final DatePicker datePicker) -> new DateCell() {
    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (item.isBefore(maxDatefin.getValue())) { //Disable all dates after required date
            setDisable(true);
            setStyle("-fx-background-color: #7f7a7a;"); //To set background on different color
        }
    }
};

datefinn.setDayCellFactory(dayCellFactoryfin);
        
    }

    @FXML
    private void numeriquePrix(ActionEvent event) {
        UnaryOperator<Change> integerFilter = change -> {
    String input = change.getText();
    if (input.matches("[0-9]*")) { 
        return change;
    }
        
    return null;
};

   prixx.setTextFormatter(new TextFormatter<>(integerFilter));
    }

    @FXML
    private void numerique(ActionEvent event) {
         UnaryOperator<Change> integerFilter = change -> {
    String input = change.getText();
    if (input.matches("[0-9]*")) { 
        return change;
    }
        
    return null;
};

   nbreplace.setTextFormatter(new TextFormatter<>(integerFilter));
    }

    
    
}
