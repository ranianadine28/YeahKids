/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entites.livraison;
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
 * @author test
 */
public class Servicelivraison implements Service<livraison> {
    
     Connection cnx;
     
    public Servicelivraison(Connection cnx) {
        this.cnx = DB.getInstance().getConnection();
    }

    public Servicelivraison() {
               cnx = DB.getInstance().getConnection();

    }

  
@Override
    public void ajout(livraison t) {
        try {
            String req = "insert into livraison (id_produit,quantite,prix,adresse,id_parent) values"
                    + " ( '" + t.getId_produit() +" ',' "+t.getQuantite() +"',' "+t.getPrix() +"',' "+t.getAdresse() +"',' "+t.getId_parent() +"')";
            Statement st = this.cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Servicelivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(livraison t) {
        try {
            String req = "update livraison set Id_produit = ? ,Quantite = ? , prix = ? ,  = ? , adresse = ? , Id_parent= ? where Id_livraison = ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getId_produit());
            ps.setInt(2, t.getQuantite());
            ps.setInt(3, t.getPrix());
            
            ps.setString(4, t.getAdresse());
            ps.setInt(5, t.getId_parent());

            ps.executeUpdate();
           
            ps.setInt(5, t.getId_produit());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Servicelivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from livraison where id_livraison = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Servicelivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<livraison> afficher() {
        List<livraison> list = new ArrayList<>();
        try {
            String req ="select * from livraison";
            Statement st = this.cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                livraison p = new livraison();
                p.setId_livraison(rs.getInt("id_livraison"));
                p.setId_produit(rs.getInt("id_produit"));
                p.setQuantite(rs.getInt("Quantite"));
                p.setPrix(rs.getInt("Prix"));
                p.setAdresse(rs.getString("adresse"));
                p.setId_parent(rs.getInt("id_parent"));

                


                
                
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Servicelivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}