package MAZE.Logic;
import java.util.*;


public class MazeBuilder {
	public int size, visitedCellsDimension;
	public char[][] maze;
	char[][] visitedCell;
	Cell guideCell;
	Stack<Cell> pathHistory;
	private Hero hero;
	private Dragon dragon;
	private Sword sword;
	/**
	 * @brief inicializa o labirinto random
	 */
	public MazeBuilder(){}

	
	
	class Cell
	{
		public int line, col;
		/**
		 * Inicializa e constroi uma cela com dado X e dado Y
		 * @param col
		 * @param line
		 */
		public Cell(int col, int line)
		{
			this.line = line;
			this.col = col;
		}
	}

	/**
	 * @brief Verifica se a cell onde estamos não se consegue movimentar para nenhum sítio por onde já tenha passado
	 * @param x
	 * @param y
	 * @param visitedCell
	 * @return verdadeiro caso não se consgio movimentar, ou falso caso consiga.
	 */
	public boolean deadEnd(int x, int y , char[][] visitedCell){
		if(y-1 >= 0)
			if(visitedCell[y-1][x] == '.') return false;
		if(y+1 <= visitedCell.length-1)
			if(visitedCell[y+1][x] == '.') return false;
		if(x-1 >= 0)
			if(visitedCell[y][x-1] == '.') return false;
		if(x+1 <= visitedCell.length-1)
			if(visitedCell[y][x+1] == '.') return false;

		return true;

	}

	/**
	 * @brief Cria um tabuleiro random com lado = size em que para cada célula em branco há possibilidade de chegar à saída
	 * @param size
	 * @return
	 */

	public char[][] buildMaze(int size){
		maze = new char[size][size];
		visitedCellsDimension = (size - 1) / 2;
		pathHistory = new Stack<Cell>();
		visitedCell = new char[visitedCellsDimension][visitedCellsDimension];
		
		//initial maze
		for(int i  = 0; i < size; i++)
			for(int j = 0; j< size; j++)
				if(i %2 !=0 && j%2 != 0)
					maze[i][j] = ' ';
				else 
					maze[i][j] = 'X';


		//visited cells maze
		for (int i = 0; i < visitedCellsDimension; i++)
			for(int j = 0; j < visitedCellsDimension; j++){ 
				visitedCell[i][j] = '.';
			}

		//guideCell 
		Random rand = new Random();
		int line=0, col=0, r1;
		r1 = rand.nextInt(4);
		int temp = 0;
		while(temp % 2 == 0)
			temp = rand.nextInt(size-2) + 1;

		switch(r1)
		{
		case 0:
			line = 1;
			col = temp;
			break;
		case 1:
			line = size-2;
			col = temp;
			break;
		case 2:
			col = 1;
			line = temp;
			break;
		case 3:
			col = size-2;
			line = temp;
			break;
		}
		guideCell = new Cell((line - 1)/2, (col - 1)/2);
		pathHistory.push(new Cell(guideCell.col,guideCell.line));
		visitedCell[(col-1)/2][(line-1)/2] = '+';


		//create exit
		if (line + 1 == size - 1)
			maze[line + 1][col] = 'S';
		else if (line - 1 == 0)
			maze[line - 1][col] = 'S';
		else if (col + 1 == size - 1)
			maze[line][col + 1] = 'S';
		else if (col - 1 == 0)
			maze[line][col - 1] = 'S';

		

		
		while(!pathHistory.empty()){
			do{
				rand = new Random();
				int dir = rand.nextInt(4);
				switch(dir){
				case 0: //left
					if(guideCell.col != 0){
						if(visitedCell[guideCell.col-1][guideCell.line] == '.'){
							maze[guideCell.col*2+1][guideCell.line*2+1] =' ';
							maze[guideCell.col*2][guideCell.line*2+1] =' ';
							guideCell.col = guideCell.col-1;
							visitedCell[guideCell.col][guideCell.line] = '+';
							pathHistory.push(new Cell(guideCell.col,guideCell.line));

						}
					}break;
				case 1: 
					if(guideCell.line != 0){
						if(visitedCell[guideCell.col][guideCell.line-1] == '.'){
							maze[guideCell.col*2+1][guideCell.line*2+1] =' ';
							maze[guideCell.col*2+1][guideCell.line*2] =' ';
							guideCell.line = guideCell.line-1;
							visitedCell[guideCell.col][guideCell.line] = '+';
							pathHistory.push(new Cell(guideCell.col,guideCell.line));

						}
					}break;
				case 2: 
					if(guideCell.line != visitedCellsDimension-1){
						if(visitedCell[guideCell.col][guideCell.line+1] == '.'){
							maze[guideCell.col*2+1][guideCell.line*2+1] =' ';
							maze[guideCell.col*2+1][guideCell.line*2+2] =' ';
							guideCell.line = guideCell.line+1;
							visitedCell[guideCell.col][guideCell.line] = '+';
							pathHistory.push(new Cell(guideCell.col,guideCell.line));

						}
					}break;
				case 3: 
					if(guideCell.col != visitedCellsDimension-1){
						if(visitedCell[guideCell.col+1][guideCell.line] == '.'){
							maze[guideCell.col*2+1][guideCell.line*2+1] =' ';
							maze[guideCell.col*2+2][guideCell.line*2+1] =' ';
							guideCell.col = guideCell.col+1;
							visitedCell[guideCell.col][guideCell.line] = '+';
							pathHistory.push(new Cell(guideCell.col,guideCell.line));

						}
					}break;
				}

			}while(!deadEnd(guideCell.line,guideCell.col, visitedCell));
			guideCell = pathHistory.pop();

		}
		cleanMaze2();
		return maze;

	}
	
	/**
	 * @brief Verifica se o tabuleiro random não tem nenhuma célula em branco sem caminho para a sáida
	 */
	public void cleanMaze2(){
		if(guideCell.line == 0 && guideCell.col == 0)
			maze[guideCell.line*2+2][guideCell.col*2+1] = ' ';
		else if(guideCell.line == 0 && guideCell.col == visitedCellsDimension-1)
			maze[guideCell.line*2+1][guideCell.col*2] = ' ';
		else if(guideCell.line == visitedCellsDimension-1 && guideCell.col == visitedCellsDimension-1)
			maze[guideCell.line*2][guideCell.col*2+1] = ' ';
		else if(guideCell.line == visitedCellsDimension-1 && guideCell.col == 0)
			maze[guideCell.line*2+1][guideCell.col*2+2] = ' ';
		else if(guideCell.col == 0 )
			maze[guideCell.line*2+2][guideCell.col*2+1] = ' ';
		else if(guideCell.col == visitedCellsDimension-1)
			maze[guideCell.line*2][guideCell.col*2+1] = ' ';
		else if(guideCell.line == 0)
			maze[guideCell.line*2+1][guideCell.col*2+2] = ' ';
		else if(guideCell.line == visitedCellsDimension-1)
			maze[guideCell.line*2+1][guideCell.col*2] = ' ';

	}
	
	/**
	 * @brief Retorna o maze que se está a usar
	 * @return Retorna o random maze
	 */
	public char[][] getMaze(){
		return maze;
	}

}