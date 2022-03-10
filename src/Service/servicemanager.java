/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entites.manager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DB;
/**
 *
 * @author fedi
 */


public class servicemanager implements Service<manager>{
    Connection cnx;

    public servicemanager() {
        cnx = DB.getInstance().getConnection();
    }

    @Override
    public void ajout(manager t) {
     try {
            String req = "insert into parent (prenom,nom,email,login,mdp,image) values(?,?,?,?,?,?)";
            
                    
            PreparedStatement ps = cnx.prepareStatement(req);
              ps.setString(1, t.getPrenom());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getlogin());
            ps.setString(5, t.getmdp());
            File file = new File(t.getimage());

         
             FileInputStream input = new FileInputStream(file);
            
           
       ps.setBinaryStream(6,(InputStream)input,(int)file.length());
            ps.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public void modifier(manager t) {
        try {
            String req = "update manager set prenom = ? , nom = ? , email = ? ,login = ? , mdp = ?,image = ? where id_manager = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getPrenom());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getlogin());
            ps.setString(5, t.getmdp());
            ps.setString(6, t.getimage());
            ps.setInt(7, t.getId_manager());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(servicemanager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from manager where id_manager = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(servicemanager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<manager> afficher() {
        List<manager> list = new ArrayList<>();
        try {
            String req ="select * from manager";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                manager p = new manager();
                p.setId_manager(rs.getInt("id_manager"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setmdp(rs.getString("mdp"));
                p.setlogin(rs.getString("login"));
                p.setimg(rs.getBytes("image"));

                
                
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(servicemanager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
public manager recherche(String mdp,String login) {
                manager p = new manager();
                            boolean test=false; 

    
    try 
        {
            String req ="select * from manager WHERE (mdp=? and login=? ) ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, mdp);
            ps.setString(2, login);
            
            ResultSet rs = ps.executeQuery();

            
            while(rs.next()){
                
                p.setId_manager(rs.getInt("id_manager"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setmdp(rs.getString("mdp"));
                p.setlogin(rs.getString("login"));
                p.setimg(rs.getBytes("image"));
                test=true;
                break;
                
                
                
                
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if ( test==false){
        return null;
        }
        else 
            return p;
    }
}
