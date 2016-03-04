package Interface;
import java.util.Scanner;

public class Hero  {

	private char h;
	private char move;
	private int x,y;
	private boolean end ;
	private boolean dragon;
	private boolean heroAlive;
	private boolean heroArmed;
	
	public Hero(int x, int y){
		this.x = x;
		this.y = y;
		heroAlive =  true;
		heroArmed =  false;
		h = 'H';
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
	
	public boolean getHeroAlive(){
		return heroAlive;
	}
	
	public void setHeroAlive(boolean alive){
		heroAlive = alive;
	}
	
	public boolean getHeroArmed(){
		return heroArmed;
	}

	public void setHeroArmed(boolean armed){
		heroArmed = armed;
	}
}

