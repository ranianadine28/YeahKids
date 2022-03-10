/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author test
 */
public class livraison {
     private int id_livraison;
     private int id_produit;
     private int quantite;
     private int prix;
     private String adresse;
     private int id_parent;
    
     public livraison(int id_livraison,int id_produit, int quantite,int prix , String adresse, int id_parent) {
        this.id_livraison=id_livraison;
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.prix = prix;
        this.id_parent = id_parent;
        this.adresse = adresse;
  
     }
        public livraison() {
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getPrix() {
        return prix;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_livraison(int id_livrison) {
        this.id_livraison = id_livrison;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }
        
@Override
    public String toString() {
        return "livraison{" + "id_livraison=" + id_livraison + ", id_produit=" + id_produit + ", quantite=" + quantite + ", prix=" + prix + ", adresse=" + adresse + ",id_parent=" +id_parent+ '}';
  
    }

   

   
}
