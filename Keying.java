
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.Timer;

public class Keying extends JPanel{
	private Ship heroShip;
	private Ship alienShip;

	//need these to use .getBounds and check if the asteroids collide with the ship because Rectangle class is useful for this

	private ArrayList<Rectangle> boundAsters = new ArrayList<Rectangle>();
	private ArrayList<Asteroid> asters = new ArrayList<Asteroid>();
	
	private Rectangle BoundHeroShip;
	private Rectangle BoundAlienShip;
	
	private boolean ingame = true;
	
	private int radius = 30;
	private int width = 1000;
	private int height = 1000;
	private final int ASTER_COUNT = 10;
	
	private boolean hero_right = false;
	private boolean hero_left = false;
	private boolean hero_up = false;
	private boolean hero_down = false;
	
	private boolean alien_right = false;
	private boolean alien_left = false;
	private boolean alien_up = false;
	private boolean alien_down = false;
	

	
	private Timer timer;
	
	public Keying(Universe uni, Images i, JPanel gp){
		heroShip = new Ship(radius,500,800);
		alienShip = new Ship(radius,500,200);
		for(int j=1; j<=ASTER_COUNT;j++){
			Asteroid aster = new Asteroid(radius);
			asters.add(aster);
			Rectangle boundAster = new Rectangle(aster.getvarX(),aster.getvarY(),radius,radius);
			boundAsters.add(boundAster);
		}
		
		BoundHeroShip = new Rectangle(heroShip.getX(),heroShip.getY(),radius*2,radius);
		BoundAlienShip = new Rectangle(alienShip.getX(),alienShip.getY(),radius*2,radius);
		
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
		
		CheckCollisions();
		if(ingame){
		super.paintComponent(g);
		//universe
		this.setBackground(Color.BLACK);
		//heroship
		g.setColor(Color.GREEN);
		g.fillOval(heroShip.getX(),heroShip.getY(),
				heroShip.getRadius()*2,heroShip.getRadius());
		//heroship bound
		g.setColor(Color.RED);
		g.drawRect(BoundHeroShip.x, BoundHeroShip.y, BoundHeroShip.width, BoundHeroShip.height);
		//alienship
		g.setColor(Color.RED);
		g.fillOval(alienShip.getX(), alienShip.getY(), 
				alienShip.getRadius()*2, alienShip.getRadius());
		//alienship bound
		g.setColor(Color.GREEN);
		g.drawRect(BoundAlienShip.x, BoundAlienShip.y, BoundAlienShip.width, BoundAlienShip.height);
		
		for(int j=1; j<ASTER_COUNT; j++){
			//asteroid #1
			Asteroid aster = asters.get(j);
			g.setColor(Color.GRAY);
			g.fillOval(aster.getvarX(), aster.getvarY(), radius, radius);
			//bound #1
			Rectangle bound = boundAsters.get(j);
			g.setColor(Color.RED);
			g.drawRect(bound.x,bound.y,bound.width,bound.height);
			if(aster.getvarY()< getHeight()){
				 aster.setvarY(aster.getvarY()+3);
				 bound.y+=3;
			}
		}
		
		if(hero_right){
			heroShip.setX(heroShip.getX()+1);
			BoundHeroShip.x+=1;
		}
		if(hero_left){
			heroShip.setX(heroShip.getX()-1);
			BoundHeroShip.x-=1;
		}
		if(hero_up){
			heroShip.setY(heroShip.getY()-1);
			BoundHeroShip.y-=1;
		}
		if(hero_down){
			heroShip.setY(heroShip.getY()+1);
			BoundHeroShip.y+=1;
		}
		
		if(alien_right){
			alienShip.setX(alienShip.getX()+1);
			BoundAlienShip.x+=1;
		}
		if(alien_left){
			alienShip.setX(alienShip.getX()-1);
			BoundAlienShip.x-=1;
		}
		if(alien_up){
			alienShip.setY(alienShip.getY()-1);
			BoundAlienShip.y-=1;
		}
		if(alien_down){
			alienShip.setY(alienShip.getY()+1);
			BoundAlienShip.y+=1;
		}
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		else{
			drawGameOver(g);
		}
		repaint();
	}
	
	public void drawGameOver(Graphics g){
		 String msg = "Game Over!!";
	        Font small = new Font("Helvetica", Font.BOLD, 64);
	        FontMetrics fm = getFontMetrics(small);

	        g.setColor(Color.white);
	        g.setFont(small);
	        g.drawString(msg, (width - fm.stringWidth(msg)) / 2,
	                height / 2);
	        JOptionPane.showMessageDialog(null,"Your score is " + (System.currentTimeMillis())/1000);
	}
	public void CheckCollisions(){
		if(BoundAlienShip.intersects(BoundHeroShip)){
			this.removeAll();
			ingame = false;
		}
		else{	
			for(Rectangle element: boundAsters){
			if(element.intersects(BoundHeroShip)){
				this.removeAll();
				ingame = false;
				}
			}
		}
	}
}
