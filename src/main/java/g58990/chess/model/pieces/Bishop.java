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
 * Represents a bishop.
 * @author jp
 */
public class Bishop extends Piece{
    
    /**
     * Constructor of bishop.
     * @param color the color of the bishop
     */
    public Bishop(Color color) {
        super(color);
    }
    
    /**
     * Gets the possible moves for a bishop
     * @param position the position of the bishop
     * @param board the board where the bishop is
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMoves = new ArrayList<>();
        Direction[] dirs = {Direction.NE, Direction.NW, Direction.SW, Direction.SE};
        for(Direction dir : dirs) {
            possMoves.addAll(super.getPossMovesDir(position, dir, board));
        }
        return possMoves;
    }
}
