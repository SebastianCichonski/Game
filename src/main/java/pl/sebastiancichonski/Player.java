package pl.sebastiancichonski;

public class Player {
    private int points;
    private final String name;

    public Player(String name) {
        this.name = name;
        points = 1;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void addPoints(){
        this.points ++;
    }

    public void subPoints(){
        this.points --;
    }
}