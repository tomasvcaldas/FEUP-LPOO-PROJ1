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
	 * Constrói um dragão
	 */
	public Dragon(){
	}
	
	/**
	 * Constrói um dragão vivo, acordado
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
	 * Verifica o estado de vida do dragão
	 * @return true se o dragão estiver vivo e false se estiver morto
	 */
	public boolean getDragonAlive(){
		return dragonAlive;
	}
	
	/**
	 * Define o estado de vida do drgão
	 * @param alive
	 */
	public void setDragonAlive(boolean alive){
		dragonAlive = alive;
	}
	
	/**
	 * Gera um número aleatório de 1 a 5
	 * @return o número gerado aleatoriamente
	 */
	public int randomDragon(){
		Random r = new Random();	
		int dmove = r.nextInt(4) +1; 	
		return dmove;
	}
	
	/**
	 * Retorna a posição x
	 * @return posição x 
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Retorna a posição y
	 * @return y
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Define a posição em x para newX
	 * @param newX
	 */
	public void setX(int newX){
		x = newX;
	}
	
	/**
	 * Define a posição em y para newY
	 * @param newY
	 */
	public void setY(int newY){
		y = newY;
	}
	
	/**
	 * Verifica 
	 * @return true se o dragão estiver a dormir e false se estiver acordado
	 */
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
