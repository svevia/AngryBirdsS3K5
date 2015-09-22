import java.awt.*;
import javax.swing.*;


public class Courbe extends JPanel{
	
	public static double X_MIN = 0;
	public static double X_MAX = 10;
	public static double Y_MIN = 0;
	public static double Y_MAX = 10;
	public static double T_MIN = 0;
	public static double T_MAX = 20;
	
	public double x(double t){
		return 2+(t*t);
	}
	
	public double y(double t){
		return 1+t;
	}
	
	public int toScreenX(double x){
		return (int) Math.round((getWidth()-1)*(x-X_MIN)/(X_MAX-X_MIN));
	}
	
	public int toScreenY(double y){
		return (int) Math.round((getWidth()-1)*(y-Y_MIN)/(Y_MAX-Y_MIN));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		double t = T_MIN;
		double x = x(t);
		double y = y(t);
		int precision = 400;
		double saut = (T_MAX-T_MIN)/(precision-1);
		for(int i =0; i<precision;i++){
			double ti = 0+i*saut;
			double xi = x(ti);
			double yi = y(ti);
			g.drawLine(toScreenX(x),toScreenY(y),toScreenX(xi),toScreenX(yi));
			x=xi;
			y=yi;
		}
		
	}
	

	public static void main(String[] args) {
		JFrame fen = new JFrame();
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel dessin = new Courbe();
		dessin.setPreferredSize(new Dimension(250,250));
		fen.getContentPane().add(dessin,BorderLayout.CENTER);
		fen.pack();
		fen.setVisible(true);

	}

}
