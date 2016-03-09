package Interface;
import java.util.Scanner;

public class Game     {
	public boolean endGame;
	public boolean dragonDead; 
	public boolean heroAlive;
	public boolean playingGame;

	public Game(){}

	public static void main(String[] args) {
		Game game =  new Game();
		Maze maze  = new Maze();
		Hero hero =  new Hero();
		Dragon dragon = new Dragon();
		dragon.setType(dragon.defineType());
		char move1;
		maze.printMaze();
		boolean heroAlive = true;
		boolean dragonDead= false;
		boolean playingGame = true;
		boolean gameRunning = true;
		while(gameRunning == true && heroAlive == true){
			move1 = game.askForMove();
			gameRunning = maze.moveHero(move1);
			heroAlive = maze.checkDragonPosition();
				if (dragon.getType() == Dragon.Type.RANDOM ){
					maze.moveDragonRandomly();
					heroAlive = maze.checkDragonPosition();
				}
				
				else if (dragon.getType() == Dragon.Type.SLEEPING ){
					maze.randomSleep();
					if (!dragon.getDragonAsleep()){
						maze.moveDragonRandomly();
						heroAlive = maze.checkDragonPosition();
					}
				}
				
				maze.printMaze();
		}
		System.out.println("Acabou o jogo");
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


