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
 * Represents a king.
 * @author jp
 */
public class King extends Piece{
    
    /**
     * Constructor of king.
     * @param color the color of the king
     */
    public King(Color color) {
        super(color);
    }
    
    /**
     * Gets the possible moves for a king
     * @param position the position of the king
     * @param board the board where the king is
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMoves = new ArrayList<>();
        Direction[] dirs = Direction.values();
        Color color = super.getColor();
        for(Direction dir : dirs) {
            Position pos = super.newPosition(position, dir, 1);
            if(board.contains(pos)) {
                if(board.isFree(pos) || board.containsOppositeColor(pos, color)) {
                    possMoves.add(pos);
                }
            }
        }
        return possMoves;
    }
}
