package fr.lille1.sci.fish;

import java.awt.Color;

import fr.lille1.sci.core.Agent;
import fr.lille1.sci.core.Environnement;
import fr.lille1.sci.main.Position;

public class Thon extends Agent {

	private int age;
	private int tempsReproduction;

	public Thon(Environnement env, int numero, int x, int y,
			int tempsReproduction) {
		super(env, 0, 0);
		this.numero = numero;
		this.color = Color.BLUE;
		this.x = x;
		this.y = y;
		this.tempsReproduction = tempsReproduction;
	}

	@Override
	public void decide() {

		Position newThonPosition = this.env.getPlaceLibre(x, y);

		if (this.age % this.tempsReproduction == 0 && newThonPosition != null) {
			Thon t = new Thon(env, this.numero * 2, newThonPosition.getX(),
					newThonPosition.getY(), tempsReproduction);

			this.env.addAgent(newThonPosition.getX(), newThonPosition.getY(), t);
		} else if (newThonPosition != null) {
			bouger(newThonPosition);
		}

		//System.out.println("Thon " + this.numero + " " + this.age);
		
		this.age++;
	}

	@Override
	public String toString() {
		return "Thon [age=" + age + ", tempsReproduction=" + tempsReproduction
				+ ", color=" + color + ", numero=" + numero + "]";
	}
	
	

}
