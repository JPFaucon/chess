/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.chess.model;

import g58990.chess.model.pieces.Bishop;
import g58990.chess.model.pieces.King;
import g58990.chess.model.pieces.Knight;
import g58990.chess.model.pieces.Pawn;
import g58990.chess.model.pieces.Piece;
import g58990.chess.model.pieces.Queen;
import g58990.chess.model.pieces.Rook;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game. A game has a board, 2 colors, and once the game has started, 
 * a game has a current player.
 * @author jp
 */
public class Game implements Model{
    private Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;
    private King whiteKing;
    private King blackKing;
    private GameState state;
    
    /**
     * Constructor of Game.
     */
    public Game(){
        this.white = new Player(Color.WHITE);
        this.black = new Player(Color.BLACK);
        this.board = new Board();
    }
    
    /**
     * Getter of board (used for testing)
     * @return the board
     */
    Board getBoard(){
        return this.board;
    }
    
    /**
     * Getter of state.
     * @return the state of the game
     */
    @Override
    public GameState getState() {
        return this.state;
    }

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    @Override
    public void start() {
        this.state = GameState.PLAY;
        Color white = this.white.getColor();
        Color black = this.black.getColor();
        int whitePawnRow = this.board.getInitialPawnRow(white);
        int blackPawnRow = this.board.getInitialPawnRow(black);
        int whitePiecesRow = whitePawnRow - 1;
        int blackPiecesRow = blackPawnRow + 1;
        for (int col = 0; col < 8; col++) {
            Piece whitePiece = new Pawn(white);
            Position whitePos = new Position(whitePawnRow, col);
            this.board.setPiece(whitePiece, whitePos);
            
            Piece blackPiece = new Pawn(black);
            Position blackPos = new Position(blackPawnRow, col);
            this.board.setPiece(blackPiece, blackPos);
            
            if(col == 0 || col == 7) {
                Piece whiteRook = new Rook(white);
                Position whiteRookPos = new Position(whitePiecesRow, col);
                this.board.setPiece(whiteRook, whiteRookPos);
                
                Piece blackRook = new Rook(black);
                Position blackRookPos = new Position(blackPiecesRow, col);
                this.board.setPiece(blackRook, blackRookPos);
            }
            
            if(col == 1 || col == 6) {
                Piece whiteKnight = new Knight(white);
                Position whiteKnightPos = new Position(whitePiecesRow, col);
                this.board.setPiece(whiteKnight, whiteKnightPos);
                
                Piece blackKnight = new Knight(black);
                Position blackKnightPos = new Position(blackPiecesRow, col);
                this.board.setPiece(blackKnight, blackKnightPos);
            }
            
            if(col == 2 || col == 5) {
                Piece whiteBishop = new Bishop(white);
                Position whiteBishopPos = new Position(whitePiecesRow, col);
                this.board.setPiece(whiteBishop, whiteBishopPos);
                
                Piece blackBishop = new Bishop(black);
                Position blackBishopPos = new Position(blackPiecesRow, col);
                this.board.setPiece(blackBishop, blackBishopPos);
            }
            
            if(col == 3) {
                Piece whiteQueen = new Queen(white);
                Position whiteQueenPos = new Position(whitePiecesRow, col);
                this.board.setPiece(whiteQueen, whiteQueenPos);
                
                Piece blackQueen = new Queen(black);
                Position blackQueenPos = new Position(blackPiecesRow, col);
                this.board.setPiece(blackQueen, blackQueenPos);
            }
            
            if(col == 4) {
                King whiteKing = new King(white);
                Position whiteKingPos = new Position(whitePiecesRow, col);
                this.board.setPiece(whiteKing, whiteKingPos);
                this.whiteKing = whiteKing;
                
                King blackKing = new King(black);
                Position blackKingPos = new Position(blackPiecesRow, col);
                this.board.setPiece(blackKing, blackKingPos);
                this.blackKing = blackKing;
            }
        }
        
        this.currentPlayer = this.white;
    }

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos  is not located on the board.
     */
    @Override
    public Piece getPiece(Position pos) {
        if(!this.board.contains(pos)){
            throw new IllegalArgumentException("La position doit exister sur le "
                    + "plateau.");
        }
        return this.board.getPiece(pos);
    }

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    @Override
    public Player getOppositePlayer() {
        return this.currentPlayer == this.white ? this.black : this.white;
    }

