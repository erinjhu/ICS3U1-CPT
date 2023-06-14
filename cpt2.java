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
					}
					System.out.println("Count: "+intRemoved+ "	Value: "+intDeck[intRemoved][0]+"	Suit: "+intDeck[intRemoved][1]+"	Rand: "+intDeck[intRemoved][2]);
					// NOTE: make bottom 5 cards represent no value
				}
				// Change strSwap Variables to Integers
				for(intSwapCount = 0; intSwapCount <= 4; intSwapCount++){
					intSwap[intSwapCount] = Integer.parseInt(strSwap[intSwapCount]);
					System.out.println("intSwap["+intSwapCount+"] = "+intSwap[intSwapCount]);
				}
				// Swap Player's Cards
				System.out.println("Swapped Cards");
				for(intSwapCount = 0; intSwapCount <= 4; intSwapCount++){
					System.out.println("intSwap["+intSwapCount+"] = "+intSwap[intSwapCount]);
					if(intSwap[intSwapCount] > -1){
						intPlayer[intSwap[intSwapCount]][0] = intDeck[intSwapCount][0];
						intPlayer[intSwap[intSwapCount]][1] = intDeck[intSwapCount][1];
						System.out.println("Card #"+intSwap[intSwapCount]+"	Value: "+(intPlayer[intSwap[intSwapCount]][0])+"	Suite: "+(intPlayer[intSwap[intSwapCount]][1]));
					}
				}									
				// Test Printing: Player's Replaced Hand
					// Card position	Value	Suit
				con.println("Player's New Hand");
				for(intTestCount = 0; intTestCount < 5; intTestCount++){
					con.println("Card # "+intTestCount+"	Value: "+(intPlayer[intTestCount][0])+".	Suit: "+(intPlayer[intTestCount][1]));
				}
				// Bubble Sort Player's Hand
				intPlayer = sortHand(intPlayer); 
				System.out.println("Player's New Hand, Sorted");
				for(intTestCount = 0; intTestCount < 5; intTestCount++){
					System.out.println("Card # "+intTestCount+"	Value: "+(intPlayer[intTestCount][0])+".	Suit: "+(intPlayer[intTestCount][1]));
				}
				// Calculate Prize Money
				intPrize = prize(intPlayer);
				System.out.println("Final Prize: "+intPrize);
				// Add Prize to Player's Total Money
			// Else If Statement: Menu Choice - Help
			}			
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
	// Method: Bubble Sorting Deck
	public static int[][] sortDeck(int intDeck[][], int intCount){
		int intBelow;
		int intCurrent;
		int intCounter;
		int intCounter2;
		int intTemp;
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
		return intDeck;
	}
	// Method: Bubble Sorting Hand
	public static int[][] sortHand(int intHand[][]){
		int intBelow;
		int intCurrent;
		int intCounter;
		int intCounter2;
		int intTemp;
		for(intCounter2 = 0; intCounter2 < 5 - 1; intCounter2++){ 
			for(intCounter = 0; intCounter < 5 - intCounter2 - 1; intCounter++){
				intBelow = intHand[intCounter + 1][0]; // Sort based on card value
 				intCurrent = intHand[intCounter][0];
				if(intBelow < intCurrent){
					// Swap the suit
					intTemp = intHand[intCounter+1][1];
					intHand[intCounter+1][1] = intHand[intCounter][1];
					intHand[intCounter][1] = intTemp;
					// Swap the value
					intTemp = intHand[intCounter+1][0];
					intHand[intCounter+1][0] = intHand[intCounter][0];
					intHand[intCounter][0] = intTemp;
				}
			}
		}
		return intHand;
	}
	// Method: Prize Calculation
	public static int prize(int intPlayer[][]){
		int intPrize = 0;
		int intJacks = 0;
		int intQueens = 0;
		int intKings = 0;
		int intCount;
		int intAdjacent = 0;
		int intCheck = 0;
		int intCheck2 = 0; // For Straight
		int intCheck3 = 0; // For Flush
		int intCheck4 = 0; // For Royal Flush
		int intSuit = 0;
		boolean blnNoMatch = false;
		boolean blnSF = false; // Signifies if hand is a straight flush
		// Royal Flush
		if(intPrize == 0){
			// Reset check variables
			intAdjacent = 0;
			intCheck = 0;
			// Check for 1 (Ace)
			if(intPlayer[0][0] == 1){
				intCheck = 1;
			}
			// Check for 10-13 (10 to King)
			for(intCount = 1; intCount < 4; intCount++){
				if(intPlayer[intCount][0] == (intPlayer[intCount + 1][0] - 1)){
					intCheck = intCheck + 1;
				}
			}
			// If it is straight, check if the suits match
			if(intCheck == 4){
				for(intCount = 1; intCount <= 4; intCount++){
					if(intPlayer[0][1] == intPlayer[intCount][1]){
						intCheck = intCheck + 1;
					}else{
						intCheck = 0;
					}
				}
				// If it is a straight flush, check if it is royal
				if(intCheck == 8){
						intPrize = 800;
						System.out.println("RF A Prize: "+intPrize);
				}
			}
		}
		// Straight Flush
		if(intPrize == 0){
			// Check if it is a flush
			for(intCount = 0; intCount <= 3; intCount++){
				if(intPlayer[intCount][0] == (intPlayer[intCount + 1][0] - 1)){
					intAdjacent = intAdjacent + 1;
				}else if(intPlayer[intCount][0] == 13 && intPlayer[intCount + 1][0] == 1){
					intAdjacent = intAdjacent + 1;
				}
			}
			// If it is a flush, check if the suits match
			if(intAdjacent == 4){
				for(intCount = 1; intCount <= 4; intCount++){
					if(intPlayer[0][1] == intPlayer[intCount][1]){
						intCheck = intCheck + 1;
					}else{
						intCheck = 0;
					}
				}
				if(intCheck == 4){
					intPrize = 50;
					System.out.println("SF Prize: "+intPrize);
				}
			}
		}
		// Full House
		if(intPrize == 0){	
			if(intPlayer[0][0] == intPlayer[1][0] && intPlayer[0][0] == intPlayer[2][0] && intPlayer[3][0] == intPlayer[4][0]){
				intPrize = 9;
				System.out.println("FH Prize: "+intPrize);
			}else if(intPlayer[2][0] == intPlayer[3][0] && intPlayer[3][0] == intPlayer[4][0] && intPlayer[1][0] == intPlayer[2][0]){
				intPrize = 9;
				System.out.println("FH Prize: "+intPrize);
			}
		}
		// Two Pair
		if(intPrize == 0){
			if(intPlayer[0][0] == intPlayer[1][0] && intPlayer[2][0] == intPlayer[3][0] && intPlayer[0][0] != intPlayer[1][0]){
				intPrize = 2;
				System.out.println("2P Prize: "+intPrize);
			}else if(intPlayer[1][0] == intPlayer[2][0] && intPlayer[3][0] == intPlayer[4][0] && intPlayer[2][0] != intPlayer[3][0]){
				intPrize = 2;
				System.out.println("2P Prize: "+intPrize);
			}
		}
		// Jacks or Better
		if(intPrize == 0){
			for(intCount = 0; intCount < 5; intCount++){
				if(intPlayer[intCount][0] == 11){
					intJacks = intJacks + 1;
				}else if(intPlayer[intCount][0] == 12){
					intQueens = intQueens + 1;
				}else if(intPlayer[intCount][0] == 13){
					intKings = intKings + 1;
				}
			}
			if(intJacks == 2 || intQueens == 2 || intKings == 2){
				intPrize = 1;
				System.out.println("JoB Prize: "+intPrize);
			}
		}
		// Three of a Kind
		if(intPrize == 0){	
			if(intPlayer[0][0] == intPlayer[1][0] && intPlayer[0][0] == intPlayer[2][0] && intPlayer[0][0] != intPlayer[3][0] && intPlayer[0][0] != intPlayer[4][0]){
				intPrize = 3;
				System.out.println("3K Prize: "+intPrize);
			}else if(intPlayer[1][0] == intPlayer[2][0] && intPlayer[1][0] == intPlayer[3][0] && intPlayer[1][0] != intPlayer[0][0] && intPlayer[1][0] != intPlayer[4][0]){
				intPrize = 3;
				System.out.println("3K Prize: "+intPrize);
			}else if(intPlayer[2][0] == intPlayer[3][0] && intPlayer[3][0] == intPlayer[4][0] && intPlayer[1][0] != intPlayer[2][0] && intPlayer[0][0] != intPlayer[2][0]){
				intPrize = 3;
				System.out.println("3K Prize: "+intPrize);
			}
		}
		// Straight
		if(intPrize == 0){
			for(intCount = 0; intCount <= 3; intCount++){
				if(intPlayer[intCount][0] == (intPlayer[intCount + 1][0] - 1)){
					intAdjacent = intAdjacent + 1;
				}else if(intPlayer[intCount][0] == 13 && intPlayer[intCount + 1][0] == 1){
					intAdjacent = intAdjacent + 1;
				}
			}
			// Ensure that straight is not a straight flush
			intCheck2 = 0;
			if(intAdjacent == 4){
				intSuit = (intPlayer[0][1] + intPlayer[1][1] + intPlayer[2][1] + intPlayer[3][1] + intPlayer[4][1]) / 5;
				// If any of the suits are different from the average, that means it is not a flush
				for(intCount = 0; intCount <= 4; intCount++){
					if(intPlayer[intCount][1] != intSuit){
						intCheck2 = intCheck2 + 1;
					}
				}
				if(intCheck2 != 0){
						intPrize = 4;
						System.out.println("S Prize: "+intPrize);
				}
			}
		}
		// Flush
		if(intPrize == 0){
			for(intCount = 1; intCount <= 4; intCount++){
				if(intPlayer[0][1] == intPlayer[intCount][1]){
					intCheck3 = intCheck3 + 1;
				}
			}
			if(intCheck3 == 4){
				intPrize = 6;
				System.out.println("F Prize: "+intPrize);
			}
		}
		// Four of a Kind
		if(intPrize == 0){	
			if(intPlayer[0][0] == intPlayer[1][0] && intPlayer[0][0] == intPlayer[2][0] && intPlayer[0][0] == intPlayer[3][0]){
				intPrize = 25;
				System.out.println("4K Prize: "+intPrize);
			}else if(intPlayer[1][0] == intPlayer[2][0] && intPlayer[1][0] == intPlayer[3][0] && intPlayer[1][0] == intPlayer[4][0]){
				intPrize = 25;
				System.out.println("4K Prize: "+intPrize);
			}
		}
		
			return intPrize;
		}
	}



