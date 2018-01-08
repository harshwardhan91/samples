package com.local.chessgame;

public class ChessBoard {

    Spot[][] board;
    private King whiteKing;
    private King blackKing;

    public ChessBoard() {
        initialize();
    }

    public Spot[][] getBoard() {
        return board;
    }

    private void initialize(){
        board = new Spot[8][8];
        for(int i = 0;i<8;i++){
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Spot(i,j);
            }
        }
        initPieces();
    }

    public Color getSpotPieceColor(int fromY,int fromX){
        Spot fromSpot = board[fromY][fromX];
        if(fromSpot!=null && fromSpot.getPiece()!=null){
            return fromSpot.getPiece().getColor();
        }
        return null;
    }

    public boolean movePiece(int fromY,int fromX,int toY,int toX){
        if(fromX > 7 || fromY > 7 || toX >7 || toY >7 || fromX < 0 || fromY < 0 || toX < 0 || toY < 0){
            return false;
        }
        Spot fromSpot = board[fromY][fromX];
        Spot toSpot = board[toY][toX];
        Piece piece = fromSpot.getPiece();
        if(piece == null){
            return false;
        }
        if(piece.verifyMove(fromSpot, toSpot) && toSpot.occupySpot(piece)){
                fromSpot.emptySpot();
                return true;
        }
        return false;
    }

    public boolean isGameAlive(){
        if(!whiteKing.isAlive() || !blackKing.isAlive()){
            return false;
        }
        return true;
    }

    private void initPieces(){
        for (int i = 0; i < 8; i++) {
            Spot spot = board[0][i];
            switch (i) {
                case 0 : spot.occupySpot(new Rook(Color.WHITE));break;
                case 1 : spot.occupySpot(new Knight(Color.WHITE));break;
                case 2 : spot.occupySpot(new Bishop(Color.WHITE));break;
                case 3 :
                    whiteKing = new King(Color.WHITE);
                    spot.occupySpot(whiteKing);break;
                case 4 : spot.occupySpot(new Queen(Color.WHITE));break;
                case 5 : spot.occupySpot(new Bishop(Color.WHITE));break;
                case 6 : spot.occupySpot(new Knight(Color.WHITE));break;
                case 7 : spot.occupySpot(new Rook(Color.WHITE));break;
                default:break;
            }
        }
        for (int i = 0; i < 8; i++) {
            Spot spot = board[7][i];
            switch (i) {
                case 0 : spot.occupySpot(new Rook(Color.BLACK));break;
                case 1 : spot.occupySpot(new Knight(Color.BLACK));break;
                case 2 : spot.occupySpot(new Bishop(Color.BLACK));break;
                case 3 :
                    blackKing = new King(Color.BLACK);
                    spot.occupySpot(blackKing);break;
                case 4 : spot.occupySpot(new Queen(Color.BLACK));break;
                case 5 : spot.occupySpot(new Bishop(Color.BLACK));break;
                case 6 : spot.occupySpot(new Knight(Color.BLACK));break;
                case 7 : spot.occupySpot(new Rook(Color.BLACK));break;
                default:break;
            }
        }
        for (int i = 0; i < 8; i++) {
            Spot spot = board[1][i];
            spot.occupySpot(new Pawn(Color.WHITE));
        }
        for (int i = 0; i < 8; i++) {
            Spot spot = board[6][i];
            spot.occupySpot(new Pawn(Color.BLACK));
        }
    }

    public void displayBoard(){
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "\t");
            }
        }
        System.out.println();
    }

    public Color getTrueKing() {
        if(whiteKing.isAlive){
            return whiteKing.getColor();
        }else{
            return blackKing.getColor();
        }
    }
}
