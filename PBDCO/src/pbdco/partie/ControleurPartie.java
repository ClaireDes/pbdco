package pbdco.partie;


import pbdco.Code;
import pbdco.modele.Joueur;
import pbdco.vuejeu.JeuInterface;
import pbdco.vuejeu.VueJoueur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.TablePosition;

import pbdco.modele.FabriqueTransaction;
import pbdco.BDAccessEx;
import pbdco.Code;
import pbdco.modele.*;
import pbdco.vuejeu.JeuInterface;
import pbdco.vuejeu.VueJoueur;


/**
 * Created by ravenetq on 4/23/18.
 */
public class ControleurPartie {

    private Joueur adversaire;
    private Joueur joueur;

    private TablePositions tablePositions;
    private Position positionCourante = new Position(0,0);

    private EtatsPartie etat;
    

    public void initPlateau(Code codeTour, Code codeRencontre) throws BDAccessEx {
        //on commence par effacer le plateau
        String requete1 = "DELETE FROM Coup WHERE codeRencontre = ?";
        String requete2 = "DELETE FROM Piece WHERE codeRencontre = ?";
        //on place les pieces
        /*(codePiece, ligneInit, colonneInit, ligneFin, colonneFin, typePiece,
        couleur, codeRencontre, codeTour */
        /****pieces blanches****/
        String requete3 = "INSERT INTO Piece\n" +
        "VALUES (1,1,1,null,null,'tour','blanc',?,?)";
        String requete4 = "INSERT INTO Piece\n" +
        "VALUES (2,1,2,null,null,'cavalier','blanc','?','?')";
        String requete5 = "INSERT INTO Piece\n" +
        "VALUES (3,1,3,null,null,'fou','blanc','?','?')";
        String requete6 = "INSERT INTO Piece\n" +
        "VALUES (4,1,4,null,null,'reine','blanc',?,?)";
        String requete7 = "INSERT INTO Piece\n" +
        "VALUES (5,1,5,null,null,'roi','blanc',?,?)";
        String requete8 = "INSERT INTO Piece\n" +
        "VALUES (6,1,6,null,null,'fou','blanc',?,?)";
        String requete9 = "INSERT INTO Piece\n" +
        "VALUES (7,1,7,null,null,'cavalier','blanc',?,?)";
        String requete10 = "INSERT INTO Piece\n" +
        "VALUES (8,1,8,null,null,'tour','blanc',?,?)";
        String requete11 = "INSERT INTO Piece\n" + 
        "VALUES (9,2,1,null,null,'pion','blanc',?,?)";
        String requete12 = "INSERT INTO Piece\n" +
        "VALUES (10,2,2,null,null,'pion','blanc',?,?)";
        String requete13 = "INSERT INTO Piece\n" + 
        "VALUES (11,2,3,null,null,'pion','blanc',?,?)";
        String requete14 = "INSERT INTO Piece\n" + 
        "VALUES (12,2,4,null,null,'pion','blanc',?,?)";
        String requete15 = "INSERT INTO Piece\n" +
        "VALUES (13,2,5,null,null,'pion','blanc',?,?)";
        String requete16 = "INSERT INTO Piece\n" +
        "VALUES (14,2,6,null,null,'pion','blanc',?,?)";
        String requete17 = "INSERT INTO Piece\n" +
        "VALUES (15,2,7,null,null,'pion','blanc',?,?)";
        String requete18 = "INSERT INTO Piece\n" +
        "VALUES (16,2,8,null,null,'pion','blanc',?,?)";
        /****pieces noires****/
        String requete19 = "INSERT INTO Piece\n" +
        "VALUES (1,1,1,null,null,'tour','noir',?,?)";
        String requete20 = "INSERT INTO Piece\n" +
        "VALUES (2,1,2,null,null,'cavalier','noir','?','?')";
        String requete21 = "INSERT INTO Piece\n" +
        "VALUES (3,1,3,null,null,'fou','noir','?','?')";
        String requete22 = "INSERT INTO Piece\n" +
        "VALUES (4,1,4,null,null,'reine','noir',?,?)";
        String requete23 = "INSERT INTO Piece\n" +
        "VALUES (5,1,5,null,null,'roi','noir',?,?)";
        String requete24 = "INSERT INTO Piece\n" +
        "VALUES (6,1,6,null,null,'fou','noir',?,?)";
        String requete25 = "INSERT INTO Piece\n" +
        "VALUES (7,1,7,null,null,'cavalier','noir',?,?)";
        String requete26 = "INSERT INTO Piece\n" +
        "VALUES (8,1,8,null,null,'tour','noir',?,?)";
        String requete27 = "INSERT INTO Piece\n" + 
        "VALUES (9,2,1,null,null,'pion','noir',?,?)";
        String requete28 = "INSERT INTO Piece\n" +
        "VALUES (10,2,2,null,null,'pion','noir',?,?)";
        String requete29 = "INSERT INTO Piece\n" + 
        "VALUES (11,2,3,null,null,'pion','noir',?,?)";
        String requete30 = "INSERT INTO Piece\n" + 
        "VALUES (12,2,4,null,null,'pion','noir',?,?)";
        String requete31 = "INSERT INTO Piece\n" +
        "VALUES (13,2,5,null,null,'pion','noir',?,?)";
        String requete32 = "INSERT INTO Piece\n" +
        "VALUES (14,2,6,null,null,'pion','noir',?,?)";
        String requete33 = "INSERT INTO Piece\n" +
        "VALUES (15,2,7,null,null,'pion','noir',?,?)";
        String requete34 = "INSERT INTO Piece\n" +
        "VALUES (16,2,8,null,null,'pion','noir',?,?)";
        Connection conn = null;
        // Connexion à la BD
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1", "grelliel", "grelliel");
            if (conn == null) {
                throw new BDAccessEx("connexion échouée");
            } else {
                System.out.println("Connection ok");
            }

            try {
                PreparedStatement pstmt = conn.prepareStatement(requete1);
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete2);
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete3);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete4);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete5);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete6);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete7);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete8);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete9);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete10);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete11);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete12);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete13);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete14);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete15);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete16);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete17);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete18);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete19);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete20);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete21);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete22);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete23);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete24);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete25);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete26);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete27);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete28);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete29);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete30);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete31);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete32);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete33);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                pstmt = conn.prepareStatement(requete34);
                pstmt.setString(2,codeTour.getName());
                pstmt.setInt(1, codeRencontre.getValue());
                
                conn.commit();
                conn.close();
                System.out.println("enregistrement des différentes pieces dans la base");
            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.err.println(ex.getMessage());
               }
        } catch (SQLException ex) {
            throw new BDAccessEx("initPlateau Raised SQLException during the connection\n" + ex.getMessage());
            }
    }
   

    public void procedureAbandon() {
        //Fait recommencer le joueur qui utilise cette vue : "joueur"
    }

    public void procedureRecommencer() {
        //Fait recommencer le joueur qui utilise cette vue : "joueur"
    }

    public void coupSuivant() { //Pour lire une partie
        //Joue le coup suivant de la partie en lecture
        String trans = "UPDATE Piece SET ligneInit=?, colonneInit=? WHERE ligneInit=? AND colonneInit=? AND codeRencontre=?\n" +
                " AND codeTour=?";
        Connection conn = null;
        // Connexion à la BD
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1", "grelliel", "grelliel");
            if (conn == null) {
                throw new BDAccessEx("connexion échouée");
            } else {
                System.out.println("Connection ok");
            }

            try {
                PreparedStatement pstmt = conn.prepareStatement(trans);
                pstmt.setInt(3,coup.getPreviousY(piece));
                pstmt.setInt(4,coup.getPreviousX(piece));
                pstmt.setInt(1,coup.getCurrentY(piece));
                pstmt.setInt(2,coup.getCurrentX(piece));
                pstmt.setInt(5,codeRencontre.getValue());
                pstmt.setString(6, codeTour.getName());
                conn.commit();
                conn.close();
                System.out.println("enregistrement des différentes pieces dans la base");
            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.err.println(ex.getMessage());
               }
        } catch (SQLException ex) {
            throw new BDAccessEx("initPlateau Raised SQLException during the connection\n" + ex.getMessage());
            }

    }

    protected void informe() {
        //Informe ses observateurs, comme la vue
    }
    
    public void pieceABouger(int noBouton) {
        if(etat == EtatsPartie.BLANC_JOUE && (1==tablePositions.caseOccupee(noBouton))) { //Clic pour sélectionner la pièce à bouger
            positionCourante = caseToPosition(noBouton);
            etat = EtatsPartie.BLANC_DEPLACE;
        }
        if(etat == EtatsPartie.BLANC_DEPLACE) {

        }
        if(etat == EtatsPartie.NOIR_JOUE && tablePositions.caseOccupee(noBouton)==2) {

        }
    }

    public Position caseToPosition(int noBouton) {
        return new Position(noBouton%8+1, 8-(noBouton/8+1)+1);
    }

    public static void main(String[] args) {
        ControleurPartie controleur = new ControleurPartie("Premier joueur", "Second joueur", new Code(123456789), EtatsPartie.JOUER_RENCONTRE);
    }

    public ControleurPartie(String infoJoueur1, String infoJoueur2, Code codeRencontre, EtatsPartie affronterOuRejouer) {
        new JeuInterface(this).setVisible(true);
        etat = affronterOuRejouer;
        tablePositions = new TablePositions();
        
        if(etat == EtatsPartie.REJOUER_PARTIE) System.out.println("Ce cas n'est pas traité");
        else if (etat == EtatsPartie.JOUER_RENCONTRE) {
            new VueJoueur(infoJoueur1, infoJoueur2).setVisible(true);
            etat = EtatsPartie.BLANC_JOUE;
        }
        new VueJoueur(infoJoueur1, infoJoueur2).setVisible(true);

    }
}
