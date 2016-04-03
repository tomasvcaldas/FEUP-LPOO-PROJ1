package MAZE.Gui;
import MAZE.Logic.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GPainel extends JPanel{
	
	Image dragonAwake, dragonAsleep, wall, heroArmed, heroUnarmed, exit, sword, relva;
	private int x=0, y=0, width=25, height=25;
	
	private char[][] maze;
	
	public void setMaze(char[][] maze){
		this.maze=maze;
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

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i=0; i < maze.length; i++){
			for (int j=0; j < maze[i].length; j++){
				if (maze[j][i] == 'D' || maze[i][j] == 'F')
					g.drawImage(dragonAwake, i*width, j*height, this);
				if (maze[j][i] == 'd' || maze[i][j] == 'f')
					g.drawImage(dragonAsleep, i*width, j*height, this);
				if (maze[j][i] == 'E')
					g.drawImage(sword, i*width, j*height, this);
				if (maze[j][i] == 'S')
					g.drawImage(exit, i*width, j*height, this);
				if (maze[j][i] == ' ')
					g.drawImage(relva, i*width, j*height, this);
				if (maze[j][i] == 'H')
					g.drawImage(heroUnarmed, i*width, j*height, this);
				if (maze[j][i] == 'A')
					g.drawImage(heroArmed, i*width, j*height, this);
				if (maze[j][i] == 'X')
					g.drawImage(wall, i*width, j*height, this);
			}
		}	
	}
}
