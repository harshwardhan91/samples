package com.local.chessgame;

public class Player {

    Color playerColor;

    String name;


    public Player(Color playerColor,String name) {
        this.playerColor = playerColor;this.name = name;
    }

    @Override
    public String toString() {
        return name +
                "," + playerColor;
    }

    public Color getPlayerColor() {
        return playerColor;
    }
}
