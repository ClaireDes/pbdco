/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

/**
 *
 * @author livingstonehgs
 */
public enum EtatsPartie {
    CHOIX_MODE, 
    
    BLANC_JOUE, BLANC_DEPLACE,
    NOIR_JOUE, NOIR_DEPLACE,
    
    BLANC_ECHEC, NOIR_ECHEC,
    
    REJOUER_PARTIE, JOUER_RENCONTRE,
    
    BLANC_DEMANDE_ABANDON, NOIR_DEMANDE_ABANDON,
    BLANC_DEMANDE_RECOMMENCER, NOIR_DEMANDE_RECOMMENCER
    
}
