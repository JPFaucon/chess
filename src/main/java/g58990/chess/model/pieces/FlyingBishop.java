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
 *
 * @author jp
 */
public class FlyingBishop  extends Piece{
    public FlyingBishop(Color color) {
        super(color);
    }
    
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMoves = new ArrayList<>();
        Direction[] dirs = {Direction.NE, Direction.NW, Direction.SW, Direction.SE};
        for(Direction dir : dirs) {
            possMoves.addAll(getPossMovesFlyingBishop(position, board, dir));
        }
        return possMoves;
    }
    
    private List<Position> getPossMovesFlyingBishop(Position position, Board board, Direction dir) {
        List<Position> possMovesDir = new ArrayList<>();
        int cpt = 0;
        Position pos;
        
        do {
            pos = super.newPosition(position, dir, cpt + 1);
            if(board.contains(pos)) {
                if(board.isFree(pos) || board.containsOppositeColor(pos, super.getColor())) {
                    possMovesDir.add(pos);
                }
            }
            cpt++;
        }
        while(board.contains(pos));
        return possMovesDir;
    }
}
