import java.awt.*;

public class Universe {
	//instance variables
	private int size;
	private int star_rows;
	private int star_size;
	
	//generic universe
	public Universe(){
		size = 1000;
		star_rows = 20;
		star_size = 5;
	}
	//overloaded constructor
	public Universe(int size, int star_rows, int star_size){
		this.size = size;
		this.star_rows = star_rows;
		this.star_size = star_size;
		
	}
	public int getSize(){
		return size;
	}
	public int getStar_rows(){
		return star_rows;
	}
	public int getStar_size(){
		return star_size;
	}
	//one method to create universe
	public void create(DrawingPanel panel, Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, size, size);
		g.setColor(Color.YELLOW);
		for(int i = 0; i < star_rows; i++){
			for(int j = 0; j < star_rows; j++){
				g.fillOval(i*size/star_rows+10, j*size/star_rows+10, star_size, star_size);
			}
		}
	}
}
