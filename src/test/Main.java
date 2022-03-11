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
import Service.SendMailSSL;
/**
 *
 * @author fedi
 */
public class Main {
    
    public static void main(String[] args) {    
     //from,password,to,subject,message  
     SendMailSSL.send("pivdev04@gmail.com","Yeahkid_10","fadihaboubi8@gmail.com","hello javatpoint","How r u?");  
     //change from, password and to  1
 }   
    
}