/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.*;
import Service.*;
import utils.DB;

/**
 *
 * @author fedi
 */
public class Main {
    
    public static void main(String[] args) {
       Servicelivraison sp = new Servicelivraison();

        
        
        
        List<livraison>  liste= sp.afficher();
for (int i = 0; i < liste.size(); i++) {
      System.out.println(liste.get(i).toString());
    }        
    }
    
}