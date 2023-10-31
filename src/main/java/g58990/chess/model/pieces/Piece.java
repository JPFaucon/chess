/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.chess.model.pieces;

import g58990.chess.model.Board;
import g58990.chess.model.Color;
import g58990.chess.model.Direction;
import g58990.chess.model.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a piece. A piece has a color.
 * @author jp
 */
public abstract class Piece {
    private Color color;
    
    /**
     * Constructor of piece
     * @param color the color of the piece
     */
    public Piece(Color color){
        this.color = color;
    }
    
    /**
     * Getter of color
     * @return the color of the piece
     */
    public Color getColor(){
        return this.color;
    }
    
    /**
     * Gets the possible moves for a piece.
     * @param position the position of the piece
     * @param board the board where the piece is
     * @return a list of possible moves
     */
    public abstract List<Position> getPossibleMoves(Position position, Board board);
    
    /**
     * Get the positions in which the piece can capture an opponent piece.
     * @param position the position of the piece
     * @param board the board where the piece is
     * @return a list of position a piece can capture
     */
    public List<Position> getCapturePositions(Position position, Board board){
        return this.getPossibleMoves(position, board);
    }
    
    /**
     * Creates a new position from an old position.
     * @param oldPos the old position
     * @param dir the direction of the new position
     * @param nbSquares the distance (in square) between the old and the new 
     * direction.
     * @return the new position
     */
    protected Position newPosition(Position oldPos, Direction dir, int nbSquares){
        int row = oldPos.getRow() + nbSquares * dir.getDeltaRow();
        int column = oldPos.getColumn() + nbSquares * dir.getDeltaColumn();
        return new Position(row, column);
    }
        
    /**
     * Checks if a square of a board is free, from a position of a piece.
     * @param pos the position of the piece
     * @param dir the direction where the square to be checked is (from the 
     * position)
     * @param board the board where the piece is
     * @param nbSquares the distance (in squares) between the position and the 
     * square to be checked
     * @return true if the square to be checked is free, false otherwise
     */
    protected boolean isFree(Position pos, Direction dir, Board board, int nbSquares){
        Position posToCheck = newPosition(pos, dir, nbSquares);
        return board.isFree(posToCheck);
    }
    
    /**
     * Gets the possible moves for a piece in a direction.
     * @param position the position of the piece
     * @param dir the direction of the move
     * @param board the board where the piece is
     * @return a list of possible moves
     */
    protected List<Position> getPossMovesDir(Position position, Direction dir, Board board) {
        List<Position> possMovesDir = new ArrayList<>();
        int cpt = 0;
        Position pos;
        do {
            pos = newPosition(position, dir, cpt + 1);
            if(board.contains(pos)){
                if(board.isFree(pos) || board.containsOppositeColor(pos, this.color)){
                    possMovesDir.add(pos);
                }
            }
            cpt++;
        }
        while(board.contains(pos) && board.isFree(pos));
        return possMovesDir;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        return this.color == other.color;
    }
}
