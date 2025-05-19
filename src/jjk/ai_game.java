package jjk;
import java.util.*;

public class ai_game {
	public void game_start(player p1,player p2) {
		Scanner input=new Scanner(System.in);
		
		while((p1.getCurse1().getHealth()>0||p1.getCurse2().getHealth()>0)&&(p2.getCurse1().getHealth()>0||p2.getCurse2().getHealth()>0)) {
			
			boolean isGeto=p1.getCurrent().getName().equals("Suguru Geto");
			boolean isJogo=p1.getCurrent().getName().equals("Jogo");
			boolean isHanami=p1.getCurrent().getName().equals("Hanami");
			boolean isMahito=p1.getCurrent().getName().equals("Mahito");
			boolean isGojo=p1.getCurrent().getName().equals("Satoru Gojo");
			//all these booleans use the characters name for checks throughout the game
			
			System.out.println("\n\n**************player 1s turn*******************\n\n");
			p1.setTurn(true);
			System.out.println("current character is "+p1.getCurrent().getName());
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
			else{
				
			}
	
			if(isGojo){
				
				System.out.println("(note that reversed curse technique does heal, it just shows up as damage\n\n)");
			}
			else if(isMahito) {
				System.out.println("(the first attack listed doubles the damage of the second attack\n\n)");
			}
			
			System.out.println("press 6 to switch your character\n");
			
			while(true) {
				int x=input.nextInt();
				if(x<6) {
					if(p1.getCurrent().getEnergy()>=p1.getCurrent().getAbility(x-1).getCost()) {
						if(p1.getCurrent().getName().equals("Suguru Geto")) {
							((geto) p1.getCurrent()).changeDMG();
							
						}
						changestats(x,p1,p2);
						System.out.println("player ones "+p1.getCurrent().getName()+"s energy: "+   p1.getCurrent().getEnergy()+"\n\n");
						System.out.println("player ones "+p1.getCurrent().getName()+"s health: "+   p1.getCurrent().getHealth()+"\n\n");
						System.out.println("A.Is "+p2.getCurrent().getName()+"s energy: "+   p2.getCurrent().getEnergy()+"\n\n");
						System.out.println("A.Is "+p2.getCurrent().getName()+"s health: "+   p2.getCurrent().getHealth()+"\n\n");
						break;
					}
					else {
						System.out.println("can't pick that move, since you don't have enough cursed energy");
					}
					
					
					
				}
				
				else if(x==6) {
					
					if(p1.getCurrent().getName().equals(p1.getCurse1().getName())&&p1.getCurse2().getHealth()>0) {
						
						p1.setCurrent(p1.getCurse2());
						System.out.println("current for p1 is "+p1.getCurrent().getName());
						break;
					}
					else if(p1.getCurrent().getName().equals(p1.getCurse2().getName())&&p1.getCurse1().getHealth()>0){
						p1.setCurrent(p1.getCurse1());
						System.out.println("current for p1 is "+p1.getCurrent().getName());
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
				break;
			}
			
			System.out.println("**************A.Is turn*******************"); 
			p2.setTurn(true);
			System.out.println("current character is "+p2.getCurrent().getName()+"\n\n");
			
			while(true) {
				int y=chooseAIMove(p1,p2);
				if(y<6) {
					if(p2.getCurrent().getName().equals("Suguru Geto")) {
						((geto) p2.getCurrent()).changeDMG();
						
					}
						changestats(y-1,p1,p2);
						System.out.println("player ones "+p1.getCurrent().getName()+"s energy: "+   p1.getCurrent().getEnergy()+"\n\n");
						System.out.println("player ones "+p1.getCurrent().getName()+"s health: "+   p1.getCurrent().getHealth()+"\n\n");
						System.out.println("A.Is "+p2.getCurrent().getName()+"s energy: "+   p2.getCurrent().getEnergy()+"\n\n");
						System.out.println("A.Is "+p2.getCurrent().getName()+"s health: "+   p2.getCurrent().getHealth()+"\n\n");
						break;
				}
				
				else if(y==6) {
					if(p2.getCurrent().getName().equals(p2.getCurse1().getName())&&p2.getCurse2().getHealth()>0) {
						p2.setCurrent(p2.getCurse2());
						System.out.println("current for A.I is "+p2.getCurrent().getName());
						break;
					}
					else if(p2.getCurrent().getName().equals(p2.getCurse2().getName())&&p2.getCurse1().getHealth()>0){
						p2.setCurrent(p2.getCurse1());
						System.out.println("current for A.I is "+p2.getCurrent().getName());
						break;
					}
					else {
						System.out.println("\n\n the other character is dead\n\n");
					}
				}
				
				
			}
			
			p2.setTurn(false);
			
			
			
			
		}
		if(p1.getCurse1().getHealth()<=0&&p1.getCurse2().getHealth()<=0) {
			System.out.println("\n\nplayer 1 loses \n\n");
		}
		else if(p2.getCurse1().getHealth()<=0&&p2.getCurse2().getHealth()<=0){
			System.out.println("\n\nA.I loses \n\n");
		}
		
		input.close();
		
		
		
		
		
		
	}
	//returns 1 indexed int for choosing the ai move.
	private static int chooseAIMove(player humanPlayer, player aiPlayer) {
	    curse_user aiCurrent = aiPlayer.getCurrent();
	    curse_user humanCurrent = humanPlayer.getCurrent();
	    boolean isGeto2=aiCurrent.getName().equals("Suguru Geto");
		boolean isMahito2=aiCurrent.getName().equals("Mahito");
		boolean isGojo2=aiCurrent.getName().equals("Satoru Gojo");
	    
	    // If AI health is low and has healing ability, prioritize healing, or switch char if possible
	    if (isGojo2 && aiCurrent.getHealth() <=250000 && aiCurrent.getEnergy() >= aiCurrent.getAbility(4).getCost()) {
	        return 5; // Use healing ability
	    }
	    else if(aiPlayer.getCurrent().getName().equals(aiPlayer.getCurse1().getName())&&aiPlayer.getCurse2().getHealth()>0&&aiCurrent.getHealth() <=250000) {
	    	return 6;
	    }
	    else if(aiPlayer.getCurrent().getName().equals(aiPlayer.getCurse2().getName())&&aiPlayer.getCurse1().getHealth()>0&&aiCurrent.getHealth() <=250000) {
	    	return 6;
	    }
	    
	    // If enemy health is low, use strongest attack
	    if (humanCurrent.getHealth() <=200000) {
	        // Find strongest attack the AI can afford
	        int strongestIndex = 0;
	        double maxDamage = 0;
	        
	        for (int i = 0; i < 5; i++) {
	            if (i < 3 || aiCurrent.getMVST_SIZE()!=3) {//if curse user is mahito/geto loop breaks
	                if (aiCurrent.getAbility(i) != null && aiCurrent.getAbility(i).getDamage() > maxDamage && aiCurrent.getEnergy() >= aiCurrent.getAbility(i).getCost()) {
	                    maxDamage = aiCurrent.getAbility(i).getDamage();
	                    strongestIndex = i;
	                }
	            }
	            else {
	            	break;
	            }
	        }
	        return strongestIndex + 1; // Return 1-based index
	    }
	    
	    // If AI energy is low, use basic attack or switch
	    if (aiCurrent.getEnergy() < 500) {
	        // 50% chance to use basic attack or switch
	        if (Math.random() < 0.5) {
	        	if(isGeto2 ||isMahito2) {//returns index of punch for mahito or geto
	        		return 3;
	        	}
	        	else {
	        		return 4;
	        	}
	           
	        } else {
	            return 6; // Switch character, all chars switch using 6
	        }
	    }
	    
	    // Default to weighted random selection
	    double[] weights;
	    if(aiCurrent.getMVST_SIZE()==3) {
	    	weights=new double[3];
	    	weights[0]=0.4;
	    	weights[1]=0.4;
	    	weights[2]=0.2;
	    }
	    else if(aiCurrent.getMVST_SIZE()==4) {
	    	weights=new double[4];
	    	weights[0]=0.3;
	    	weights[1]=0.3;
	    	weights[2]=0.3;
	    	weights[3]=0.1;
	    	
	    	
	    }
	    else {
	    	weights = new double[5];
	    	weights[0]=0.3;
	    	weights[1]=0.1;
	    	weights[2]=0.3;
	    	weights[3]=0.1;
	    	weights[4]=0.2;
	    	
	    }
	     // Probabilities for abilities 1-5
	    double rand = Math.random();
	    double cumulativeWeight = 0;
	    
	    for (int i = 0; i < weights.length; i++) {
	        cumulativeWeight += weights[i];
	        if (rand < cumulativeWeight&&aiCurrent.getAbility(i).getCost()<=aiCurrent.getEnergy()) {
	            return i + 1;
	        }
	        else {
	        	continue;
	        }
	    }
	    if(aiCurrent.getMVST_SIZE()==3) {
	    	return 3;
	    }
	    else {
	    	return 4;
	    }
	    // Fallback to punch/attack that costs 0 cursed energy
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
	//gets the max CE available for a character
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
				
				p1.getCurrent().setEnergy(p1.getCurrent().getEnergy()-p1.getCurrent().getAbility(x-1).getCost());
				
				update(p1,p2);
			
				if(p1.getCurrent().getName().equals("Satoru Gojo")) {
					if(x<=4) {
						
							double a=Math.random();
							if(a<0.005) {
								p2.getCurrent().setHealth(p2.getCurrent().getHealth()-(p1.getCurrent().getAbility(x-1).getDamage()*1.2));
								System.out.println("\n\n BLACK FLASH HIT!!\n\n");
							}
							else {
								p2.getCurrent().setHealth(p2.getCurrent().getHealth()-p1.getCurrent().getAbility(x-1).getDamage());
							}
							
						
					}
					else if(x==5) {
						p1.getCurrent().setHealth(p1.getCurrent().getHealth()+p1.getCurrent().getAbility(x-1).getDamage());
					}
				}
				else if(p1.getCurrent().getName().equals("Mahito")) {
					if(x==1) {
						((mahito) p1.getCurrent()).double_damage();
					}
					else {
						double a=Math.random();
						if(a<0.005) {
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
					if(x<=5) {
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
					System.out.println("\n\n "+"player 2s "+p2.getCurrent().getName()+" is dead");
					if(p2.getCurse1().getHealth()<=0&&p2.getCurse2().getHealth()<=0) {
						return;
					}
					else {
						if(p2.getCurrent().getName().equals(p2.getCurse1().getName())) {
							p2.setCurrent(p2.getCurse2());
							update(p1,p2);
							System.out.println("\n\nswitched to "+p2.getCurrent().getName()+ " since "+p2.getCurse1().getName()+" died\n\n");
							
						}
						else {
							p2.setCurrent(p2.getCurse1());
							update(p1,p2);
							System.out.println("\n\nswitched to "+p2.getCurrent().getName()+ " since "+p2.getCurse2().getName()+" died\n\n");
						}
					}
					
				}
				
			}
			else {
				
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
					System.out.println("\n\n player 1s "+p1.getCurrent().getName()+" is dead");
					if(p1.getCurse1().getHealth()<=0&&p1.getCurse2().getHealth()<=0) {
						return;
					}
					else {
						if(p1.getCurrent().getName().equals(p1.getCurse1().getName())) {
							p1.setCurrent(p1.getCurse2());
							update(p1,p2);
							System.out.println("\n\nswitched to "+p1.getCurrent().getName()+ " since "+p1.getCurse1().getName()+" died\n\n");
							
							
						}
						else {
							p1.setCurrent(p1.getCurse1());
							update(p1,p2);
							System.out.println("\n\nswitched to "+p1.getCurrent().getName()+ " since "+p1.getCurse2().getName()+" died\n\n");
							
						}
					}
					
				}
				
			}
			
			
			
		
		
		
		
	}
	
}
