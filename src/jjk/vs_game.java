package jjk;
import java.util.*;
public class vs_game {
	
	
	public void game_start(player p1,player p2) {
		Scanner input=new Scanner(System.in);
		//boolean condition checks to see if at least one of the characters on both sides are alive, else game loop ends and a player wins
		while((p1.getCurse1().getHealth()>0||p1.getCurse2().getHealth()>0)&&(p2.getCurse1().getHealth()>0||p2.getCurse2().getHealth()>0)) {
			boolean isGeto2=p2.getCurrent().getName().equals("Suguru Geto");
			boolean isJogo2=p2.getCurrent().getName().equals("Jogo");
			boolean isHanami2=p2.getCurrent().getName().equals("Hanami");
			boolean isMahito2=p2.getCurrent().getName().equals("Mahito");
			boolean isGojo2=p2.getCurrent().getName().equals("Satoru Gojo");
			boolean isGeto=p1.getCurrent().getName().equals("Suguru Geto");
			boolean isJogo=p1.getCurrent().getName().equals("Jogo");
			boolean isHanami=p1.getCurrent().getName().equals("Hanami");
			boolean isMahito=p1.getCurrent().getName().equals("Mahito");
			boolean isGojo=p1.getCurrent().getName().equals("Satoru Gojo");
			
			//all these booleans use the characters name for checks throughout the game
			System.out.println("\n\n**************player 1s turn*******************\n\n");
			p1.setTurn(true);
			System.out.println("current character is "+p1.getCurrent().getName());
			//this section prints out the characters abilities
			System.out.println("pick a move, press the corrosponding number\n\n");
			System.out.println(p1.getCurrent().getName()+"s abilities: \npress 1 for \n"+p1.getCurrent().getAbility(0)+"\n\n");
			System.out.println("press 2 for \n"+p1.getCurrent().getAbility(1)+"\n\n");
			System.out.println("press 3 for \n"+p1.getCurrent().getAbility(2)+"\n\n");
			if(!isGeto&&!isMahito) {
				System.out.println("press 4 for \n"+p1.getCurrent().getAbility(3)+"\n\n");
				if(!isJogo&&!isHanami) {
					System.out.println("press 5 for \n"+p1.getCurrent().getAbility(4)+"\n\n");
				}
			}
			//damage of reversed cursed technique is actually how much it heals
			if(isGojo){
				
				System.out.println("(note that reversed curse technique does heal, it just shows up as damage\n\n)");
			}
			else if(isMahito) {
				System.out.println("(the first attack listed doubles the damage of the second attack\n\n)");
			}
			
			System.out.println("press 6 to switch your character\n\n");
			
			while(true) {
				int x=input.nextInt();
				if(x<6) {
					if(p1.getCurrent().getEnergy()>=p1.getCurrent().getAbility(x-1).getCost()) {
						changestats(x,p1,p2);
						System.out.println("player ones "+p1.getCurrent().getName()+"s energy: "+   p1.getCurrent().getEnergy()+"\n\n");
						System.out.println("player ones "+p1.getCurrent().getName()+"s health: "+   p1.getCurrent().getHealth()+"\n\n");
						System.out.println("player twos "+p2.getCurrent().getName()+"s energy: "+   p2.getCurrent().getEnergy()+"\n\n");
						System.out.println("player twos "+p2.getCurrent().getName()+"s health: "+   p2.getCurrent().getHealth()+"\n\n");
						break;
					}
					else {
						System.out.println("can't pick that move, since you don't have enough cursed energy\n\n");
					}
					
					
					
				}
				
				else if(x==6) {
					
					if(p1.getCurrent().getName().equals(p1.getCurse1().getName())&&p1.getCurse2().getHealth()>0) {
						//switches to curse 2
						p1.setCurrent(p1.getCurse2());
						System.out.println("current for p1 is "+p1.getCurrent().getName()+"\n\n");
						break;
					}
					else if(p1.getCurrent().getName().equals(p1.getCurse2().getName())&&p1.getCurse1().getHealth()>0){
						//switches to curse 1
						p1.setCurrent(p1.getCurse1());
						System.out.println("current for p1 is "+p1.getCurrent().getName()+"\n\n");
						break;
					}
					else {
						System.out.println("\n\n the other character is dead\n\n");
					}
					
				}
				else {
					System.out.println("\n\n pick a valid input option\n\n");
				}
			}
			p1.setTurn(false);
			
			
			if(p2.getCurse1().getHealth()<=0&&p2.getCurse2().getHealth()<=0) {
				//if both p2 curses are now dead break out of the game loop
				break;
			}
			
			System.out.println("**************player 2s turn*******************");
			p2.setTurn(true);
			System.out.println("current character is "+p2.getCurrent().getName()+"\n\n");
			System.out.println("pick a move, press the corrosponding number");
			System.out.println(p2.getCurrent().getName()+"s abilities: \npress 1 for \n"+p2.getCurrent().getAbility(0)+"\n\n");
			System.out.println("press 2 for \n"+p2.getCurrent().getAbility(1)+"\n\n");
			System.out.println("press 3 for \n"+p2.getCurrent().getAbility(2)+"\n\n");
			if(!isGeto2&&!isMahito2) {
				System.out.println("press 4 for \n"+p2.getCurrent().getAbility(3)+"\n\n");
				if(!isJogo2&&!isHanami2) {
					System.out.println("press 5 for \n"+p2.getCurrent().getAbility(4)+"\n\n");
				}
			}
			
			if(isGojo2){
				
				System.out.println("(note that reversed curse technique does heal, it just shows up as damage)"+"\n\n");
			}
			else if(isMahito2) {
				System.out.println("(the first attack listed doubles the damage of the second attack\n\n)");
			}
			
			System.out.println("press 6 to switch your character"+"\n\n");
			while(true) {
				int y=input.nextInt();
				if(y<6) {
					if(p2.getCurrent().getEnergy()>=p2.getCurrent().getAbility(y-1).getCost()) {
						changestats(y,p1,p2);
						System.out.println("player ones "+p1.getCurrent().getName()+"s energy: "+   p1.getCurrent().getEnergy()+"\n\n");
						System.out.println("player ones "+p1.getCurrent().getName()+"s health: "+   p1.getCurrent().getHealth()+"\n\n");
						System.out.println("player twos "+p2.getCurrent().getName()+"s energy: "+   p2.getCurrent().getEnergy()+"\n\n");
						System.out.println("player twos "+p2.getCurrent().getName()+"s health: "+   p2.getCurrent().getHealth()+"\n\n");
						break;
					}
					else {
						System.out.println("can't pick that move, since you don't have enough cursed energy\n\n");
					}
					
					
					
				}
				
				else if(y==6) {
					if(p2.getCurrent().getName().equals(p2.getCurse1().getName())&&p2.getCurse2().getHealth()>0) {
						p2.setCurrent(p2.getCurse2());
						//switches to curse 2
						System.out.println("current for p2 is "+p2.getCurrent().getName()+"\n\n");
						break;
					}
					else if(p2.getCurrent().getName().equals(p2.getCurse2().getName())&&p2.getCurse1().getHealth()>0){
						p2.setCurrent(p2.getCurse1());//switches to curse 1
						System.out.println("current for p2 is "+p2.getCurrent().getName()+"\n\n");
						break;
					}
					else {
						System.out.println("\n\n the other character is dead\n\n");
					}
				}
				else {
					System.out.println("\n\n pick a valid input option\n\n");
				}
				
			}
			
			p2.setTurn(false);
			
			
			
			
		}
		//win condition check, 
		if(p1.getCurse1().getHealth()<=0&&p1.getCurse2().getHealth()<=0) {
			System.out.println("\n\nplayer 1 loses, player 2 wins!\n\n");
		}
		else if(p2.getCurse1().getHealth()<=0&&p2.getCurse2().getHealth()<=0){
			System.out.println("\n\nplayer 2 loses, player 1 wins!\n\n");
		}
		input.close();
		return;
		
		
		
		
		
		
	}
	//updates the curse char to be equal to current
	private static void update(player p1,player p2) {
		if(p1.getCurrent().getName().equals(p1.getCurse1().getName())) {
			p1.setCurse1(p1.getCurrent());
			
		}
		else {
			p1.setCurse2(p1.getCurrent());
			
		}
		if(p2.getCurrent().getName().equals(p2.getCurse1().getName())) {
			p2.setCurse1(p2.getCurrent());
		}
		else {
			p2.setCurse2(p2.getCurrent());
		}
	}
	//gets the max CE available for a character, used when regenerating CE
	private static double getMaxCE(String name) {
			switch(name) {
				case "Satoru Gojo": return 6000;
				case "Ryomen Sukuna": return 5500;
		        case "Suguru Geto": return 6500;
		        case "Mahito": return 5250;
		        case "Jogo": return 5500;
		        case "Hanami": return 5000;
		        default: return 5000;
			}
		}
	
