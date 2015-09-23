package fr.lille1.sci.main;

import fr.lille1.sci.fish.PoissonSMA;

public class PoissonSimulation {
	
	public static final boolean DEBUG = true;

    public static void main(String[] args) {

        if (args.length < 9) {
            System.out.println("Usage : java Simulation tailleX tailleY tailleCase nombrePoissons nombreRequins tempsReproductionPoisson tempsReproductionRequin tempsSansManger sleepTime");
            return;
        }

        int tailleX = Integer.parseInt(args[0]);
        int tailleY = Integer.parseInt(args[1]);
        int tailleCase = Integer.parseInt(args[2]);
        
        int nombrePoissons = Integer.parseInt(args[3]);
        int nombreRequins = Integer.parseInt(args[4]);
        int tempsReproductionPoisson = Integer.parseInt(args[5]);
        int tempsReproductionRequin = Integer.parseInt(args[6]);
        int tempsSansManger = Integer.parseInt(args[7]);
        
        int sleepTime = Integer.parseInt(args[8]);  
        
        System.out.println(sleepTime);

        PoissonSMA sma = new PoissonSMA();
        
        System.out.println("init global");

        
        sma.init(tailleX, tailleY, nombrePoissons + nombreRequins);
        
        System.out.println("init poissons");
        
        sma.initPoissons(nombrePoissons, tempsReproductionPoisson);
        
        System.out.println("init requins");
        
        
        sma.initRequins(nombreRequins, tempsReproductionRequin, tempsSansManger);
        
        System.out.println("init canvas");

        PixelCanvas canvas = new PixelCanvas(tailleX, tailleY, tailleCase);
        sma.addObserver(canvas);

        sma.run(0, sleepTime);

    }

}
