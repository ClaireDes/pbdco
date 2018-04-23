/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

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
        
       
        System.out.println("test");
        initialize();
        
        //TESTS MARCHENT
        
        
        
        
    }
    
    /**
     *
     */
    public static void initialize(){
        //Pièces noires
        //---Pions----
        Pion p1 = new Pion(2,1,false);
        System.out.println(p1.toString());
        Pion p2 = new Pion(2,2,false);
        System.out.println(p2.toString());
        Pion p3 = new Pion(2,3,false);
        System.out.println(p3.toString());
        Pion p4 = new Pion(2,4,false);
        System.out.println(p4.toString());
        Pion p5 = new Pion(2,5,false);
        System.out.println(p5.toString());
        Pion p6 = new Pion(2,6,false);
        System.out.println(p6.toString());
        Pion p7 = new Pion(2,7,false);
        System.out.println(p7.toString());
        Pion p8 = new Pion(2,8,false);
        System.out.println(p8.toString());
        
        //Pièces blanches
        //---Pions----
        Pion p9 = new Pion(7,1,true);
        System.out.println(p9.toString());
        Pion p10 = new Pion(7,2,true);
        System.out.println(p10.toString());
        Pion p11 = new Pion(7,3,true);
        System.out.println(p11.toString());
        Pion p12 = new Pion(7,4,true);
        System.out.println(p12.toString());
        Pion p13 = new Pion(7,5,true);
        System.out.println(p13.toString());
        Pion p14 = new Pion(7,6,true);
        System.out.println(p14.toString());
        Pion p15 = new Pion(7,7,true);
        System.out.println(p15.toString());
        Pion p16 = new Pion(7,8,true);
        System.out.println(p16.toString());
        
        
    }
    
}
