package MAZE.Logic;

public class Sword {

	private int x,y ;
	private boolean dragonAndSword;
	/**
	 * @brief Constroi e inicializa a espada numa localização específica
	 * @param x
	 * @param y
	 */
	
	
	
	public Sword(int x, int y){
		this.x = x;
		this.y = y;
		dragonAndSword = false;
	}
	/**
	 * @brief Constroi e inicializa a espada
	 */
	public Sword(){}
	
	/**
	 * @brief Retorna um booleano em relação à sobreposição do dragão e a espada
	 * @return novo valor do booleano
	 */
	public boolean getDragonAndSword(){
		return dragonAndSword;
	}
	
	/**
	 * @brief Altera o valor do booleano em relação à sobreposição do dragão e da espada
	 * @param dands
	 */
	public void setDragonAndSword(boolean dands){
		dragonAndSword = dands;
	}	
	/**
	 * @brief retorna o valor de X da espada
	 * @return valor de x
	 */
	public int getX(){
		return x;
	}
	/**
	 * @brief retorna o valor de Y da espada
	 * @return valor de y
	 */
	public int getY(){
		return y;
	}
	/**
	 * @brief altera o valor de X da espada
	 * @param newX
	 */
	public void setX(int newX){
		x = newX;
	}
	/**
	 * @brief altera o valor de y da espada
	 * @param newY
	 */
	public void setY(int newY){
		y = newY;
	}	
}