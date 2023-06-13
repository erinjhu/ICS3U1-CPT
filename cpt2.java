// Game Name: Video Poker
// Programmer Name: Erin Hu
// Version Number: 0

// Notes: different from original version because strSwap is an array
// images in folder: images/filename

import arc.*;

public class cpt2{
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
		String strSwap[] = new String[5];
		String strSwap1 = "";
		String strSwap2 = "";
		String strSwap3 = "";
		String strSwap4 = "";
		String strSwap5 = "";
		int intBet;
		int intTestCount;
		int intRemoved; // Remove Player's Cards from Deck
		int intSwapCount; // Count Variable for For Loop
		int intSwap[] = new int[5];
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
			TextInputFile txtDeck = new TextInputFile("deckstart.txt");
			System.out.println("Starting Deck, Unshuffled");
			for(intRow = 0; intRow < 52; intRow++){
				intDeck[intRow][0] = txtDeck.readInt();
				intDeck[intRow][1] = txtDeck.readInt();
				intDeck[intRow][2] = (int)(Math.random()*100+1);
				System.out.println("intRow: "+intRow+"	Value: "+intDeck[intRow][0]+"	Suit: "+intDeck[intRow][1]+"	Rand: "+intDeck[intRow][2]);
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
			System.out.println("Shuffled Deck");
			for(intCounter = 0; intCounter <= 51; intCounter++){ 
				System.out.println("Value: "+intDeck[intCounter][0]+"	Suit: "+intDeck[intCounter][1]+"	Rand: "+intDeck[intCounter][2]);
			}
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
			System.out.println("strAllPositions: "+strAllPositions);
			intLength = strAllPositions.length();
			if(!strAllPositions.equals("-1")){
				if(intLength == 1){
					strSwap[0] = strAllPositions.substring(0,1);
					for(intSwapCount = 0; intSwapCount <= 4; intSwapCount++){
						strSwap[intSwapCount] = "-1";
					}
				}else if(intLength == 3){
					strSwap[0] = strAllPositions.substring(0,1);
					strSwap[1] = strAllPositions.substring(2,3); 
					con.println(strSwap2);
					for(intSwapCount = 2; intSwapCount <= 4; intSwapCount++){
						strSwap[intSwapCount] = "-1";
					}
				}else if(intLength == 5){
					strSwap[0] = strAllPositions.substring(0,1);
					strSwap[1] = strAllPositions.substring(2,3); 
					strSwap[2] = strAllPositions.substring(4,5);
					for(intSwapCount = 3; intSwapCount <= 4; intSwapCount++){
						strSwap[intSwapCount] = "-1";
					}
				}else if(intLength == 7){
					strSwap[0] = strAllPositions.substring(0,1);
					strSwap[1] = strAllPositions.substring(2,3); 
					strSwap[2] = strAllPositions.substring(4,5);
					strSwap[3] = strAllPositions.substring(6,7);
					strSwap[4] = "-1";
				}else if(intLength == 9){
					strSwap[0] = strAllPositions.substring(0,1);
					strSwap[1] = strAllPositions.substring(2,3); 
					strSwap[2] = strAllPositions.substring(4,5);
					strSwap[3] = strAllPositions.substring(6,7);
					strSwap[4] = strAllPositions.substring(8,9);				
				}
				// Test Printing: Player's Hand
				System.out.println("Card #'s to Swap");
				for(intSwapCount = 0; intSwapCount <= 4; intSwapCount++){
					System.out.println("strSwap["+intSwapCount+"]: "+strSwap[intSwapCount]);
				}
				System.out.println("Player's Current Hand");
				for(intTestCount = 0; intTestCount < 5; intTestCount++){
						System.out.println("Position: "+intTestCount+"	Value: "+(intPlayer[intTestCount][0])+"	Suit: "+(intPlayer[intTestCount][1]));
				}
				// Remove Player's Cards from Deck
				System.out.println("Deck After Removed Cards");
				for(intRemoved = 0; intRemoved <= 51; intRemoved++){
					if(intRemoved <= 46){
						// Card Shift Up
						intDeck[intRemoved][0] = intDeck[intRemoved + 5][0];
						intDeck[intRemoved][1] = intDeck[intRemoved + 5][1];
						intDeck[intRemoved][2] = intDeck[intRemoved + 5][2];
						System.out.println("Count: "+intRemoved+ "Value: "+intDeck[intRemoved][0]+"	Suit: "+intDeck[intRemoved][1]+"	Rand: "+intDeck[intRemoved][2]);
					}
					// NOTE: make bottom 5 cards represent no value
				}
				// Test Printing: Cards to Swap
				con.println("Cards to Swap: "+strSwap1+strSwap2+strSwap3+strSwap4+strSwap5);
				// Change strSwap Variables to Integers
				for(intSwapCount = 0; intSwapCount <= 4; intSwapCount++){
					intSwap[intSwapCount] = Integer.parseInt(strSwap[intSwapCount]);
					System.out.println("intSwap["+intSwapCount+"] = "+intSwap[intSwapCount]);
				}
				// Swap Player's Cards
				System.out.println("Swapped Cards");
				for(intSwapCount = 0; intSwapCount <= 4; intSwapCount++){
					if(intSwap[intSwapCount] > -1){
						intPlayer[intSwap[intSwapCount]][0] = intDeck[intSwapCount][0];
						intPlayer[intSwap[intSwapCount]][1] = intDeck[intSwapCount][1];
						System.out.println("Card #"+intSwapCount+"	Value: "+(intPlayer[intSwapCount][0])+"	Suite: "+(intPlayer[intSwapCount][1]));
					}
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
	}
}
