/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author fedi
 */
public abstract class utilisateur {
    protected String prenom;
    protected String nom;
    protected String email;
    protected String login;
    protected String mdp;
    protected String image;
   protected byte[] img;
    

    public utilisateur(){};
    public utilisateur(String prenom, String nom, String email,String login,String mdp,String image) {
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.mdp = mdp;
        this.image = image;
        this.email = email;
        
    }

    public utilisateur(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.mdp = mdp;
        this.image = image;
        this.email = email;    }

   
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }
     public void setEmail(String email) {
        this.email=email;
    }

    public String getimage() {
        return this.image;
    }
    public void setimage(String image) {
        this.image = image;
    }
    public void setlogin(String login) {
        this.login = login;
    }
    public String getlogin() {
        return this.login;
    }
    public void setmdp(String mdp) {
        this.mdp = mdp;
    }
    public String getmdp() {
        return this.mdp;
    }
    public void setimg(byte[] img) {
        this.img = img;
    }
    public byte[] getimg() {
        return this.img;
    }

    @Override
    public String toString() {
        return "utilisateur {"+  "prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", login=" + login + ", mdp=" + mdp +  '}' ;
    }
    
}
