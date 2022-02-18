/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author rania
 */
public class Commentaire {

    private int id;

    private String contenu;

    private int idUser;

    private int idPub;

    public Commentaire() {
    }

    public Commentaire(int id, String contenu, int idUser, int idPub) {
        this.id = id;
        this.contenu = contenu;
        this.idUser = idUser;
        this.idPub = idPub;
    }

    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdPub() {
        return idPub;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", contenu=" + contenu + ", idUser=" + idUser + ", idPub=" + idPub + '}';
    }
    

}
