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
public class Publication {

    private int id;

    private String image;

    private String titre;

    private String description;

    private int nbLike;

    private int nbDislike;

    public Publication() {
    }

    public Publication(int id, String image, String titre, String description, int nbLike, int nbDislike) {
        this.id = id;
        this.image = image;
        this.titre = titre;
        this.description = description;
        this.nbLike = nbLike;
        this.nbDislike = nbDislike;
    }

    public Publication(String image, String titre, String description) {
        this.image = image;
        this.titre = titre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getNbLike() {
        return nbLike;
    }

    public int getNbDislike() {
        return nbDislike;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNbLike(int nbLike) {
        this.nbLike = nbLike;
    }

    public void setNbDislike(int nbDislike) {
        this.nbDislike = nbDislike;
    }
    

}
