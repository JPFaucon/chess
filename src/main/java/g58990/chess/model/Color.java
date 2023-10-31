/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package g58990.chess.model;

/**
 * Enumaration of two colors
 * @author jp
 */
public enum Color {
    WHITE, BLACK;
    
    /**
     * Gives the opposite color of the current object
     * @return the opposite color of the current object
     */
    public Color opposite(){
        return this == values()[0] ? values()[1] : values()[0];
    }
}
