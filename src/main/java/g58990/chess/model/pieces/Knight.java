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
 * Represents a knight.
 * @author jp
 */
public class Knight extends Piece{
    
    /**
     * Constructor of knight
     * @param color the color of the knight
     */
    public Knight(Color color) {
        super(color);
    }
    
    /**
     * Gets the possible moves for a knight
     * @param position the position of the knight
     * @param board the board where the knight is
     * @return a list the possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMoves = new ArrayList<>();
        Direction[] dirs = {Direction.N, Direction.E, Direction.S, Direction.W};
        Color color = super.getColor();
        for (int i = 0; i < 4; i++) {
            Position pos = super.newPosition(position, dirs[i], 2);
            for (int j = 1; j < 4; j+=2) {
                Position pos2 = super.newPosition(pos, dirs[(i + j) % 4], 1);
                if(board.contains(pos2)){
                    if(board.isFree(pos2) || board.containsOppositeColor(pos2, color)){
                        possMoves.add(pos2);
                    }
                }
            }
        }
        return possMoves;
    }
}
