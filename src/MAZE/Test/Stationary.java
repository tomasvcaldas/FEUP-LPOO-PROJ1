package MAZE.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import MAZE.Interface.Game;
import MAZE.Logic.*;

public class Stationary {

	@Test
	public void test2a() {

		Maze maze = new Maze();		
		maze.moveHero('D');
		assertEquals(2,maze.getHero().getX());
		assertEquals(1,maze.getHero().getY());	
	}

	@Test

	public void test2b() {

		Maze maze = new Maze();	
		maze.moveHero('A');
		assertEquals(1,maze.getHero().getX());
		assertEquals(1,maze.getHero().getY());	
	}

	@Test

	public void test2c(){

		Maze maze = new Maze();
		maze.getHero().setX(1);
		maze.getHero().setY(7);
		maze.moveHero('S');
		assertEquals(true,maze.getHero().getHeroArmed());

	}

	@Test

	public void test2d(){

		Maze maze = new Maze();	
		maze.moveHero('S');
		assertEquals(false,maze.getHero().getHeroArmed());
		maze.checkDragonPosition();	
		assertEquals(false,maze.getHero().getHeroAlive());
		assertEquals(false, maze.getVitoria());
	}

	@Test

	public void test2e(){

		Maze maze = new Maze();
		maze.getHero().setX(1);
		maze.getHero().setY(7);
		maze.moveHero('S');
		assertEquals(true,maze.getHero().getHeroArmed());
		maze.getDragon().setX(1);
		maze.getDragon().setY(6);
		maze.moveHero('W');
		assertEquals(true,maze.checkDragonPosition());
		maze.checkDragonPosition();
		assertEquals(true,maze.getDragon().getDragonAlive());

	}
	
	@Test
	
	public void test2f(){
		
		Maze maze = new Maze();
		maze.getHero().setHeroArmed(true); //esta armado
		maze.getDragon().setDragonAlive(false); //dragao morto
		maze.getHero().setX(8);
		maze.getHero().setY(5);
		maze.moveHero('D');
		assertEquals(true,maze.getVitoria()); //ganha
	}
	
	@Test
	
	public void test2g(){
		
		Maze maze = new Maze();
		maze.getHero().setHeroArmed(false); //nao esta armado
		maze.getHero().setX(8);
		maze.getHero().setY(5);
		maze.moveHero('D');
		assertEquals(false,maze.getVitoria()); //nao consegue sair
		//Vitoria so acontece quando ele chega a saida
	}
	
	@Test
	
	public void test2h(){
		Maze maze = new Maze();
		maze.getHero().setHeroArmed(true); //esta armado
		maze.getDragon().setDragonAlive(true); //mas nao matou o dragao
		maze.getHero().setX(8);
		maze.getHero().setY(5);
		maze.moveHero('D');
		assertEquals(false,maze.getVitoria());  //nao ganha
	}
	
}
