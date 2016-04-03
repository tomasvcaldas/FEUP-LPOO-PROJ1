package MAZE.Gui;
import MAZE.Logic.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GPainel extends JPanel implements KeyListener{
	
	Image dragonAwake, dragonAsleep, wall, heroArmed, heroUnarmed, exit, sword, relva;
	private int x=0, y=0, width=25, height=25;
	
	private Maze maze;
	
	public void setMaze(Maze maze){
		this.maze = maze;
	}
	
	
	public GPainel() {
		dragonAwake = new ImageIcon("dragaoawake.jpg").getImage();
		dragonAwake= dragonAwake.getScaledInstance(width, height, 1);
		dragonAsleep = new ImageIcon("dragaosleep.jpg").getImage();
		dragonAsleep= dragonAsleep.getScaledInstance(width, height, 1);
		heroArmed = new ImageIcon("heroiarmed.png").getImage();
		heroArmed= heroArmed.getScaledInstance(width, height, 1);
		heroUnarmed = new ImageIcon("heroiunarmed.png").getImage();
		heroUnarmed= heroUnarmed.getScaledInstance(width, height, 1);
		exit = new ImageIcon("out.png").getImage();
		exit = exit.getScaledInstance(width, height, 1);
		relva = new ImageIcon("relva.jpg").getImage();
		relva = relva.getScaledInstance(width, height, 1);
		sword = new ImageIcon("sword.jpg").getImage();
		sword= sword.getScaledInstance(width, height, 1);
		wall = new ImageIcon("wall.jpg").getImage();
		wall= wall.getScaledInstance(width, height, 1);
		
		addKeyListener(this);
		this.setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i=0; i < maze.getBoard().length; i++){
			for (int j=0; j < maze.getBoard()[i].length; j++){
				if (maze.getBoard()[j][i] == 'D' || maze.getBoard()[i][j] == 'F')
					g.drawImage(dragonAwake, i*width, j*height, this);
				if (maze.getBoard()[j][i] == 'd' || maze.getBoard()[i][j] == 'f')
					g.drawImage(dragonAsleep, i*width, j*height, this);
				if (maze.getBoard()[j][i] == 'E')
					g.drawImage(sword, i*width, j*height, this);
				if (maze.getBoard()[j][i] == 'S')
					g.drawImage(exit, i*width, j*height, this);
				if (maze.getBoard()[j][i] == ' ')
					g.drawImage(relva, i*width, j*height, this);
				if (maze.getBoard()[j][i] == 'H')
					g.drawImage(heroUnarmed, i*width, j*height, this);
				if (maze.getBoard()[j][i] == 'A')
					g.drawImage(heroArmed, i*width, j*height, this);
				if (maze.getBoard()[j][i] == 'X')
					g.drawImage(wall, i*width, j*height, this);
			}
		}	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {			
		switch(e.getKeyCode()){
		case KeyEvent.VK_W:
			maze.moveHero('W');
			System.out.println("Up");
			repaint();
			break;
		case KeyEvent.VK_S:
			maze.moveHero('S');
			repaint();
			break;
		case KeyEvent.VK_A:
			maze.moveHero('A');
			repaint();
			break;
		case KeyEvent.VK_D:
			maze.moveHero('D');
			repaint();
			break;
		default:
			break;
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
