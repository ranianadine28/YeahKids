/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


/**
 *
 * @author rania
 */
public class Event {

    private int id ;
    private static int idUser ;

    private String nomEvent ;

    private  String typeEvent ;

    private Date dateDebutEvent ;

    private Date dateFinEvent ;

    private String lieuEvent ;

    private int capaciteEvent ;

    private String descriptionEvent ;

    private String logo ;

    private int prixEvent ;

    public Event(int id, int idUser, String nomEvent, String typeEvent, Date dateDebutEvent, Date dateFinEvent, String lieuEvent, int capaciteEvent, String descriptionEvent, String logo, int prixEvent) {
        this.id = id;
        this.idUser = idUser;
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.dateDebutEvent = dateDebutEvent;
        this.dateFinEvent = dateFinEvent;
        this.lieuEvent = lieuEvent;
        this.capaciteEvent = capaciteEvent;
        this.descriptionEvent = descriptionEvent;
        this.logo = logo;
        this.prixEvent = prixEvent;
    }
   
    public Event() {
    }

    public int getId() {
        return id;
    }

   

    public String getNomEvent() {
        return nomEvent;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public Date getDateDebutEvent() {
        return dateDebutEvent;
    }

    public Date getDateFinEvent() {
        return dateFinEvent;
    }

    public String getLieuEvent() {
        return lieuEvent;
    }

    public int getCapaciteEvent() {
        return capaciteEvent;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public String getLogo() {
        return logo;
    }

    public int getPrixEvent() {
        return prixEvent;
    }

    public static int getIdUser() {
        return idUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setIdUser(int idUser) {
        Event.idUser = idUser;
    }

    



    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public void setDateDebutEvent(Date dateDebutEvent) {
        this.dateDebutEvent = dateDebutEvent;
    }

    public void setDateFinEvent(Date dateFinEvent) {
        this.dateFinEvent = dateFinEvent;
    }

    public void setLieuEvent(String lieuEvent) {
        this.lieuEvent = lieuEvent;
    }

    public void setCapaciteEvent(int capaciteEvent) {
        this.capaciteEvent = capaciteEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setPrixEvent(int prixEvent) {
        this.prixEvent = prixEvent;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", idUser=" + idUser + ", nomEvent=" + nomEvent + ", typeEvent=" + typeEvent + ", dateDebutEvent=" + dateDebutEvent + ", dateFinEvent=" + dateFinEvent + ", lieuEvent=" + lieuEvent + ", capaciteEvent=" + capaciteEvent + ", descriptionEvent=" + descriptionEvent + ", logo=" + logo + ", prixEvent=" + prixEvent + '}';
    }

    public Event(String nomEvent, String typeEvent, Date dateDebutEvent, Date dateFinEvent, String lieuEvent, int capaciteEvent, String descriptionEvent, String logo, int prixEvent) {
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.dateDebutEvent = dateDebutEvent;
        this.dateFinEvent = dateFinEvent;
        this.lieuEvent = lieuEvent;
        this.capaciteEvent = capaciteEvent;
        this.descriptionEvent = descriptionEvent;
        this.logo = logo;
        this.prixEvent = prixEvent;
    }
    
    
    
    
    
    

   
}
