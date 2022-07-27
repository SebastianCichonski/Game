package pl.sebastiancichonski;

import pl.sebastiancichonski.Field;

public class GameBoard {
    public static final int BOARD_SIZE = 6;
    private Field board[][] = new Field[BOARD_SIZE][BOARD_SIZE];


    /**
     * Konstruktor inicjalizujący tablice(planszę gry);
     */
    public GameBoard() {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j< board.length; j++){
                board[i][j] = Field.EMPTY;
            }
        }
        board[0][0] = Field.X;
        board[board.length-1][board.length-1] = Field.O;
    }

    public Field[][] getBoard() {
        return board;
    }

    public Field getField(int x, int y){
        return board[x][y];
    }

    public void show(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                switch (board[i][j]) {
                    case EMPTY:
                        System.out.print("|_");
                        break;
                    case O:
                        System.out.print("|O");
                        break;
                    case X:
                        System.out.print("|X");
                        break;
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }
}
