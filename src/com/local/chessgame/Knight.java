package com.local.chessgame;

public class Knight extends Piece{

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean verifyMove(Spot from, Spot to) {
        if (!super.verifyMove(from, to)) {
            return false;
        }
        if(to.getX() != from.getX() - 1 && to.getX() != from.getX() + 1 && to.getX() != from.getX() + 2 && to.getX() != from.getX() - 2)
            return false;
        if(to.getY() != from.getY() - 2 && to.getY() != from.getY() + 2 && to.getY() != from.getY() - 1 && to.getY() != from.getY() + 1)
            return false;
//        if(Math.sqrt(Math.pow(Math.abs((to.getX() - from.getX())),2)) + Math.pow(Math.abs((to.getY() - from.getY())), 2) !=
//                Math.sqrt(2) +1){
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+"Kgt";
    }
}
