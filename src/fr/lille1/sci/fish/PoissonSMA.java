package fr.lille1.sci.fish;

import java.util.ArrayList;
import java.util.Random;

import fr.lille1.sci.core.Agent;
import fr.lille1.sci.core.Environnement;
import fr.lille1.sci.core.SMA;

public class PoissonSMA extends SMA {

	@Override
	public void init(int tailleX, int tailleY, int nombreAgents) {
		this.env = new Environnement(tailleX, tailleY);
		this.setAgents(new ArrayList<Agent>(nombreAgents));
	}

	public void initPoissons(int nombrePoissons, int tempsReproductionPoisson) {
		for (int i = 0; i < nombrePoissons; i++) {

			int x, y;
			do {
				Random random = new Random();
				x = random.nextInt(env.getTailleX());
				y = random.nextInt(env.getTailleY());
			} while (this.env.estVide(x, y));

			Thon p = new Thon(env, i, x, y, tempsReproductionPoisson);
			this.env.put(p.getX(), p.getY(), p);
			this.getAgents().add(p);

		}
	}

	public void initRequins(int nombreRequins, int tempsReproductionRequin,
			int tempsSansManger) {
		for (int i = 0; i < nombreRequins; i++) {
			int x, y;
			do {
				Random random = new Random();
				x = random.nextInt(env.getTailleX());
				y = random.nextInt(env.getTailleY());
			} while (this.env.estVide(x, y));

			Requin p = new Requin(env, i, x, y, tempsReproductionRequin,
					tempsSansManger);
			this.env.put(p.getX(), p.getY(), p);
			this.getAgents().add(p);
		}
	}

	@Override
	public void run(int nbTour, int sleepTime) {
		// TODO Auto-generated method stub

	}

}
