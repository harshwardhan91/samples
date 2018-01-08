package com.local.chessgame;

public class Spot {

    Piece piece;
    int x;
    int y;

    public Spot(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void emptySpot(){
        piece = null;
    }

    public boolean occupySpot(Piece piece){
        if(this.piece == null){
            this.piece = piece;
            return true;
        }
        if(this.piece.getColor() == piece.getColor()){
            return false;
        }
        this.piece.setAlive(false);
        this.piece = piece;
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSame(Spot givenSpot){
        if(givenSpot == null){
            return false;
        }
        if(givenSpot.getY() == y && givenSpot.getX() == x){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if(piece!=null) {
            return piece.toString();
        }
        return "___\t";
    }
}
