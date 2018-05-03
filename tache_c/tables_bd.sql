//Lucas
DROP TABLE Joueur;
DROP TABLE Rencontre;
DROP TABLE Tour;
DROP TABLE Piece;
DROP TABLE Coup;

CREATE TABLE Tournoi(
  codeTournoi INT NOT NULL,
  codeTour CHAR(20) NOT NULL CHECK(codeTour IN('qualif','quart','demi','finale')),
  PRIMARY KEY (codeTournoi, codeTour)
)

CREATE TABLE Joueur (
  codeJoueur INT NOT NULL PRIMARY KEY,
  prenom CHAR(30) NOT NULL,
  nom CHAR(30) NOT NULL,
  adresse CHAR(50) NOT NULL
)

CREATE TABLE Rencontre(
  codeRencontre INT NOT NULL,
  codeTournoi INT NOT NULL,
  codeTour CHAR(20) NOT NULL,
  joueur1 INT NOT NULL,
  joueur2 INT NOT NULL,
  blanc INT,
  noir INT,
  vainqueur INT,
  PRIMARY KEY (codeRencontre, codeTour, codeTournoi),
  FOREIGN KEY (codeTournoi, codeTour) REFERENCES Tournoi(codeTournoi, codeTour),
  FOREIGN KEY (joueur1) REFERENCES Joueur(codeJoueur),
  FOREIGN KEY (joueur2) REFERENCES Joueur(codeJoueur),
  FOREIGN KEY (blanc) REFERENCES Joueur(codeJoueur),
  FOREIGN KEY (noir) REFERENCES Joueur(codeJoueur),
  FOREIGN KEY (vainqueur) REFERENCES Joueur(codeJoueur)
)

CREATE TABLE Piece(
  codePiece INT NOT NULL,
  ligneInit INT NOT NULL CHECK(ligneInit>0 AND ligneInit<9),
  colonneInit INT NOT NULL CHECK(colonneInit>0 AND colonneInit<9),
  ligneFin INT CHECK(ligneFin>0 AND ligneFin<9),
  colonneFin INT CHECK(colonneFin>0 AND colonneFin<9),
  typePiece CHAR(10) NOT NULL CHECK(typePiece IN ('pion','tour','fou', 'cavalier', 'roi', 'reine')),
  couleur CHAR(5) NOT NULL CHECK(couleur IN('blanc', 'noir', 'rose')),
  codeRencontre INT NOT NULL,
  codeTour CHAR(20) NOT NULL,
  codeTournoi INT NOT NULL,
  PRIMARY KEY (codePiece, codeRencontre, codeTour, codeTournoi),
  FOREIGN KEY (codeRencontre, codeTour, codeTournoi)  REFERENCES Rencontre(codeRencontre, codeTour, codeTournoi),
  CONSTRAINT Kuniq UNIQUE (ligneInit,colonneInit),
  CONSTRAINT Kpion CHECK ((typePiece!='pion') OR ((couleur='blanc' AND (ligneFin=ligneInit+1)) OR ((couleur='noir' AND (ligneFin=ligneInit-1))))),
  CONSTRAINT Ktour CHECK ((typePiece!='tour') OR ((ligneFin!=ligneInit AND colonneFin=colonneInit) OR ( ligneFin=ligneInit AND colonneFin!=colonneInit))),
  CONSTRAINT Kfou CHECK ((typePiece!='fou') OR (ABS(ligneFin-ligneInit)=ABS(colonneFin-colonneInit))),
  CONSTRAINT Kcavalier CHECK ((typePiece!='cavalier') OR ((ABS(ligneFin-ligneInit)=1 AND ABS(colonneFin-colonneInit)=2) OR (ABS(ligneFin-ligneInit)=2 AND ABS(colonneFin-colonneInit)=1))),
  CONSTRAINT Kroi CHECK ((typePiece!='roi') OR ((ABS(ligneFin-ligneInit)<2 AND ABS(colonneFin-colonneInit)<2))),
  CONSTRAINT Kreine CHECK ((typePiece!='reine') OR (((ligneFin!=ligneInit AND colonneFin=colonneInit) OR ( ligneFin=ligneInit AND colonneFin!=colonneInit)) OR (ABS(ligneFin-ligneInit)=ABS(colonneFin-colonneInit))))
)

CREATE TABLE Coup (
  codeCoup INT NOT NULL,
  ligneCour INT NOT NULL CHECK(ligneCour>0 AND ligneCour<9),
  ColonneCour INT NOT NULL CHECK(colonneCour>0 AND colonneCour<9),
  lignePrec INT NOT NULL CHECK(lignePrec>0 AND lignePrec<9),
  colonnePrec INT NOT NULL CHECK(colonnePrec>0 AND colonnePrec<9),
  codeRencontre INT NOT NULL,
  codeTour CHAR(20) NOT NULL,
  codeTournoi INT NOT NULL,
  PRIMARY KEY (codeCoup, codeRencontre, codeTour, codeTournoi),
  FOREIGN KEY (codeRencontre, codeTour, codeTournoi) REFERENCES Rencontre(codeRencontre, codeTour, codeTournoi)
)


tests :
INSERT INTO Tour VALUES('qualif');
insert into Joueur values(1,'Lucas','GRELLIER','lucas@gmail.com');
  insert into Joueur values(2,'Quentin','RAVENET','quentin@gmail.com');
    UPDATE Rencontre SET blanc=1, noir=2;
    insert into Piece values(1,2,1,null,null,'pion','blanc',1,'qualif')
      insert into Piece values(2,7,1,null,null,'pion','noir',1,'qualif')
