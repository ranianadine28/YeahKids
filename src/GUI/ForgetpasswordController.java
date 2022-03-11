/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.PasswordUtils;
import Service.SendMailSSL;
import Service.serviceadmin;
import Service.servicemanager;
import Service.serviceparent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author fedi
 */

public class ForgetpasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField email;
    @FXML
    TextField responde;
    @FXML
    Label question;
    
    
    
    String repon;
    String login;
    String utilisateur;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
public void setinformation(String ques,String responde,String login,String utilisateur) {
        question.setText(ques);
        this.repon=responde;
        this.login=login;
        this.utilisateur=utilisateur;

        }
@FXML
private void sendmail(ActionEvent event){
         
        
        
       
                        System.out.print(responde.getText());

    if(repon.equals(responde.getText())){
                          System.out.print("fuck you");

        String password=SendMailSSL.generateRandomPassword(8);
        String salt = PasswordUtils.getSalt(30);
        String securePassword = PasswordUtils.generateSecurePassword(password, salt);
        

        if(utilisateur.equals("parent")){
        serviceparent sp= new serviceparent();
        sp.modifier_mdp(this.login,securePassword,salt);
       String msg="this is you new password:"+password+"\n welcome back"+utilisateur;
        SendMailSSL.send(email.getText(),"Change Password" , msg);
        
        
        }
        if(utilisateur.equals("manager")){
        servicemanager sp= new servicemanager();
        sp.modifier_mdp(login,securePassword,salt);
        
        
        }
        if(utilisateur.equals("admin")){
        serviceadmin sp= new serviceadmin();
        sp.modifier_mdp(login,securePassword,salt);
        
        
        }
        
        
    }
    else{
            System.out.print("3asba");
        }
    
    
}
    
   
    
    
}
