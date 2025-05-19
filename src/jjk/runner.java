package jjk;

	
import java.util.*;
public class runner {
	public static void main(String[] args) {
		//runner class, player chooses.
		Scanner input=new Scanner(System.in);
		System.out.println("do you want to play against a bot, or with a friend(max 2 players in one game)\n\n");
		System.out.println("\n\npress 1 for A.I, press 2 to fight a friend\n\n");
		int x;
		while(true) {
			x=input.nextInt();
			if(x==1) {
				ai_start schloob=new ai_start();
				
				schloob.ai_game_start();
				break;
			}
			else if(x==2) {
				vs_start goon=new vs_start();
				
				goon.vs_game_start();
				break;
			}
			else {
				System.out.println("\n\nplease enter a valid integer value\n\n");
			}
		}
		input.close();
		
		
		
	}

}
