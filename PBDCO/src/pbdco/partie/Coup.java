/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

/**
 *
 * @author belinbr
 */
public class Coup {

    private Boolean misEnEchec = false; //savoir si on fait un échec à ce coup
    private Position[] currentEchecPositionList = new Position[50]; //50 décidé arbitrairement : liste des positions qu'il est possible d'atteindre à partir de la position acuelle d'une pièce
    private Position[] previousEchecPositionList = new Position[50]; //50 décidé arbitrairement : liste des positions qu'il est possible d'atteindre à partir de la position précédente d'une pièce

    public Boolean getMisEnEchec(){
        return this.misEnEchec;
    }

    public void setMisEnEchec(Boolean misEnEchec){
        this.misEnEchec = misEnEchec;
    }

    public int getPreviousX(Piece piece){
        return piece.getPreviousPosition().getX();
    }

    public int getPreviousY(Piece piece){
        return piece.getPreviousPosition().getY();
    }
    
    public int getCurrentX(Piece piece){
        return piece.getCurrentPosition().getX();
    }
    
    public int getCurrentY(Piece piece){
        return piece.getCurrentPosition().getY();
    }

    public void updatePositionPiece(Piece piece, Position newPosition){
        piece.updatePosition(new Position(newPosition.getX(), newPosition.getY(),piece.getColorBool()));
    }

    //calcule toutes les positions diagonales accessibles à partir de la pièce et charge les données dans les deux listes de positions
    public int setDiagonalPositions(Piece piece, TablePositions tablePositions, Position[] currentEchecPositionList, Position[] previousEchecPositionList){
      int i=0;
      int j=0;
      int k=0;
      int l=0;
      //CALCUL DIAGONALE HAUTE DROITE
      while(piece.getCurrentPosition().getX()<(8-i) && piece.getCurrentPosition().getY()<(8-i) && tablePositions.getPosition(piece.getIntCurrentPosition()+9*i).getState()==0){
        currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+9*i);
        i=i+1;
      }
      //CALCUL DIAGONALE HAUTE GAUCHE
      while(piece.getCurrentPosition().getX()>(1+j) && piece.getCurrentPosition().getY()<(8-j) && tablePositions.getPosition(piece.getIntCurrentPosition()+7*j).getState()==0){
        currentEchecPositionList[j+i] = tablePositions.getPosition(piece.getIntCurrentPosition()+7*j);
        j=j+1;
      }
      //CALCUL DIAGONALE BASSE DROITE
      while(piece.getCurrentPosition().getY()>(1+k) && piece.getCurrentPosition().getX()<(8-k) && tablePositions.getPosition(piece.getIntCurrentPosition()-7*k).getState()==0){
        currentEchecPositionList[k+i+j] = tablePositions.getPosition(piece.getIntCurrentPosition()-7*k);
        k=k+1;
      }
      //CALCUL DIAGONALE BASSE GAUCHE
      while(piece.getCurrentPosition().getY()>(1+l) && piece.getCurrentPosition().getX()>(1+l) && tablePositions.getPosition(piece.getIntCurrentPosition()-9*l).getState()==0){
        currentEchecPositionList[k+i+j+l] = tablePositions.getPosition(piece.getIntCurrentPosition()-9*l);
        l=l+1;
      }

      //CALCUL POUR LA POSITION PRECEDENTE
      i=j=k=l=0;

