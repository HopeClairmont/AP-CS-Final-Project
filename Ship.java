package SpaceGame;


import java.awt.*;

public class Ship {
	private int radius;
	private int x;
	private int y;
	private boolean isTouching = false;
	
	public Ship(int r, int x, int y){
		radius = r;
		this.setX(x);
		this.setY(y);
	}
	public int getRadius(){
		return radius;
	}
	public void setRadius(int r){
		radius = r;
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
	public boolean isTouching() {
		return isTouching;
	}
	public void setTouching(boolean isTouching) {
		this.isTouching = isTouching;
	}
	public void checkIsTouching(Point q){
		Point p = new Point(x,y);
		if(p.distance(q) < this.getRadius()){
			isTouching = true;
		}
	}
}