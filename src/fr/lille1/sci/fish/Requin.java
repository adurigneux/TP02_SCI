package fr.lille1.sci.fish;

import java.awt.Color;

import fr.lille1.sci.core.Agent;
import fr.lille1.sci.core.Environnement;

public class Requin extends Agent {

	private int age;
	private int tempsReproduction;
	private int tempsSansManger;

	public Requin(Environnement env, int numero, int x, int y,
			int tempsReproduction, int tempsSansManger) {
		super(env, 0, 0);

		this.color = Color.GRAY;
		this.x = x;
		this.y = y;
		this.tempsReproduction = tempsReproduction;
		this.tempsSansManger = tempsSansManger;
	}

	@Override
	public void decide() {
		// TODO Auto-generated method stub

	}

}
