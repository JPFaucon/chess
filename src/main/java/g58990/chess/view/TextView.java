/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.chess.view;

import g58990.chess.model.Color;
import g58990.chess.model.Model;
import g58990.chess.model.pieces.Piece;
import g58990.chess.model.Player;
import g58990.chess.model.Position;
import g58990.chess.model.pieces.Bishop;
import g58990.chess.model.pieces.King;
import g58990.chess.model.pieces.Knight;
import g58990.chess.model.pieces.Pawn;
import g58990.chess.model.pieces.Queen;
import g58990.chess.model.pieces.Rook;
import java.util.Scanner;

/**
 * Represents the view of the chess game.
 * @author jp
 */
public class TextView implements View{
    private Model model;
    
    /**
     * Constructor of model.
     * @param model the model
     */
    public TextView(Model model){
        this.model = model;
    }
    
    /**
     * Display the title and a welcome message to players.
     */
    @Override
    public void displayTitle() {
        System.out.println("----------Jeu d'échec----------");
        System.out.println();
        System.out.println("Bonjour et bienvenue dans ce jeu d'échec ! ");
    }

    /**
     * Display the winner.
     */
    @Override
    public void displayWinner() {
        Player winner = this.model.getOppositePlayer();
        String colWinner = winner.getColor() == Color.WHITE ? "Blancs" : "Noirs";
        System.out.println("Les " + colWinner + " ont gagné !");
    }

    /**
     * Display the board.
     */
    @Override
    public void displayBoard() {
        for (int row = 8; row > 0; row--) {
            System.out.println("  -------------------------");
            
            System.out.print(row + " ");
            for (int col = 0; col < 8; col++) {
                String piece = displayPiece(row - 1, col);
                System.out.print("|" + piece);
            }
            System.out.println("|");
        }
        System.out.println("  -------------------------");

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        System.out.print("  ");
        for(char letter : letters){
            System.out.print("  " + letter);
        }
        System.out.println();
    }
    
    /**
     * Gets a word discribing a piece on a board.
     * @param row the row of the position on the board
     * @param col the column of the position on the board
     * @return "  " if there is no piece on the given position, a word discribing 
     * the piece otherwise
     */
    private String displayPiece(int row, int col){
        Position pos = new Position(row, col);
        Piece piece = this.model.getPiece(pos);
        String displayPiece = "";
        if(piece == null){
            displayPiece += "  ";
        }else if(piece.getColor() == Color.BLACK){
            if(piece instanceof Pawn) {
                displayPiece += "PN";
            } else if(piece instanceof Rook) {
                displayPiece += "TN";
            } else if(piece instanceof Knight) {
                displayPiece += "CN";
            } else if(piece instanceof Bishop) {
                displayPiece += "FN";
            } else if(piece instanceof King) {
                displayPiece += "*N";
            } else if(piece instanceof Queen) {
                displayPiece += "#N";
            }
            
        }else{
            if(piece instanceof Pawn) {
                displayPiece += "PB";
            } else if(piece instanceof Rook) {
                displayPiece += "TB";
            } else if(piece instanceof Knight) {
                displayPiece += "CB";
            } else if(piece instanceof Bishop) {
                displayPiece += "FB";
            } else if(piece instanceof King) {
                displayPiece += "*B";
            } else if(piece instanceof Queen) {
                displayPiece += "#B";
            }
        }
        return displayPiece;
    }

    /**
     * Display a message inviting the current player to play.
     */
    @Override
    public void displayPlayer() {
        String color;
        if(this.model.getCurrentPlayer().getColor() == Color.BLACK){
            color = "noir";
        }else{
            color = "blanc";
        }
        
        System.out.println("C'est à vous de jouer, joueur " + color + ".");
    }

    /**
     * Ask a valid position on the board to the current player.
     * @return the position
     */
    @Override
    public Position askPosition() {
        int row = readRowUntil(1,8) - 1;
        int col = readColInAH();
        return new Position(row, col);
    }
    
    /**
     * Ask for a column letter (between a and h inclusive). This letter can be 
     * uppercase or lowercase.
     * @return a column letter
     */
    private int readColInAH(){
        Scanner clavier = new Scanner(System.in);
        int col;
        do{
            System.out.println("Entrez une lettre comprise entre a et h inclus, "
                    + "a correspondant à la première colonne et h à la dernière.");
            col = switch(clavier.next()){
                case "a", "A" -> 0;
                case "b", "B" -> 1;
                case "c", "C" -> 2;
                case "d", "D" -> 3;
                case "e", "E" -> 4;
                case "f", "F" -> 5;
                case "g", "G" -> 6;
                case "h", "H" -> 7;
                default -> -1;
            };
            if(col == -1){
                displayError("Cette valeur n'est pas comprise entre a et h.");
            }
        }while(col == -1);
        return col;
    }
    
    /**
     * Ask for an integer.
     * @return an integer
     */
    private int readInt(){
        Scanner clavier = new Scanner(System.in);
        while(!clavier.hasNextInt()){
            clavier.next();
            displayError("La saisie n'est pas un entier.");
        }
        return clavier.nextInt();
    }
    
    /**
     * Ask for a line number between min and max.
     * @param min the minimum value of the integer
     * @param max the maximum value of the integer
     * @return a line number between min and max
     */
    private int readRowUntil(int min, int max){
        int n;
        do{
            System.out.println("Entrez un numéro de ligne (compris entre " + min
                    + " et " + max + " inclus).");
            n = readInt();
            if(n < min || n > max){
                displayError("Ce numéro de ligne n'existe pas.");
            }
        }while(n < min || n > max);
        return n;
    }

    /**
     * Display an error message.
     * @param message the error message
     */
    @Override
    public void displayError(String message) {
        System.out.println(message);
    }
    
    /**
     * Display a message.
     * @param message the message
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    /**
     * Display a check message.
     */
    @Override
    public void displayCheck() {
        Player player = model.getCurrentPlayer();
        String color = player.getColor() == Color.BLACK ? "noir" : "blanc";
        System.out.println("Le joueur " + color + " est en échec.");
    }
    
    /**
     * Display a mat message.
     */
    @Override
    public void displayMat() {
        Player player = model.getCurrentPlayer();
        String color = player.getColor() == Color.BLACK ? "noir" : "blanc";
        System.out.println("Le joueur " + color + " est en échec et mat.");
    }
    
    /**
     * Display a stale mat message.
     */
    @Override
    public void displayStaleMat() {
        System.out.println("Pat!");
    }
}
