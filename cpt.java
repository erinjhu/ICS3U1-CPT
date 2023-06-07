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
		// Card Setup Variables
		int intRow = 0; 
		int intHandRow;
		int intDeck[][] = new int[52][3];
		int intPlayer[][] = new int[5][2];
		// Bubble Sort (Deck Shuffle) Variables
		int intCounter; 
		int intCounter2;
		int intTemp; 
		int intBelow;
		int intCurrent;
		// Gameplay Variables
		String strAllPositions;
		String strSwap1 = "";
		String strSwap2 = "";
		String strSwap3 = "";
		String strSwap4 = "";
		String strSwap5 = "";
		int intBet;
		int intTestCount;
		int intRemoved; // Remove Player's Cards from Deck
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
			TextInputFile txtDeck = new TextInputFile("deckwithoutrandom.txt");
			while(txtDeck.eof() == false){
				intDeck[intRow][0] = txtDeck.readInt();
				//con.println(intDeck[intRow][0]);
				intDeck[intRow][1] = txtDeck.readInt();
				//con.println(intDeck[intRow][1]);
				intDeck[intRow][2] = (int)(Math.random()*100+1);
				//con.println(intDeck[intRow][2]);
				intRow = intRow + 1;
				//con.sleep(500);
			}
			txtDeck.close();
			// Shuffle Deck: Bubble Sort
			for(intCounter2 = 0; intCounter2 < 52 - 1; intCounter2++){ 
				for(intCounter = 0; intCounter < 52 - intCounter2 - 1; intCounter++){
					intBelow = intDeck[intCounter + 1][2];
					intCurrent = intDeck[intCounter][2];
					if(intBelow < intCurrent){
						// Swap the random integer
						intTemp = intDeck[intCounter + 1][2];
						intDeck[intCounter + 1][2] = intDeck[intCounter][2];
						intDeck[intCounter][2] = intTemp;
						// Swap the suit
						intTemp = intDeck[intCounter+1][1];
						intDeck[intCounter+1][1] = intDeck[intCounter][1];
						intDeck[intCounter][1] = intTemp;
						// Swap the value
						intTemp = intDeck[intCounter+1][0];
						intDeck[intCounter+1][0] = intDeck[intCounter][0];
						intDeck[intCounter][0] = intTemp;
					}
				}
			}
			// Test Printing: Shuffled Deck
			TextOutputFile txtTest = new TextOutputFile("decktest.txt");
			for(intCounter = 0; intCounter <= 51; intCounter++){ 
				txtTest.println(intDeck[intCounter][0]);
				txtTest.println(intDeck[intCounter][1]);
				txtTest.println(intDeck[intCounter][2]);
			}
			txtTest.close();
			// Array Setup: Player's Hand
			for(intHandRow = 0; intHandRow < 5; intHandRow++){
				intPlayer[intHandRow][0] = intDeck[intHandRow][0]; // Card Value
				intPlayer[intHandRow][1] = intDeck[intHandRow][1]; // Card Suit
				con.println("Card #"+intHandRow+". Value: "+(intPlayer[intHandRow][0])+".	Suite: "+(intPlayer[intHandRow][1]));
			}
			// Player Enters Replacement Cards
			
			/*strSwap1 = substring.strAllPositions(0,1);
			strSwap2 = substring.strAllPositions(0,1);
			strSwap3 = substring.strAllPositions(0,1);
			strSwap4 = substring.strAllPositions(0,1);
			strSwap5 = substring.strAllPositions(0,1); */
			// Planning Notes
				// Example: 0 1 2 3 4
						 //0123456789
						 // 0 -> 0,1   2 total 1
						 // 1 -> 2,3   4 total 3
						 // 2 -> 4,5   6 total 5
						 // 3 -> 6,7   8 total 7
				// Enter entire string
				// Find string length
				// Loop. Count variable is (length/2); shows number of card positions needed
				// Alternative to loop: if statements; easier to program
				// Substring. Index numbers are (length - 2), (length - 1); takes out individual card position
				
			// Variables (move to top after)
			int intLength;
			con.println("Enter cards to replace.");
			strAllPositions = con.readLine();
			intLength = strAllPositions.length();
			if(!strAllPositions.equals("-1")){
				if(intLength == 1){
					strSwap1 = strAllPositions.substring(0,1);
				}else if(intLength == 3){
					strSwap1 = strAllPositions.substring(0,1);
					strSwap2 = strAllPositions.substring(2,3); 
					con.println(strSwap2);
				}else if(intLength == 5){
					strSwap1 = strAllPositions.substring(0,1);
					strSwap2 = strAllPositions.substring(2,3); 
					strSwap3 = strAllPositions.substring(4,5);
				}else if(intLength == 7){
					strSwap1 = strAllPositions.substring(0,1);
					strSwap2 = strAllPositions.substring(2,3); 
					strSwap3 = strAllPositions.substring(4,5);
					strSwap4 = strAllPositions.substring(6,7);
				}else if(intLength == 9){
					strSwap1 = strAllPositions.substring(0,1);
					strSwap2 = strAllPositions.substring(2,3); 
					strSwap3 = strAllPositions.substring(4,5);
					strSwap4 = strAllPositions.substring(6,7);
					strSwap5 = strAllPositions.substring(8,9);
				}
			}
			// Test Printing: Player's Hand
			con.println("strSwap1: "+strSwap1);
			con.println("strSwap2: "+strSwap2);
			con.println("strSwap3: "+strSwap3);
			con.println("strSwap4: "+strSwap4);
			con.println("strSwap5: "+strSwap5);
			con.println("Player's Hand");
			for(intTestCount = 0; intTestCount < 5; intTestCount++){
					con.println("Position: "+intTestCount+"	Value: "+(intPlayer[intTestCount][0])+".	Suit: "+(intPlayer[intTestCount][1]));
			}
			// Remove Player's Cards from Deck
			txtTest = new TextOutputFile("decktest.txt");			// Test
			for(intRemoved = 0; intRemoved <= 51; intRemoved++){
				if(intRemoved <= 46){
					// Cards Shift Up
					intDeck[intRemoved][0] = intDeck[intRemoved + 5][0];
					intDeck[intRemoved][1] = intDeck[intRemoved + 5][1];
					intDeck[intRemoved][2] = intDeck[intRemoved + 5][2];
					// Print New Deck to Text File
					txtTest.println(intDeck[intRemoved][0]);
					txtTest.println(intDeck[intRemoved][1]);
					txtTest.println(intDeck[intRemoved][2]);
				}
				
				
				// NOTE: make bottom 5 cards represent no value
			
			
			}
			txtTest.println("cards have been removed");		// Test
			txtTest.close();
			// Test Printing: Cards to Swap
			con.println("Cards to Swap: "+strSwap1+strSwap2+strSwap3+strSwap4+strSwap5);
			intPlayer[0][0] = intDeck[0][0]; // Value
			con.println("test"+intPlayer[0][0]);
			// Swap Player's Cards
			if(!strSwap1.equals("")){
				intPlayer[0][0] = intDeck[0][0]; // Value
				intPlayer[0][1] = intDeck[0][1]; // Suit
			}
			if(!strSwap2.equals("")){
				intPlayer[1][0] = intDeck[1][0]; // Value
				intPlayer[1][1] = intDeck[1][1]; // Suit
			}
			if(!strSwap3.equals("")){
				intPlayer[2][0] = intDeck[2][0]; // Value
				intPlayer[2][1] = intDeck[2][1]; // Suit
			}
			if(!strSwap4.equals("")){
				intPlayer[3][0] = intDeck[3][0]; // Value
				intPlayer[3][1] = intDeck[3][1]; // Suit
			}
			if(!strSwap5.equals("")){
				intPlayer[4][0] = intDeck[4][0]; // Value
				intPlayer[4][1] = intDeck[4][1]; // Suit
			}
			// Test Printing: Player's Replaced Hand
				// Card position	Value	Suit
				con.println("Player's New Hand");
				for(intTestCount = 0; intTestCount < 5; intTestCount++){
					con.println("Position: "+intTestCount+"	Value: "+(intPlayer[intTestCount][0])+".	Suit: "+(intPlayer[intTestCount][1]));
				}
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
