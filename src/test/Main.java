/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entities.Eleve;
import java.sql.Date;
import services.*;
import utils.MyDB;
import java.time.LocalDate;
/**
 *
 * @author lotfi
 */
public class Main {
    
    public static void main(String[] args) {
     
      
               ServiceEleve sp = new ServiceEleve();
        Eleve p = new Eleve(10, "nomdqsdqs", "d", 12, 233, 43);
        //sp.ajouter(p);
          sp.supprimer(10);
          //sp.modifier(p);
        
        System.out.println(sp.afficher());
    }
    
}