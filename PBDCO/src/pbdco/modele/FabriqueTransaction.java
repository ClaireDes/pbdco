/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;
import java.sql.*;


/**
 *
 * @author milcenan
 */
public abstract class FabriqueTransaction {
    
    //A COMPLETER
    static String URL = "jdbc:oracle:thin@nomdelabase";
    static String USER = "barbault";
    static String PASSWD = "barbault";
    
    
        public abstract void fabriqueTransaction(String operation,Modele param);
        
        public abstract void fabriqueRequete();
}
