/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entites.reclamation;
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


public class servicereclamation implements Service<reclamation>{
    Connection cnx;

    public servicereclamation() {
        cnx = DB.getInstance().getConnection();
    }

    @Override
    public void ajout(reclamation t) {
        try {
            String req = "insert into reclamation (id_parent,contenu) values"
                    + " ( '"+t.get_idparent() +" ',' "+t.get_contenu() +"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(reclamation t) {
        try {
            String req = "update reclamation set contenu = ?  where id_reclamation = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.get_contenu());
           
            ps.setInt(2, t.get_id());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from reclamation where id_reclamation = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            } 
        catch (SQLException ex) {
            Logger.getLogger(servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<reclamation> afficher() {
        List<reclamation> list = new ArrayList<>();
        try {
            String req ="select * from reclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                reclamation p = new reclamation();
                p.set_idparent(rs.getInt("id_parent"));
                p.set_contenu(rs.getString("contenu"));
                


                
                
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
