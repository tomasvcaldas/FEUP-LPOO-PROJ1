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
			   	   {'X', ' ', ' ', ' ', 'S'},
			       {'X', ' ', 'X', 'D', 'X'},
			       {'X', 'E', 'H', ' ', 'X'},
			       {'X', 'X', 'X', 'X', 'X'}};
			  
	char[][] m4  ={{'X', 'X', 'X', 'X', 'X'},
				   {'X', ' ', ' ', ' ', 'S'},
		           {'X', 'E', 'X', 'D', 'X'},
		           {'X', 'H', ' ', ' ', 'X'},
		           {'X', 'X', 'X', 'X', 'X'}};
	
	char[][] m5  ={{'X', 'X', 'X', 'X', 'X'},
			       {'X', ' ', ' ', ' ', 'S'},
	               {'X', 'E', 'X', ' ', 'X'},
	               {'X', 'D', ' ', 'H', 'X'},
	               {'X', 'X', 'X', 'X', 'X'}};
	
	char[][] m6  ={{'X', 'X', 'X', 'X', 'X'},
		           {'X', ' ', ' ', 'D', 'S'},
		           {'X', 'E', 'X', ' ', 'X'},
		           {'X', ' ', ' ', 'H', 'X'},
		           {'X', 'X', 'X', 'X', 'X'}};
	
	char[][] m7  ={{'X', 'X', 'X', 'X', 'X'},
	               {'X', ' ', ' ', 'H', 'S'},
	               {'X', 'E', 'X', ' ', 'X'},
	               {'X', ' ', ' ', 'D', 'X'},
	               {'X', 'X', 'X', 'X', 'X'}};
	
	
	char[][] m8  ={{'X', 'X', 'X', 'X', 'X'},
                   {'X', ' ', ' ', 'H', 'S'},
                   {'X', ' ', 'X', ' ', 'X'},
                   {'X', ' ', ' ', 'D', 'X'},
                   {'X', 'X', 'X', 'X', 'X'}};

	char[][] m9  =  {{'X', 'X', 'X', 'S', 'X'},
            		 {'X', ' ', ' ', 'H', 'X'},
            		 {'X', ' ', 'X', ' ', 'X'},
            		 {'X', 'D', ' ', ' ', 'X'},
            		 {'X', 'X', 'X', 'X', 'X'}};
	
	char[][] m10  =  {{'X', 'X', 'X', 'S', 'X'},
					  {'X', ' ', ' ', ' ', 'X'},
					  {'X', ' ', 'X', ' ', 'X'},
					  {'X', 'H', 'E', ' ', 'X'},
					  {'X', 'X', 'X', 'X', 'X'}};
	
	char[][] m11  =  {{'X', 'X', 'X', 'X', 'X'},
					  {'X', ' ', ' ', 'D', 'X'},
					  {'X', ' ', 'X', ' ', 'X'},
					  {'X', 'H', 'E', ' ', 'X'},
			          {'X', 'S', 'X', 'X', 'X'}};
	
	char[][] m12  =  {{'X', 'X', 'X', 'X', 'X'},
					  {'X', ' ', ' ', 'D', 'X'},
					  {'X', ' ', 'X', ' ', 'X'},
					  {'S', 'H', ' ', ' ', 'X'},
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
		maze.setBoard(m4);
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

	
	@Test
	
	public void testHeroMovesRightAndDies(){
		Maze maze =  new Maze();
		maze.setBoard(m3);
		maze.setHero(new Hero(2,3));
		maze.setDragon(new Dragon(3,2));
		maze.getHero().setHeroArmed(false);
		maze.getDragon().setDragonAlive(true);
		maze.moveHero('D');
		maze.checkDragonPosition();
		assertEquals(false,maze.getHero().getHeroAlive());
	}
	
	@Test
	public void testHeroMovesLeftAndDies(){
		Maze maze =  new Maze();
		maze.setBoard(m5);
		maze.setHero(new Hero(3,3));
		maze.setDragon(new Dragon(1,3));
		maze.getHero().setHeroArmed(false);
		maze.getDragon().setDragonAlive(true);
		maze.moveHero('A');
		maze.checkDragonPosition();
		assertEquals(false,maze.getHero().getHeroAlive());
	}
	
	@Test
	public void testHeroMovesUpAndDies(){
		Maze maze =  new Maze();
		maze.setBoard(m6);
		maze.setHero(new Hero(3,3));
		maze.setDragon(new Dragon(3,1));
		maze.getHero().setHeroArmed(false);
		maze.getDragon().setDragonAlive(true);
		maze.moveHero('W');
		maze.checkDragonPosition();
		assertEquals(false,maze.getHero().getHeroAlive());	
	}
	
	@Test
	public void testHeroMovesDownAndDies(){
		Maze maze =  new Maze();
		maze.setBoard(m7);
		maze.setHero(new Hero(3,1));
		maze.setDragon(new Dragon(3,3));
		maze.getHero().setHeroArmed(false);
		maze.getDragon().setDragonAlive(true);
		maze.moveHero('S');
		maze.checkDragonPosition();
		assertEquals(false,maze.getHero().getHeroAlive());	
	}
	
	
	@Test 
	public void testSword(){
		Maze maze =  new Maze();
		maze.setBoard(m8);
		maze.placeSword();
		boolean sword = false;
		int i, j;
		while(sword == false){
		for(i = 0 ;i < m8.length; i++){
			for(j = 0; j<m8[i].length; j++){
				if(m8[i][j] == 'E') 
				{
					sword = true;
					assertEquals(i,maze.getSword().getY());
					assertEquals(j,maze.getSword().getX());
				}
			}
		}
	}
	}
	
	@Test
	public void goUpandWin(){
		Maze maze = new Maze();
		Dragon dragon =  new Dragon();
		maze.setBoard(m9);
		maze.setHero(new Hero(3,1));
		maze.setDragon(new Dragon(1,3));
		maze.getHero().setHeroArmed(true);
		maze.getDragon().setDragonAlive(false);
		maze.moveHero('W');
		assertEquals(true, maze.getVitoria());
	
	}
	
	@Test
	public void goRightAndGrabSword(){
		Maze maze = new Maze();
		maze.setBoard(m10);
		maze.setHero(new Hero(1,3));
		maze.setSword(new Sword(2,3));
		maze.getHero().setHeroArmed(false);
		maze.moveHero('D');
		assertEquals(true, maze.getHero().getHeroArmed());
	}
	
	
	@Test
	public void goDownAndWin(){
		Maze maze = new Maze();
		Dragon dragon =  new Dragon();
		maze.setBoard(m11);
		maze.setHero(new Hero(1,3));
		maze.setDragon(new Dragon(3,1));
		maze.getHero().setHeroArmed(true);
		maze.getDragon().setDragonAlive(false);
		maze.moveHero('S');
		assertEquals(true, maze.getVitoria());
	}
	
	@Test
	public void goLeftArmed(){
		Maze maze =  new Maze();
		maze.setBoard(m1);
		maze.setHero(new Hero(3,1));
		maze.getHero().setHeroArmed(true);
		maze.moveHero('A');
		assertEquals(1, maze.getHero().getY());
		assertEquals(2,maze.getHero().getX());
	}
	
	@Test 
	public void goLeftAndWin(){
		Maze maze = new Maze();
		Dragon dragon =  new Dragon();
		maze.setBoard(m12);
		maze.setHero(new Hero(1,3));
		maze.setDragon(new Dragon(3,1));
		maze.getHero().setHeroArmed(true);
		maze.getDragon().setDragonAlive(false);
		maze.moveHero('A');
		assertEquals(true, maze.getVitoria());
	}
	
	@Test
	public void goLeftAndKillDragon(){
		Maze maze = new Maze();
		maze.setBoard(m5);
		maze.setHero(new Hero(3,3));
		maze.getHero().setHeroArmed(true);
		maze.setDragon(new Dragon(1,3));
		maze.moveHero('A');
		maze.checkDragonPosition();
		assertEquals(true, maze.getHero().getHeroAlive());
		assertEquals(false, maze.getDragon().getDragonAlive());
	}
	
	@Test
	public void goRightAndKillDragon(){
		Maze maze = new Maze();
		maze.setBoard(m3);
		maze.setHero(new Hero(2,3));
		maze.getHero().setHeroArmed(true);
		maze.setDragon(new Dragon(3,2));
		maze.moveHero('D');
		maze.checkDragonPosition();
		assertEquals(true, maze.getHero().getHeroAlive());
		assertEquals(false, maze.getDragon().getDragonAlive());
	}
	
	@Test
	public void goUpAndKillDragon(){
		Maze maze = new Maze();
		maze.setBoard(m6);
		maze.setHero(new Hero(3,3));
		maze.getHero().setHeroArmed(true);
		maze.setDragon(new Dragon(3,1));
		maze.moveHero('W');
		maze.checkDragonPosition();
		assertEquals(true, maze.getHero().getHeroAlive());
		assertEquals(false, maze.getDragon().getDragonAlive());
	}
}

