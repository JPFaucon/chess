/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.chess.model;

/**
 * Represents a player. A player has a color.
 * @author jp
 */
public class Player {
    private Color color;
    
    /**
     * Constructor of player
     * @param color the color of the player
     */
    public Player(Color color){
        this.color = color;
    }
    
    /**
     * Getter of color
     * @return the color of the player
     */
    public Color getColor(){
        return this.color;
    }
}
