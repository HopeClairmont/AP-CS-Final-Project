import java.awt.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class Asteroid extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Rectangle aster;
	private int radius = 10;
	private int offset = (int) (radius*1.5);
	private int x;
	private int y;
	
	private Timer t = new Timer();
	private boolean isTouching = false;
	
	public Asteroid(int r){
		Random rand = new Random(); //this variable 
		x = rand.nextInt(950) + offset;
		y = offset;
		radius = r;
	}
	public int getvarX(){
		return x;
	}
	public int getvarY(){
		return y;
	}
	public void setvarX(int x){
		this.x = x;
	}
	public void setvarY(int y){
		this.y = y;
	}
	public void setIsTouching(boolean newIT){
		isTouching = newIT;
	}
	
	public int getRadius(){ //RADIUS does not have a setter!
		return radius;
	}
	
	public boolean getIsTouching(){
		return isTouching;
	}
}