package SpaceGame;

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
		x = rand.nextInt(900) + offset;
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
	
	public void updatePosition(Graphics g){
			this.setBackground(Color.BLACK);
			g.setColor(Color.GRAY);
			g.fillRect(aster.x, aster.y, aster.width, aster.height);
			t.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  if(!isTouching && getY()< getHeight()){
						  aster.y+=offset;
						  repaint();
					  }
				  }
			}, 500,500);
			
	}
	
}
