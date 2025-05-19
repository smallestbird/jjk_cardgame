package jjk;
import java.nio.file.*;
public class mahito extends curse_user{
	private double cur;
	private final double MAX_DAMAGE = 200000;
	
	public mahito() {
		setName("Mahito");
		setMVST_SIZE(3);
		setHealth(450000);//ability constructer follows this order: name, damage, cost
		setAbility(0,new ability("soul multiplicity",0,300));//soul multiplicy doubles the damage of body repel
		setAbility(1,new ability("body repel",10000,600));//base damage is 10000(assuming you never use soul multiplicity)
		setAbility(2,new ability("punch",4000,0));
		//this file path might need to change, make sure it is correct
		setFile(Paths.get("pictures", "mahito.txt").toString());
		setGrade(0);
		setEnergy(5250);
		cur=this.getAbility(1).getDamage();
		
		
	}
	public void double_damage() {
		
		cur=Math.min(cur*2, MAX_DAMAGE);//cur represents the doubled value of body repels damage
		setAbility(1,new ability("body repel",cur,600));//max damage is there to prevent one hit knock outs
	}
	public void reset() {
		cur=10000;//resets cur back to base, this happens after the player uses body repel
		
	}
	public String toString() {
		return "One of the great disaster curses. Mahito is an immature and sadistic cursed spirit who enjoys toying with human emotions. "
				+ "He believes he was born from human transgressions and considers himself the manifestation of "
				+ "humans' hatred of each other. As such, Mahito supports human extermination and deems cursed "
				+ "spirits to be the true rulers of the world. Unlike his ally Jogo, who is short-tempered and "
				+ "arrogant, Mahito can remain relatively calm and playful upon confrontation with an enemy.\n\n\"You can't let yourself get trapped in an ideal of indifference.\"\n\n";
	}
}
