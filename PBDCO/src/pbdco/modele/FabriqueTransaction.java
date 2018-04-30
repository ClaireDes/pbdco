/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

/**
 *
 * @author milcenan
 */
public abstract class FabriqueTransaction {
        public abstract void fabriqueTransaction(String operation,Modele param);
        
        public abstract void fabriqueRequete();
}
