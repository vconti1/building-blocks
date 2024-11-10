import java.awt.Dimension;
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
	
	BuildingBlocks(){
		setPreferredSize(new Dimension(boardWidth,boardHeight));
		setFocusable(true);
		addKeyListener(this);
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
