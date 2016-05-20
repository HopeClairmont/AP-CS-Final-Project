package SpaceGame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class Keying extends JPanel{
	private Ship heroShip;
	private Ship alienShip;
	private Asteroid aster1;
	private Asteroid aster2;
	private Asteroid aster3;
	private Asteroid aster4;
	private Asteroid aster5;
	//need these to use .getBounds and check if the asteroids collide with the ship because Rectangle class is useful for this
	private Rectangle BoundAster1;
	private Rectangle BoundAster2;
	private Rectangle BoundAster3;
	private Rectangle BoundAster4;
	private Rectangle BoundAster5;
	private ArrayList<Rectangle> BoundAsters = new ArrayList<Rectangle>();
	
	private Rectangle BoundHeroShip;
	private Rectangle BoundAlienShip;
	
	private boolean ingame = true;
	private boolean CollisionDetected;
	
	private int radius = 30;
	private int width = 1000;
	private int height = 1000;
	
	private boolean hero_right = false;
	private boolean hero_left = false;
	private boolean hero_up = false;
	private boolean hero_down = false;
	
	private boolean alien_right = false;
	private boolean alien_left = false;
	private boolean alien_up = false;
	private boolean alien_down = false;
	
	public Keying(Universe uni, Images i, JPanel gp){
		heroShip = new Ship(radius,500,800);
		alienShip = new Ship(radius,500,200);
		aster1 = new Asteroid(radius);
		aster2 = new Asteroid(radius);
		aster3 = new Asteroid(radius);
		aster4 = new Asteroid(radius);
		aster5 = new Asteroid(radius);
		
		BoundAster1 = new Rectangle(aster1.getvarX(),aster1.getvarY(),radius,radius);
		BoundAster2 = new Rectangle(aster2.getvarX(),aster2.getvarY(),radius,radius);
		BoundAster3 = new Rectangle(aster3.getvarX(),aster3.getvarY(),radius,radius);
		BoundAster4 = new Rectangle(aster4.getvarX(),aster4.getvarY(),radius,radius);
		BoundAster5 = new Rectangle(aster5.getvarX(),aster5.getvarY(),radius,radius);
		BoundAsters.add(BoundAster1);
		BoundAsters.add(BoundAster2);
		BoundAsters.add(BoundAster3);
		BoundAsters.add(BoundAster4);
		BoundAsters.add(BoundAster5);
		
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
		//asteroid #1
		g.setColor(Color.GRAY);
		g.fillOval(aster1.getvarX(), aster1.getvarY(), radius, radius);
		//bound #1
		g.setColor(Color.RED);
		g.drawRect(BoundAster1.x,BoundAster1.y,BoundAster1.width,BoundAster1.height);
		if(aster1.getvarY()< getHeight()){
			 aster1.setvarY(aster1.getvarY()+3);
			 BoundAster1.y+=3;
		}
		//asteroid #2
		g.setColor(Color.GRAY);
		g.fillOval(aster2.getvarX(), aster2.getvarY(), radius, radius);
		//bound #2
		g.setColor(Color.RED);
		g.drawRect(BoundAster2.x,BoundAster2.y,BoundAster2.width,BoundAster2.height);	
		if(aster2.getvarY()< getHeight()){
			 aster2.setvarY(aster2.getvarY()+3);
			 BoundAster2.y+=3;
		}
		//asteroid #3
		g.setColor(Color.GRAY);
		g.fillOval(aster3.getvarX(), aster3.getvarY(), radius, radius);
		//bound #3
		g.setColor(Color.RED);
		g.drawRect(BoundAster3.x,BoundAster3.y,BoundAster3.width,BoundAster3.height);
		if(aster3.getvarY()< getHeight()){
			 aster3.setvarY(aster3.getvarY()+5);
			 BoundAster3.y+=5;
		}
		//asteroid #4
		g.setColor(Color.GRAY);
		g.fillOval(aster4.getvarX(), aster4.getvarY(), radius, radius);
		//bound #4
		g.setColor(Color.RED);
		g.drawRect(BoundAster4.x,BoundAster4.y,BoundAster4.width,BoundAster4.height);	
		if(aster4.getvarY()< getHeight()){
			 aster4.setvarY(aster4.getvarY()+5);
			 BoundAster4.y+=5;
		}
		//asteroid #5
		g.setColor(Color.GRAY);
		g.fillOval(aster5.getvarX(), aster5.getvarY(), radius, radius);
		//bound #5
		g.setColor(Color.RED);
		g.drawRect(BoundAster5.x,BoundAster5.y,BoundAster5.width,BoundAster5.height);	
		if(aster5.getvarY()< getHeight()){
			 aster5.setvarY(aster5.getvarY()+6);
			 BoundAster5.y+=6;
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
			Thread.sleep(20);
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
		 String msg = "Game Over";
	        Font small = new Font("Helvetica", Font.BOLD, 14);
	        FontMetrics fm = getFontMetrics(small);

	        g.setColor(Color.white);
	        g.setFont(small);
	        g.drawString(msg, (width - fm.stringWidth(msg)) / 2,
	                height / 2);
	}
	public void CheckCollisions(){
		for(Rectangle element: BoundAsters){
			if(element.intersects(BoundHeroShip)){
				this.removeAll();
				ingame = false;
			}
		}
	}
}