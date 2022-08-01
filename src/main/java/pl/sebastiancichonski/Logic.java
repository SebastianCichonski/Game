package pl.sebastiancichonski;

import static pl.sebastiancichonski.TypeOfMovement.*;

public class Logic {
    private GameBoard game;
    Player player_X;
    Player player_O;

    public Logic(GameBoard game, Player player_O, Player player_X) {
        this.game = game;
        this.player_O = player_O;
        this.player_X = player_X;

    }

    //TODO  , sprawdzenie czy wygrana/remis,

    private boolean checkField(int x, int y, int a, int b, Player player) {
        return ((game.getField(x, y).name().equals(player.getName())) &&
                (game.getField(a, b) == Field.EMPTY));
    }

    private TypeOfMovement checkMove(int x, int y, int a, int b) {
        if ((a == x && b == y - 1) || (a == x && b == y + 1) || (a == x + 1 && b == y) || (a == x - 1 && b == y)) {
            return PROPAGATION;
        } else if ((a == x && b == y - 2) || (a == x && b == y + 2) || (a == x + 2 && b == y) || (a == x - 2 && b == y)) {
            return JUMP;
        } else {
            return FORBIDDEN;
        }
    }

    private boolean isOnBoard(int x, int y) {
        if (x < 0) return false;
        if (y < 0) return false;
        if (x > game.BOARD_SIZE - 1) return false;
        if (y > game.BOARD_SIZE - 1) return false;
        return true;
    }

    private void consequencesOfMovement(int x, int y, Field field, Player player) {
        Field fieldOpponent = field.name().equals("O") ? Field.X : Field.O;
        Player playerOpponent = player.getName().equals("O") ? player_X : player_O;
        if (isOnBoard(x - 1, y)) {
            if (game.getField(x - 1, y) == fieldOpponent) {
                game.setField(x - 1, y, field);
                player.addPoints();
                playerOpponent.subPoints();
            }
        }
        if (isOnBoard(x + 1, y)) {
            if (game.getField(x + 1, y) == fieldOpponent) {
                game.setField(x + 1, y, field);
                player.addPoints();
                playerOpponent.subPoints();
            }
        }
        if (isOnBoard(x, y - 1)) {
            if (game.getField(x, y - 1) == fieldOpponent) {
                game.setField(x, y - 1, field);
                player.addPoints();
                playerOpponent.subPoints();
            }
        }
        if (isOnBoard(x, y + 1)) {
            if (game.getField(x, y + 1) == fieldOpponent) {
                game.setField(x, y + 1, field);
                player.addPoints();
                playerOpponent.subPoints();
            }
        }
        if (isOnBoard(x - 1, y - 1)) {
            if (game.getField(x - 1, y - 1) == fieldOpponent) {
                game.setField(x - 1, y - 1, field);
                player.addPoints();
                playerOpponent.subPoints();
            }
        }
        if (isOnBoard(x - 1, y + 1)) {
            if (game.getField(x - 1, y + 1) == fieldOpponent) {
                game.setField(x - 1, y + 1, field);
                player.addPoints();
                playerOpponent.subPoints();
            }
        }
        if (isOnBoard(x + 1, y + 1)) {
            if (game.getField(x + 1, y + 1) == fieldOpponent) {
                game.setField(x + 1, y + 1, field);
                player.addPoints();
                playerOpponent.subPoints();
            }
        }
        if (isOnBoard(x + 1, y - 1)) {
            if (game.getField(x + 1, y - 1) == fieldOpponent) {
                game.setField(x + 1, y - 1, field);
                player.addPoints();
                playerOpponent.subPoints();
            }
        }
    }

    public boolean endGame(Player player) {
        Player playerOpponent = player.getName().equals("O") ? player_X : player_O;
        Field fieldOpponent = player.getName().equals("O") ? Field.X : Field.O;
        //oponent nie ma już pionów
        if (playerOpponent.getPoints() == 0) {
            return true; //Wygrywa player
            //brak wolnych pól
        } else if (((player.getPoints() + playerOpponent.getPoints()) == (game.BOARD_SIZE * game.BOARD_SIZE))) {
            return true; //Liczypy punkty
        } else {//brak mozliwości ruchu
            for (int i = 0; i < game.getBoard().length; i++) {
                for (int j = 0; j < game.getBoard().length; j++) {
                    if (game.getField(i, j) == fieldOpponent) {
                        if (isPossibleToMove(i, j)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

        public boolean move ( int x, int y, int a, int b, Player player){
            if (checkField(x, y, a, b, player)) {
                boolean result = false;
                Field field = player.getName().equals("O") ? Field.O : Field.X;
                switch (checkMove(x, y, a, b)) {
                    case PROPAGATION:
                        game.setField(a, b, field);
                        player.addPoints();
                        result = true;
                        break;
                    case JUMP:
                        game.setField(a, b, field);
                        game.setField(x, y, Field.EMPTY);
                        result = true;
                        break;
                    default:
                        result = false;
                }
                consequencesOfMovement(a, b, field, player);
                return result;
            } else {
                return false;
            }
        }

    private boolean isPossibleToMove(int x, int y) {
        if (isOnBoard(x, y - 1)) {
            if (game.getField(x, y - 1) == Field.EMPTY) return true;
        }
        if (isOnBoard(x, y + 1)) {
            if (game.getField(x, y + 1) == Field.EMPTY) return true;
        }
        if (isOnBoard(x + 1, y)) {
            if (game.getField(x + 1, y) == Field.EMPTY) return true;
        }
        if (isOnBoard(x - 1, y)) {
            if (game.getField(x - 1, y) == Field.EMPTY) return true;
        }
        if (isOnBoard(x, y - 2)) {
            if (game.getField(x, y - 2) == Field.EMPTY) return true;
        }
        if (isOnBoard(x, y + 2)) {
            if (game.getField(x, y + 2) == Field.EMPTY) return true;
        }
        if (isOnBoard(x + 2, y)) {
            if (game.getField(x + 2, y) == Field.EMPTY) return true;
        }
        if (isOnBoard(x - 2, y)) {
            if (game.getField(x - 2, y) == Field.EMPTY) return true;
        }
        return false;
    }
}

