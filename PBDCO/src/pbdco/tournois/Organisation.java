/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

/**
 *
 * @author milcenan
 */
public class Organisation {
    private String tour;
    private int nombreParticipant;
    
    public Organisation(String tour, int nombre){
        this.tour = tour;
        this.nombreParticipant = nombre;
    }
    
    public String getTour(){
        return this.tour;
    }
    
    public void setTour(String nouvTour){
        this.tour = nouvTour;
    }
}
