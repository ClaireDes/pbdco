/*transactions*/

/*creer echiquier*/
/*codeR et codeT sont des variables detrminees en java*/
INSERT INTO Piece
VALUES (1,1,1,null,null,'tour','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (2,1,2,null,null,'cavalier','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (3,1,3,null,null,'fou','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (4,1,4,null,null,'reine','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (5,1,5,null,null,'roi','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (6,1,6,null,null,'fou','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (7,1,7,null,null,'cavalier','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (8,1,8,null,null,'tour','blanc','codeR','codeT');

INSERT INTO Piece 
VALUES (9,2,1,null,null,'pion','blanc','codeR','codeT');

INSERT INTO Piece 
VALUES (10,2,2,null,null,'pion','blanc','codeR','codeT');

INSERT INTO Piece 
VALUES (11,2,3,null,null,'pion','blanc','codeR','codeT');

INSERT INTO Piece 
VALUES (12,2,4,null,null,'pion','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (13,2,5,null,null,'pion','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (14,2,6,null,null,'pion','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (15,2,7,null,null,'pion','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (16,2,8,null,null,'pion','blanc','codeR','codeT');

INSERT INTO Piece
VALUES (17,7,1,null,null,'pion','noir','codeR','codeT');

INSERT INTO Piece
VALUES (18,7,2,null,null,'pion','noir','codeR','codeT');

INSERT INTO Piece
VALUES (19,7,3,null,null,'pion','noir','codeR','codeT');

INSERT INTO Piece
VALUES (20,7,4,null,null,'pion','noir','codeR','codeT');

INSERT INTO Piece
VALUES (21,7,5,null,null,'pion','noir','codeR','codeT');

INSERT INTO Piece 
VALUES (22,7,6,null,null,'pion','noir','codeR','codeT');

INSERT INTO Piece
VALUES (23,7,7,null,null,'pion','noir','codeR','codeT');

INSERT INTO Piece
VALUES (24,7,8,null,null,'pion','noir','codeR','codeT');

INSERT INTO Piece
VALUES (25,8,1,null,null,'tour','noir','codeR','codeT');

INSERT INTO Piece
VALUES (26,8,2,null,null,'cavalier','noir','codeR','codeT');

INSERT INTO Piece
VALUES (27,8,3,null,null,'fou','noir','codeR','codeT');

INSERT INTO Piece
VALUES (28,8,4,null,null,'roi','noir','codeR','codeT');

INSERT INTO Piece 
VALUES (29,8,5,null,null,'reine','noir','codeR','codeT');

INSERT INTO Piece
VALUES (30,8,6,null,null,'fou','noir','codeR','codeT');

INSERT INTO Piece 
VALUES (31,8,7,null,null,'cavalier','noir','codeR','codeT');

INSERT INTO Piece 
VALUES (32,8,8,null,null,'tour','noir','codeR','codeT');


/*rejouer une partie*/
DELETE * FROM Coup WHERE codeRencontre=codeR AND codeTour=codeT;
DELETE * FROM Piece WHERE codeRencontre=codeR AND codeTour=codeT;
/* + creer echiquier */
  

/* Créer coup */
INSERT INTO Coup VALUES (codeC, ligneC, colonneC, ligneP, colonneP,codeR, codeT);
UPDATE Piece SET colonneInit=colonneC AND ligneInit=ligneC WHERE colonneFin=colonneC AND ligneFin=colonneC;

/* Demarrer un nouveau tour */
UPDATE Tour SET codeTour=codeT WHERE codeTour=codeT2;






















<<<<<<< HEAD


=======
>>>>>>> modele_bd
