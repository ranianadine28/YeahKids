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

public final class Singleton_login {
    private static Singleton_login instance;
    private utilisateur util;
    private String type; 
    
    public Singleton_login(utilisateur a ) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        if (a instanceof parent){
        
            this.util = a;
        type="parent";
        System.out.print(util.getlogin());
        
        }
        if (a instanceof manager){
        this.util = a;
        type="manager";
        }
        if (a instanceof admin){
        this.util = a;
        type="admin";
        }
    }

    public static Singleton_login getInstance() {
        if (instance == null) {
            instance = new Singleton_login();
        }
        return instance;
    
    }
    public static Singleton_login getInstance(utilisateur a) {
        if (instance == null) {
            instance = new Singleton_login(a);
        }
        return instance;
    
    }

    public Singleton_login() {
    }

    public Singleton_login(manager p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public utilisateur get_util(){
    return this.util;   
    
    }
    public String get_type(){
    return this.type;   
    
    }
    
    
}