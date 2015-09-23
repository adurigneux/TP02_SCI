package fr.lille1.sci.core;

import java.util.List;
import java.util.Observable;

public abstract class SMA extends Observable {

	protected Environnement env;
	protected List<Agent> agents;

	public abstract void init(int tailleX, int tailleY, int nombreAgents);

	public abstract void run(int nbTour, int sleepTime);

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	public void addAgent(Agent agent) {
		this.agents.add(agent);
	}

	public void removeAgent(Agent agent) {
		this.agents.remove(agent);
	}
}
