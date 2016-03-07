package Interface;
import java.util.Scanner;
import java.util.Random;


public class Game     {
	public boolean endGame;
	public boolean dragonAlive;

	public Game(){}

	public static void main(String[] args) {
		Game game =  new Game();
		Maze maze  = new Maze();
		Hero hero =  new Hero();
		Dragon dragon = new Dragon();
		dragon.setType(dragon.defineType());
		char move1;
		maze.printMaze();
		boolean playingGame = true;
		while(playingGame == true){
			move1 = game.askForMove();
			playingGame = maze.moveHero(move1);
				if (dragon.getType() == Dragon.Type.RANDOM  && playingGame == true ){
					maze.moveDragonRandomly();
					playingGame = maze.checkDragonPosition();
				}
				else if (dragon.getType() == Dragon.Type.SLEEPING && maze.checkDragonPosition() == true){
					maze.randomSleep();
					if (!dragon.getDragonAsleep()){
						maze.moveDragonRandomly();
						maze.checkDragonPosition();
					}
				}
				//playingGame = maze.checkDragonPosition();
			maze.printMaze();
		}
		System.out.println("Acabou o jogo!");
	}

	public char askForMove(){	
		Scanner reader = new Scanner(System.in);
		System.out.print("Para onde deseja mexer o herói? (WASD)");
		char move = reader.next().charAt(0);
		return move;
	}
	
	public boolean getDragonAlive(){
		return dragonAlive;
	}

	public boolean getEndGame(){
		return endGame;
	}

	public void setEndGame(boolean end){
		endGame = end;
	}
}


