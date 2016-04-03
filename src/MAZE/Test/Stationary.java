package MAZE.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import MAZE.Logic.*;

public class Stationary {

	char [][] m1 = {{'X', 'X', 'X', 'X', 'X'},
					{'X', ' ', ' ', 'H', 'S'},
					{'X', ' ', 'X', ' ', 'X'},
					{'X', 'E', ' ', 'D', 'X'},
					{'X', 'X', 'X', 'X', 'X'}};
	
	char[][] m2 = {{'X', 'X', 'X', 'X', 'X'},
				   {'X', ' ', ' ', 'D', 'S'},
				   {'X', ' ', 'X', ' ', 'X'},
				   {'X', 'E', 'H', ' ', 'X'},
				   {'X', 'X', 'X', 'X', 'X'}};
	
	char[][] m3 = {{'X', 'X', 'X', 'X', 'X'},
			   	   {'X', ' ', ' ', 'D', 'S'},
			       {'X', 'E', 'X', ' ', 'X'},
			       {'X', 'H', ' ', ' ', 'X'},
			       {'X', 'X', 'X', 'X', 'X'}};
	

	@Test
	public void test2a() {

		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(3,1));
		maze.moveHero('A');
		assertEquals(2,maze.getHero().getX());
		assertEquals(1,maze.getHero().getY());	
	}
	
	@Test
	public void moveRight() {

		Maze maze = new Maze();
		maze.setBoard(m2);
		maze.setHero(new Hero(2,3));
		maze.moveHero('D');
		assertEquals(3,maze.getHero().getX());
		assertEquals(3,maze.getHero().getY());	
	}
	
	@Test
	public void moveUp() {

		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(1,2));
		maze.moveHero('W');
		assertEquals(1,maze.getHero().getX());
		assertEquals(1,maze.getHero().getY());	
	}
	
	@Test
	public void moveUpSword() {

		Maze maze = new Maze();
		maze.setBoard(m3);
		maze.setHero(new Hero(1,3));
		maze.moveHero('W');
		assertEquals(true,maze.getHero().getHeroArmed());
	}
	
	@Test
	public void moveLeftSword() {

		Maze maze = new Maze();
		maze.setBoard(m2);
		maze.setHero(new Hero(2,3));
		maze.moveHero('A');
		assertEquals(true,maze.getHero().getHeroArmed());
	}

	@Test
	public void test2b() {

		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(3,1));
		maze.moveHero('W');
		assertEquals(3,maze.getHero().getX());
		assertEquals(1,maze.getHero().getY());	
	}

	@Test

	public void test2c(){

		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(1,2));
		maze.moveHero('S');
		assertEquals(true, maze.getHero().getHeroArmed());
	}

	@Test

	public void test2d(){

		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(3,1));
		maze.setDragon(new Dragon(3,3));
		maze.moveHero('S');
		maze.checkDragonPosition();
		assertEquals(false, maze.getHero().getHeroAlive());
		assertEquals(false, maze.getVitoria());
		
	}

	@Test

	public void test2e(){

		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(3,1));
		maze.getHero().setHeroArmed(true);
		maze.setDragon(new Dragon(3,3));
		maze.moveHero('S');
		maze.checkDragonPosition();
		assertEquals(true, maze.getHero().getHeroAlive());
		assertEquals(false, maze.getDragon().getDragonAlive());

	}

	@Test

	public void test2f(){

		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(3,1));
		maze.setDragon(new Dragon());
		maze.getHero().setHeroArmed(true);
		maze.getDragon().setDragonAlive(false);
		maze.moveHero('D');
		assertEquals(4,maze.getHero().getX());
		assertEquals(1,maze.getHero().getY());	
		assertEquals(true, maze.getVitoria());
	}

	@Test

	public void test2g(){

		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(3,1));
		maze.setDragon(new Dragon());
		maze.getHero().setHeroArmed(true);
		maze.getDragon().setDragonAlive(false);
		maze.moveHero('D');
		assertEquals(4,maze.getHero().getX());
		assertEquals(1,maze.getHero().getY());	
		assertEquals(true, maze.getVitoria());
	}

	@Test

	public void test2h(){
		Maze maze = new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(3,1));
		maze.setDragon(new Dragon());
		maze.getHero().setHeroArmed(true);
		maze.getDragon().setDragonAlive(true);
		maze.moveHero('D');
		assertEquals(3,maze.getHero().getX());
		assertEquals(1,maze.getHero().getY());	
		assertEquals(false, maze.getVitoria());
	}

}
