/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.chess.model;

import g58990.chess.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a board. A board is composed of squares.
 * @author jp
 */
public class Board {
    private Square[][] squares;
    
    /**
     * Constructor of board.
     */
    public Board(){
        this.squares = new Square[8][8];
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                this.squares[row][column] = new Square(null);
            }
        }
    }
     /**
      * Checks if a position is on the board.
      * @param pos the position to check
      * @return true if the position is on the board, false otherwise
      */
    public boolean contains(Position pos){
        return pos.getColumn() < 8 && pos.getColumn() >= 0 && pos.getRow() < 8 
                && pos.getRow() >= 0;
    }
    
    /**
     * Gets the initial position of a pawn.
     * @param color the color of the pawn
     * @return the raw of the initial position of a given color
     */
    public int getInitialPawnRow(Color color){
        return color == Color.WHITE ? 1 : 6;
    }
    
    /**
     * Setter of piece.
     * @param piece the piece to be placed
     * @param position the position of the square where the piece must be placed
     * @throws IllegalArgumentException if the position is not on the board
     */
    public void setPiece(Piece piece, Position position){
        if(!this.contains(position)){
            throw new IllegalArgumentException("The given position is not on the "
                    + "board!");
        }
        this.squares[position.getRow()][position.getColumn()].setPiece(piece);
    }
    
    /**
     * Getter of piece.
     * @param pos the position of the square.
     * @return the piece on the square whose position is given
     * @throws IllegalArgumentException if the position is not on the board
     */
    public Piece getPiece(Position pos){
        if(!this.contains(pos)){
            throw new IllegalArgumentException("The given position is not on the "
                    + "board!");
        }
        return this.squares[pos.getRow()][pos.getColumn()].getPiece();
    }
    
    /**
     * Delete the piece on a square.
     * @param pos the position of the square
     * @throws IllegalArgumentException if the position is not on the board
     */
    public void dropPiece(Position pos){
        if(!this.contains(pos)){
            throw new IllegalArgumentException("The given position is not on the "
                    + "board!");
        }
        this.setPiece(null, pos);
    }
    
    /**
     * Checks if there is a piece on a square.
     * @param pos the position of the square
     * @return true if there is no piece on the square, false otherwise
     * @throws IllegalArgumentException if the position is not on the board
     */
    public boolean isFree(Position pos){
        if(!this.contains(pos)){
            throw new IllegalArgumentException("The given position is not on the "
                    + "board!");
        }
        return this.squares[pos.getRow()][pos.getColumn()].isFree();
    }
    
    /**
     * Checks if a square is occupied by an opponent's piece.
     * @param pos the position of the square
     * @param color the color of the player
     * @return false if the color of the player is the same as the color of the 
     * piece on the square of the given position or if there is no piece on the 
     * square, true otherwise
     * @throws IllegalArgumentException if the position is not on the board
     */
    public boolean containsOppositeColor(Position pos, Color color){
        if(!this.contains(pos)){
            throw new IllegalArgumentException("The given position is not on the "
                    + "board!");
        }
        
        if(this.isFree(pos)){
            return false;
        }
        return this.getPiece(pos).getColor() != color;
    }
    
    /**
     * Finds all positions occupied by a certain player.
     * @param player the player whose positions we want to know.
     * @return a list containing all player positions
     */
    public List<Position> getPositionOccupiedBy(Player player){
        List<Position> listPositions = new ArrayList<>();
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Square square = this.squares[row][column];
                if(!square.isFree()){
                    if(square.getPiece().getColor() == player.getColor()){
                        listPositions.add(new Position(row, column));
                    }
                }
            }
        }
        return listPositions;
    }
    
    /**
     * Get the position of a piece.
     * @param piece the piece whose position we want
     * @return the position of the piece
     */
    public Position getPiecePosition(Piece piece) {
        Position pos;
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                pos = new Position(row, col);
                if(!this.isFree(pos) && getPiece(pos).equals(piece)) {
                    return pos;
                }
            }
        }
        return null;
    }
}
