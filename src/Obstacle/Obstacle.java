package Obstacle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Obstacle extends JPanel {
	private int x, y, largueur, hauteur;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLUE);
		g.fillOval(x, y, largueur, hauteur);

	}

	public Obstacle(int x, int y, int largueur, int hauteur) {
		this.x = x;
		this.y = y;
		this.largueur = largueur;
		this.hauteur = hauteur;
		JFrame fenetre = new JFrame();
		setPreferredSize(new Dimension(500, 500));
		fenetre.getContentPane().add(this);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setVisible(true);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static void main(String[] args) {
		Obstacle o1 = new Obstacle(200, 50, 10, 10);
	}

}
