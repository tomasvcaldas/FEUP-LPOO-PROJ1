package Interface;

import java.util.Scanner;



public class Maze   {
	private Hero hero;
	private Dragon dragon;
	private Sword sword;
	private boolean dragonAlive;

	private char[][] board = {
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','H',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X','D','X','X',' ','X',' ','X',' ','X'},
			{'X','E','X','X',' ','X',' ','X',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	public Maze(){
		hero = new Hero(1,1);
		dragon = new Dragon(1,3);
		boolean dragonAlive =  true;
		sword =  new Sword(1,4);
		
	}



	public boolean moveHero(char dir){
		if(dir == 'W'){
			if(hero.getHeroArmed() == false){
				if(board[hero.getY()-1][hero.getX()] != 'X'){
					if(board[hero.getY()-1][hero.getX()] == ' '){
						hero.setY(hero.getY()-1);
						hero.setX(hero.getX());
						board[hero.getY()][hero.getX()] = 'H';
						board[hero.getY()+1][hero.getX()] = ' ';
						if(board[hero.getY()-1][hero.getX()] == 'D' ){
							board[hero.getY()][hero.getX()] = ' ';
							return false;
						}
					}
					else if(board[hero.getY()-1][hero.getX()] == 'E'){
						hero.setY(hero.getY()-1);
						hero.setX(hero.getX());
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()+1][hero.getX()] = ' ';
						hero.setHeroArmed(true);
					}
					else if(board[hero.getY()-1][hero.getX()] == 'S'){
						board[hero.getY()-1][hero.getX()] = 'S';
					}
				}
			}
			if(hero.getHeroArmed() == true){
				if(board[hero.getY()-1][hero.getX()] != 'X'){
					if(board[hero.getY()-1][hero.getX()] == ' '){
						hero.setY(hero.getY()-1);
						hero.setX(hero.getX());
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()+1][hero.getX()] = ' ';
					}
					if(board[hero.getY()-1][hero.getX()] == 'D' ){
						board[hero.getY()-1][hero.getX()] = ' ';
						dragon.setDragonAlive(false);
					}
					if(board[hero.getY()][hero.getX()+1] == 'D' ){
						dragon.setDragonAlive(false);
						board[hero.getY()][hero.getX()+1] = ' ';
					}
					if(board[hero.getY()][hero.getX()-1] == 'D' ){
						dragon.setDragonAlive(false);
						board[hero.getY()][hero.getX()-1] = ' ';
					}
					else if(board[hero.getY()-1][hero.getX()] == 'S' && dragon.getDragonAlive()== true){
						board[hero.getY()-1][hero.getX()] = 'S';
					}
					else if(board[hero.getY()-1][hero.getX()] == 'S' && dragon.getDragonAlive() == false ){
						hero.setY(hero.getY()-1);
						hero.setX(hero.getX());
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()+1][hero.getX()] = ' ';
						return false;
					}
				}
			}
		}
		else if(dir == 'D'){	
			if(hero.getHeroArmed() == false){
				if(board[hero.getY()][hero.getX()+1] != 'X'){
					if(board[hero.getY()][hero.getX()+1] == ' '){
						hero.setY(hero.getY());
						hero.setX(hero.getX()+1);
						board[hero.getY()][hero.getX()] = 'H';
						board[hero.getY()][hero.getX()-1] = ' ';
						if(board[hero.getY()][hero.getX()+1] == 'D'){
							board[dragon.getY()][dragon.getX()] = ' ';
							return false;
						}
					}
					else if(board[hero.getY()][hero.getX()+1] == 'E'){
						hero.setY(hero.getY());
						hero.setX(hero.getX()+1);
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()][hero.getX()-1] = ' ';
						hero.setHeroArmed(true);
					}
					else if(board[hero.getY()][hero.getX()+1] == 'S'){
						board[hero.getY()][hero.getX()+1] = 'S';
					}
				}
			}

			if(hero.getHeroArmed() == true){
				if(board[hero.getY()][hero.getX()+1] != 'X'){
					if(board[hero.getY()][hero.getX()+1] == ' '){
						hero.setY(hero.getY());
						hero.setX(hero.getX()+1);
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()][hero.getX()-1] = ' ';
					}
					if(board[hero.getY()][hero.getX()+1] == 'D' ){
						dragon.setDragonAlive(false);
						board[hero.getY()][hero.getX()+1] = ' ';
					}
					if(board[hero.getY()+1][hero.getX()] == 'D' ){
						dragon.setDragonAlive(false);
						board[hero.getY()+1][hero.getX()] = ' ';
					}
					if(board[hero.getY()-1][hero.getX()] == 'D' ){
						dragon.setDragonAlive(false);
						board[hero.getY()-1][hero.getX()] = ' ';
					}
					else if(board[hero.getY()][hero.getX()+1] == 'S' && dragon.getDragonAlive()== true){
						board[hero.getY()][hero.getX()+1] = 'S';
					}
					else if(board[hero.getY()][hero.getX()+1] == 'S' && dragon.getDragonAlive() == false ){
						hero.setY(hero.getY());
						hero.setX(hero.getX()+1);
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()][hero.getX()-1] = ' ';
						return false;
					}
				}
			}
		}
		else if(dir == 'S'){	
			if(hero.getHeroArmed() == false){
				if(board[hero.getY()+1][hero.getX()] != 'X'){
					if(board[hero.getY()+1][hero.getX()] == ' '){
						hero.setY(hero.getY()+1);
						hero.setX(hero.getX());
						board[hero.getY()][hero.getX()] = 'H';
						board[hero.getY()-1][hero.getX()] = ' ';
						if(board[hero.getY()+1][hero.getX()] == 'D' ){
							board[hero.getY()][hero.getX()] = ' ';
							return false;
						}
					}
					else if(board[hero.getY()+1][hero.getX()] == 'E'){
						hero.setY(hero.getY()+1);
						hero.setX(hero.getX());
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()-1][hero.getX()] = ' ';
						hero.setHeroArmed(true);
					}
					else if(board[hero.getY()+1][hero.getX()] == 'S'){
						board[hero.getY()+1][hero.getX()] = 'S';
					}
				}
			}
			if(hero.getHeroArmed() == true){
				if(board[hero.getY()+1][hero.getX()] != 'X'){
					if(board[hero.getY()+1][hero.getX()] == ' '){
						hero.setY(hero.getY()+1);
						hero.setX(hero.getX());
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()-1][hero.getX()] = ' ';
					}
					if(board[hero.getY()+1][hero.getX()] == 'D' ){
						board[hero.getY()+1][hero.getX()] = ' ';
						dragon.setDragonAlive(false);
					}
					if(board[hero.getY()][hero.getX()+1] == 'D' ){
						board[hero.getY()][hero.getX()+1] = ' ';
						dragon.setDragonAlive(false);
					}
					if(board[hero.getY()][hero.getX()-1] == 'D' ){
						board[hero.getY()][hero.getX()-1] = ' ';
						dragon.setDragonAlive(false);
					}

					else if(board[hero.getY()+1][hero.getX()] == 'S' && dragon.getDragonAlive()== true){
						board[hero.getY()+1][hero.getX()] = 'S';
					}
					else if(board[hero.getY()+1][hero.getX()] == 'S' && dragon.getDragonAlive() == false ){
						hero.setY(hero.getY()+1);
						hero.setX(hero.getX());
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()-1][hero.getX()] = ' ';
						return false;
					}
				}
			}
		}

		else if(dir =='A'){	
			if(hero.getHeroArmed() == false){
				if(board[hero.getY()][hero.getX()-1] != 'X'){
					if(board[hero.getY()][hero.getX()-1] == ' '){
						hero.setY(hero.getY());
						hero.setX(hero.getX()-1);
						board[hero.getY()][hero.getX()] = 'H';
						board[hero.getY()][hero.getX()+1] = ' ';
						if(board[hero.getY()][hero.getX()-1] == 'D' ){
							board[hero.getY()][hero.getX()] = ' ';
							return false;
						}
					}
					else if(board[hero.getY()][hero.getX()-1] == 'E'){
						hero.setY(hero.getY());
						hero.setX(hero.getX()-1);
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()][hero.getX()+1] = ' ';
						hero.setHeroArmed(true);
					}
					else if(board[hero.getY()][hero.getX()-1] == 'S'){
						board[hero.getY()][hero.getX()-1] = 'S';
					}
				}
			}
			if(hero.getHeroArmed() == true){
				if(board[hero.getY()][hero.getX()-1] != 'X'){
					if(board[hero.getY()][hero.getX()-1] == ' '){
						hero.setY(hero.getY());
						hero.setX(hero.getX()-1);
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()][hero.getX()+1] = ' ';
					}
					if(board[hero.getY()][hero.getX()-1] == 'D' ){
						board[hero.getY()][hero.getX()-1] = ' ';
						dragon.setDragonAlive(false);
					}
					if(board[hero.getY()+1][hero.getX()] == 'D' ){
						board[hero.getY()+1][hero.getX()] = ' ';
						dragon.setDragonAlive(false);
					}
					if(board[hero.getY()-1][hero.getX()] == 'D' ){
						board[hero.getY()-1][hero.getX()] = ' ';
						dragon.setDragonAlive(false);
					}
					else if(board[hero.getY()][hero.getX()-1] == 'S' && dragon.getDragonAlive()== true){
						board[hero.getY()][hero.getX()-1] = 'S';
					}
					else if(board[hero.getY()][hero.getX()-1] == 'S' && dragon.getDragonAlive() == false ){
						hero.setY(hero.getY());
						hero.setX(hero.getX()-1);
						board[hero.getY()][hero.getX()] = 'A';
						board[hero.getY()][hero.getX()+1] = ' ';
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void moveDragonRandomly(){
		int move = dragon.randomDragon();

		if (dragon.getDragonAlive() == true){ //o drago so mexe se estiver vivo

			if(move == 1 ){ // move up
				if(board[dragon.getY()-1][dragon.getX()] != 'X'){
					if(board[dragon.getY()-1][dragon.getX()] == ' '){
						dragon.setY(dragon.getY()-1);
						dragon.setX(dragon.getX());
						board[dragon.getY()][dragon.getX()] = 'D';
						if(sword.getDragonAndSword() == true){
							board[dragon.getY()+1][dragon.getX()] = 'E';
							sword.setDragonAndSword(false);
						}
						else board[dragon.getY()+1][dragon.getX()] = ' ';	
					}
					else if(board[dragon.getY()-1][dragon.getX()] == 'E'){
						dragon.setY(dragon.getY()-1);
						dragon.setX(dragon.getX());
						board[dragon.getY()][dragon.getX()] = 'F';
						board[dragon.getY()+1][dragon.getX()] = ' ';
						sword.setDragonAndSword(true);
					}	
				}
			}
			if(move == 2 ){ // move right
				if(board[dragon.getY()][dragon.getX()+1] != 'X'){
					if(board[dragon.getY()][dragon.getX()+1] == ' '){
						dragon.setY(dragon.getY());
						dragon.setX(dragon.getX()+1);
						board[dragon.getY()][dragon.getX()] = 'D';
						if(sword.getDragonAndSword() == true){
							board[dragon.getY()][dragon.getX()-1] = 'E';
							sword.setDragonAndSword(false);
						}
						else board[dragon.getY()][dragon.getX()-1] = ' ';
					}
					else if(board[dragon.getY()][dragon.getX()+1] == 'E'){
						dragon.setY(dragon.getY());
						dragon.setX(dragon.getX()+1);
						board[dragon.getY()][dragon.getX()] = 'F';
						board[dragon.getY()][dragon.getX()-1] = ' ';
						sword.setDragonAndSword(true);
					}	
				}
			}
			if(move == 3){ // move down
				if(board[dragon.getY()+1][dragon.getX()] != 'X'){
					if(board[dragon.getY()+1][dragon.getX()] == ' '){
						dragon.setY(dragon.getY()+1);
						dragon.setX(dragon.getX());
						board[dragon.getY()][dragon.getX()] = 'D';
						if(sword.getDragonAndSword() == true){
							board[dragon.getY()-1][dragon.getX()] = 'E';
							sword.setDragonAndSword(false);
						}
						else board[dragon.getY()-1][dragon.getX()] = ' ';	
					}
					else if(board[dragon.getY()+1][dragon.getX()] == 'E'){
						dragon.setY(dragon.getY()+1);
						dragon.setX(dragon.getX());
						board[dragon.getY()][dragon.getX()] = 'F';
						board[dragon.getY()-1][dragon.getX()] = ' ';
						sword.setDragonAndSword(true);
					}
				}	
			}
			if(move == 4 ){ // move left
				if(board[dragon.getY()][dragon.getX()-1] != 'X'){
					if(board[dragon.getY()][dragon.getX()-1] == ' '){
						dragon.setY(dragon.getY());
						dragon.setX(dragon.getX()-1);
						board[dragon.getY()][dragon.getX()] = 'D';
						if(sword.getDragonAndSword() == true){
							board[dragon.getY()][dragon.getX()+1] ='E';
							sword.setDragonAndSword(false);
						}
						else board[dragon.getY()][dragon.getX()+1] = ' ';	
					}
					else if(board[dragon.getY()][dragon.getX()-1] == 'E'){
						dragon.setY(dragon.getY());
						dragon.setX(dragon.getX()-1);
						board[dragon.getY()][dragon.getX()] = 'F';
						board[dragon.getY()][dragon.getX()+1] = ' ';
						sword.setDragonAndSword(true);

					}	
				}
			}
		}
	}


	public void printMaze(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}