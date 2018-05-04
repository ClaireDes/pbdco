/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import pbdco.Code;
import pbdco.modele.FabriqueDeOrganisation;

/**
 *
 * @author milcenan
 */
public class Organisation {
    private String tour;
    private int nbrParticipants;
    private Code codeTour;
    private FabriqueDeOrganisation fabriqueOrga;
    
    public Organisation(Code codeTour){
        this.codeTour = new Code(codeTour);
        this.frabriqueOrga = new fabriqueDeOrganisation();
        this.tour = this.fabriqueOrga.quelTour();
        if(this.tour == null){
            //Relever une erreur
        }
        this.nbrParticipants = this.fabriqueOrga.nbrDeJoueurs();
    }
    
    public Organisation(){
        this.frabriqueOrga = new fabriqueDeOrganisation();
        this.tour = this.fabriqueOrga.quelTour();
        if(this.tour == null){
            this.codeTour = this.fabriqueOrga.creerTournoi();
        }
        this.nbrParticipants = this.fabriqueOrga.nbrDeJoueurs();
    }
    
    public String getTour(){
        return this.tour;
    }
    
    public Code getCodeTour(){
        return this.codeTour;
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
    
}
