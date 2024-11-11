import java.awt.BasicStroke;
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
		
		int gravity = 5;
		
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
	        bl.setPaint(Color.blue);
	        bl.fillRect(b.x, b.y, b.width, b.height);
	    }
		
	}
	
	public void spawnBlock() {
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
		 	dropBlocks();
		    repaint();
		    
	}
	
	public void dropBlocks() {
		if (!blocks.isEmpty()) {
	        Block currentBlock = blocks.get(blocks.size() - 1);
	        
	        // Apply gravity to make the block fall
	        currentBlock.y += gravity;

	        // Check for collision with the floor or other blocks
	        if (currentBlock.y + currentBlock.height >= boardHeight - floorOffset || isCollidingWithOtherBlocks(currentBlock)) {
	            // Snap the block to the floor or the block it landed on
	            if (currentBlock.y + currentBlock.height >= boardHeight - floorOffset) {
	                currentBlock.y = boardHeight - floorOffset - currentBlock.height;
	            } else {
	                // Align the block on top of the block it collided with
	                currentBlock.y = getCollisionYPosition(currentBlock);
	            }
	            
	            // Spawn a new block at the top
	            spawnBlock();
	        }
	    }
	}
	private boolean isCollidingWithOtherBlocks(Block currentBlock) {
	    for (int i = 0; i < blocks.size() - 1; i++) {
	        Block otherBlock = blocks.get(i);
	        // Check if the current block is directly above another block and within the same x bounds
	        if (currentBlock.x < otherBlock.x + otherBlock.width &&
	            currentBlock.x + currentBlock.width > otherBlock.x &&
	            currentBlock.y + currentBlock.height >= otherBlock.y) {
	            return true;
	        }
	    }
	    return false;
	}
	private int getCollisionYPosition(Block currentBlock) {
	    for (int i = 0; i < blocks.size() - 1; i++) {
	        Block otherBlock = blocks.get(i);
	        if (currentBlock.x < otherBlock.x + otherBlock.width &&
	            currentBlock.x + currentBlock.width > otherBlock.x &&
	            currentBlock.y + currentBlock.height >= otherBlock.y) {
	            return otherBlock.y - currentBlock.height;
	        }
	    }
	    return currentBlock.y;
	}
	
	//This method changes the color for each frame, not for each block. Will need work
	/*
	private Color randomColor() {
		
		Random rand = new Random();
		int num = rand.nextInt(8);
		
		switch(num) {
		
		case 1: return Color.white;
		case 2: return Color.blue;
		case 3: return Color.red;
		case 4: return Color.green;
		case 5: return Color.yellow;
		case 6: return Color.orange;
		case 7: return Color.pink;
		}
		
		
		return Color.white;
	}
	*/
}
