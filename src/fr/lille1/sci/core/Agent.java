package fr.lille1.sci.core;

import java.awt.Color;

public abstract class Agent {

    protected Environnement env;
    protected int x;
    protected int y;
    protected Color color;
    protected int numero;

    public Agent(Environnement env, int x, int y) {
        this.env = env;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }

    public Environnement getEnv() {
        return env;
    }

    public void setEnv(Environnement env) {
        this.env = env;
    }
    

    public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

	public abstract void decide();

    @Override
    public String toString() {
        return "Agent{" +
                "env=" + env +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
