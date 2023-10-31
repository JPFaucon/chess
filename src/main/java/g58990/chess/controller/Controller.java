/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.chess.controller;

import g58990.chess.model.GameState;
import g58990.chess.model.Model;
import g58990.chess.model.Position;
import g58990.chess.view.View;

/**
 * Represents the controller of the chess game.
 * @author jp
 */
public class Controller {
    private View view;
    private Model model;
    
    public Controller(Model model, View view){
        this.view = view;
        this.model = model;
    }
    
    public void play(){
        boolean gameIsOver = false;
        
        view.displayTitle();
        model.start();
        
        while(!gameIsOver){
            this.view.displayBoard();
            this.view.displayPlayer();
            boolean validatedMove;
            boolean validMove;
            GameState gameState;
            do{
                Position startPos;
                boolean goodStartPos;
                
                do{
                    view.displayMessage("Entrez votre position de départ.");
                    startPos = view.askPosition();
                    goodStartPos = this.model.isCurrentPlayerPosition(startPos) 
                            && !model.getPossibleMoves(startPos).isEmpty();
                    if(!goodStartPos){
                        view.displayError("La case sélectionnée ne contient "
                                + "aucune de vos pièces ou la pièce sélectionnée "
                                + "ne peut pas bouger.");
                    }
                }while(!goodStartPos);
                
                view.displayMessage("Entrez votre position d'arrivée.");
                Position endPos = view.askPosition();
                validatedMove = model.getPossibleMoves(startPos).contains(endPos);
                validMove = model.isValidMove(startPos, endPos);
                if(validatedMove && validMove){
                    model.movePiecePosition(startPos, endPos);
                }else{
                    view.displayError("Ce coup n'est pas possible, veuillez "
                            + "recommencer.");
                }
            }while(!(validatedMove && validMove));
            gameState = model.getState();
            switch(gameState) {
                case STALE_MATE -> view.displayStaleMat();
                case CHECK_MATE -> view.displayMat();
                case CHECK -> view.displayCheck();
                case PLAY -> {
                }
            }
            gameIsOver = this.model.isGameOver();
        }
        view.displayWinner();
    }
}
