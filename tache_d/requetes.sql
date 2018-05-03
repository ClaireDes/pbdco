/****REQUETES****/

/* nombre joueurs */
SELECT COUNT(codeJoueur) FROM Joueur NATURAL JOIN Rencontre WHERE codeTour='finale';

/* nombre parties gagnées par joueur */ 
SELECT COUNT(Vainqueur) FROM Vainqueur where codeJoueur=XXX;

/* nombre parties à jouer par joueur */
SELECT COUNT(Rencontres) FROM Rencontres WHERE codeJoueur=XXX;

/* liste parties par tour */
SELECT COUNT(Rencontres) FROM Rencontres WHERE codeTour=XXX;

/* liste parties à jouer / en train d'être jouées par tour */
SELECT codeRencontre, 



/* Les parties en cours */
/* Si on crée une rencontre seulement quand elle commence: */
SELECT codeRencontre from Rencontres 
MINUS 
(SELECT codeRencontre from Vainqueur); 


/*Position possible ? */
/* la colonne CASE ainsi créee indique si la case est atteignable par la pièce ou non*/
SELECT codepiece,CASE 
WHEN ligneFin > 8 OR ligneFin < 0 OR colonneFin < 0 OR colonneFin > 8 THEN 'false'
WHEN typepiece = 'tour' and lignefin=ligneinit THEN 'true'
WHEN typepiece = 'tour' AND colonneFin=colonneInit THEN 'true'
WHEN typepiece = 'tour' AND ligneFin <> ligneInit AND colonneFin <> colonneFin THEN 'false'
WHEN typepiece = 'fou' AND ABS(ligneInit-ligneFin) = ABS(colonneInit-colonneFin) THEN 'true'
WHEN typepiece = 'fou' AND ABS(ligneInit-ligneFin) <> ABS(colonneInit-colonneFin) THEN 'false'
WHEN typepiece = 'cavalier' AND ABS(ligneInit-ligneFin)=2 AND ABS(colonneInit-colonneFin)=1 THEN 'true'
WHEN typepiece = 'cavalier' AND ABS(ligneInit-ligneFin)=1 AND ABS(colonneInit-colonneFin)=2 THEN 'true'
WHEN typepiece = 'cavalier' AND ABS(ligneInit-ligneFin)=1 AND ABS(colonneInit-colonneFin)<>2 THEN 'false'
WHEN typepiece = 'cavalier' AND ABS(ligneInit-ligneFin)=2 AND ABS(colonneInit-colonneFin)<>1 THEN 'false'
WHEN typepiece = 'cavalier' AND ABS(ligneInit-ligneFin)<>1 AND ABS(colonneInit-colonneFin)=2 THEN 'false'
WHEN typepiece = 'cavalier' AND ABS(ligneInit-ligneFin)<>2 AND ABS(colonneInit-colonneFin)=1 THEN 'true'
WHEN typepiece = 'cavalier' AND ABS(ligneInit-ligneFin)>1 THEN 'false'
WHEN typepiece = 'cavalier' AND ABS(colonneInit-colonneFin)>1 THEN 'false'
WHEN typepiece = 'roi' AND ABS(ligneInit-ligneFin)>1 THEN 'false'
WHEN typepiece = 'roi' AND ABS(colonneInit-colonneFin)>1 THEN 'false'
WHEN typepiece = 'roi' AND ABS(ligneInit-ligneFin)=1 OR ABS(colonneInit-colonneFin)=1 THEN 'true'
WHEN typepiece = 'reine' AND ABS(ligneInit-ligneFin) = ABS(colonneInit-colonneFin) THEN 'true'
WHEN typepiece = 'reine' AND ligneFin=ligneInit THEN 'true'
WHEN typepiece = 'reine' AND colonneFin=colonneInit THEN 'true'
ELSE 'false' 
END AS possible FROM Piece;
	
		
/*position => couleur */
SELECT couleur FROM Piece
WHERE ligneInit = L AND colonneInit = C;

/*quel tour on est */
SELECT codeTour FROM Rencontre;









