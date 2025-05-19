package jjk;
import java.nio.file.*;
public class sukuna extends curse_user{
	
	public sukuna() {
		
		setName("Ryomen Sukuna");
		setMVST_SIZE(5);
		setHealth(520000);//ability constructer follows this order: name, damage, cost
		setAbility(0,new ability("cleave",70000,350));
		setAbility(1,new ability("dismantle",70000,350));
		setAbility(2,new ability("malevolent shrine",80000,400));
		setAbility(3,new ability("punch",2000,0));
		setAbility(4,new ability("divine flame",100000,450));
		//this file path might need to change, make sure it is correct
		setFile(Paths.get("pictures", "sukuna.txt").toString());
		setGrade(0);
		setEnergy(5500);
		
	}
	public String toString() {
		return "the king of curses. Ryomen Sukuna is the knwon to be the most powerfull curse user of heian era, the golden age of jujutsu\""+
				". \nSukuna is egotistical, hedonistic, psychopathic, and exceptionally sadistic. \""
				+ "\nWhen he was reincarnated shortly after Yuji ingested his finger, he commented, \""
				+ "\nimplying the slaughter of women and children and likening them to maggots crawling around.\n\n\"Stand proud, you're strong\"\n\n";
		}

}
