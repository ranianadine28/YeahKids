package Service;

import entites.parent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.tools.ShellFunctions.input;
import utils.DB;
/**
 *
 * @author fedi
 */


public class serviceparent implements Service<parent>{
    Connection cnx;

    public serviceparent() {
        cnx = DB.getInstance().getConnection();
    }

    @Override
    public void ajout(parent t) {
        try {
            String req = "insert into parent (prenom,nom,email,login,mdp,image) values(?,?,?,?,?,?)";
            
                    
            PreparedStatement ps = cnx.prepareStatement(req);
              ps.setString(1, t.getPrenom());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getlogin());
            ps.setString(5, t.getmdp());
            File file = new File(t.getimage());

         
             FileInputStream input = new FileInputStream(file);
            
           
       ps.setBinaryStream(6,(InputStream)input,(int)file.length());
            ps.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(parent t) {
        try {
            String req = "update parent set prenom = ? , nom = ? , email = ? ,login = ? , mdp = ?,image = ? where id_parent = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getPrenom());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getlogin());
            ps.setString(5, t.getmdp());
            ps.setString(6, t.getimage());
            ps.setInt(7, t.getId_parent());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from parent where id_parent = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<parent> afficher() {
        List<parent> list = new ArrayList<>();
        try 
        {
            String req ="select * from parent";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                parent p = new parent();
                p.setId_parent(rs.getInt("id_parent"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setmdp(rs.getString("mdp"));
                p.setlogin(rs.getString("login"));
                p.setimg(rs.getBytes("image"));

                
                
                
                list.add(p);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public parent recherche(String mdp,String login) {
                parent p = new parent();
                            boolean test=false; 

    
    try 
        {
            String req ="select * from parent WHERE (mdp=? and login=? ) ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, mdp);
            ps.setString(2, login);
            
            ResultSet rs = ps.executeQuery();

            
            while(rs.next()){
                
                p.setId_parent(rs.getInt("id_parent"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setmdp(rs.getString("mdp"));
                p.setlogin(rs.getString("login"));
                p.setimg(rs.getBytes("image"));
                test=true;
                break;
                
                
                
                
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(serviceparent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if ( test==false){
        return null;
        }
        else 
            return p;
    }    


}
