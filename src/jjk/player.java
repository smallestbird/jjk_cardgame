package jjk;

public class player {
	private curse_user c1;
	private curse_user c2;
	private boolean isTurn;
	private curse_user current;
	//current curse that the player is using
	public player(curse_user a,curse_user b, boolean c, int x) {
		c1=a;
		c2=b;
		isTurn=c;
		if(x==1) {
			current=c1;
			
		}
		else {
			current=c2;
		}
		
	}
	//rest are getters and setters
	public boolean getTurn() {
		return isTurn;
	}
	public void setTurn(boolean b) {
		isTurn=b;
	}
	public curse_user getCurse2() {
		return c2;
	}
	public void setCurse2(curse_user c2) {
		this.c2 = c2;
	}
	public curse_user getCurse1() {
		return c1;
	}
	public void setCurse1(curse_user c1) {
		this.c1 = c1;
	}
	public curse_user getCurrent() {
		return current;
	}
	public void setCurrent(curse_user current) {
		this.current = current;
	}
	
	
}
