/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package g58990.chess;

import g58990.chess.controller.Controller;
import g58990.chess.model.Game;
import g58990.chess.model.Model;
import g58990.chess.view.TextView;

/**
 * Starts the game.
 * @author jp
 */
public class Chess {

    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        controller.play();
    }
}
