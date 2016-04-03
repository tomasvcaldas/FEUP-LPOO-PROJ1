package MAZE.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import MAZE.Logic.*;
import java.awt.Point;


public class RandomDragon {

	char [][] m2 = {{'X', 'X', 'X', 'X', 'X'},
			{'X', ' ', ' ', ' ', ' '},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X'}};

	@Test(timeout=1000)
	public void moveDragonRandom() {
		Maze maze = new Maze();
		maze.setBoard(m2);
		maze.setSword(new Sword(3,1));
		maze.setDragon(new Dragon(2,2));
		int xinicial = maze.getDragon().getX();
		int yinicial = maze.getDragon().getY();


		boolean xMov = false, yMov = false;
		while(!xMov || !yMov){
			maze.moveDragonRandomly(maze.getDragon());
			if(maze.getDragon().getX() != xinicial)
				xMov = true;
			if(maze.getDragon().getY() != yinicial)
				yMov = true;
		}
	}

	@Test(timeout=1000)
	public void DragonAsleeps() {
		Maze maze = new Maze();
		maze.setBoard(m2);
		maze.setSword(new Sword(3,1));
		maze.setDragon(new Dragon(2,2));	
		maze.getDragon().setDragonAsleep(false);
		boolean adormece = false;
		while(!adormece){
			maze.moveDragonRandomly(maze.getDragon());
			maze.randomSleep();
			if (maze.getDragon().getDragonAsleep() == true)
				adormece = true;
		}
	}
	
	@Test(timeout=1000)
	public void DragonAwakes() {
		Maze maze = new Maze();
		maze.setBoard(m2);
		maze.setSword(new Sword(3,1));
		maze.setDragon(new Dragon(2,2));	
		maze.getDragon().setDragonAsleep(true);
		boolean acorda = false;
		while(!acorda){
			maze.moveDragonRandomly(maze.getDragon());
			maze.randomSleep();
			if (maze.getDragon().getDragonAsleep() == false)
				acorda = true;
		}
	}
	
	@Test(timeout=1000)
	public void PlaceHero(){
		Maze maze = new Maze();
		maze.setBoard(m2);
		maze.placeDragons(1);
		boolean posdragao = false;
		while(!posdragao){
			for (int i=0; i<m2.length;i++){
				for (int j=0; j < m2[i].length; j++){
					if (m2[j][i] == 'D')
						posdragao = true;
				}
			}
		}
	}
	
	@Test(timeout=1000)
	public void PlaceDragons(){
		Maze maze = new Maze();
		maze.setBoard(m2);
		maze.placeHero();
		boolean posheroi = false;
		while(!posheroi){
			for (int i=0; i<m2.length;i++){
				for (int j=0; j < m2[i].length; j++){
					if (m2[j][i] == 'H')
						posheroi = true;
				}
			}
		}
	}
	
	
	

}
