import java.awt.*;
import javax.swing.*;

public class Ship extends JPanel{

	private int radius;
	private Point position;
	private Color c;
	
	//creates generic ship
	public Ship(){
		radius = 30;
		position = new Point(485,500);
		c = Color.GREEN;
	}
	public Ship(int r, Point p, Color c){
		radius = r;
		position = p;
		this.c = c;
	}
	public int getRadius(){
		return radius;
	}
	public Point getPosition(){
		return position;
	}
	public Color getColor(){
		return c;
	}
	public void create(DrawingPanel panel, Graphics g){
		g.fillOval((int)position.getX(), (int)position.getY(), radius*2, radius);
	}
}
