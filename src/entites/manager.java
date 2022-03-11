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
public class manager extends utilisateur{
    private int id_manager;
    public manager(int id_manager, String prenom, String nom, String email,String login,String mdp,String image,String salt,String question,String responde){
        super(prenom,nom,email,login,mdp,image,salt,question,responde);
        this.id_manager=id_manager;
    }

    public manager() {
    }

   
    public int getId_manager(){
        return id_manager;
        
    }
    public void setId_manager(int id){
        this.id_manager=id;
        
    }
    @Override
    public String toString() {
        return "manager {"+"id="+id_manager +  "prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", login=" + login + ", mdp=" + mdp + ", image=" + image + '}' ;
    }
    
}
