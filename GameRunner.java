import javax.swing.JFrame;

public class GameRunner {
	public static int w = 1000;
	public static int h = 1000;
	public static Universe uni = new Universe();
	public static void main(String[] args) {
		uni.setSize(1000,1000);
		uni.setResizable(true);
		uni.setVisible(true);
		uni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		uni.setTitle("Space Game");
		uni.setLocationRelativeTo(null);
		uni.setAlwaysOnTop(true);
	}

}
