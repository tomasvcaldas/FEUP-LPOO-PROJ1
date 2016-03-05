package Interface;
import java.util.Scanner;
import java.util.Random;


public class Game     {
	public boolean endGame;
	
	public Game(){}
	
	public static void main(String[] args) {
		Game game =  new Game();
		Maze maze  = new Maze();
		Dragon dragon = new Dragon();
		//dragon.setType(dragon.defineType());
		char move1;
		maze.printMaze();
		boolean endGame = true;
		while(endGame){
			move1 = game.askForMove() ;
			endGame = maze.moveHero(move1);
			//if (dragon.getType() != Dragon.Type.STATIONARY) 
			maze.moveDragonRandomly();
			maze.printMaze();
			//dragon.randomSleep();
		}
		System.out.println("Acabou o jogo!");
	}
		
	public char askForMove(){	
		Scanner reader = new Scanner(System.in);
		System.out.print("Para onde deseja mexer o her�i? (WASD)");
		char move = reader.next().charAt(0);
		return move;
	}
	
	public boolean getEndGame(){
		return endGame;
	}
	
	public void setEndGame(boolean end){
		endGame = end;
	}
}


