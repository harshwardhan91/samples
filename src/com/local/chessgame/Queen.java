package com.local.chessgame;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean verifyMove(Spot from, Spot to) {
        if(!super.verifyMove(from, to)){
            return false;
        }
        if(to.getX() - from.getX() == to.getY() - from.getY()){
            return true;
        }else if(from.getX() == to.getX()){
            return true;
        }else if(from.getY() == to.getY()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()+"Qun";
    }
}
