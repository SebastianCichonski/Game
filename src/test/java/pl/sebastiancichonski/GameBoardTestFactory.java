package pl.sebastiancichonski;

import static pl.sebastiancichonski.Field.*;

public class GameBoardTestFactory {

    public static GameBoard create(){
        Field noEmptyFields [][] = {
                {X, X, O, O, O, EMPTY},
                {X, X, O, O, EMPTY, O},
                {X, O, O, O, EMPTY, O},
                {O, O, EMPTY, O, EMPTY, O},
                {O, O, O, EMPTY, O, O},
                {O, O, O, EMPTY, O, O},
        };
    return new GameBoard(noEmptyFields);
    }
}
