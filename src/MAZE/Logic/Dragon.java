package MAZE.Logic;
import java.util.Random;
import java.util.Scanner;

public class Dragon {
	
	public enum Type {STATIONARY, RANDOM, SLEEPING}
	
	
	int x, y;
	private boolean dragonAlive;
	private Type type;
	private boolean dragonAsleep;
	
	/**
	 * Constr�i um drag�o
	 */
	public Dragon(){
	}
	
	/**
	 * Constr�i um drag�o vivo, acordado
	 * @param x
	 * @param y
	 */
	public Dragon (int x, int y){
		dragonAlive = true;
		this.x = x;
		this.y = y;
		dragonAsleep = false;
	}
	
	/**
	 * Verifica o estado de vida do drag�o
	 * @return true se o drag�o estiver vivo e false se estiver morto
	 */
	public boolean getDragonAlive(){
		return dragonAlive;
	}
	
	/**
	 * Define o estado de vida do drg�o
	 * @param alive
	 */
	public void setDragonAlive(boolean alive){
		dragonAlive = alive;
	}
	
	/**
	 * Gera um n�mero aleat�rio de 1 a 5
	 * @return o n�mero gerado aleatoriamente
	 */
	public int randomDragon(){
		Random r = new Random();	
		int dmove = r.nextInt(4) +1; 	
		return dmove;
	}
	
	/**
	 * Retorna a posi��o x
	 * @return posi��o x 
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Retorna a posi��o y
	 * @return y
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Define a posi��o em x para newX
	 * @param newX
	 */
	public void setX(int newX){
		x = newX;
	}
	
	/**
	 * Define a posi��o em y para newY
	 * @param newY
	 */
	public void setY(int newY){
		y = newY;
	}
	
	/**
	 * Verifica 
	 * @return true se o drag�o estiver a dormir e false se estiver acordado
	 */
	public boolean getDragonAsleep(){
		return dragonAsleep;
	}
	
	public void setDragonAsleep(boolean asleep){
		dragonAsleep = asleep;
	}
	
	public char askDragonType(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Escolho o tipo de drag�o durante o jogo - S(stationary), R(random) ou A(alternate random and sleep)");
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
