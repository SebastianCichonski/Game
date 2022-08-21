import pl.sebastiancichonski.GameBoard;
import pl.sebastiancichonski.Logic;
import pl.sebastiancichonski.Player;


public class Main {
    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        Player player_X = new Player("X");
        Player player_O = new Player("O");
        Logic logicGame = new Logic(game, player_O, player_X);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(0,0,0,1, player_X);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(7,7,6,7, player_O);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(0,1,1,1, player_X);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(6,7,6,6, player_O);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(1,1,3,1, player_X);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(6,6,4,6, player_O);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(3,1,4,1, player_X);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(6,7,6,6, player_O);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(0,1,0,3, player_X);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(4,6,4,5, player_O);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        logicGame.move(0,3,1,3, player_X);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        System.out.println(logicGame.endGame(player_X));
        logicGame.move(4,5,4,3, player_O);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
        System.out.println(logicGame.endGame(player_O));
        logicGame.move(3,1,3,2, player_X);
        System.out.printf("Points of Player X: %d ----- Points of Player O: %d\n", player_X.getPoints(),player_O.getPoints());
        game.show();
    }

}
