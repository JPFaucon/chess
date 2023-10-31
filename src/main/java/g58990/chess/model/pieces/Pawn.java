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

/**
 * Represents a pawn.
 * @author jp
 */
public class Pawn extends Piece{
    
    /**
     * Constructor of pawn.
     * @param color the color of the pawn
     */
    public Pawn(Color color) {
        super(color);
    }
    
    /**
     * Gets the possible moves for a pawn.
     * @param position the position of the pawn
     * @param board the board where the pawn is
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        Direction[] dirs = getPossibleDirections();
        List<Position> possMoves = new ArrayList<>();
        int row = position.getRow();
        
        //Cheks if the piece can move two squares, if it can, add the end 
        //position to the list possMoves.
        if(row == board.getInitialPawnRow(super.getColor())){
            if(super.isFree(position, dirs[0], board, 1)){
                if(super.isFree(position, dirs[0], board, 2)){
                    possMoves.add(super.newPosition(position, dirs[0], 2));
                }
            }
        }
        
        //Check the three positions in front of the piece, for each position, 
        //if the move is possible, add the position to the list possMoves.
        for(Direction dir : dirs){
            Position pos = super.newPosition(position, dir, 1);
            if(board.contains(pos)){
                if(dir.getDeltaColumn() == 0){
                    if(board.isFree(pos)){
                        possMoves.add(pos);
                    }
                } else{
                    if(board.containsOppositeColor(pos, super.getColor())){
                        possMoves.add(pos);
                    }
                }
            }
        }
        
        return possMoves;
    }
    
    /**
     * Gets an array of direction a piece can take, the first direction of the 
     * list is South for black pieces and North for white pieces.
     * @return the array of direction
     */
    private Direction[] getPossibleDirections(){
        Direction[] dirs = new Direction[3];
        if(super.getColor() == Color.BLACK){
            dirs[0] = Direction.S;
            dirs[1] = Direction.SE;
            dirs[2] = Direction.SW;
        }else{
            dirs[0] = Direction.N;
            dirs[1] = Direction.NE;
            dirs[2] = Direction.NW;
        }
        return dirs;
    }
    
    /**
     * Get the positions in which the pawn can capture an opponent piece.
     * @param position the position of the pawn
     * @param board the board where the pawn is
     * @return a list of positions
     */
    @Override
    public List<Position> getCapturePositions(Position position, Board board) {
        List<Position> capturePos = new ArrayList<>();
        Direction[] dirs = new Direction[2];
        if(super.getColor() == Color.BLACK){
            dirs[0] = Direction.SE;
            dirs[1] = Direction.SW;
        }else{
            dirs[0] = Direction.NE;
            dirs[1] = Direction.NW;
        }
        
        for(Direction dir : dirs){
            Position pos = newPosition(position, dir, 1);
            if(board.contains(pos)){
                if(board.isFree(pos) || board.containsOppositeColor(pos, super.getColor())) {
                    capturePos.add(pos);
                }
            }
        }
        
        return capturePos;
    }
}
