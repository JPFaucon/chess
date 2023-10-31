/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package g58990.chess.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jp
 */
public class PositionTest {
    
    public PositionTest() {
    }

    @Test
    public void testNextGeneralCaseNE() {
        Direction dir = Direction.NE;
        Position pos = new Position(4,4);
        Position nextPos = pos.next(dir);
        Assertions.assertEquals(nextPos.getRow(), 5);
        Assertions.assertEquals(nextPos.getColumn(), 5);
    }
    
    @Test
    public void testNextGeneralCaseSW() {
        Direction dir = Direction.SW;
        Position pos = new Position(4,4);
        Position nextPos = pos.next(dir);
        Assertions.assertEquals(nextPos.getRow(), 3);
        Assertions.assertEquals(nextPos.getColumn(), 3);
    }
}
