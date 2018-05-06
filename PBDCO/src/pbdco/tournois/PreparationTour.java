/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import java.util.Iterator;
import java.util.Set;
import javax.swing.RowFilter.Entry;
import pbdco.BDAccessEx;
import pbdco.Code;
import pbdco.modele.FabriqueDeRencontre;
import pbdco.modele.Joueur;
import pbdco.modele.Rencontre;

/**
 *
 * @author milcenan
 */
public class PreparationTour extends Organisation{
    
    public PreparationTour(boolean bool) throws BDAccessEx{
        super(bool);
    }
    
    public void creeRencontre() throws BDAccessEx{
        switch(this.getTour()){
            case "qualif": 
                this.loadAllJoueurs();
                System.out.println("je vais creer les rencontres");
                Set<Entry<Integer, Joueur>> setHM1 = this.getListJoueur().entrySet();
                Set<Entry<Integer, Joueur>> setHM2 = this.getListJoueur().entrySet();
                Iterator <Entry<Integer, Joueur>> it1 = setHM1.iterator();
                Iterator <Entry<Integer, Joueur>> it2 = setHM2.iterator();
                int i = 1;
                Joueur j1;
                Joueur j2;

                while(it1.hasNext()){
                    Entry<Integer, Joueur> e1 = it1.next();
                    if(i!=this.getNbrParticipants()){
                        int j = i+1;
                        int k = 1;
                        while(k!=j){
                            Entry<Integer, Joueur> e2 = it2.next();
                            k=k+1;
                        }
                        while(it2.hasNext()){
                            Entry<Integer, Joueur> e2 = it2.next();
                            j1 = (Joueur) e1.getValue(i);
                            j2 = (Joueur) e2.getValue(j);
                            Rencontre renc = new Rencontre(j1, j2, this.getTour(), getFabriqueRencontre());
                            j = j+1;
                        }
                    }
                    i=i+1;
                }
                break;
            case "demi":
                
        }
    }
    
    public int rencontresQualifs(int nbrParticipants){
        int res = 0;
        for(int i=1;i<nbrParticipants;i++){
            res = res + i;
        }
        return res;
    }
}
