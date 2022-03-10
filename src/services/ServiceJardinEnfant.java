/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.JardinEnfant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author lotfi
 */
public class ServiceJardinEnfant implements jardenfantService<JardinEnfant>{
    Connection cnx;
    public ServiceJardinEnfant() {
        cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(JardinEnfant je) {
        try {
            String req = "insert into jardinenfant (nom,description,logo,nb_employes,adresse,date_creation,prix,telephone) values"
                    + " (  '" + je.getNom() + "', '" + je.getDescription() + "','" + je.getLogo() + "','" + je.getNb_employes() + "','" + je.getAdresse() + "','" + je.getDate_creation() + "','" + je.getPrix() + "','" + je.getTelephone() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJardinEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(JardinEnfant je) {
        try {
            String req = "update jardinenfant set  nom = ? , description = ? , logo = ? , nb_employes = ? , adresse = ? , date_creation = ? , prix = ? , telephone = ? where idj = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, je.getNom());
            ps.setString(2, je.getDescription());
            ps.setString(3, je.getLogo());
             ps.setInt(4, je.getNb_employes());
              ps.setString(5, je.getAdresse());
               ps.setDate(6, je.getDate_creation());
                ps.setFloat(7, je.getPrix());
                 ps.setInt(8, je.getTelephone());
            
            
            ps.setInt(9, je.getIdj());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJardinEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
       try {
            String req = "delete from jardinenfant where idj = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJardinEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<JardinEnfant> afficher() {
        List<JardinEnfant> list = new ArrayList<>();
        try {
            String req ="select * from JardinEnfant";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                JardinEnfant jn = new JardinEnfant();
                jn.setIdj(rs.getInt(1));
                jn.setNom(rs.getString("nom"));
                jn.setDescription(rs.getString("Description"));
                jn.setLogo(rs.getString("Logo"));
                jn.setNb_employes(rs.getInt("Nb_employes"));
                jn.setAdresse(rs.getString("Adresse"));
                jn.setDate_creation(rs.getDate("Date_creation"));
                jn.setPrix(rs.getFloat("Prix"));
                jn.setTelephone(rs.getInt("Telephone"));
                list.add(jn);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJardinEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
