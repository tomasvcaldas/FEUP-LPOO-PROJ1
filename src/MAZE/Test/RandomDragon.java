package MAZE.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import MAZE.Logic.*;
import java.awt.Point;


public class RandomDragon {
	

	@Test
	public void moveDragonRandom() {
		Maze maze = new Maze();
		maze.getDragon().setType(Dragon.Type.RANDOM);
		maze.getDragon().setX(4);
		maze.getDragon().setY(6);
		
		Point p1 = new Point(4,6); //mesmo
		Point p2 = new Point(4,4); // cima
		Point p3 = new Point(4,7); //baixo
		Point p4 = new Point(3,6); //esquerda
		Point p5 = new Point(5,6); //direita
		
		boolean outcome1 = false, outcome2 = false, outcome3 = false, outcome4 = false, outcome5 = false;
		while(outcome1 || outcome2 || outcome3 || outcome4 || outcome5){
			maze.moveDragonRandomly();			
			if (p1.x == maze.getDragon().getX() && p1.getY() == maze.getDragon().getY())
				outcome1 = true;
			else if (p2.x == maze.getDragon().getX() && p2.y == maze.getDragon().getY())
				outcome2 = true;
			else if (p3.x == maze.getDragon().getX() && p3.y == maze.getDragon().getY())
				outcome3 = true;
			else if (p4.x == maze.getDragon().getX() && p4.y == maze.getDragon().getY())
				outcome4 = true;
			else if (p5.x == maze.getDragon().getX() && p5.y == maze.getDragon().getY())
				outcome5 = true;
			else
				fail ("erro moveDragonRandomly");
		}	
	}
	
	@Test
	
	public void dragonAwakes(){
		
		boolean outcome1=false, outcome2= false;
		while(outcome1 || outcome2){
			Maze maze = new Maze();
			maze.getDragon().setDragonAsleep(true);
			maze.randomSleep();
			if (maze.getDragon().getDragonAsleep() == true)
				outcome1= true;
			if (maze.getDragon().getDragonAsleep() == false)
				outcome2 = true;
			else 
				fail ("erro dragonAwakes");
		}
	}
	
	@Test

	public void dragonAsleeps(){

		boolean outcome1=false, outcome2= false;
		while(outcome1 || outcome2){
			Maze maze = new Maze();
			maze.getDragon().setDragonAsleep(false);
			maze.randomSleep();
			if (maze.getDragon().getDragonAsleep() == true)
				outcome1= true;
			if (maze.getDragon().getDragonAsleep() == false)
				outcome2 = true;
			else 
				fail ("erro dragonAsleep");
		}
	}
	
	public void dragonAsleepDead(){
		boolean outcome1= false, outcome2=false;
		
		while(outcome1 || outcome2){
			Maze maze = new Maze();
			maze.getDragon().setDragonAsleep(true); //dragao a dormir
			
		}
	}

}
