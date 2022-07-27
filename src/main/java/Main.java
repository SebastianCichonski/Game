import pl.sebastiancichonski.GameBoard;
import pl.sebastiancichonski.Logic;
import pl.sebastiancichonski.Player;

import static pl.sebastiancichonski.Player.*;

public class Main {
    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        Logic logicGame = new Logic(game);
        game.show();
        logicGame.move(0,0,0,1, PLAYER_X);
        game.show();
        logicGame.move(5,5,4,5, PLAYER_O);
        game.show();
        logicGame.move(0,1,1,1, PLAYER_X);
        game.show();
        logicGame.move(4,0,3,0, PLAYER_O);
        game.show();
        logicGame.move(1,1,3,1, PLAYER_X);
        game.show();


    }

}
