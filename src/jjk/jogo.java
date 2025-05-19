package jjk;
import java.nio.file.*;
public class jogo extends curse_user{
	
	public jogo() {
		setName("Jogo");
		setMVST_SIZE(4);
		setHealth(450000);//ability constructer follows this order: name, damage, cost
		setAbility(0,new ability("disaster flames",60000,300));
		setAbility(1,new ability("ember instincts",30000,100));
		setAbility(2,new ability("maximum:meteor",75000,500));
		setAbility(3,new ability("punch",2000,0));
		//this file path might need to change, make sure it is correct
		setFile(Paths.get("pictures", "jogo.txt").toString());
		setGrade(0);
		setEnergy(5500);
		
	}
	public String toString() {
		return "One of the great disaster curses. Jogo was defined by his pride as a cursed spirit. On a personal level, Jogo was always ill-tempered, "
				+ "irritable, and very arrogant. Jogo believed that cursed spirits are the true humans and they "
				+ "are the ones who will inherit the earth. He saw humans as creatures made of lies pretending to hide "
				+ "their true nature with the positive emotions they show. Curses are made up of negative emotions that "
				+ "Jogo views as pure intent, and so he thinks that curses born from such truth are the purest forms of "
				+ "humans and the fake ones should be eliminated.\n\n\"Humans are made up of lies. For every positive action and emotion they show, there's always a flip-side.\"\n\n";
	}
}
