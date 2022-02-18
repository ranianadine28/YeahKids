/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Event;
import IService.IEventService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author rania
 */
public class EventService implements IEventService{

    private Connection con = DataSource.getInstance().getConnection();

    @Override
    public Event getEvenementById(int id) {
        try {
            String query = "select * from event where id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Event evenement;
            while (rs.next()) {
                evenement = new Event(rs.getInt("id"), rs.getInt("id_user"), rs.getString("event"), rs.getString("Type"), rs.getDate("date_debut_event"), rs.getDate("date_fin_event"), rs.getString("lieu_event"), rs.getInt("capacite_event"), rs.getString("description_event"), rs.getString("logo"), rs.getInt("prix_event"));
                return evenement;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Event getEvenementByAventure(String s) {
        try {
            String query = "select * from event where type = 'Aventure'";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            Event evenement;
            while (rs.next()) {
                evenement = new Event(rs.getInt("id"), rs.getInt("id_user"), rs.getString("event"), rs.getString("Type"), rs.getDate("date_debut_event"), rs.getDate("date_fin_event"), rs.getString("lieu_event"), rs.getInt("capacite_event"), rs.getString("description_event"), rs.getString("logo"), rs.getInt("prix_event"));
                return evenement;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Event insertEvenement(Event e) {
        try {

            String query = "INSERT INTO `event`(id_user,event,Type,date_debut_event,date_fin_event,lieu_event,capacite_event,description_event,logo,prix_event) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prs = con.prepareStatement(query);

            prs.setInt(1, e.getIdUser());

            prs.setString(2, e.getNomEvent());
            prs.setString(3, e.getTypeEvent());
            prs.setDate(4, e.getDateDebutEvent());
            prs.setDate(5, e.getDateFinEvent());
            prs.setString(6, e.getLieuEvent());
            prs.setInt(7, e.getCapaciteEvent());
            prs.setString(8, e.getDescriptionEvent());
            prs.setString(9, e.getLogo());
            prs.setInt(10, e.getPrixEvent());

            int id = prs.executeUpdate();
            e.setId(id);
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ObservableList<Event> getAll() {

        try {
            String query = "select * from event";
            Statement ste = con.createStatement();
            ResultSet rs = ste.executeQuery(query);
            ObservableList<Event> evenements = FXCollections.observableArrayList();
            while (rs.next()) {
                evenements.add(new Event(rs.getInt("id"), rs.getInt("id_user"), rs.getString("event"), rs.getString("Type"), rs.getDate("date_debut_event"), rs.getDate("date_fin_event"), rs.getString("lieu_event"), rs.getInt("capacite_event"), rs.getString("description_event"), rs.getString("logo"), rs.getInt("prix_event")));

            }
            return evenements;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ObservableList<Event> getEv() {
        try {
            String query = "select * from event WHERE date_debut_event > NOW()";

            Statement ste = con.createStatement();
            ResultSet rs = ste.executeQuery(query);
            ObservableList<Event> evenements = FXCollections.observableArrayList();
            while (rs.next()) {
                evenements.add(new Event(rs.getInt("id"), rs.getInt("id_user"), rs.getString("event"), rs.getString("Type"), rs.getDate("date_debut_event"), rs.getDate("date_fin_event"), rs.getString("lieu_event"), rs.getInt("capacite_event"), rs.getString("description_event"), rs.getString("logo"), rs.getInt("prix_event")));

            }
            System.out.println("+++" + evenements.size());
            return evenements;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ObservableList<Event> getEv1() {
        try {
            String query = "select * from event WHERE responsable=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Event.getIdUser());
            ResultSet rs = ps.executeQuery();
            ObservableList<Event> evenements = FXCollections.observableArrayList();
            while (rs.next()) {
                evenements.add(new Event(rs.getInt("id"), rs.getInt("id_user"), rs.getString("event"), rs.getString("Type"), rs.getDate("date_debut_event"), rs.getDate("date_fin_event"), rs.getString("lieu_event"), rs.getInt("capacite_event"), rs.getString("description_event"), rs.getString("logo"), rs.getInt("prix_event")));
            }
            System.out.println("+++" + evenements.size());
            return evenements;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean deleteEvenement(int ide) {
        try {
            Connection con = DataSource.getInstance().getConnection();
            String query = "DELETE from event where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ide);
            ps.executeUpdate();
            System.out.println("Suppression avec SuccÃƒÂ©s !");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updateEvenement(Event e, int id) {

        try {
            String query = "Update event set event = ?,Type=?,date_debut_event=?,=?,date_fin_event=?,lieu_event=?,capacite_event=?,description_event=?,	logo=?,prix_event=? where id = " + id;
            PreparedStatement prs = con.prepareStatement(query);

            prs.setString(1, e.getNomEvent());
            prs.setString(2, e.getTypeEvent());
            prs.setDate(3, (Date) e.getDateDebutEvent());
            prs.setDate(4, (Date) e.getDateFinEvent());
            prs.setString(5, e.getLieuEvent());
            prs.setInt(6, e.getCapaciteEvent());
            prs.setString(7, e.getDescriptionEvent());
            prs.setString(8, e.getLogo());

            prs.setInt(9, e.getPrixEvent());
            prs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
