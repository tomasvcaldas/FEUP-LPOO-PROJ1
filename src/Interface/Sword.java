package Interface;

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
	
	
}
