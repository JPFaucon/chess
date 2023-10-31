/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.chess.model;

/**
 * Represents a position. A position is composed of a row and a column.
 * @author jp
 */
public class Position {
    private int row;
    private int column;
    
    /**
     * Constructor of position
     * @param row the row of the position
     * @param column the column of the position
     */
    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }
    
    /**
     * Getter of row
     * @return the row of the position
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Getter of column
     * @return the column of the position
     */
    public int getColumn(){
        return this.column;
    }
    
    /**
     * Creates a new position from the current position in a certain direction
     * @param dir the direction for the new position
     * @return the new position
     */
    public Position next(Direction dir){
        int newRow = this.row + dir.getDeltaRow();
        int newColumn = this.column + dir.getDeltaColumn();
        return new Position(newRow, newColumn);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.row;
        hash = 71 * hash + this.column;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }
    
    
}