	private static void changestats(int x,player p1,player p2) {
			if(p1.getTurn()) {
				
				if(p1.getCurrent().getName().equals("Suguru Geto")) {
					((geto) p1.getCurrent()).changeDMG();
					//randomizes getos damage everytime it is the players turn
				}
				
				
				p1.getCurrent().setEnergy(p1.getCurrent().getEnergy()-p1.getCurrent().getAbility(x-1).getCost());//subtracts cursed energy
				update(p1,p2);
			
				
				if(p1.getCurrent().getName().equals("Satoru Gojo")) {
					if(x<=4) {
						
							double a=Math.random();//this checks for black flash
							if(a<0.005) {
								p2.getCurrent().setHealth(p2.getCurrent().getHealth()-(p1.getCurrent().getAbility(x-1).getDamage()*1.2));
								System.out.println("\n\n BLACK FLASH HIT!!\n\n");
							}
							else {
								p2.getCurrent().setHealth(p2.getCurrent().getHealth()-p1.getCurrent().getAbility(x-1).getDamage());
							}
							
						
					}
					else if(x==5) {//heals does not do damage
						p1.getCurrent().setHealth(p1.getCurrent().getHealth()+p1.getCurrent().getAbility(x-1).getDamage());
					}
				}
				else if(p1.getCurrent().getName().equals("Mahito")) {
					if(x==1) {
						((mahito) p1.getCurrent()).double_damage();//doubles damage of body repel attack
					}
					else {
						double a=Math.random();
						if(a<0.005) {//again, checks for black flash
							p2.getCurrent().setHealth(p2.getCurrent().getHealth()-(p1.getCurrent().getAbility(x-1).getDamage()*1.2));
							System.out.println("\n\n BLACK FLASH HIT!!\n\n");
						}
						else {
							p2.getCurrent().setHealth(p2.getCurrent().getHealth()-p1.getCurrent().getAbility(x-1).getDamage());
						}
						if(x==2) {
							p1.getCurrent().setAbility(1, new ability("body repel",10000,600));
							((mahito)p1.getCurrent()).reset();
						}
					}
				}
				else  {
					if(x<=5) {//for all other characters without quirks
						double a=Math.random();
						if(a<0.005) {
							p2.getCurrent().setHealth(p2.getCurrent().getHealth()-(p1.getCurrent().getAbility(x-1).getDamage()*1.2));
							System.out.println("\n\n BLACK FLASH HIT!!\n\n");
						}
						else {
							p2.getCurrent().setHealth(p2.getCurrent().getHealth()-p1.getCurrent().getAbility(x-1).getDamage());
						}
						
						
					}
				}
				
				update(p1,p2);
		
				
				//regenerates cursed energy for p2
				double currentEnergy = p2.getCurrent().getEnergy();
			    double maxRegenAmount = 300;
			    p2.getCurrent().setEnergy(Math.min(currentEnergy + maxRegenAmount,getMaxCE(p2.getCurrent().getName())));
			    update(p1, p2);
				
				//this is where the game checks for any dead characters, done for player 2
				if(p2.getCurrent().getHealth()<=0) {
					System.out.println("\n\n "+"player 2s "+p2.getCurrent().getName()+" is dead\n\n");
					if(p2.getCurse1().getHealth()<=0&&p2.getCurse2().getHealth()<=0) {
						return;
					}
					else {
						if(p2.getCurrent().getName().equals(p2.getCurse1().getName())) {
							p2.setCurrent(p2.getCurse2());
							update(p1,p2);//switches to curse 2
							System.out.println("\n\nswitched to "+p2.getCurrent().getName()+ " since "+p2.getCurse1().getName()+" died\n\n");
							
						}
						else {
							p2.setCurrent(p2.getCurse1());
							update(p1,p2);//switches to curse 1
							System.out.println("\n\nswitched to "+p2.getCurrent().getName()+ " since "+p2.getCurse2().getName()+" died\n\n");
						}
					}
					
				}
				
			}
			else {
				//else if it is player 2s turn
				p2.getCurrent().setEnergy(p2.getCurrent().getEnergy()-p2.getCurrent().getAbility(x-1).getCost());
				if(p2.getCurrent().getName().equals("Suguru Geto")) {
					((geto) p2.getCurrent()).changeDMG();
					
				}
				
				update(p1,p2);
			
				
				if(p2.getCurrent().getName().equals("Satoru Gojo")) {
					if(x<=4) {
						
							double a=Math.random();
							if(a<0.005) {
								p1.getCurrent().setHealth(p1.getCurrent().getHealth()-(p2.getCurrent().getAbility(x-1).getDamage()*1.2));
								System.out.println("\n\n BLACK FLASH HIT!!\n\n");
							}
							else {
								p1.getCurrent().setHealth(p1.getCurrent().getHealth()-p2.getCurrent().getAbility(x-1).getDamage());
							}
							
						
					}
					else if(x==5) {
						p2.getCurrent().setHealth(p2.getCurrent().getHealth()+p2.getCurrent().getAbility(x-1).getDamage());
					}
				}
				else if(p2.getCurrent().getName().equals("Mahito")) {
					if(x==1) {
						((mahito) p2.getCurrent()).double_damage();
					}
					else {
						double a=Math.random();
						if(a<0.005) {
							p1.getCurrent().setHealth(p1.getCurrent().getHealth()-(p2.getCurrent().getAbility(x-1).getDamage()*1.2));
							System.out.println("\n\n BLACK FLASH HIT!!\n\n");
						}
						else {
							p1.getCurrent().setHealth(p1.getCurrent().getHealth()-p2.getCurrent().getAbility(x-1).getDamage());
						}
						if(x==2) {
							p2.getCurrent().setAbility(1, new ability("body repel",10000,600));
							((mahito)p2.getCurrent()).reset();
						}
					}
				}
				else  {
					if(x<=5) {
						double a=Math.random();
						if(a<0.005) {
							p1.getCurrent().setHealth(p1.getCurrent().getHealth()-(p2.getCurrent().getAbility(x-1).getDamage()*1.2));
							System.out.println("\n\n BLACK FLASH HIT!!\n\n");
						}
						else {
							p1.getCurrent().setHealth(p1.getCurrent().getHealth()-p2.getCurrent().getAbility(x-1).getDamage());
						}
						
						
					}
				}
				
				update(p1,p2);
				
				//regenerates cursed energy for p1
				double currentEnergy = p1.getCurrent().getEnergy();
			    double maxRegenAmount = 300;
			    p1.getCurrent().setEnergy(Math.min(currentEnergy + maxRegenAmount,getMaxCE(p1.getCurrent().getName())));
			    update(p1, p2);
				
				//this is where the game checks for any dead characters, done for player 1
				if(p1.getCurrent().getHealth()<=0) {
					System.out.println("\n\n player 1s "+p1.getCurrent().getName()+" is dead\n\n");
					if(p1.getCurse1().getHealth()<=0&&p1.getCurse2().getHealth()<=0) {
						return;
					}
					else {
						if(p1.getCurrent().getName().equals(p1.getCurse1().getName())) {
							p1.setCurrent(p1.getCurse2());//switches to curse 2
							update(p1,p2);
							System.out.println("\n\nswitched to "+p1.getCurrent().getName()+ " since "+p1.getCurse1().getName()+" died\n\n");
							
							
						}
						else {
							p1.setCurrent(p1.getCurse1());//switches to curse 1
							update(p1,p2);
							System.out.println("\n\nswitched to "+p1.getCurrent().getName()+ " since "+p1.getCurse2().getName()+" died\n\n");
							
						}
					}
					
				}
				
			}
			
			
			
		
		
		
		
	}
	
	
	
}
