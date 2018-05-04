/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;



import java.util.List;
import pbdco.BDAccessEx;
import pbdco.Code;
import pbdco.modele.FabriqueDeOrganisation;
import java.sql.*;
import java.util.Map;
import java.util.Set;
import pbdco.modele.*;
/**
 *
 * @author milcenan
 */
public abstract class Organisation {
    private String tour;
    private int nbrParticipants;
    private Map<Integer,Joueur> listeDesJoueurs;
    private Code codeTournoi;
    private FabriqueDeOrganisation fabriqueOrga;
    
//    public Organisation(Code codeTournoi){
//        this.codeTournoi = codeTournoi;
//        this.fabriqueOrga = new FabriqueDeOrganisation();
//        this.tour = this.fabriqueOrga.quelTour(codeTournoi);
//        if(this.tour == null){
//            //Relever une erreur
//        }
//        this.nbrParticipants = this.fabriqueOrga.nbrDeJoueurs(codeTournoi);
//    }
    
    public Organisation() throws BDAccessEx{
        
        
        this.fabriqueOrga = new FabriqueDeOrganisation();
        this.tour = "qualif";
        this.fabriqueOrga.creerTournois();
        this.nbrParticipants = this.fabriqueOrga.nbrDeJoueurs(codeTournoi);
    }
    
    public String getTour(){
        return this.tour;
    }
    
    public Code getCodeTournoi(){
        return this.codeTournoi;
    }
    
    public int getNbrParticipants(){
        return this.nbrParticipants;
    }
    
    public FabriqueDeOrganisation getFabriqueOrga(){
        return this.fabriqueOrga;
    }
    
//    public void setCodeTour(Code codeTournoi){
//        this.codeTour = codeTournoi;
//        this.fabriqueOrga.setCodeTour(codeTournoi);
//    }
    
    public void setTour(String nouvTour){
        this.tour = nouvTour;
    }
    
    public void setNbrParticipants(int nouvNbr){
        this.nbrParticipants = nouvNbr;
    }
    
    public void loadAllJoueurs() throws BDAccessEx{
        listeDesJoueurs = fabriqueOrga.loadAllJoueurs();
    }
    
}
