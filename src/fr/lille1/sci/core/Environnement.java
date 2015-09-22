package fr.lille1.sci.core;
public class Environnement {

    private Agent[][] espace;
    private int tailleX;
    private int tailleY;

    public Environnement(int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;

        this.espace = new Agent[tailleX][tailleY];
    }

    public int getTailleX() {
        return this.tailleX;
    }

    public int getTailleY() {
        return this.tailleY;
    }

    public boolean put(int x, int y, Agent agent) {

        this.espace[x][y] = agent;
        return true;
    }

    public Agent get(int x, int y) {
        return this.espace[x][y];
    }

    public boolean estEnDehors(int x, int y) {
        return (estDehorsX(x) && estDehorsY(y));
    }

    public boolean estDehorsX(int x) {
        return !(x >= 0 && x < this.tailleX);
    }

    public boolean estDehorsY(int y) {
        return !(y >= 0 && y < this.tailleY);
    }

    public boolean estVide(int x, int y) {
        return this.get(x, y) == null;
    }

    public void clear(int x, int y) {
        this.espace[x][y] = null;
    }

}
