import java.awt.Graphics;

import javax.swing.JFrame;

public class Main {

	
	//Blocks will be built, you can mark my words!
	public static void main(String[] args) {
		int boardWidth = 360;
		int boardHeight = 640;
		
		JFrame frame = new JFrame("Building Blocks");
		

		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BuildingBlocks buildingBlocks = new BuildingBlocks();
		frame.add(buildingBlocks);
		frame.pack();
		buildingBlocks.requestFocus();
		frame.setVisible(true);
	}
}
