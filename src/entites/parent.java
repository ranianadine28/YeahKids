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
/*
private List<reclamation> list ;
*/
public class parent extends utilisateur{
    private int id_parent;
    public parent(int id_parent,String prenom, String nom, String email,String login,String mdp,String image,String salt,String question,String responde){
        super(prenom,nom,email,login,mdp,image,salt,question,responde);
        this.id_parent=id_parent;
    }
    public parent(){}

    
    public int getId_parent(){
        return id_parent;
        
    }
    public void setId_parent(int id){
        this.id_parent=id;
        
    }
    @Override
    public String toString() {
        return "parent {"+"id="+id_parent +  "prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", login=" + login + ", mdp=" + mdp + ", image=" + image + '}' ;
    }
    
    

}

