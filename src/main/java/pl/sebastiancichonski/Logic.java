package pl.sebastiancichonski;

import static pl.sebastiancichonski.TypeOfMovement.*;

public class Logic {
    private GameBoard game;

    public Logic(GameBoard game) {
        this.game = game;
    }

    //TODO ruch, sprawdzenie czy możliwy, sprawdzenie czy wygrana/remis, konsekwencje ruchu,

    private boolean checkField(int x, int y, int a, int b, Player player){
        return ((game.getField(x,y).name().equals(player.name())) &&
                (game.getField(a,b) == Field.EMPTY));
    }

    private TypeOfMovement checkMove(int x, int y, int a, int b){
        if((a==x && b==y-1) || (a==x && b==y+1) || (a==x+1 && b==y) || (a==x-1 && b==y)){
            return PROPAGATION;
        }else  if((a==x && b==y-2) || (a==x && b==y+2) || (a==x+2 && b==y) || (a==x-2 && b==y)){
            return JUMP;
        }else {
            return FORBIDDEN;
        }
    }

    private void consequencesOfMovement(int x, int y, Field field){
        Field fieldOpponent = field.name().equals("O") ? Field.O : Field.X;
        if(game.getField(x-1,y) == fieldOpponent) game.setField(x-1,y,field);
        if(game.getField(x+1,y) == fieldOpponent) game.setField(x+1,y,field);
        if(game.getField(x,y-1) == fieldOpponent) game.setField(x,y-1,field);
        if(game.getField(x,y+1) == fieldOpponent) game.setField(x,y+1,field);
        if(game.getField(x-1,y-1) == fieldOpponent) game.setField(x-1,y-1,field);
        if(game.getField(x-1,y+1) == fieldOpponent) game.setField(x-1,y+1,field);
        if(game.getField(x+1,y+1) == fieldOpponent) game.setField(x+1,y+1,field);
        if(game.getField(x+1,y-1) == fieldOpponent) game.setField(x+1,y-1,field);
    }

    public boolean move(int x, int y, int a, int b, Player player){
        if(checkField(x,y,a,b,player)){
            boolean result = false;
            Field field = player.name().equals("O") ? Field.O : Field.X;
            switch(checkMove(x,y,a,b)){
                case PROPAGATION:
                    game.setField(a,b,field);
                    result = true;
                    break;
                case JUMP:
                    game.setField(a,b,field);
                    game.setField(x,y,Field.EMPTY);
                    result = true;
                    break;
                default:
                    result = false;
            }
            consequencesOfMovement(a,b,field);
            return result;
        }else {
            return false;
        }
    }
}
