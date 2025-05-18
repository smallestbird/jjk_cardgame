package jjk;
import java.nio.file.*;
public class gojo extends curse_user{
	
	public gojo() {
		setName("Satoru Gojo");
		setMVST_SIZE(5);
		setHealth(500000);//ability constructer follows this order: name, damage, cost
		setAbility(0,new ability("blue",55000,200));
		setAbility(1,new ability("red",65000,300));
		setAbility(2,new ability("purple",90000,500));
		setAbility(3,new ability("punch",2000,0));
		setAbility(4,new ability("reverse cursed technique",150000,1000));//heals gojo all other moves damage, special case accounted for in vs_game and ai_game
		//this file path might need to change, make sure it is correct
		setFile(Paths.get("pictures", "gojo.txt").toString());
		setGrade(0);
		setEnergy(6000);
	}
	public String toString() {
		return "the strongest. gojo satoru is a complex individual. He is usually laidback and \""
			+ "\nplayful with his students, close colleagues, and friends. However, he is unsympathetic and cruel towards sorcerer executives\""+
				". \nFamous for being one of the strongest jujutsu sorcerer only rivaled by ryomen sukuna himself.\n\n\"Nah, I'd win.\"\n\n";
	}
	

}