      while(piece.getPreviousPosition().getX()<(8-i) && piece.getPreviousPosition().getY()<(8-i) && tablePositions.getPosition(piece.getIntPreviousPosition()+9*i).getState()==0){
        previousEchecPositionList[i] = tablePositions.getPosition(piece.getIntPreviousPosition()+9*i);
        i=i+1;
      }
      while(piece.getPreviousPosition().getX()>(1+j) && piece.getPreviousPosition().getY()<(8-j) && tablePositions.getPosition(piece.getIntPreviousPosition()+7*j).getState()==0){
        previousEchecPositionList[j+i] = tablePositions.getPosition(piece.getIntPreviousPosition()+7*j);
        j=j+1;
      }
      while(piece.getPreviousPosition().getY()>(1+k) && piece.getPreviousPosition().getX()<(8-k) && tablePositions.getPosition(piece.getIntPreviousPosition()-7*k).getState()==0){
        previousEchecPositionList[k+i+j] = tablePositions.getPosition(piece.getIntPreviousPosition()-7*k);
        k=k+1;
      }
      while(piece.getPreviousPosition().getY()>(1+l) && piece.getPreviousPosition().getX()>(1+l) && tablePositions.getPosition(piece.getIntPreviousPosition()-9*l).getState()==0){
        previousEchecPositionList[k+i+j+l] = tablePositions.getPosition(piece.getIntPreviousPosition()-9*l);
        l=l+1;
      }
      return i+j+k+l; //utile pour le calcul de la dame qui doit charger d'autres positions
    }

    //calcule les positions accessibles via ligne droite à partir d'une pièce et charge les données dans les listes de positions
    public void setStraightPositions(Piece piece, TablePositions tablePositions, Position[] currentEchecPositionList, Position[] previousEchecPositionList, int a){
      int m = 0;
      int n=0;
      int o=0;
      int p = 0;
      //CALCUL LIGNE DROITE
      while(piece.getCurrentPosition().getX()<(8-m) && tablePositions.getPosition(piece.getIntCurrentPosition()+m).getState()==0){
        currentEchecPositionList[a+m] = tablePositions.getPosition(piece.getIntCurrentPosition()+m);
        m=m+1;
      }
      ///CALCUL LIGNE DESSUS
      while(piece.getCurrentPosition().getY()<(8-n) && tablePositions.getPosition(piece.getIntCurrentPosition()+8*n).getState()==0){
        currentEchecPositionList[a+m+n] = tablePositions.getPosition(piece.getIntCurrentPosition()+8*n);
        n=n+1;
      }
      //CALCUL LIGNE DESSOUS
      while(piece.getCurrentPosition().getY()>(1+o) && tablePositions.getPosition(piece.getIntCurrentPosition()-8*o).getState()==0){
        currentEchecPositionList[a+m+n+o] = tablePositions.getPosition(piece.getIntCurrentPosition()-8*o);
        o=o+1;
      }
      //CALCUL LIGNE GAUCHE
      while(piece.getCurrentPosition().getX()>(1+p) && tablePositions.getPosition(piece.getIntCurrentPosition()-p).getState()==0){
        currentEchecPositionList[a+m+n+o+p] = tablePositions.getPosition(piece.getIntCurrentPosition()-p);
        p=p+1;
      }

      //CALCUL POUR LA POSITION PRECEDENTE
      m=n=o=p=0;
      while(piece.getPreviousPosition().getX()<(8-m) && tablePositions.getPosition(piece.getIntPreviousPosition()+m).getState()==0){
        previousEchecPositionList[a+m] = tablePositions.getPosition(piece.getIntPreviousPosition()+m);
        m=m+1;
      }
      while(piece.getPreviousPosition().getY()<(8-n) && tablePositions.getPosition(piece.getIntPreviousPosition()+8*n).getState()==0){
        previousEchecPositionList[a+m+n] = tablePositions.getPosition(piece.getIntPreviousPosition()+8*n);
        n=n+1;
      }
      while(piece.getPreviousPosition().getY()>(1+o) && tablePositions.getPosition(piece.getIntPreviousPosition()-8*o).getState()==0){
        previousEchecPositionList[a+m+n+o] = tablePositions.getPosition(piece.getIntPreviousPosition()-8*o);
        o=o+1;
      }
      while(piece.getPreviousPosition().getX()>(1+p) && tablePositions.getPosition(piece.getIntPreviousPosition()-p).getState()==0){
        previousEchecPositionList[a+m+n+o+p] = tablePositions.getPosition(piece.getIntPreviousPosition()-p);
        p=p+1;
      }
    }

    //pour une pièce donnée, charge les positions anciennes et courantes accessibles sans obstacle
    public void setEchecCase(Piece piece, TablePositions tablePositions){
        int i = 0;
        int j = 0;
        int b,c;
        switch (piece.getNom()) {

          case "pion":
              if(piece.getColorBool()==1){ //less blancs sont en haut, le pion ne peut donc aller qu'en bas
                if(piece.getCurrentPosition().getX()<8 && piece.getCurrentPosition().getY()>1){
                  currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-7);
                  i=i+1;
                }
                if(piece.getCurrentPosition().getX()>1 && piece.getCurrentPosition().getY()>1){
                  currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-9);
                }
                if(piece.getPreviousPosition().getX()<8 && piece.getPreviousPosition().getY()>1){
                  previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-7);
                  j=j+1;
                }
                if(piece.getPreviousPosition().getX()>1 && piece.getPreviousPosition().getY()>1){
                  previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-9);
                }
              }
              else{//les noirs en bas, le pion ne peut que monter
                if(piece.getCurrentPosition().getX()<8 && piece.getCurrentPosition().getY()<8){
                  currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+9);
                  i=i+1;
                }
                if(piece.getCurrentPosition().getX()>1 && piece.getCurrentPosition().getY()<8){
                  currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+7);
                }
                if(piece.getPreviousPosition().getX()<8 && piece.getPreviousPosition().getY()<8){
                  previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+9);
                  j=j+1;
                }
                if(piece.getPreviousPosition().getX()>1 && piece.getPreviousPosition().getY()<8){
                  previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+7);
                }
              }
              for(c=0;c<previousEchecPositionList.length;c++){
                  previousEchecPositionList[c].setEchec((false));
              }
              for(b=0;i<currentEchecPositionList.length;b++){
                currentEchecPositionList[b].setEchec(true);
              }
            break;

          case "tour": //appel de la méthode de calcul des positions en ligne droite
              setStraightPositions(piece, tablePositions, currentEchecPositionList, previousEchecPositionList,0);
              for(c=0;c<previousEchecPositionList.length;c++){
                  previousEchecPositionList[c].setEchec((false));
              }
              for(b=0;i<currentEchecPositionList.length;b++){
                currentEchecPositionList[b].setEchec(true);
              }
            break;

          case "fou": //appel de la méthoode de calcul des positions en diagonale
              int L = setDiagonalPositions(piece, tablePositions, currentEchecPositionList, previousEchecPositionList);
              for(c=0;c<previousEchecPositionList.length;c++){
                  previousEchecPositionList[c].setEchec((false));
              }
              for(b=0;i<currentEchecPositionList.length;b++){
                currentEchecPositionList[b].setEchec(true);
              }
            break;

          case "roi": //calcul des positions accessibles pour le roi : pas de sens de déplacement, toutes les positions adjacentes uniquement
            if(piece.getCurrentPosition().getX()<8 && piece.getCurrentPosition().getY()>1){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-7);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()>1 && piece.getCurrentPosition().getY()>1){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-9);
              i=i+1;
            }
            if(piece.getCurrentPosition().getY()>1){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-8);
              i=i+1;
            }
            if(piece.getCurrentPosition().getY()<8){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+8);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()<8 && piece.getCurrentPosition().getY()<8){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+9);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()>1 && piece.getCurrentPosition().getY()<8){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+7);
            }
            if(piece.getCurrentPosition().getX()>1){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-1);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()<8){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+1);
            }
            if(piece.getPreviousPosition().getX()<8 && piece.getPreviousPosition().getY()>1){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-7);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()>1 && piece.getPreviousPosition().getY()>1){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-9);
            }
            if(piece.getPreviousPosition().getX()<8 && piece.getPreviousPosition().getY()<8){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+9);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()>1 && piece.getPreviousPosition().getY()<8){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+7);
              j=j+1;
            }
            if(piece.getPreviousPosition().getY()>1){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-8);
              j=j+1;
            }
            if(piece.getPreviousPosition().getY()<8){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+8);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()>1){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-1);
              j=i+1;
            }
            if(piece.getPreviousPosition().getX()<8){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+1);
            }
            for(c=0;c<previousEchecPositionList.length;c++){
                  previousEchecPositionList[c].setEchec((false));
              }
              for(b=0;i<currentEchecPositionList.length;b++){
                currentEchecPositionList[b].setEchec(true);
              }
            break;

          case "dame": //appels des méthodes de calcul des positions en diagonale et ligne droite
              L = setDiagonalPositions(piece, tablePositions, currentEchecPositionList, previousEchecPositionList);
              setStraightPositions(piece, tablePositions, currentEchecPositionList, previousEchecPositionList,L);
              for(c=0;c<previousEchecPositionList.length;c++){
                  previousEchecPositionList[c].setEchec((false));
              }
              for(b=0;i<currentEchecPositionList.length;b++){
                currentEchecPositionList[b].setEchec(true);
              }
            break;

          case "cavalier": //calcul positions accessibles pour le cavalier, pas de sens de déplacement, seulement 8 positions accessibles au maximum
            if(piece.getCurrentPosition().getX()<8 && piece.getCurrentPosition().getY()<7){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+17);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()>1 && piece.getCurrentPosition().getY()<7){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+15);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()>2 && piece.getCurrentPosition().getY()<8){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+6);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()<7 && piece.getCurrentPosition().getY()<8){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()+10);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()<2 && piece.getCurrentPosition().getY()>1){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-10);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()<7 && piece.getCurrentPosition().getY()>1){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-6);
            }
            if(piece.getCurrentPosition().getX()>1 && piece.getCurrentPosition().getY()>2){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-17);
              i=i+1;
            }
            if(piece.getCurrentPosition().getX()<8 && piece.getCurrentPosition().getY()>2){
              currentEchecPositionList[i] = tablePositions.getPosition(piece.getIntCurrentPosition()-15);
            }


            if(piece.getPreviousPosition().getX()<8 && piece.getPreviousPosition().getY()<7){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+17);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()>1 && piece.getPreviousPosition().getY()<7){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+15);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()>2 && piece.getPreviousPosition().getY()<8){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+6);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()<7 && piece.getPreviousPosition().getY()<8){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()+10);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()<2 && piece.getPreviousPosition().getY()>1){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-10);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()<7 && piece.getPreviousPosition().getY()>1){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-6);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()>1 && piece.getPreviousPosition().getY()>2){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-17);
              j=j+1;
            }
            if(piece.getPreviousPosition().getX()<8 && piece.getPreviousPosition().getY()>2){
              previousEchecPositionList[j] = tablePositions.getPosition(piece.getIntPreviousPosition()-15);
            }
            for(c=0;c<previousEchecPositionList.length;c++){
                  previousEchecPositionList[c].setEchec((false));
              }
              for(b=0;i<currentEchecPositionList.length;b++){
                currentEchecPositionList[b].setEchec(true);
              }
            break;
          default :
            System.out.println("ERREUR : pièce mal définie");
        }
    }
    public void verifyCoup(Piece piece, Position newPosition, TablePositions tablePositions){

        int deltaX = newPosition.getX()-piece.getCurrentPosition().getX();
        int deltaY = newPosition.getY()-piece.getCurrentPosition().getY();
        int i =0;

        switch (piece.getNom()) {
            case "pion":
                if(newPosition.getState()!=0 && piece.getColorBool()!=newPosition.getState()){//si la case est occupée par une pièce
                        if(newPosition.getPiece().getNom().equals("roi")){
                            System.out.println("Echec !");
                            this.setMisEnEchec(true);
                        }
                        // A FAIRE
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                else if(newPosition.getState()!=0 && piece.getColorBool()==newPosition.getState()){
                    throw new UnsupportedOperationException("on ne peut aller sur une case occupée par une de ses propres pièces déjà");
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                setEchecCase(piece, tablePositions);
                break;
            case "roi":
                if(!newPosition.getEchec()){//on vérifie que le roi ne se met pas sur une case en échec
                    if(newPosition.getState()!=0 && piece.getColorBool()!=newPosition.getState()){//si la case est occupée
                        // A FAIRE
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                    }
                    else if(newPosition.getState()!=0 && piece.getColorBool()==newPosition.getState()){
                        throw new UnsupportedOperationException("on ne peut aller sur une case occupée par une de ses propres pièces déjà");
                    }
                    updatePositionPiece(piece, newPosition); //la pièce est déplacée
                    setEchecCase(piece, tablePositions);
                }
                else{
                    throw new UnsupportedOperationException("Le roi ne peut se mettre en échec");
                }
                break;
            case "dame":
                if(deltaX==0){//déplacement vertical
                    if(deltaY>0){//si la dame est en dessous de la case sélectionnée
                        while(i<deltaY){
                            i = i+1;
                            if(tablePositions.getPosition(piece.getIntCurrentPosition()+8*i).getState()!=0){
                                throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                    else if(deltaY<0){//si la dame est au dessus de la case sélectionnée
                        while(i<deltaY){
                            i = i+1;
                            if(tablePositions.getPosition(piece.getIntCurrentPosition()-8*i).getState()!=0){
                                throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                }
                else if(deltaY==0){//déplacement horizontal
                    if(deltaX>0){//si la dame est à gauche de la case sélectionnée
                        while(i<deltaX){
                            i = i+1;
                            if(tablePositions.getPosition(piece.getIntCurrentPosition()+i).getState()!=0){
                                throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                    else if(deltaX<0){//si la dame est à droite de la case sélectionnée
                        while(i<deltaX){
                            i = i+1;
                            if(tablePositions.getPosition(piece.getIntCurrentPosition()-i).getState()!=0){
                                throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                }
                else if(deltaX<0 && deltaY<0){//déplacement diagonale basse gauche
                    while(i<deltaX){
                        i = i+1;
                        if(tablePositions.getPosition(piece.getIntCurrentPosition()-9*i).getState()!=0){
                            throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX<0 && deltaY>0){//déplacement diagonale haute gauche
                    while(i<deltaX){
                        i = i+1;
                        if(tablePositions.getPosition(piece.getIntCurrentPosition()+7*i).getState()!=0){
                            throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX>0 && deltaY<0){//déplacement diagonale basse droite
                    while(i<deltaX){
                        i = i+1;
                        if(tablePositions.getPosition(piece.getIntCurrentPosition()-7*i).getState()!=0){
                            throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX>0 && deltaY>0){//déplacement diagonale haute droite
                    while(i<deltaX){
                        i = i+1;
                        if(tablePositions.getPosition(piece.getIntCurrentPosition()+9*i).getState()!=0){
                            throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                if(newPosition.getState()!=0 && piece.getColorBool()!=newPosition.getState()){//si la case est occupée
                        // A FAIRE
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                else if(newPosition.getState()!=0 && piece.getColorBool()==newPosition.getState()){
                    throw new UnsupportedOperationException("on ne peut aller sur une case occupée par une de ses propres pièces déjà");
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                setEchecCase(piece, tablePositions);
                break;
            case "tour":
                if(deltaX==0){//déplacement vertical
                    if(deltaY>0){//si la tour est en dessous de la case sélectionnée
                        while(i<deltaY){
                            i = i+1;
                            if(tablePositions.getPosition(piece.getIntCurrentPosition()+8*i).getState()!=0){
                                throw new UnsupportedOperationException("La tour ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                    else if(deltaY<0){//si la tour est au dessus de la case sélectionnée
                        while(i<deltaY){
                            i = i+1;
                            if(tablePositions.getPosition(piece.getIntCurrentPosition()-8*i).getState()!=0){
                                throw new UnsupportedOperationException("La tour ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                }
                else if(deltaY==0){//déplacement horizontal
                    if(deltaX>0){//si la tour est à gauche de la case sélectionnée
                        while(i<deltaX){
                            i = i+1;
                            if(tablePositions.getPosition(piece.getIntCurrentPosition()+i).getState()!=0){
                                throw new UnsupportedOperationException("La tour ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                    else if(deltaX<0){//si la tour est à droite de la case sélectionnée
                        while(i<deltaX){
                            i = i+1;
                            if(tablePositions.getPosition(piece.getIntCurrentPosition()-i).getState()!=0){
                                throw new UnsupportedOperationException("La tour ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                }
                if(newPosition.getState()!=0 && piece.getColorBool()!=newPosition.getState()){//si la case est occupée
                        // A FAIRE
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                else if(newPosition.getState()!=0 && piece.getColorBool()==newPosition.getState()){
                    throw new UnsupportedOperationException("on ne peut aller sur une case occupée par une de ses propres pièces déjà");
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                setEchecCase(piece, tablePositions);
                break;
            case "fou":
                if(deltaX<0 && deltaY<0){//déplacement diagonale basse gauche
                    while(i<deltaX){
                        i = i+1;
                        if(tablePositions.getPosition(piece.getIntCurrentPosition()-9*i).getState()!=0){
                            throw new UnsupportedOperationException("Le fou ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX<0 && deltaY>0){//déplacement diagonale haute gauche
                    while(i<deltaX){
                        i = i+1;
                        if(tablePositions.getPosition(piece.getIntCurrentPosition()+7*i).getState()!=0){
                            throw new UnsupportedOperationException("Le fou ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX>0 && deltaY<0){//déplacement diagonale basse droite
                    while(i<deltaX){
                        i = i+1;
                        if(tablePositions.getPosition(piece.getIntCurrentPosition()-7*i).getState()!=0){
                            throw new UnsupportedOperationException("Le fou ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX>0 && deltaY>0){//déplacement diagonale haute droite
                    while(i<deltaX){
                        i = i+1;
                        if(tablePositions.getPosition(piece.getIntCurrentPosition()+9*i).getState()!=0){
                            throw new UnsupportedOperationException("Le fou ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                if(newPosition.getState()!=0 && piece.getColorBool()!=newPosition.getState()){//si la case est occupée
                        // A FAIRE
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                else if(newPosition.getState()!=0 && piece.getColorBool()==newPosition.getState()){
                    throw new UnsupportedOperationException("on ne peut aller sur une case occupée par une de ses propres pièces déjà");
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                setEchecCase(piece, tablePositions);
                break;
            case "cavalier":
                if(newPosition.getState()!=0 && piece.getColorBool()!=newPosition.getState()){//si la case est occupée
                        // A FAIRE
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                else if(newPosition.getState()!=0 && piece.getColorBool()==newPosition.getState()){
                    throw new UnsupportedOperationException("on ne peut aller sur une case occupée par une de ses propres pièces déjà");
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                setEchecCase(piece, tablePositions);
                break;
            default:
                throw new UnsupportedOperationException("Pièce inexistante : mauvais nom");
        }
    }
}
