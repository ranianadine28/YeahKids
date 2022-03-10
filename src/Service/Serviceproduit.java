/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entites.produit;
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
 * @author test
 */
public class Serviceproduit implements Service<produit> {
    
     Connection cnx;

    public Serviceproduit() {
        cnx = DB.getInstance().getConnection();
    }

    @Override
   public void ajout(produit t) {
        try {
            String req = "insert into produit  (nom,prix,quantite,image) values(?,?,?,?)";
            
                    
            PreparedStatement ps = cnx.prepareStatement(req);
              ps.setString(1, t.getNom());
            ps.setInt(2, t.getPrix());
            ps.setInt(3, t.getQuantite());
            
            File file = new File(t.getImage());

         
             FileInputStream input = new FileInputStream(file);
            
           
       ps.setBinaryStream(4,(InputStream)input,(int)file.length());
            ps.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }
    @Override
    public void modifier(produit t) {
        try {
            String req = "update produit set  prix = ? , nom = ? , quantite = ?  where id_produit = ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getPrix());
            ps.setString(2, t.getNom());
            ps.setInt(3, t.getQuantite());
            ps.setInt(4, t.getId_produit());

           
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Serviceproduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from produit where id_produit = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Serviceproduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<produit> afficher() {
        List<produit> list = new ArrayList<>();
        try {
            String req ="select * from produit";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                produit p = new produit();
                p.setId_produit(rs.getInt("id_produit"));
                p.setPrix(rs.getInt("prix"));
                p.setNom(rs.getString("nom"));
                p.setQuantite(rs.getInt("quantite"));
                p.setimg(rs.getBytes("image"));
                


                
                
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

 public List<produit> trier_desc() {
        List<produit> list = new ArrayList<>();
        try {
            String req ="select * from produit ORDER BY prix DESC ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                produit p = new produit();
                p.setId_produit(rs.getInt("id_produit"));
                p.setPrix(rs.getInt("prix"));
                p.setNom(rs.getString("nom"));
                p.setQuantite(rs.getInt("quantite"));
                p.setimg(rs.getBytes("image"));
                


                
                
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
  public List<produit> trier_asc() {
        List<produit> list = new ArrayList<>();
        try {
            String req ="select * from produit ORDER BY prix ASC ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                produit p = new produit();
                p.setId_produit(rs.getInt("id_produit"));
                p.setPrix(rs.getInt("prix"));
                p.setNom(rs.getString("nom"));
                p.setQuantite(rs.getInt("quantite"));
                p.setimg(rs.getBytes("image"));
                


                
                
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

