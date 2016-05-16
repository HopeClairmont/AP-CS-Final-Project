import java.awt.*;
public class GameRunner {

	public static void main(String[] args) {
		
		//creates universe
		Universe uni = new Universe();
		DrawingPanel panel = new DrawingPanel(uni.getSize(),uni.getSize());
		Graphics g = panel.getGraphics();
		uni.create(panel,g);
		
		//creates hero_ship
		Ship heroShip = new Ship();
		g.setColor(heroShip.getColor());
		heroShip.create(panel, g);
	}

}
