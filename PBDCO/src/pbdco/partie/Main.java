/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

import pbdco.vuejeu.JeuInterface;
//import pbdco.vuejeu.VueJoueur;

/**
 *
 * @author belinbr
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        System.out.println("Les blancs jouent en bas, les noirs en haut. Grille de 8x8 cases. Bonne chance !\n\n");
        initialize();
        
        //TESTS MARCHENT
        
        new JeuInterface().setVisible(true);
        //new VueJoueur().setVisible(true);
            
        
    }
    
    /**
     *
     */
    public static void initialize(){
        //Pièces noires
        //---Pions----
        Pion p1 = new Pion(new Position(1,7,true),false);
        System.out.println(p1.toString());
//        Pion p2 = new Pion(new Position(2,7,true),false);
//        System.out.println(p2.toString());
//        Pion p3 = new Pion(new Position(3,7,true),false);
//        System.out.println(p3.toString());
//        Pion p4 = new Pion(new Position(4,7,true),false);
//        System.out.println(p4.toString());
//        Pion p5 = new Pion(new Position(5,7,true),false);
//        System.out.println(p5.toString());
//        Pion p6 = new Pion(new Position(6,7,true),false);
//        System.out.println(p6.toString());
//        Pion p7 = new Pion(new Position(7,7,true),false);
//        System.out.println(p7.toString());
//        Pion p8 = new Pion(new Position(8,7,true),false);
//        System.out.println(p8.toString()+"\n\n");
//        
//        //Pièces blanches
//        //---Pions----
//        Pion p9 = new Pion(new Position(1,2,true),true);
//        System.out.println(p9.toString());
//        Pion p10 = new Pion(new Position(2,2,true),true);
//        System.out.println(p10.toString());
//        Pion p11 = new Pion(new Position(3,2,true),true);
//        System.out.println(p11.toString());
//        Pion p12 = new Pion(new Position(4,2,true),true);
//        System.out.println(p12.toString());
//        Pion p13 = new Pion(new Position(5,2,true),true);
//        System.out.println(p13.toString());
//        Pion p14 = new Pion(new Position(6,2,true),true);
//        System.out.println(p14.toString());
//        Pion p15 = new Pion(new Position(7,2,true),true);
//        System.out.println(p15.toString());
//        Pion p16 = new Pion(new Position(8,2,true),true);
//        System.out.println(p16.toString());
        
        
    }
    
}
