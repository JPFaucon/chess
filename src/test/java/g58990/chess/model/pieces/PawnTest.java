/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package g58990.chess.model.pieces;

import g58990.chess.model.Board;
import g58990.chess.model.Color;
import g58990.chess.model.Position;
import g58990.chess.model.pieces.Pawn;
import g58990.chess.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author jp
 */
public class PawnTest {
    
    private Board board;
    
    @BeforeEach     // Exécutée avant chaque test
    public void setUp() {
        board = new Board();
    }
    
    @Test
    public void testGetPossibleMovesP() {
        Position position = new Position(1,1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesGeneralCaseWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(3,3);
        board.setPiece(piece, pos);
        
        expected.add(new Position(4,3));
        positions = piece.getPossibleMoves(pos, board);
        
        assertEquals(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(1,3);
        board.setPiece(piece, pos);
        
        expected.add(new Position(2,3));
        expected.add(new Position(3,3));
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionOpponentPieceOnFirstSquareWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(1,3);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.BLACK;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(2, 3);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionOpponentPieceOnSecondSquareWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(1,3);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.BLACK;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(3, 3);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(2, 3));
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionAndOnePieceToTakeWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(1, 2);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.BLACK;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(2,1);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(2,1));
        expected.add(new Position(2,2));
        expected.add(new Position(3,2));
        
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionAndTwoPieceToTakeWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(1, 2);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.BLACK;
        Piece opponentPiece1 = new Pawn(opponentColor);
        Position opponentPos1 = new Position(2,1);
        board.setPiece(opponentPiece1, opponentPos1);
        Piece opponentPiece2 = new Pawn(opponentColor);
        Position opponentPos2 = new Position(2,3);
        board.setPiece(opponentPiece2, opponentPos2);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(opponentPos1);
        expected.add(new Position(2,2));
        expected.add(new Position(3,2));
        expected.add(opponentPos2);
        
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test 
    public void testGetPossibleMovesPieceLastRowWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(7, 2);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test 
    public void testGetPossibleMovesBordEdgeWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(5, 7);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(6, 7));
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    
    @Test
    public void testGetPossibleMovesGeneralCaseBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(3,3);
        board.setPiece(piece, pos);
        
        expected.add(new Position(2,3));
        positions = piece.getPossibleMoves(pos, board);
        
        assertEquals(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        Position pos = new Position(6,3);
        board.setPiece(piece, pos);
        
        expected.add(new Position(5,3));
        expected.add(new Position(4,3));
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionOpponentPieceOnFirstSquareBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(6,3);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.WHITE;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(5, 3);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionOpponentPieceOnSecondSquareBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(6,3);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.WHITE;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(4, 3);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(5, 3));
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionAndOnePieceToTakeBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(6, 2);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.WHITE;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(5,1);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(opponentPos);
        expected.add(new Position(5,2));
        expected.add(new Position(4,2));
        
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesInitialPositionAndTwoPieceToTakeBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(6, 2);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.WHITE;
        Piece opponentPiece1 = new Pawn(opponentColor);
        Position opponentPos1 = new Position(5,1);
        board.setPiece(opponentPiece1, opponentPos1);
        Piece opponentPiece2 = new Pawn(opponentColor);
        Position opponentPos2 = new Position(5,3);
        board.setPiece(opponentPiece2, opponentPos2);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(opponentPos1);
        expected.add(new Position(5,2));
        expected.add(new Position(4,2));
        expected.add(opponentPos2);
        
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test 
    public void testGetPossibleMovesPieceLastRowBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(0, 2);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test 
    public void testGetPossibleMovesBordEdgeBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(5, 7);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(4, 7));
        positions = piece.getPossibleMoves(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsGeneralCaseWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(3, 3);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(4, 4));
        expected.add(new Position(4, 2));
        positions = piece.getCapturePositions(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsBorderWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(3, 0);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(4, 1));
        positions = piece.getCapturePositions(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsLastRowWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(7, 3);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        positions = piece.getCapturePositions(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsOpponentPieceWhite(){
        Color color = Color.WHITE;
        Piece piece = new Pawn(color);
        Position pos = new Position(3, 3);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.BLACK;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(4,4);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(4, 4));
        expected.add(new Position(4, 2));
        positions = piece.getCapturePositions(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsSameColorPieceWhite(){
        Color color = Color.WHITE;
        Piece piece1 = new Pawn(color);
        Position pos1 = new Position(3, 3);
        board.setPiece(piece1, pos1);
        Piece piece2 = new Pawn(color);
        Position pos2 = new Position(4, 4);
        board.setPiece(piece2, pos2);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(4, 2));
        positions = piece1.getCapturePositions(pos1, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsOpponentPieceAndSameColorPieceWhite(){
        Color color = Color.WHITE;
        Piece piece1 = new Pawn(color);
        Position pos1 = new Position(3, 3);
        board.setPiece(piece1, pos1);
        Piece piece2 = new Pawn(color);
        Position pos2 = new Position(4, 4);
        board.setPiece(piece2, pos2);
        
        Color opponentColor = Color.BLACK;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(4,2);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(4, 2));
        positions = piece1.getCapturePositions(pos1, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    
    @Test
    public void testGetCapturePositionsGeneralCaseBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(3, 3);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(2, 4));
        expected.add(new Position(2, 2));
        positions = piece.getCapturePositions(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsBorderBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(3, 0);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(2, 1));
        positions = piece.getCapturePositions(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsLastRowBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(0, 3);
        board.setPiece(piece, pos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        positions = piece.getCapturePositions(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsOpponentPieceBlack(){
        Color color = Color.BLACK;
        Piece piece = new Pawn(color);
        Position pos = new Position(3, 3);
        board.setPiece(piece, pos);
        
        Color opponentColor = Color.WHITE;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(2,4);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(2, 4));
        expected.add(new Position(2, 2));
        positions = piece.getCapturePositions(pos, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsSameColorPieceBlack(){
        Color color = Color.BLACK;
        Piece piece1 = new Pawn(color);
        Position pos1 = new Position(3, 3);
        board.setPiece(piece1, pos1);
        Piece piece2 = new Pawn(color);
        Position pos2 = new Position(2, 4);
        board.setPiece(piece2, pos2);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(2, 2));
        positions = piece1.getCapturePositions(pos1, board);
        
        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetCapturePositionsOpponentPieceAndSameColorPieceBlack(){
        Color color = Color.BLACK;
        Piece piece1 = new Pawn(color);
        Position pos1 = new Position(3, 3);
        board.setPiece(piece1, pos1);
        Piece piece2 = new Pawn(color);
        Position pos2 = new Position(2, 4);
        board.setPiece(piece2, pos2);
        
        Color opponentColor = Color.WHITE;
        Piece opponentPiece = new Pawn(opponentColor);
        Position opponentPos = new Position(2,2);
        board.setPiece(opponentPiece, opponentPos);
        
        List<Position> positions;
        List<Position> expected = new ArrayList<>();
        
        expected.add(new Position(2, 2));
        positions = piece1.getCapturePositions(pos1, board);
        
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
