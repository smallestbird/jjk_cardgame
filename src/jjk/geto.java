package jjk;

import java.nio.file.Paths;

public class geto extends curse_user{
	
	public geto() {
	
	setName("Suguru Geto");
	setMVST_SIZE(3);
	setHealth(450000);//ability constructer follows this order: name, damage, cost
	setAbility(0,new ability("cursed spirit manipulation",((Math.random()*75000)+25000),400));//geto draws a curse at random, and its damage is variable every turn
	setAbility(1,new ability("Maximum: Uzumaki",((Math.random()*75000)+25000)*2.5,850));//this moves damage is 2.5 times the damage of his first move
	setAbility(2,new ability("Playful Cloud",50000,0));
	//this file path might need to change, make sure it is correct
	setFile(Paths.get("pictures", "geto.txt").toString());
	setGrade(0);
	setEnergy(6500);
	
}
	public void changeDMG() {
		double dmg1=((Math.random()*75000)+25000);
		
		setAbility(0,new ability("cursed spirit manipulation",dmg1,400));
		setAbility(1,new ability("Maximum: Uzumaki",dmg1*2.5,850));
		
	}
public String toString() {
		return "The curse manipulator. Suguru Geto hated non-sorcerers, usually referring to them as \"monkeys\". He felt sorcerers are the superior race and humanity's next stage of evolution. He was smug and extremely condescending towards normal\n"
				+ "humans, using fake personas to lure in vulnerable people who were cursed. In contrast, Suguru cared deeply for his fellow curse users, referring to his comrades as family. Each of them still looks up to Suguru for putting \n"
				+ "sorcerers as a race first and hoped that he would have become king of the jujutsu world.\n\n\"Are you the strongest because you're Satoru Gojo, or are you Satoru Gojo because you're the strongest?\"\n\n";
	}
}
