package jjk;


//this is the ability class, all characters have fixed array size for abilites, but not all have the same amount of abilities

public class ability {

	private String name;
	private double damage;
	private double cost;
	
	public ability(String n,double d,double cost){
		name=n;
		damage=d;
		this.cost=cost;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name=n;
	}
	public double getDamage() {
		return damage;
	}
	public void setDamage(double d) {
		damage=d;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double c) {
		cost=c;
	}
	public String toString() {
		return "name: "+name+" \ndamage: "+damage+" \nCE cost "+cost;
	}
	
	
}
