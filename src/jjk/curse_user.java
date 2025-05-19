package jjk;

import java.io.*;
//this class is a template for other characters in the game
public class curse_user {
	private String name;//name is usually used for boolean checks and checking which character the player is using
	private double health;
	private ability[] moveset;//variable length, some chars have a different amount of moves
	private int grade;//their grade (special grades are identified as grade 0)
	private double energy;//amount of CE a character has
	private File picture;//ascii art that displays character
	
	//note that there is a scaling for the health and damage of different grades of sorecerers 
	//special grades usually have health in the 400000-500000 range,damage in the 20000-50000 and CE from 5000-6000, with some outliers
	//try to adapt the scaling if you add grades beneath special grades, update this section if adding any other new type of character
	
	public curse_user() {
		
	}
	//all other methods are getters and setters
	public void setMVST_SIZE(int x) {
		moveset=new ability[x];
	}
	public int getMVST_SIZE() {
		return moveset.length;
	}
	public void setFile(String f) {
		picture=new File(f);
	}
	public File getFile() {
		return picture;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name=n;
	}
	
	public double getHealth() {
		return health;
	}
	public void setHealth(double h) {
		health=h;
	}
	
	public double getGrade() {
		return grade;
	}
	public void setGrade(int g) {
		grade=g;
	}
	public ability getAbility(int ind) {
		return moveset[ind];
	}
	public void setAbility(int ind,ability a) {
		moveset[ind]=a;
	}
	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double e) {
		energy=e;
	}
	
	
	
	
	
	
}
