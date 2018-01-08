package com.local.chessgame;

public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean verifyMove(Spot from, Spot to) {
        if(super.verifyMove(from,to) || Math.abs(from.getX() - to.getX()) <=1 || Math.abs(from.getY() - to.getY()) <=1){
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()+"King";
    }


}
