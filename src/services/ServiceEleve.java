/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Eleve;
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
public class ServiceEleve implements EleveService<Eleve>{
    Connection cnx;
    public ServiceEleve() {
        cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Eleve je) {
        try {
            String req = "insert into eleve (nom,prenom,age,idp,idj) values"
                    + " ( '" + je.getNom() + "', '" + je.getPrenom() + "','" + je.getAge() + "','" + je.getIdp() + "','" + je.getIdj() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Eleve je) {
        try {
            String req = "update Eleve set  nom = ? , prenom = ? , age = ? , idp = ? , idj = ?  where ide = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, je.getNom());
            ps.setString(2, je.getPrenom());
            ps.setInt(3, je.getAge());
             ps.setInt(4, je.getIdp());
             ps.setInt(5, je.getIdj());

              ps.setInt(6, je.getIde());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int ide) {
       try {
            String req = "delete from eleve where ide = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, ide);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Eleve> afficher() {
        List<Eleve> list = new ArrayList<>();
        try {
            String req ="select * from Eleve";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Eleve jn = new Eleve();
                jn.setIde(rs.getInt(1));
                jn.setNom(rs.getString("nom"));
                jn.setPrenom(rs.getString("prenom"));
                jn.setAge(rs.getInt("age"));
                jn.setidp(rs.getInt("idp"));
                jn.setidj(rs.getInt("idj"));
                list.add(jn);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJardinEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
    
}

