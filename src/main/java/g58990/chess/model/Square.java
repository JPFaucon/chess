/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.chess.model;

import g58990.chess.model.pieces.Piece;

/**
 * Represents a square. A square can have a piece.
 * @author jp
 */
public class Square {
    private Piece piece;
    
    /**
     * Constructor of square
     * @param piece 
     */
    public Square(Piece piece){
        this.piece = piece;
    }
    
    /**
     * Getter of piece
     * @return the piece on the square
     */
    public Piece getPiece(){
        return this.piece;
    }
    
    /**
     * Setter of piece
     * @param piece the type of piece
     */
    public void setPiece(Piece piece){
        this.piece = piece;
    }
    
    /**
     * Indicates if there is a piece on the square.
     * @return true if there is no piece on the square, false otherwise
     */
    public boolean isFree(){
        return this.piece == null;
    }
}
