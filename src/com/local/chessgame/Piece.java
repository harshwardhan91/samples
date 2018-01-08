package com.local.chessgame;

public abstract class Piece implements PieceVerify{
    protected Color color;
    protected boolean isAlive = true;

    public boolean verifyMove(Spot from,Spot to){
        return from != null && to != null && !from.isSame(to) && isAlive;
    }

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return color.toString().toCharArray()[0]+"";
    }
}
