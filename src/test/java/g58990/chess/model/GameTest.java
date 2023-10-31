/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package g58990.chess.model;

import g58990.chess.model.pieces.Bishop;
import g58990.chess.model.pieces.King;
import g58990.chess.model.pieces.Pawn;
import g58990.chess.model.pieces.Queen;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jp
 */
public class GameTest {

    /*@Test
    public void testIsGameOverEmptyBoard() {
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        
        boolean expected = true;
        
        boolean gameOver = game.isGameOver();
        
        assertEquals(expected, gameOver);
    }
    
    @Test
    public void testIsGameOverOnlyLastRow(){
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        board.setPiece(new Pawn(Color.WHITE), new Position(7,3));
        
        boolean expected = true;
        
        boolean gameOver = game.isGameOver();
        
        assertEquals(expected, gameOver);
    }
    
    @Test
    public void testIsGameOverNotGameOver(){
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        board.setPiece(new Pawn(Color.WHITE), new Position(6,3));
        
        boolean expected = false;
        
        boolean gameOver = game.isGameOver();
        
        assertEquals(expected, gameOver);
    }
    
    @Test
    public void testIsGameOverTwoPiecesFaceEachOther(){
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        board.setPiece(new Pawn(Color.WHITE), new Position(5,3));
        board.setPiece(new Pawn(Color.BLACK), new Position(6,3));
        
        boolean expected = true;
        
        boolean gameOver = game.isGameOver();
        
        assertEquals(expected, gameOver);
    }*/
    
    @Test
    public void testIsValidMoveGeneralCase() {
        Game game = new Game();
        game.start();
        
        boolean expected = true;
        
        Position oldPos = new Position(0, 1);
        Position newPos = new Position(2, 0);
        boolean validMove = game.isValidMove(oldPos, newPos);
        
        assertEquals(expected, validMove);
    }
    
    @Test
    public void testIsValidMoveCheck() {
        Game game = new Game();
        game.start();
        game.movePiecePosition(new Position(1,3), new Position(3,3));
        game.movePiecePosition(new Position(6,4), new Position(5,4));
        game.movePiecePosition(new Position(0,2), new Position(4,6));
        
        boolean expected = false;
        
        Position oldPos = new Position(7, 4);
        Position newPos = new Position(6, 4);
        boolean validMove = game.isValidMove(oldPos, newPos);
        
        assertEquals(expected, validMove);
    }
    
    @Test
    public void testMovePiecePositionBeginPosition() {
        Game game = new Game();
        game.start();
        
        GameState expected = GameState.PLAY;
        
        assertEquals(expected, game.getState());
    }
    
    @Test
    public void testMovePiecePositionCheck() {
        Game game = new Game();
        game.start();
        game.movePiecePosition(new Position(1,3), new Position(3,3));
        game.movePiecePosition(new Position(6,4), new Position(5,4));
        game.movePiecePosition(new Position(1,4), new Position(3,4));
        game.movePiecePosition(new Position(7,4), new Position(6,4));
        game.movePiecePosition(new Position(0,2), new Position(4,6));
        
        GameState expected = GameState.CHECK;
        
        assertEquals(expected, game.getState());
    }
    
    @Test
    public void testMovePiecePositionCheckMate() {
        Game game = new Game();
        game.start();
        game.movePiecePosition(new Position(1,5), new Position(2,5));
        game.movePiecePosition(new Position(6,4), new Position(5,4));
        game.movePiecePosition(new Position(1,6), new Position(3,6));
        game.movePiecePosition(new Position(7,3), new Position(3,7));
        
        GameState expected = GameState.CHECK_MATE;
        
        assertEquals(expected, game.getState());
    }
    
