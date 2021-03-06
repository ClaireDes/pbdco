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
    private int nbrRencontres;
    private Map<Integer,Joueur> listeDesJoueurs;
    private Code[] listeJoueurs;
    private final FabriqueDeOrganisation fabriqueOrga;
    private final FabriqueDeJoueur fabJoueur = new FabriqueDeJoueur();
    private final FabriqueDePiece fabPiece = new FabriqueDePiece();
    private final FabriqueDeCoups fabCoup = new FabriqueDeCoups();
    private final FabriqueDeRencontre fabRenc = new FabriqueDeRencontre(fabJoueur, fabPiece, fabCoup);

    
//    public Organisation(Code codeTournoi){
//        this.codeTournoi = codeTournoi;
//        this.fabriqueOrga = new FabriqueDeOrganisation();
//        this.tour = this.fabriqueOrga.quelTour(codeTournoi);
//        if(this.tour == null){
//            //Relever une erreur
//        }
//        this.nbrParticipants = this.fabriqueOrga.nbrDeJoueurs(codeTournoi);
//    }
    
    public Organisation(boolean bool) throws BDAccessEx{
        // crée un nouveau tournoi
        if(bool == true){
            this.fabriqueOrga = new FabriqueDeOrganisation();
            this.tour = "qualif";
            this.fabriqueOrga.creerTournois();
            this.nbrParticipants = this.fabriqueOrga.nbrDeJoueurs();
        }
        else{// charge le tournoi en cours
            this.fabriqueOrga = new FabriqueDeOrganisation();
            this.quelleTour();
            this.nbrParticipants = this.fabriqueOrga.nbrDeJoueurs();
            this.nbrRencontres = this.fabriqueOrga.nbrRencontres(tour);
            this.loadJoueurs();

        }
        
        
    }
    
    public String getTour(){
        return this.tour;
    }
    
    public int getNbrParticipants(){
        return this.nbrParticipants;
    }
    
    public int getNbrRencontres(){
        return this.nbrRencontres;
    }
    
    public FabriqueDeOrganisation getFabriqueOrga(){
        return this.fabriqueOrga;
    }
    
    public FabriqueDeJoueur getFabriqueJoueur(){
        return this.fabJoueur;
    }
    
    public FabriqueDePiece getFabriquePiece(){
        return this.fabPiece;
    }
    
    public FabriqueDeCoups getFabriqueCoup(){
        return this.fabCoup;
    }
    
    public FabriqueDeRencontre getFabriqueRencontre(){
        return this.fabRenc;
    }
    
    public Map getListJoueur(){
        return this.listeDesJoueurs;
    }
    
    public Code[] getJoueur(){
        return this.listeJoueurs;
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
    
    public void incNbrRencontres(){
        this.nbrRencontres++;
    }
    
    public void loadAllJoueurs() throws BDAccessEx{
        this.listeDesJoueurs = fabriqueOrga.loadAllJoueurs();
    }
    
    public void loadJoueurs() throws BDAccessEx{
        this.listeJoueurs = fabriqueOrga.loadJoueurs();
    }
    
    public void quelleTour() throws BDAccessEx{
        int res = this.getFabriqueOrga().quelTour();
        if (res==1){
            this.tour = "qualif";
        }
        else if (res==2){
            this.tour = "quart";
        }
        else if(res==3){
            this.tour="demi";
        }
        else{
            this.tour="finale";
        }
    }
}
