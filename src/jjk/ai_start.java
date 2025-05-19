package jjk;
import java.io.*;
import java.util.*;
public class ai_start {
	public void ai_game_start() {
		Scanner input=new Scanner(System.in);
		
		Scanner Fileio;
		System.out.println("\n\nhello! this jujutsu kaisen styled card game is a turn based game that involves strategy, a bit of luck, and teambuilding skills to play\""
				+". \nwould you like a tutorial?(Y/N)\n\n");
		char c;
		while(true) {
			c=input.next().charAt(0);
			if(c=='y'||c=='Y'||c=='N'||c=='n') {
				break;
			}
			else {
				System.out.println("not a valid argument");
			}
		}
		if(c=='Y'||c=='y') {
			System.out.println("great to see a new player!");
			System.out.println("this card game is kind of like pokemon showdown, but way more oversimplified, and jjk themed");
			System.out.println("you as a player get to pick 2 characters from the show, and use them to fight your opponent");
			System.out.println("each character has a certain amount of health, when a characters health goes down to 0, the player can no longer use that curse user");
			System.out.println("each character gets a certain amount of cursed energy to use, per battle");
			System.out.println("each character gets a choice of attacks to choose from, each dealing a different amount of damage, and using a different amount of cursed energy");
			System.out.println("p1 goes first, p2 goes second(if you are facing an A.I, the A.I is p2)");
			System.out.println("even though you have 2 characters, you can only use 1 at a time(so a singles battle basically)");
			System.out.println("however, you can swap out your characters that are in playd(albeit it will count as your turn)");
			System.out.println("before each turn, a roll of the dice(0.05%) is taken to determine if your character will activate black flash(only for some characters) if so, their damage will increase by 20%");
			System.out.println("each character also has a grade associated with them, only characters from the same grade can battle each other");
			//future string to be added when implementing maki
			//"(with the exception of maki, who i have coded to be a grade 2)"
		}
		curse_user[] c0= {new gojo(),new sukuna(),new geto(),new jogo(),new hanami(),new mahito()};
		//array of special grade curse users, player(s) choose from this array
		System.out.println("\n\nselect your grade, player\n\n");
		int b=input.nextInt();
		System.out.println("\n\nselect your curse users player!, the one you pick first will go out first in battle\n\n");
		//this loop displays character info
		for(int i=0;i<c0.length;i++) {
			
			
			System.out.println("\n\npress "+(i+1)+" for "+c0[i]+"\n\n");
			try {
				Fileio=new Scanner(c0[i].getFile());
				while(Fileio.hasNextLine()) {
					System.out.println(Fileio.nextLine());
				}
				
			}catch(FileNotFoundException e) {
				System.out.println("\n\nfailed to load character picture\n\n");
				e.printStackTrace();
			}
			
		}
		int x=input.nextInt();
		int y=input.nextInt();
		System.out.println("\n\nA.I's turn!\n\n");
		
		//range for chars 
		int z=(int)((Math.random()*7)+1);
		int a=(int)((Math.random()*7)+1);
		player p1=null;
		player p2=null;
		//this is where both players choose their curses, x and y are for p1, z and a are for p2
		switch(b) {
		case 0:
			//the 1 at the end of the constructer states that the current curse will be set to the first curses chosen
			p1=new player(createFromExisting(c0[x-1]),createFromExisting(c0[y-1]),true,1);
			p2=new player(createFromExisting(c0[z-1]),createFromExisting(c0[a-1]),false,1);
			break;
		default: System.out.println("\n\nplease pick a valid grade\n");
		//other cases are for curse users who are not special grade(grade 0)	
		}
		
		ai_game game=new ai_game();
		game.game_start(p1, p2);
		input.close();
		
		
	}
	//returns a new object of the character, to prevent one object from being the focus
	private static curse_user createFromExisting(curse_user original) {
	    try {
	        
	        return (curse_user) original.getClass().getDeclaredConstructor().newInstance();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to create character instance", e);
	    }
	}
}