    @Test 
    public void testMovePiecePositionStaleMate() {
        Game game = new Game();
        game.start();
        
        game.movePiecePosition(new Position(1,4), new Position(2,4));
        game.movePiecePosition(new Position(6,0), new Position(4,0));
        game.movePiecePosition(new Position(0,3), new Position(4,7));
        game.movePiecePosition(new Position(7,0), new Position(5,0));
        game.movePiecePosition(new Position(4,7), new Position(4,0));
        game.movePiecePosition(new Position(6,7), new Position(4,7));
        game.movePiecePosition(new Position(1,7), new Position(3,7));
        game.movePiecePosition(new Position(5,0), new Position(5,7));
        game.movePiecePosition(new Position(4,0), new Position(6,2));
        game.movePiecePosition(new Position(6,5), new Position(5,5));
        game.movePiecePosition(new Position(6,2), new Position(6,3));
        game.movePiecePosition(new Position(7,4), new Position(6,5));
        game.movePiecePosition(new Position(6,3), new Position(6,1));
        game.movePiecePosition(new Position(7,3), new Position(2,3));
        game.movePiecePosition(new Position(6,1), new Position(7,1));
        game.movePiecePosition(new Position(2,3), new Position(6,7));
        game.movePiecePosition(new Position(7,1), new Position(7,2));
        game.movePiecePosition(new Position(6,5), new Position(5,6));
        game.movePiecePosition(new Position(7,2), new Position(5,4));
        
        
        GameState expected = GameState.STALE_MATE;
        
        assertEquals(expected, game.getState());
    }
    
    @Test
    public void testMovePiecePositionStaleMate2() {
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        
        board.setPiece(new King(Color.BLACK), new Position(7,0));
        board.setPiece(new Pawn(Color.BLACK), new Position(6,1));
        board.setPiece(new Bishop(Color.WHITE), new Position(4,2));
        board.setPiece(new Bishop(Color.WHITE), new Position(5,3));
        board.setPiece(new Queen(Color.WHITE), new Position(3,2));
        game.movePiecePosition(new Position(3,2), new Position(4,3));
        
        GameState expected = GameState.STALE_MATE;
        
        assertEquals(expected, game.getState());
    }
    
    @Test
    public void testMovePiecePositionPromotionPB(){
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        
        Position oldPos = new Position(6,5);
        Position newPos = new Position(7,5);
        
        board.setPiece(new Pawn(Color.WHITE), oldPos);
        game.movePiecePosition(oldPos, newPos);
        
        Queen expected = new Queen(Color.WHITE);
        
        assertEquals(expected, game.getPiece(newPos));
    }
    
    @Test
    public void testMovePiecePositionPromotionPN(){
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        
        Position oldPos = new Position(1,5);
        Position newPos = new Position(0,5);
        
        board.setPiece(new Pawn(Color.WHITE), new Position(4,5));
        game.movePiecePosition(new Position(4,5), new Position(5,5));
        board.setPiece(new Pawn(Color.BLACK), oldPos);
        game.movePiecePosition(oldPos, newPos);
        
        Queen expected = new Queen(Color.BLACK);
        
        assertEquals(expected, game.getPiece(newPos));
    }
    
    @Test
    public void testMovePiecePositionNonPromotionPB(){
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        
        Position oldPos = new Position(5,5);
        Position newPos = new Position(6,5);
        
        board.setPiece(new Pawn(Color.WHITE), oldPos);
        game.movePiecePosition(oldPos, newPos);
        
        Pawn expected = new Pawn(Color.WHITE);
        
        assertEquals(expected, game.getPiece(newPos));
    }
    
    @Test
    public void testMovePiecePositionNonPromotionPN(){
        Game game = new Game();
        Board board = game.getBoard();
        game.start();
        clearBoard(board);
        
        Position oldPos = new Position(6,5);
        Position newPos = new Position(4,5);
        
        board.setPiece(new Pawn(Color.WHITE), new Position(4,4));
        game.movePiecePosition(new Position(4,4), new Position(5,4));
        board.setPiece(new Pawn(Color.BLACK), oldPos);
        game.movePiecePosition(oldPos, newPos);
        
        Pawn expected = new Pawn(Color.BLACK);
        
        assertEquals(expected, game.getPiece(newPos));
    }
    
    private void clearBoard(Board board){
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board.setPiece(null, new Position(row, col));
            }
        }
    }
}
