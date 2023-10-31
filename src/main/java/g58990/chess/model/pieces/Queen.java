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
 * Represents a queen
 * @author jp
 */
public class Queen extends Piece{
    
    /**
     * Constructor of queen.
     * @param color the color of the queen
     */
    public Queen(Color color) {
        super(color);
    }
    
    /**
     * Gets the possible moves for a queen
     * @param position the position of the queen
     * @param board the board where the queen is
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMoves = new ArrayList<>();
        Direction[] dirs = Direction.values();
        for(Direction dir : dirs) {
            possMoves.addAll(super.getPossMovesDir(position, dir, board));
        }
        return possMoves;
    }
}
