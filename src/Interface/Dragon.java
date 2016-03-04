package Interface;
import java.util.Random;


public class Dragon   {
	
	int x, y;
	private boolean dragonAlive;
	public Dragon(){
		
	}
	
	public Dragon(int x, int y){
		dragonAlive =  true;
		this.x = x;
		this.y = y;
	}
	
	public boolean getDragonAlive(){
		return dragonAlive;
	}
	
	public void setDragonAlive(boolean alive){
		dragonAlive = alive;
	}

	public int randomDragon(){
		Random r = new Random();	
		int dmove = r.nextInt(4) +1; 	
		return dmove;
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
