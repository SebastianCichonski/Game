package pl.sebastiancichonski;

import static pl.sebastiancichonski.Field.*;

public class GameBoardTestFactory {

    public static GameBoard create(){
        Field noEmptyFields [][] = {
                {X, X, O, O, O, EMPTY, EMPTY, EMPTY},
                {X, X, O, O, EMPTY, O, O, O},
                {X, O, O, O, EMPTY, O, O, EMPTY},
                {O, O, EMPTY, O, EMPTY, O, EMPTY, EMPTY},
                {O, O, O, EMPTY, O, O, O, O},
                {O, O, O, EMPTY, O, O, O, EMPTY},
                {O, O, O, EMPTY, O, O, O, EMPTY},
                {O, O, O, EMPTY, O, EMPTY, O, EMPTY},
        };
    return new GameBoard(noEmptyFields);
    }
}
