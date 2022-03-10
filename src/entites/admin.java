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
public class admin extends utilisateur{
    private int id_admin;
    public admin(int id_admin, String prenom, String nom, String email,String login,String mdp,String image){
        super(prenom,nom,email,login,mdp,image);
        this.id_admin=id_admin;
    }
    public admin() {
    }
    public int getId_admin(){
        return id_admin;
        
    }
    public void setId_admin(int id){
        this.id_admin=id;
        
    }
    @Override
    public String toString() {
        return "admin {"+"id="+id_admin +  "prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", login=" + login + ", mdp=" + mdp + ", image=" + image + '}' ;
    }
    
}
    
            
            

