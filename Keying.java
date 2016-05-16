import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keying extends JPanel{
	public Ship heroShip;
	
	public int radius = 30;
	
	public boolean right = false;
	public boolean left = false;
	
	public Keying(Universe uni, Images i){
		heroShip = new Ship(radius,500,800);
		
		uni.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_D){
					right = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					left = true;
				}
			}
			
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_D){
					right = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					left = false;
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
		
		if(right){
			heroShip.setX(heroShip.getX()+1);
		}
		if(left){
			heroShip.setX(heroShip.getX()-1);
		}
		repaint();
	}
}
