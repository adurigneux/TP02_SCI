package fr.lille1.sci.main;

import fr.lille1.sci.core.Agent;
import fr.lille1.sci.core.SMA;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PixelCanvas extends Canvas implements Observer {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private int tailleCase, width, height;
	private List<Agent> agents;
	private boolean redraw = true;

	PixelCanvas(int width, int height, int tailleCase) {
		frame = new JFrame();

		frame.add(this);
		frame.setTitle("SCI - Antoine Durigneux & Quentin Warnant  (V 2.0)");

		// set the jframe size and location, and make it visible
		setPreferredSize(new Dimension((width * tailleCase) + 2,
				(height * tailleCase) + 2));
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
		if (observable instanceof SMA) {
			agents = ((SMA) observable).getAgents();
		}
		if (redraw)
			repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		redraw = false;
		g.clearRect(0, 0, width, height);
		g.setColor(Color.black);
		g.drawRect(0, 0, width, height);

		if (agents != null) {
			for (Agent agent : agents) {
				g.setColor(agent.getColor());
				g.fillRect(agent.getX() * tailleCase,
						agent.getY() * tailleCase, tailleCase, tailleCase);
			}
		}
		redraw = true;
	}

}