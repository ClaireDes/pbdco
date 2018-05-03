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


/*Position possible ? */
/* la colonne CASE ainsi créee indique si la case est atteignable par la pièce ou non*/
SELECT ligneFin, colonneFin 
FROM Pieces 
CASE
	WHEN ligneFin > 8 OR ligneFin < 0 OR colonneFin < 0 OR colonneFin > 8 THEN 'false'
	WHEN type = 'tour' AND ligneFin=ligneInit THEN 'true' /*on suppose qu'on se deplace*/
	WHEN type = 'tour' AND colonneFin=colonneInit THEN 'true'
	WHEN type = 'tour' AND ligneFin <> ligneInit AND colonneFin <> colonneFin THEN 'false'
	WHEN type = 'fou' AND ABS(ligneInit-ligneFin) = ABS(colonneInit-colonneFin) THEN 'true'
	WHEN type = 'fou' AND ABS(ligneInit-ligneFin) <> ABS(colonneInit-colonneFin) THEN 'false'
	WHEN type = 'cavalier' AND ABS(ligneInit-ligneFin)=2 AND ABS(colonneInit-colonneFin)=1 THEN 'true'
	WHEN type = 'cavalier' AND ABS(ligneInit-ligneFin)=1 AND ABS(colonneInit-colonneFin)=2 THEN 'true'
	WHEN type = 'cavalier' AND ABS(ligneInit-ligneFin)=1 AND ABS(colonneInit-colonneFin)<>2 THEN 'false'
	WHEN type = 'cavalier' AND ABS(ligneInit-ligneFin)=2 AND ABS(colonneInit-colonneFin)<>1 THEN 'false'
	WHEN type = 'cavalier' AND ABS(ligneInit-ligneFin)<>1 AND ABS(colonneInit-colonneFin)=2 THEN 'false'
	WHEN type = 'cavalier' AND ABS(ligneInit-ligneFin)<>2 AND ABS(colonneInit-colonneFin)=1 THEN 'true'
	WHEN type = 'cavalier' AND ABS(ligneInit-ligneFin)>1 THEN 'false'
	WHEN type = 'cavalier' AND ABS(colonneInit-colonneFin)>1 THEN 'false'
	WHEN type = 'roi' AND ABS(ligneInit-ligneFin)>1 THEN 'false'
	WHEN type = 'roi' AND ABS(colonneInit-colonneFin)>1 THEN 'false'
	WHEN type = 'roi' AND ABS(ligneInit-ligneFin)=1 OR ABS(colonneInit-colonneFin)=1 THEN 'true'
	WHEN type = 'reine' AND ABS(ligneInit-ligneFin) = ABS(colonneInit-colonneFin) THEN 'true'
	WHEN type = 'reine' AND ligneFin=ligneInit THEN 'true'
	WHEN type = 'reine' AND colonneFin=colonneInit THEN 'true'
ELSE 'false';
	
		




/*position => couleur */
