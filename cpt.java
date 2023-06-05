// Game Name: Video Poker
// Programmer Name: Erin Hu
// Version Number: 0

import arc.*;

public class cpt{
	public static void main(String[] args){
		// Console
		Console con = new Console("Video Poker", 1280, 720);
		// Menu/Navigation Variables
		char chrMenu;
		String strName;
		// Gameplay Setup Variables
		int intRow = 0; // For deck
		int intHandRow;
		int intDeck[][] = new int[52][3];
		int intPlayer[][] = new int[5][2];
		// Gameplay Variables
		String strAllPositions;
		int intBet;
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
			TextInputFile txtDeck = new TextInputFile("fulldeck.txt");
			while(txtDeck.eof() == false){
				intDeck[intRow][0] = txtDeck.readInt();
				intDeck[intRow][1] = txtDeck.readInt();
				intDeck[intRow][2] = txtDeck.readInt();
				intRow = intRow + 1;
			}
			txtDeck.close();
			// Shuffle Deck: Bubble Sort
				// Notes:
			int intCounter; // Counts Cards in Deck
			int intTemp; // Temp Variable
			int intBelow;
			int intCurrent;
			for(intCounter = 0; intCounter <= ; intCounter++){ 
				intBelow = intDeck[intCounter + 1][2];
				intCurrent = intDeck[intCounter][2];
				if(intBelow > intCurrent){
					// 
					intTemp = intDeck[intCounter + 1][2];
					intDeck[intCounter + 1][2] = intDeck[intRow][2];
					intDeck[intCounter][2] = intTemp;
					//
					intTemp = intDeck[intCounter+1][1];
					intDeck[intCounter+1][1] = intDeck[intCounter][1];
					intDeck[intCounter][1] = intTemp;
					//
					intTemp = intDeck[intCounter+1][0];
					intDeck[intCounter+1][0] = intDeck[intCounter][0];
					intDeck[intCounter][0] = intTemp;
				}
			}
			// Test Printing
			TextOutputFile txtTest = new TextOutputFile("decktest.txt");
			for(intCounter = 0; intCounter <= 51; intCounter++){ 
				txtTest.println(intDeck[intCounter][0]);
				txtTest.println(intDeck[intCounter][1]);
				txtTest.println(intDeck[intCounter][2]);
			}
			// Array Setup: Player's Hand
				//intRow = 
			for(intHandRow = 0; intHandRow < 5; intHandRow++){
				intPlayer[intHandRow][0] = 0; // Card Value
				intPlayer[intHandRow][1] = 0; // Card Suit
			}
			// Player's Hand: Get Cards from Deck
			// Player Enters Replacement Cards
			// Grab New Cards, Swap Player's Cards
			// Calculate Prize Money
			// Add Prize to Player's Total Money
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
	// Method: Shuffle Deck
}
