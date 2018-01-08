package com.local.chessgame;

public class Pawn extends Piece {

    boolean isFirstMove = true;
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean verifyMove(Spot from, Spot to) {
        if(!super.verifyMove(from, to)){
            return false;
        }
        if(isFirstMove){
            isFirstMove = false;
            if(color==Color.WHITE){
                if(to.getY() == from.getY() + 2){
                    return  true;
                }
            }else{
                if(to.getY() == from.getY() - 2){
                    return  true;
                }
            }
        }
        if(color == Color.WHITE) {
            return to.getY() == from.getY() + 1;
        }else{
            return to.getY() == from.getY() - 1;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"Pwn";
    }
}
