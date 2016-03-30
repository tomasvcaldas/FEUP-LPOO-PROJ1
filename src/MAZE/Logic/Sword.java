package MAZE.Logic;

public class Sword {

	private int x,y ;
	private boolean dragonAndSword;
	
	public Sword(int x, int y){
		this.x = x;
		this.y = y;
		dragonAndSword = false;
	}
	
	public boolean getDragonAndSword(){
		return dragonAndSword;
	}
	
	public void setDragonAndSword(boolean dands){
		dragonAndSword = dands;
	}	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int newX){
		x = newX;
	}
	
	public void setY(int newY){
		y = newY;
	}
}
