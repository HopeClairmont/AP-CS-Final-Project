import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keying extends JPanel{
	public Ship heroShip;
	public Ship alienShip;
	public Asteroid aster;
	
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
		aster = new Asteroid(radius);
		
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
		this.setBackground(Color.BLACK);
		g.setColor(Color.GREEN);
		g.fillOval(heroShip.getX(),heroShip.getY(),
				heroShip.getRadius()*2,heroShip.getRadius());
		g.setColor(Color.RED);
		g.fillOval(alienShip.getX(), alienShip.getY(), 
				alienShip.getRadius()*2, alienShip.getRadius());
		g.setColor(Color.GRAY);
		g.fillOval(aster.getvarX(), aster.getvarY(), radius, radius);
		if(aster.getvarY()< getHeight()){
			 aster.setvarY(aster.getvarY()+1);
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
		repaint();
	}
}
