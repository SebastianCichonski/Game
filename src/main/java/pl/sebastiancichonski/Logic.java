package pl.sebastiancichonski;

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

    private int checkMove(int x, int y, int a, int b){
        if((a==x && b==y-1) || (a==x && b==y+1) || (a==x+1 && b==y) || (a==x-1 && b==y)){
            return 1;
        }else  if((a==x && b==y-2) || (a==x && b==y+2) || (a==x+2 && b==y) || (a==x-2 && b==y)){
            return 2;
        }else {
            return 0;
        }
    }



    public void move(int x, int y, int a, int b, Player player){
        if(checkField(x,y,a,b,player)){

        }

    }
}
