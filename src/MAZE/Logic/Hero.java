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
	 * @brief inicializa e controi um her�i com determinadas coordenadas
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
	 * @brief inicializa e contr�i um her�i
	 */
	public Hero(){
		
	}

	
	/**
	 * @brief retorna o valor de x do her�i
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
	  * @brief returna o boleano em rela��o ao her�i estar vivo ou n�o 
	  * @return heroi vivo ou n�o
	  */
	public boolean getHeroAlive(){
		return heroAlive;
	}

	/**
	 * @brief Altera o her�i para morto ou vivo
	 * @param alive
	 */
	public void setHeroAlive(boolean alive){
		heroAlive = alive;
	}
	
	/**
	 * @brief retorna se o her�i est� armado ou n�o
	 * @return her�i armado ou n�o
	 */
	public boolean getHeroArmed(){
		return heroArmed;
	}

	/**
	 * @brief Altera o her�i para armado ou n�o
	 * @param armed
	 */
	public void setHeroArmed(boolean armed){
		heroArmed = armed;
	}
}