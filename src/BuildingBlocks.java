import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
	int blockX = boardWidth/8;
	int blockY = boardHeight/2;
	int blockWidth = 34;
	int blockHeight = 24;
	
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
	
	public void draw(Graphics g) {
		g.drawRect(blockX, blockY, blockWidth, blockHeight);
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
