/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package g58990.chess.view;

import g58990.chess.model.Position;

/**
 *
 * @author jp
 */
public interface View {
    
    /**
     * Display the title and a welcome message to players.
     */
    public void displayTitle();
    
    /**
     * Display the winner.
     */
    public void displayWinner();
    
    /**
     * Display the board.
     */
    public void displayBoard();
    
    /**
     * Display a message inviting the current player to play.
     */
    public void displayPlayer();
    
    /**
     * Ask a valid position on the board to the current player.
     * @return the position
     */
    public Position askPosition();
    
    /**
     * Display an error message.
     * @param message the error message
     */
    public void displayError(String message);
    
    /**
     * Display a message.
     * @param message the message
     */
    public void displayMessage(String message);
    
    /**
     * Display a check message.
     */
    public void displayCheck();
    
    /**
     * Display a mat message.
     */
    public void displayMat();
    
    /**
     * Display a stale mate message.
     */
    public void displayStaleMat();
}
