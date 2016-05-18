import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keying extends JPanel{
	public Ship heroShip;
	public Ship alienShip;
	public Asteroid aster1;
	public Asteroid aster2;
	public Asteroid aster3;
	public Asteroid aster4;
	public Asteroid aster5;
	
	public int radius = 30;
	
	public boolean hero_right = false;
	public boolean hero_left = false;
	public boolean hero_up = false;
	public boolean hero_down = false;
	
	public boolean alien_right = false;
	public boolean alien_left = false;
	public boolean alien_up = false;
	public boolean alien_down = false;
	
	public Keying(Universe uni, Images i){
		heroShip = new Ship(radius,500,800);
		alienShip = new Ship(radius,500,200);
		aster1 = new Asteroid(radius*3);
		aster2 = new Asteroid(radius*2);
		aster3 = new Asteroid(radius);
		aster4 = new Asteroid(radius);
		aster5 = new Asteroid(radius);
		uni.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				//hero movements
				if(e.getKeyCode() == KeyEvent.VK_D){
					hero_right = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					hero_left = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_W){
					hero_up = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					hero_down = true;
				}
				
				//alien movements
				if(e.getKeyCode() == KeyEvent.VK_L){
					alien_right = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_J){
					alien_left = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_I){
					alien_up = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_K){
					alien_down = true;
				}
			}
			
			public void keyReleased(KeyEvent e){
				//hero movements
				if(e.getKeyCode() == KeyEvent.VK_D){
					hero_right = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					hero_left = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_W){
					hero_up = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					hero_down = false;
				}
				//alien movements
				if(e.getKeyCode() == KeyEvent.VK_L){
					alien_right = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_J){
					alien_left = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_I){
					alien_up = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_K){
					alien_down = false;
				}
			}
		});
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//universe
		this.setBackground(Color.BLACK);
		//heroship
		g.setColor(Color.GREEN);
		g.fillOval(heroShip.getX(),heroShip.getY(),
				heroShip.getRadius()*2,heroShip.getRadius());
		//alienship
		g.setColor(Color.RED);
		g.fillOval(alienShip.getX(), alienShip.getY(), 
				alienShip.getRadius()*2, alienShip.getRadius());
		//asteroids
		g.setColor(Color.GRAY);
		g.fillOval(aster1.getvarX(), aster1.getvarY(), radius, radius);
		if(aster1.getvarY()< getHeight()){
			 aster1.setvarY(aster1.getvarY()+3);
		}
		g.fillOval(aster2.getvarX(), aster2.getvarY(), radius, radius);
		if(aster2.getvarY()< getHeight()){
			 aster2.setvarY(aster2.getvarY()+3);
		}
		g.fillOval(aster3.getvarX(), aster3.getvarY(), radius, radius);
		if(aster3.getvarY()< getHeight()){
			 aster3.setvarY(aster3.getvarY()+5);
		}
		g.fillOval(aster4.getvarX(), aster4.getvarY(), radius, radius);
		if(aster4.getvarY()< getHeight()){
			 aster4.setvarY(aster4.getvarY()+5);
		}
		g.fillOval(aster5.getvarX(), aster5.getvarY(), radius, radius);
		if(aster5.getvarY()< getHeight()){
			 aster5.setvarY(aster5.getvarY()+6);
		}
		if(hero_right){
			heroShip.setX(heroShip.getX()+1);
		}
		if(hero_left){
			heroShip.setX(heroShip.getX()-1);
		}
		if(hero_up){
			heroShip.setY(heroShip.getY()-1);
		}
		if(hero_down){
			heroShip.setY(heroShip.getY()+1);
		}
		
		if(alien_right){
			alienShip.setX(alienShip.getX()+1);
		}
		if(alien_left){
			alienShip.setX(alienShip.getX()-1);
		}
		if(alien_up){
			alienShip.setY(alienShip.getY()-1);
		}
		if(alien_down){
			alienShip.setY(alienShip.getY()+1);
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}
}