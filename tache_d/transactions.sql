/****TRANSACTIONS****/

/* Créer joueur */
INSERT INTO Joueurs(codeJoueur, Prenom, Nom, Adresse) VALUES (id_louis, 'Louis','Martin', '32 rue des marguerites, 12345 JolieVille');

/* Créer rencontre */
INSERT INTO Rencontres(codeTour, codeRencontre, JoueurBlanc, JoueurNoir) VALUES ('finale',1,21,16);

/* Rejouer partie */

/* Supprimer l'historique */
DELETE FROM Coups WHERE codeRencontre=rencontreARejouer;

/* Mettre à jour JoueurBlanc, JoueurNoir */
UPDATE Rencontre SET (JoueurBlanc=nouveauJBlanc) WHERE codeRencontre=rencontreARejouer;

/* Créer coup */
INSERT INTO Coups VALUES (codeCoup, LigneCourante, ColonneCourante, LignePrec, ColonnePrec);

