// Game Name: Video Poker
// Programmer Name: Erin Hu
// Version Number: 

import arc.*;

public class cpt{
	public static void main(String[] args){
		// Console
		Console con = new Console();
		// Menu/Navigation Variables
		char chrMenu;
		String strName;
		// Gameplay Variables
		String strAllPositions;
		int intBet;
		int intDeck[][];
		int intPlayer[][];
		// Scoring Variables
		int intPrize;
		int intTotal;
		String strHighScore[][];
		// Menu Graphics
		con.println("TEMP: finish programming menu graphcis");
		con.println("TEMP: (p)lay, (h)elp, (v)iew high scores, (q)uit");
		// Menu Selection
		chrMenu = con.getChar();
		// If Statement: Menu Choice - Play
		if(chrMenu == 'p'){
			// Introduction: Username, Default Money, and Betting
			con.clear();
			con.println("TEMP: player selects play, start gameplay");
			con.println("What's your name?");
			strName = con.readLine();
			con.println("TEMP: default money is $1000");
			con.println("TEMP: how much money do you want to bet? You may only bet whole number values.");
			intBet = con.readInt();
			con.println("TEMP: name - "+strName+". bet - "+intBet);
			// Array Setup: Deck
			intDeck = new int[52][3];
			
		// Else If Statement: Menu Choice - Help
		}else if(chrMenu == 'h'){
			con.println("TEMP: player selects help, show help screen");
		// Else If Statement: Menu Choice - High Scores
		}else if(chrMenu == 'v'){
			con.println("TEMP: player selects view high scores, show leaderboard");
		// Else If Statement: Menu Choice - Quit
		}else if(chrMenu == 'q'){
			con.println("TEMP: player selects quit, close the game?");
		}
	}
	// Method: Graphics - Menu
	public static void menu(Console con){
	}
	// Method: Graphics - Gameplay - Card Selection
	public static void cardSelection(Console con){
	}
	// Method: Graphics - Gameplay - Card Replacement
	public static void cardReplacement(Console con){
	}
	// Method: Graphics - Gameplay - Lose Scenario
	public static void lose(Console con){
	}
	// Method: Graphics - Gameplay - Win Scenario
	public static void win(Console con){
	}
	// Method: Graphics - Help
	public static void help(Console con){
	}
	// Method: Graphics - Leaderboard
	public static void leaderboard(Console con){
	}
}
