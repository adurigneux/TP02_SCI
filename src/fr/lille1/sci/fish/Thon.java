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
		
		if (this.age % this.tempsReproduction == 0) {
			
			if (newThonPosition != null) {
				Thon t = new Thon(env, this.numero * 2, newThonPosition.getX(),
						newThonPosition.getY(), tempsReproduction);
				
				//metre a jour les infos du sma et de l'env actuel
			} 
		} else {
			bouger(newThonPosition);
		}

		this.age++;
	}

	private void bouger(Position newThonPosition) {
		this.env.clear(this.x, this.y);
		this.x = newThonPosition.getX();
		this.y = newThonPosition.getY();
		this.env.put(x, y, this);
	}

}
