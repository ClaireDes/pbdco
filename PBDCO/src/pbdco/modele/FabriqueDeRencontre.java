/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco;

/**
 *
 * @author milcenan
 */
public class FabriqueDeRencontre/* extends FabriqueTransaction*/{
    
    
    public  void fabriqueTransaction(String operation,Object name){
        
   
        switch (operation) {
            case "new":// création d'une nouvelle rencontre
                
                break;
            case "fini":// enregistrement du résultat d'une rencontre
                
                break;
            case "load":// chargement d'une rencontre avec la base de données
                
                break;
            case "lastCodeRencontre":// le dernier code rencontre utilisé (pour en generer un nouveau)
                
                break;
        }
        
        
        throw new UnsupportedOperationException("Not supported yet.");
        
        
      
    };
    
    

    public  void fabriqueRequete(){
        throw new UnsupportedOperationException("Not supported yet.");
    };    
   
}
