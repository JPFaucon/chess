/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package g58990.chess.model;

/**
 * Enumaration of the 8 directions
 * @author jp
 */
public enum Direction {
    NW(1, -1), N(1, 0), NE(1, 1), W(0, -1), E(0, 1), SW(-1, -1), S(-1, 0), SE(-1, 1);
    
    private int deltaRow;
    private int deltaColumn;
    
    /**
     * Constructor of direction
     * @param deltaR the displacement for the row
     * @param deltaC the displacement for the column
     */
    private Direction(int deltaR, int deltaC){
        this.deltaRow = deltaR;
        this.deltaColumn = deltaC;
    }
    
    /**
     * Getter of deltaRow
     * @return the displacement for the row
     */
    public int getDeltaRow(){
        return this.deltaRow;
    }
    
    /**
     * Getter of deltaColumn
     * @return the displacement for the column
     */
    public int getDeltaColumn(){
        return this.deltaColumn;
    }
}
