package Interface;
import java.util.Scanner;

public class Game     {
	public boolean endGame;
	
	public Game(){}
	
	public static void main(String[] args) {
		Game game =  new Game();
		Maze maze  = new Maze();
		Dragon dragon = new Dragon();
		dragon.setType(dragon.defineType());
		char move1;
		maze.printMaze();
		boolean endGame = true;
		while(endGame){
			move1 = game.askForMove() ;
			endGame = maze.moveHero(move1);
			maze.printMaze();
			if (dragon.getType() == Dragon.Type.RANDOM) maze.moveDragonRandomly();
			if (dragon.getType() == Dragon.Type.SLEEPING){
				maze.randomSleep();
				if (!dragon.getDragonAsleep()) maze.moveDragonRandomly();
			}
		}
		System.out.println("Acabou o jogo!");
	}
		
	public char askForMove(){	
		Scanner reader = new Scanner(System.in);
		System.out.print("Para onde deseja movimentar o herói? (W-up / A-left / S-down / D- right)");
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


