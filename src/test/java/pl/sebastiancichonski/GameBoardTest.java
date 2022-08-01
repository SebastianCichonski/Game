package pl.sebastiancichonski;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static pl.sebastiancichonski.Field.*;

public class GameBoardTest {
    private GameBoard gameBoard;

    @Before
    public void before(){
        gameBoard = new GameBoard();
    }

    @Test
    public void getField_Test() {
        assertEquals(X, gameBoard.getField(0,0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getField_OutsideBoard_ToLow_Test() {
        assertEquals(X, gameBoard.getField(0,-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getField_OutsideBoard_ToMuch_Test() {
        assertEquals(X, gameBoard.getField(0,111));
    }

    @Test
    public void setField_Test() {
        gameBoard.setField(3,3, O);
        assertEquals(O, gameBoard.getField(3,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setField_OutsideBoard_ToLow_Test() {
        gameBoard.setField(0,-3, O);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setField_OutsideBoard_ToMuch_Test() {
        gameBoard.setField(0,23, O);
    }

    @Test
    public void getBoard_Test() {
        Field tab [][] = {
                {X, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, O},
                };
        assertArrayEquals(tab,gameBoard.getBoard());
    }



}