package com.local.chessgame;

import java.util.Scanner;

public class ChessGame {

    static Player player1;
    static Player player2;

    static ChessBoard chessBoard;

    public static boolean addPlayer(Player player){
        if(player1==null){
            player1 = player;
            return true;
        }else if(player2 == null){
            player2 = player;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to chess game");
        chessBoard = new ChessBoard();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player 1 name");
        String player1s = "q";//scanner.next();
        addPlayer(new Player(Color.WHITE,player1s));
        System.out.println("Enter player 2 name");
        String player2s = "w";//scanner.next();
        addPlayer(new Player(Color.BLACK,player2s));

        System.out.println("Your board is ready!!!!");
        chessBoard.displayBoard();

//        boolean b = chessBoard.movePiece(0, 1, 2, 0);
//        if(b){
//            System.out.println("sucess");
//            chessBoard.displayBoard();
//        }else{
//            System.out.println("not sucess");
//        }

        boolean skip1 = false;
        while (chessBoard.isGameAlive()){
            chessBoard.displayBoard();
            if(!skip1 && !movePlayer(scanner,player1)){
                continue;
            }
            skip1 = false;
            chessBoard.displayBoard();
            if(!movePlayer(scanner,player2)){
                skip1 = true;
                continue;
            }
        }
        chessBoard.displayBoard();
        if(player1.getPlayerColor().equals(chessBoard.getTrueKing())){
            System.out.println(player1 + " is true King");
        }else{
            System.out.println(player2 + " is true King");
        }

    }

    private static boolean movePlayer(Scanner scanner,Player player) {
        System.out.println("Enter move from "+ player + "separated by ',' y,x and - y,x");
        String p1Move = scanner.next();
        String[] split1 = p1Move.split("-");
        if(split1.length <2){
            System.out.println("not valid move bro");
            return false;
        }
        String[] split = split1[0].split(",");
        if(split1.length <2){
            System.out.println("not valid move bro");
            return false;
        }
        int fromY = Integer.parseInt(split[0]);
        int fromX = Integer.parseInt(split[1]);
        Color spotPieceColor = chessBoard.getSpotPieceColor(fromY, fromX);
        if(spotPieceColor == null || !spotPieceColor.equals(player.getPlayerColor())){
            System.out.println("not valid move bro");
            return false;
        }
        String[] split2 = split1[1].split(",");
        if(split2.length <2){
            System.out.println("not valid move bro");
            return false;
        }
        int toY = Integer.parseInt(split2[0]);
        int toX = Integer.parseInt(split2[1]);
        boolean b1 = chessBoard.movePiece(fromY, fromX, toY, toX);
        if(!b1){
            System.out.println("not valid move bro");
            return false;
        }
        return true;
    }

}
