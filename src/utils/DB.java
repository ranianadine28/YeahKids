/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fedi
 */
public class DB {
    
    private String url ="jdbc:mysql://localhost/esprit"; // :3306 (port mysql)
    private String user ="root";
    private String pass ="";
    private Connection connection;
    static DB instance;
    
    private DB(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static DB getInstance(){
        if(instance == null)
            instance = new DB();
       return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
}
