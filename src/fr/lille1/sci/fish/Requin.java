package fr.lille1.sci.fish;

import java.awt.Color;

import fr.lille1.sci.core.Agent;
import fr.lille1.sci.core.Environnement;
import fr.lille1.sci.main.Position;

public class Requin extends Agent {

	private int age;
	private int tempsReproduction;
	private int tempsSansManger;
	private int limiteTempsSansManger;

	public Requin(Environnement env, int numero, int x, int y,
			int tempsReproduction, int limiteTempsSansManger) {
		super(env, 0, 0);

		this.color = Color.GRAY;
		this.x = x;
		this.y = y;
		
		this.tempsReproduction = tempsReproduction;
		this.tempsSansManger = 0;
		this.limiteTempsSansManger = limiteTempsSansManger;
	}

	@Override
	public void decide() {

		if (this.limiteTempsSansManger == this.tempsSansManger) {
			this.env.remove(x, y);
			return;
		}

		Position newReqPosition = this.env.getPlaceLibre(x, y);
		Position firstThonDispo = this.env.getThonDispo(x, y);

		if (this.age % this.tempsReproduction == 0 && newReqPosition != null) {
			Requin r = new Requin(env, this.numero * 2, newReqPosition.getX(),
					newReqPosition.getY(), tempsReproduction, tempsSansManger);

			this.env.addAgent(newReqPosition.getX(), newReqPosition.getY(), r);
			this.tempsSansManger++;

		} else if (firstThonDispo != null) {
			manger(firstThonDispo);
		} else if (newReqPosition != null) {
			bouger(newReqPosition);
			this.tempsSansManger++;
		}

		this.age++;

	}

	private void manger(Position positionThon) {
		this.env.remove(positionThon.getX(), positionThon.getY()); // On retire
																	// le
																	// poisson
																	// de
																	// l'espace
																	// et du SMA
		this.tempsSansManger = 0; // On raz le temps sans manger
		bouger(positionThon);
	}

}
