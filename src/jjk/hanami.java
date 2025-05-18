package jjk;
import java.nio.file.*;
public class hanami extends curse_user{
	
	public hanami() {
		setName("Hanami");
		setMVST_SIZE(4);
		setHealth(460000);//ability constructer follows this order: name, damage, cost
		setAbility(0,new ability("wooden ball",55000,300));
		setAbility(1,new ability("cursed bud",40000,200));
		setAbility(2,new ability("roots",59000,350));
		setAbility(3,new ability("punch",4000,0));
		//this file path might need to change, make sure it is correct
		setFile(Paths.get("pictures", "hanami.txt").toString());
		setGrade(0);
		setEnergy(5000);
		
	}
	public String toString() {
		return "One of the great disaster curses. Hanami is the type of spirit who cares for the planet that the humans have been abusing for "
				+ "thousands of years. They wish to kill humans in order to sacrifice them so they can be sages "
				+ "to a cleaner world controlled by cursed spirits that will respect the earth.[1] Hanami believes "
				+ "in Jogo's ideals along with Dagon, as they want to replace humanity with cursed spirits because they "
				+ "feel curses are the true humans.\n\n\"Death is something humans fear and detest. However, humans linger beyond it, as well. Death is a mirror for humans.\"\n\n";
	}
}
