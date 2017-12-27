/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formation.proxibanque.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adminl
 */
public class Bdd {
    
    public static String Driver = "com.mysql.jdbc.Driver";
    public static String BddURL = "jdbc:mysql://localhost/proxibanqueHiKo";
    public static String nomUtil = "root";
    public static String mdpUtil = "";
    
    public static Connection seConnecter(){
        Connection cnx = null;
        try {
            Class classe = Class.forName (Driver);
             cnx = DriverManager.getConnection(BddURL, nomUtil, mdpUtil);
             
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }      
        
        return cnx;
    }
    
        public static void  seDeconnecter(Connection cnx){

        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
