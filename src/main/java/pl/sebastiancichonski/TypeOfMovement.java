package pl.sebastiancichonski;

public enum TypeOfMovement {
    PROPAGATION (1),
    JUMP (2),
    FORBIDDEN (0);

    private int scope;

    TypeOfMovement(int scope){
        this.scope = scope;
    }

    public int getScope() {
        return scope;
    }
}
