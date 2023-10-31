/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package g58990.chess.model.pieces;

import g58990.chess.model.Board;
import g58990.chess.model.Color;
import g58990.chess.model.Position;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author jp
 */
public class QueenTest {
    
    private Board board;
    
    @BeforeEach     // Exécutée avant chaque test
    public void setUp() {
        board = new Board();
    }
    
    @Test
    public void testGetPossibleMovesGeneralCaseWhite() {
        Color color = Color.WHITE;
        Piece piece = new Queen(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(3,3);
        board.setPiece(piece, pos);
        
        expected.add(new Position(2,2));
        expected.add(new Position(1,1));
        expected.add(new Position(0,0));
        
        expected.add(new Position(4,4));
        expected.add(new Position(5,5));
        expected.add(new Position(6,6));
        expected.add(new Position(7,7));
        
        expected.add(new Position(4,2));
        expected.add(new Position(5,1));
        expected.add(new Position(6,0));
        
        expected.add(new Position(2,4));
        expected.add(new Position(1,5));
        expected.add(new Position(0,6));
        
        expected.add(new Position(4,3));
        expected.add(new Position(5,3));
        expected.add(new Position(6,3));
        expected.add(new Position(7,3));
        
        expected.add(new Position(2,3));
        expected.add(new Position(1,3));
        expected.add(new Position(0,3));
        
        expected.add(new Position(3,2));
        expected.add(new Position(3,1));
        expected.add(new Position(3,0));
        
        expected.add(new Position(3,4));
        expected.add(new Position(3,5));
        expected.add(new Position(3,6));
        expected.add(new Position(3,7));
        
        positions = piece.getPossibleMoves(pos, board);
               
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesBorderWhite() {
        Color color = Color.WHITE;
        Piece piece = new Queen(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(0,3);
        board.setPiece(piece, pos);
        
        expected.add(new Position(1,4));
        expected.add(new Position(2,5));
        expected.add(new Position(3,6));
        expected.add(new Position(4,7));
        
        expected.add(new Position(1,2));
        expected.add(new Position(2,1));
        expected.add(new Position(3,0));
        
        expected.add(new Position(1,3));
        expected.add(new Position(2,3));
        expected.add(new Position(3,3));
        expected.add(new Position(4,3));
        expected.add(new Position(5,3));
        expected.add(new Position(6,3));
        expected.add(new Position(7,3));
        
        expected.add(new Position(0,2));
        expected.add(new Position(0,1));
        expected.add(new Position(0,0));
        
        expected.add(new Position(0,4));
        expected.add(new Position(0,5));
        expected.add(new Position(0,6));
        expected.add(new Position(0,7));
        positions = piece.getPossibleMoves(pos, board);
               
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesPieceToTakeWhite() {
        Color color = Color.WHITE;
        Piece piece = new Queen(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(3,3);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.BLACK;
        Piece opponentPiece = new Queen(opponentColor);
        Position opponentPos = new Position(5,5);
        board.setPiece(opponentPiece, opponentPos);
        
        expected.add(new Position(2,2));
        expected.add(new Position(1,1));
        expected.add(new Position(0,0));
        
        expected.add(new Position(4,4));
        expected.add(new Position(5,5));
        
        expected.add(new Position(4,2));
        expected.add(new Position(5,1));
        expected.add(new Position(6,0));
        
        expected.add(new Position(2,4));
        expected.add(new Position(1,5));
        expected.add(new Position(0,6));
        
        expected.add(new Position(4,3));
        expected.add(new Position(5,3));
        expected.add(new Position(6,3));
        expected.add(new Position(7,3));
        
        expected.add(new Position(2,3));
        expected.add(new Position(1,3));
        expected.add(new Position(0,3));
        
        expected.add(new Position(3,2));
        expected.add(new Position(3,1));
        expected.add(new Position(3,0));
        
        expected.add(new Position(3,4));
        expected.add(new Position(3,5));
        expected.add(new Position(3,6));
        expected.add(new Position(3,7));
        positions = piece.getPossibleMoves(pos, board);
               
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesWhitePieceWhite() {
        Color color = Color.WHITE;
        Piece piece = new Queen(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(3,3);
        board.setPiece(piece, pos);
        
        Piece piece2 = new Queen(color);
        Position pos2 = new Position(2,2);
        board.setPiece(piece2, pos2);
        
        expected.add(new Position(4,4));
        expected.add(new Position(5,5));
        expected.add(new Position(6,6));
        expected.add(new Position(7,7));
        
        expected.add(new Position(4,2));
        expected.add(new Position(5,1));
        expected.add(new Position(6,0));
        
        expected.add(new Position(2,4));
        expected.add(new Position(1,5));
        expected.add(new Position(0,6));
        
        expected.add(new Position(4,3));
        expected.add(new Position(5,3));
        expected.add(new Position(6,3));
        expected.add(new Position(7,3));
        
        expected.add(new Position(2,3));
        expected.add(new Position(1,3));
        expected.add(new Position(0,3));
        
        expected.add(new Position(3,2));
        expected.add(new Position(3,1));
        expected.add(new Position(3,0));
        
        expected.add(new Position(3,4));
        expected.add(new Position(3,5));
        expected.add(new Position(3,6));
        expected.add(new Position(3,7));
        positions = piece.getPossibleMoves(pos, board);
               
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesGeneralCaseBlack() {
        Color color = Color.BLACK;
        Piece piece = new Queen(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(3,3);
        board.setPiece(piece, pos);
        
        expected.add(new Position(2,2));
        expected.add(new Position(1,1));
        expected.add(new Position(0,0));
        
        expected.add(new Position(4,4));
        expected.add(new Position(5,5));
        expected.add(new Position(6,6));
        expected.add(new Position(7,7));
        
        expected.add(new Position(4,2));
        expected.add(new Position(5,1));
        expected.add(new Position(6,0));
        
        expected.add(new Position(2,4));
        expected.add(new Position(1,5));
        expected.add(new Position(0,6));
        
        expected.add(new Position(4,3));
        expected.add(new Position(5,3));
        expected.add(new Position(6,3));
        expected.add(new Position(7,3));
        
        expected.add(new Position(2,3));
        expected.add(new Position(1,3));
        expected.add(new Position(0,3));
        
        expected.add(new Position(3,2));
        expected.add(new Position(3,1));
        expected.add(new Position(3,0));
        
        expected.add(new Position(3,4));
        expected.add(new Position(3,5));
        expected.add(new Position(3,6));
        expected.add(new Position(3,7));
        positions = piece.getPossibleMoves(pos, board);
               
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesBorderBlack() {
        Color color = Color.BLACK;
        Piece piece = new Queen(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(0,0);
        board.setPiece(piece, pos);
        
        expected.add(new Position(1,1));
        expected.add(new Position(2,2));
        expected.add(new Position(3,3));
        expected.add(new Position(4,4));
        expected.add(new Position(5,5));
        expected.add(new Position(6,6));
        expected.add(new Position(7,7));
        
        expected.add(new Position(1,0));
        expected.add(new Position(2,0));
        expected.add(new Position(3,0));        
        expected.add(new Position(4,0));
        expected.add(new Position(5,0));
        expected.add(new Position(6,0));
        expected.add(new Position(7,0));
        
        expected.add(new Position(0,1));
        expected.add(new Position(0,2));
        expected.add(new Position(0,3));
        expected.add(new Position(0,4));
        expected.add(new Position(0,5));
        expected.add(new Position(0,6));
        expected.add(new Position(0,7));
        positions = piece.getPossibleMoves(pos, board);
               
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesPieceToTakeBlack() {
        Color color = Color.BLACK;
        Piece piece = new Queen(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(3,3);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.WHITE;
        Piece opponentPiece = new Queen(opponentColor);
        Position opponentPos = new Position(4,3);
        board.setPiece(opponentPiece, opponentPos);
        
        expected.add(new Position(2,2));
        expected.add(new Position(1,1));
        expected.add(new Position(0,0));
        
        expected.add(new Position(4,4));
        expected.add(new Position(5,5));
        expected.add(new Position(6,6));
        expected.add(new Position(7,7));
        
        expected.add(new Position(4,2));
        expected.add(new Position(5,1));
        expected.add(new Position(6,0));
        
        expected.add(new Position(2,4));
        expected.add(new Position(1,5));
        expected.add(new Position(0,6));
        
        expected.add(new Position(4,3));
        
        expected.add(new Position(2,3));
        expected.add(new Position(1,3));
        expected.add(new Position(0,3));
        
        expected.add(new Position(3,2));
        expected.add(new Position(3,1));
        expected.add(new Position(3,0));
        
        expected.add(new Position(3,4));
        expected.add(new Position(3,5));
        expected.add(new Position(3,6));
        expected.add(new Position(3,7));
        positions = piece.getPossibleMoves(pos, board);
               
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesWhitePieceBlack() {
        Color color = Color.BLACK;
        Piece piece = new Queen(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(3,3);
        board.setPiece(piece, pos);
        
        Piece piece2 = new Queen(color);
        Position pos2 = new Position(4,4);
        board.setPiece(piece2, pos2);
        
        expected.add(new Position(2,2));
        expected.add(new Position(1,1));
        expected.add(new Position(0,0));
        
        expected.add(new Position(4,2));
        expected.add(new Position(5,1));
        expected.add(new Position(6,0));
        
        expected.add(new Position(2,4));
        expected.add(new Position(1,5));
        expected.add(new Position(0,6));
        
        expected.add(new Position(4,3));
        expected.add(new Position(5,3));
        expected.add(new Position(6,3));
        expected.add(new Position(7,3));
        
        expected.add(new Position(2,3));
        expected.add(new Position(1,3));
        expected.add(new Position(0,3));
        
        expected.add(new Position(3,2));
        expected.add(new Position(3,1));
        expected.add(new Position(3,0));
        
        expected.add(new Position(3,4));
        expected.add(new Position(3,5));
        expected.add(new Position(3,6));
        expected.add(new Position(3,7));
        positions = piece.getPossibleMoves(pos, board);
               
        assertEqualsIgnoringOrder(expected, positions);
    }
        
        /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }
}
