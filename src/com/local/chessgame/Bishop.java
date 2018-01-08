package com.local.chessgame;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean verifyMove(Spot from, Spot to) {
        if(!super.verifyMove(from, to)){
            return false;
        }
        return Math.abs(from.getX() - to.getX()) == Math.abs(from.getY() - to.getY());
    }

    @Override
    public String toString() {
        return super.toString()+"Bsh";
    }
}
