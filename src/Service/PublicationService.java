/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Publication;
import IService.IPublicationService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author rania
 */
public class PublicationService implements IPublicationService {

    private Connection con = DataSource.getInstance().getConnection();

    @Override
    public Publication insertPub(Publication p) {
        try {

            String query = "INSERT INTO `publication`(id_user,image,titre,description,nb_like,nb_dislike) VALUES(?,?,?,?,?,?)";
            PreparedStatement prs = con.prepareStatement(query);

            prs.setInt(1, 1);

            prs.setString(2, p.getImage());
            prs.setString(3, p.getTitre());
            prs.setString(4, p.getDescription());

            prs.setInt(5, 0);

            prs.setInt(6, 0);

            int id = prs.executeUpdate();
            p.setId(id);
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
