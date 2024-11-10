import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class BuildingBlocks extends JPanel implements ActionListener, KeyListener {

	final int width = 16;
	final int height = 16;
	final int boardWidth = 360;
	final int boardHeight = 640;
	int blockX = boardWidth/2;
	int blockY = boardHeight/2;
	int blockWidth = 32;
	int blockHeight = 32;
	int floorOffset = 125;
	
	class Block{
		int x = blockX;
		int y = blockY;
		int width = blockWidth;
		int height = blockHeight;
		
		
		Block(){
		}
	}
	
	BuildingBlocks(){
		setPreferredSize(new Dimension(boardWidth,boardHeight));
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(this);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		
		Graphics2D block = (Graphics2D) g;
		Graphics2D floor = (Graphics2D) g;
		
		floor.setPaint(Color.white);
		floor.fillRect(0, boardHeight-floorOffset, boardWidth, blockX/8);
		
		//block.setPaint(Color.white);
		//block.fillRect(blockX, blockY, blockWidth, blockHeight);
		
		//g.drawRect(blockX, blockY, blockWidth, blockHeight);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
