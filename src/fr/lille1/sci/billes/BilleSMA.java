package fr.lille1.sci.billes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import fr.lille1.sci.core.Agent;
import fr.lille1.sci.core.Environnement;
import fr.lille1.sci.core.SMA;


public class BilleSMA extends SMA {

    public void init(int tailleX, int tailleY, int nombreAgents) {
        this.env = new Environnement(tailleX, tailleY);
        this.setAgents(new ArrayList<Agent>(nombreAgents));

        for (int i = 0; i < nombreAgents; i++) {

            Bille b = new Bille(env, i);
            this.env.put(b.getX(), b.getY(), b);
            this.getAgents().add(b);

        }
    }

    @Override
    public void run(final int nbTour, int sleepTime) {

        final int[] compteur = {0};

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Collections.shuffle(getAgents());
                for (Agent a : getAgents()) {
                    //clear env place before
                    //   this.env.clear(a.getX(), a.getY());
                    a.decide();

                    //System.out.println(a.toString());
                    env.put(a.getX(), a.getY(), a);
                }

                setChanged();
                notifyObservers();

                compteur[0]++;
                if (compteur[0] == nbTour) {
                    this.cancel();
                }
            }
        }, 0, sleepTime);



    }

}
