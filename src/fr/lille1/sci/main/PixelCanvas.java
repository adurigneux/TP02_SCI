package fr.lille1.sci.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import fr.lille1.sci.billes.Bille;
import fr.lille1.sci.billes.BilleSMA;
import fr.lille1.sci.core.Agent;


public class PixelCanvas extends Canvas implements Observer {


    private JFrame frame;
    private int tailleCase, width, height;
    private List<Agent> agents;


    PixelCanvas(int width, int height, int tailleCase) {
        frame = new JFrame();

        frame.add(this);
        frame.setTitle("Billes - Antoine Durigneux & Quentin Warnant  (V 1.0)");

        // set the jframe size and location, and make it visible
        setPreferredSize(new Dimension((width * tailleCase) + 2, (height * tailleCase) + 2));
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        this.tailleCase = tailleCase;
        this.width = width * tailleCase;
        this.height = height * tailleCase;
    }

    @Override
    public void update(Observable observable, Object objectConcerne) {
        if (observable instanceof BilleSMA) {
            agents = ((BilleSMA) observable).getAgents();
            // System.out.println("Nouveau tour");
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //clear everything
        //  g.clearRect(0, 0, width, height);
        g.setColor(Color.black);
        g.drawRect(0, 0, width, height);

        if (agents != null) {
            for (Agent agent : agents) {
                Bille b = (Bille) agent;
                g.setColor(b.getCouleur());
                g.fillRect(b.getX() * tailleCase, b.getY() * tailleCase, tailleCase, tailleCase);
            }
        }


    }


}