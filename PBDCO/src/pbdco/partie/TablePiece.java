/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

/**
 *
 * @author belin
 */
public class TablePiece {
    private Piece[] tablePiece = new Piece[32];

    public Piece[] getTablePiece(){
        return this.tablePiece;
    }

    public void setTablePiece(Piece[] tablePiece){
        this.tablePiece = tablePiece;
    }

    public Piece getPiece(int number){
        return this.tablePiece[number];
    }

    public void setPiece(int number, String nom, int couleur, Position previousPosition, Position currentPosition){
        this.tablePiece[number].setCouleur(couleur);
        this.tablePiece[number].setNom("");
        this.tablePiece[number].getCurrentPosition().setPosition(currentPosition.getX(),currentPosition.getY());
        this.tablePiece[number].getPreviousPosition().setPosition(previousPosition.getX(),previousPosition.getY());
    }

    public void init(){
        TablePositions tablePositions = new TablePositions();
        tablePositions.init();
        //NOIRS
        setPiece(0,"tour",2,tablePositions.getPosition(0), tablePositions.getPosition(0));
        setPiece(0,"tour",2,tablePositions.getPosition(1), tablePositions.getPosition(1));
        setPiece(1,"fou",2,tablePositions.getPosition(2), tablePositions.getPosition(2));
        setPiece(2,"cavalier",2,tablePositions.getPosition(3), tablePositions.getPosition(3));
        setPiece(3,"dame",2,tablePositions.getPosition(4), tablePositions.getPosition(4));
        setPiece(4,"roi",2,tablePositions.getPosition(5), tablePositions.getPosition(5));
        setPiece(5,"cavalier",2,tablePositions.getPosition(6), tablePositions.getPosition(6));
        setPiece(6,"fou",2,tablePositions.getPosition(7), tablePositions.getPosition(7));
        setPiece(7,"tour",2,tablePositions.getPosition(8), tablePositions.getPosition(8));
        setPiece(8,"pion",2,tablePositions.getPosition(9), tablePositions.getPosition(9));
        setPiece(9,"pion",2,tablePositions.getPosition(10), tablePositions.getPosition(10));
        setPiece(10,"pion",2,tablePositions.getPosition(11), tablePositions.getPosition(11));
        setPiece(11,"pion",2,tablePositions.getPosition(12), tablePositions.getPosition(12));
        setPiece(12,"pion",2,tablePositions.getPosition(13), tablePositions.getPosition(13));
        setPiece(13,"pion",2,tablePositions.getPosition(14), tablePositions.getPosition(14));
        setPiece(14,"pion",2,tablePositions.getPosition(15), tablePositions.getPosition(15));
        setPiece(15,"pion",2,tablePositions.getPosition(16), tablePositions.getPosition(16));
        //BLANCS
        setPiece(16,"pion",1,tablePositions.getPosition(17), tablePositions.getPosition(17));
        setPiece(17,"pion",1,tablePositions.getPosition(18), tablePositions.getPosition(18));
        setPiece(18,"pion",1,tablePositions.getPosition(19), tablePositions.getPosition(19));
        setPiece(19,"pion",1,tablePositions.getPosition(20), tablePositions.getPosition(20));
        setPiece(20,"pion",1,tablePositions.getPosition(21), tablePositions.getPosition(21));
        setPiece(21,"pion",1,tablePositions.getPosition(22), tablePositions.getPosition(22));
        setPiece(22,"pion",1,tablePositions.getPosition(23), tablePositions.getPosition(23));
        setPiece(23,"pion",1,tablePositions.getPosition(24), tablePositions.getPosition(24));
        setPiece(24,"tour",1,tablePositions.getPosition(25), tablePositions.getPosition(25));
        setPiece(25,"fou",1,tablePositions.getPosition(26), tablePositions.getPosition(26));
        setPiece(26,"cavalier",1,tablePositions.getPosition(27), tablePositions.getPosition(27));
        setPiece(27,"dame",1,tablePositions.getPosition(28), tablePositions.getPosition(28));
        setPiece(28,"roi",1,tablePositions.getPosition(29), tablePositions.getPosition(29));
        setPiece(29,"cavalier",1,tablePositions.getPosition(30), tablePositions.getPosition(30));
        setPiece(30,"fou",1,tablePositions.getPosition(31), tablePositions.getPosition(31));
        setPiece(31,"tour",1,tablePositions.getPosition(32), tablePositions.getPosition(32));
    }
}
