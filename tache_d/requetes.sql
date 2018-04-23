/****REQUETES****/

/* nombre joueurs */
SELECT COUNT(Joueurs) FROM Joueurs WHERE codeTour=XXX;

/* nombre parties gagnées par joueur */ 
SELECT COUNT(Vainqueur) FROM Vainqueur where codeJoueur=XXX;

/* nombre parties à jouer par joueur */
SELECT COUNT(Rencontres) FROM Rencontres WHERE codeJoueur=XXX;

/* liste parties par tour */
SELECT COUNT(Rencontres) FROM Rencontres WHERE codeTour=XXX;

/* liste parties à jouer / en train d'être jouées par tour */
SELECT codeRencontre, 

/* Rang d'un joueur */
SELECT codeJoueur,COUNT(Vainqueur) AS NbVictoires,ROW_NUMBER() RNO OVER (ORDER BY NBVictoires) 
FROM Vainqueur 
ORDER BY NbVictoires 
WHERE codeJouer=Machin;


/* Les parties en cours */
/* Si on créer une rencontre seulement quand elle commence: */
SELECT codeRencontre from Rencontres 
MINUS 
(SELECT codeRencontre from Vainqueur); 
