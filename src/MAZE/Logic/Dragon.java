package MAZE.Logic;
import java.util.Random;
import java.util.Scanner;

public class Dragon {
	
	public enum Type {STATIONARY, RANDOM, SLEEPING}
	//o dragao pode nao se mover, pode mover-se para uma das casas adjacente aleatoriamente ou pode ser aleatorio e dormir.
	
	int x, y;
	private boolean dragonAlive;
	private Type type;
	private boolean dragonAsleep;
	public Dragon(){
	}
	
	public Dragon (int x, int y){
		dragonAlive = true;
		this.x = x;
		this.y = y;
		dragonAsleep = false; 
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
	
	public boolean getDragonAsleep(){
		return dragonAsleep;
	}
	
	public void setDragonAsleep(boolean asleep){
		dragonAsleep = asleep;
	}
	
	public char askDragonType(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Escolho o tipo de dragão durante o jogo - S(stationary), R(random) ou A(alternate random and sleep)");
		char typedragon = reader.next().charAt(0);	
		return typedragon;
	}
	
	public Type getType(){
		return type;
	}
	
	public Type defineType(){

		char typedragon = askDragonType();

		if (typedragon == 'S'){
			type = Dragon.Type.STATIONARY;}
		if (typedragon == 'R'){
			type = Dragon.Type.RANDOM;}
		if (typedragon == 'A'){
			type = Dragon.Type.SLEEPING;}
		
		return type;
	}
	
	public void setType(Type newType){
		type = newType;
	}

}
