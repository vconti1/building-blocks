import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;





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
	
	
	//Game logic
		int velocityX = -4;
		int velocityY = 0;
		int gravity = 4;
		
		ArrayList<Block> blocks;
		
		Timer gameLoop;
		Timer placeBlocksTimer;
		boolean gameOver = false;
	
	class Block{
		int x = blockX;
		int y = blockY;
		int width = blockWidth;
		int height = blockHeight;
		
		
		 Block() {
		        this.x = boardWidth / 2;
		        this.y = 0;
		    }
	}
	
	BuildingBlocks(){
		setPreferredSize(new Dimension(boardWidth,boardHeight));
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(this);
		
		blocks = new ArrayList<>();
		blocks.add(new Block()); // Add a starting block
		
		placeBlocksTimer = new Timer(1500,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		placeBlocksTimer.start();
		
		//game timer
		gameLoop = new Timer(1000/60,this);
		gameLoop.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		
		Graphics2D floor = (Graphics2D) g;
		Graphics2D bl = (Graphics2D) g;
		
		floor.setPaint(Color.white);
		floor.fillRect(0, boardHeight-floorOffset, boardWidth, blockX/8);
		
		// Draw each block
	    for (Block b : blocks) {
	        bl.setPaint(Color.white);
	        bl.fillRect(b.x, b.y, b.width, b.height);
	    }
		
	}
	
	public void spawnBlock(Graphics g) {
		Block newBlock = new Block();
	    newBlock.x = boardWidth / 2; // Center the new block
	    newBlock.y = 0; // Start at the top
	    blocks.add(newBlock);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

	    // Check if there is a block to control
	    if (!blocks.isEmpty()) {
	        Block currentBlock = blocks.get(blocks.size() - 1); // The most recent block

	        // Move left
	        if (key == KeyEvent.VK_A && currentBlock.x > 0) {
	            currentBlock.x -= width; // Move by the width of one block
	        }
	        // Move right
	        if (key == KeyEvent.VK_D && currentBlock.x < boardWidth - blockWidth) {
	            currentBlock.x += width; // Move by the width of one block
	        }
	        repaint(); // Redraw the screen to show the movement
	    }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (!blocks.isEmpty()) {
		        Block currentBlock = blocks.get(blocks.size() - 1);
		        
		        // Apply gravity to make the block fall
		        currentBlock.y += gravity;

		        // Stop the block if it reaches the floor
		        if (currentBlock.y + currentBlock.height >= boardHeight - floorOffset) {
		            currentBlock.y = boardHeight - floorOffset - currentBlock.height;
		            spawnBlock(null); // Spawn a new block when this one lands
		        }
		    }
		    repaint();
	}
	
}
