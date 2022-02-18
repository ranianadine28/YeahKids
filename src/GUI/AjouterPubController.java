/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Publication;
import Service.PublicationService;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author rania
 */
public class AjouterPubController implements Initializable {

    private final PublicationService ps = new PublicationService();
    FileChooser saveFileChooser = new FileChooser();
    File saveFile;
    File srcFile, destFile;
    @FXML
    private AnchorPane ajouteventpane;
    @FXML
    private TextField titree;
    @FXML
    private TextArea descriptionn;
    @FXML
    private JFXButton Image;
    @FXML
    private Label alertetitre;
    @FXML
    private Label alertedescription;
    @FXML
    private JFXButton retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        Publication p =new Publication( srcFile.getName(), titree.getText(), descriptionn.getText());
        ps.insertPub(p);
    }

    @FXML
    private void retourclicked(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

}
