package MAZE.Logic;

public class Hero  {

	private char h;
	private char move;
	private int x,y;
	private boolean end ;
	private boolean dragon;
	private boolean heroAlive;
	private boolean heroArmed;
	/**
	 * @brief inicializa e controi um herói com determinadas coordenadas
	 * @param x
	 * @param y
	 */
	
	public Hero(int x, int y){
		this.x = x;
		this.y = y;
		heroAlive =  true;
		heroArmed =  false;
		h = 'H';
	}
	
	/**
	 * @brief inicializa e contrói um herói
	 */
	public Hero(){
		
	}

	
	/**
	 * @brief retorna o valor de x do herói
	 * @return valor de x 
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * @brief retorna o valor de y do heroi
	 * @return valor de y
	 */
	public int getY(){
		return y;
	}
	/**
	 * @brief altera o valor de x do heroi
	 * @param newX
	 */
	public void setX(int newX){
		x = newX;
	}
	 /**
	  * @brief altera o valor de y do heroi
	  * @param newY
	  */
	public void setY(int newY){
		y = newY;
	}
	 /**
	  * @brief returna o boleano em relação ao herói estar vivo ou não 
	  * @return heroi vivo ou não
	  */
	public boolean getHeroAlive(){
		return heroAlive;
	}

	/**
	 * @brief Altera o herói para morto ou vivo
	 * @param alive
	 */
	public void setHeroAlive(boolean alive){
		heroAlive = alive;
	}
	
	/**
	 * @brief retorna se o herói está armado ou não
	 * @return herói armado ou não
	 */
	public boolean getHeroArmed(){
		return heroArmed;
	}

	/**
	 * @brief Altera o herói para armado ou não
	 * @param armed
	 */
	public void setHeroArmed(boolean armed){
		heroArmed = armed;
	}
}