    /**
     * Check if the square at the given position is occupied
     * by a piece of the current player.
     *
     * @param pos the postion
     * @return true if the position is occupied by a piece
     * of the current player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the board.
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        if(!this.board.contains(pos)){
            throw new IllegalArgumentException("La position doit exister sur le "
                    + "plateau.");
        }
        return this.board.getPositionOccupiedBy(currentPlayer).contains(pos);
    }

    /**
     * Moves a piece from one position of the chess board to
     * another one. Change the current player. Change the state of the game.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if
     *                                  1) oldPos or newPos are not located on the board, or
     *                                  2) oldPos does not contain a piece, or
     *                                  3) the piece does not belong to the current player, or
     *                                  4) the move is not valid for the piece located at position oldPos                                 
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if(!this.board.contains(oldPos) || !this.board.contains(newPos)){
            throw new IllegalArgumentException("La position doit exister sur le "
                    + "plateau.");
        }
        if(this.board.isFree(oldPos)){
            throw new IllegalArgumentException("oldPos doit contenir une pièce.");
        }
        if(!isCurrentPlayerPosition(oldPos)){
            throw new IllegalArgumentException("La couleur de la pièce sélectionnée "
                    + "n'est pas la même que la couleur du joueur qui joue.");
        }
        if(!getPossibleMoves(oldPos).contains(newPos)){
            throw new IllegalArgumentException("Le déplacement n'est pas "
                    + "possible pour la pièce sélectionnée.");
        }
        
        this.board.setPiece(this.board.getPiece(oldPos), newPos);
        this.board.dropPiece(oldPos);
        
        if(this.board.getPiece(newPos) instanceof Pawn) {
            if(newPos.getRow() == 7 || newPos.getRow() == 0) {
                Color col = this.board.getPiece(newPos).getColor();
                this.board.setPiece(new Queen(col), newPos);
            }
        }
        
        List<Position> capturePositions = getCapturePositions(this.currentPlayer);
        King king = getOppositePlayer() == white ? whiteKing : blackKing;
        Position posKing = board.getPiecePosition(king);
        
        
        if(capturePositions.contains(posKing)) {
            boolean isCheckMate = true;
            for(Position pos1 : getPiecesPositions(getOppositePlayer())) {
                for(Position pos2 : getPossibleMoves(pos1)) {
                    if(isValidMove(pos1, pos2)) {
                        isCheckMate = false;
                    }
                }
            }
            if(isCheckMate) {
                this.state = GameState.CHECK_MATE;
            } else {
                this.state = GameState.CHECK;
            }
        } else {
            boolean isStaleMate = true;
            for(Position pos1 : getPiecesPositions(getOppositePlayer())) {
                for(Position pos2 : getPossibleMoves(pos1)) {
                    if(isValidMove(pos1, pos2)) {
                        isStaleMate = false;
                    }
                }
            }
            if(isStaleMate) {
                this.state = GameState.STALE_MATE;
            } else {
                this.state = GameState.PLAY;
            }
        }
        this.currentPlayer = getOppositePlayer();
    }

    /**
     * Check if the game is over or not
     *
     * @return true if the game is over, false otherwise.
     */
    @Override
    public boolean isGameOver() {
        return this.state == GameState.CHECK_MATE 
                || this.state == GameState.STALE_MATE;
    }

    /**
     * Get the possible moves for the piece located at
     * the specified position.
     *
     * @param position the position of the piece
     * @return the liste of admissible positions.
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        Piece piece = this.board.getPiece(position);
        return piece.getPossibleMoves(position, this.board);
    }
    
    /**
     * Moves a piece from one position of the chess board to
     * another one.
     * @param oldPos the position of the piece
     * @param newPos the new position of the piece
     */
    private void move (Position oldPos, Position newPos) {
        this.board.setPiece(this.board.getPiece(oldPos), newPos);
        this.board.dropPiece(oldPos);
    }
    
    /**
     * Check if the move of a piece is valid.
     * @param oldPos the start position of the piece
     * @param newPos the new position of the piece
     * @return true if the move is valid, false otherwise
     * @throws IllegalArgumentException if
     *                                  1) oldPos doesn't contain piece, or
     *                                  2) the move is impossible.
     */
    @Override
    public boolean isValidMove(Position oldPos, Position newPos) {
        if(board.isFree(oldPos)) {
            throw new IllegalArgumentException("La position de départ doit "
                    + "contenir une pièce.");
        }
        
        List<Position> possMoves = getPossibleMoves(oldPos);
        if(!possMoves.contains(newPos)) {
            throw new IllegalArgumentException("Le mouvement n'est pas possible.");
        }
        
        boolean validMove = true;
        
        Color colorPlayer = board.getPiece(oldPos).getColor();
        Player player = colorPlayer == Color.WHITE ? this.white : this.black;
        Player opponent = player == this.white ? this.black : this.white;
        
        Piece sauvegarde = board.getPiece(newPos);
        move(oldPos, newPos);
        
        List<Position> capturePositions = getCapturePositions(opponent);
        King king = player == white ? whiteKing : blackKing;
        Position posKing = board.getPiecePosition(king);
        
        if(capturePositions.contains(posKing)) {
            validMove = false;
        }
        
        move(newPos, oldPos);
        board.setPiece(sauvegarde, newPos);
        
        return validMove;
    }
    
    /**
     * Gets the capture positions of a player
     * @param player the player whose capture positions we want
     * @return an array list of capture position
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> capturePositions = new ArrayList<>();
        for(Position pos : getPiecesPositions(player)) {
            Piece piece = this.board.getPiece(pos);
            capturePositions.addAll(piece.getCapturePositions(pos, board));
        }
        return capturePositions;
    }
    
    /**
     * Gets the positions of the pieces of a player
     * @param player the player whose pieces positions we want 
     * @return an array list of pieces positions
     */
    private List<Position> getPiecesPositions(Player player) {
        List<Position> piecesPositions = new ArrayList<>();
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                Position pos = new Position(row, col);
                if(!this.board.isFree(pos)){
                    Piece piece = this.board.getPiece(pos);
                    if(piece.getColor() == player.getColor()) {
                        piecesPositions.add(pos);
                    }
                }
            }
        }
        return piecesPositions;
    }
}
