// Game Name: Video Poker
// Programmer Name: Erin Hu
// Version Number: 12

import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class finalcpt{
	public static void main(String[] args){
	
		// Variables
		
		Console con = new Console("Video Poker", 1280, 720);
		int intPage = 10;
		// Loop
		String strName = "";
		char chrMenu = 'o';
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
		char chrPlay = 'y';
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
		String strSuit = "";
		int intCount;
		int intLength;
		String strValue = "";
		// Scoring Variables
		int intPrize;
		int intTotal = 1000;
		int intPrizeMoney;
		int intLines;
		String strHighScores[][];	
		intPage = 0;
		
		// Game Loop
		
		while(intPage >= -1){
			
			// Page 0 - Menu
			while(intPage == 0){
				con.clear();
				BufferedImage imgMenu = con.loadImage("Menu.jpg");
				con.drawImage(imgMenu, 0, 0);
				con.repaint();
				chrMenu = con.getChar();
				if(chrMenu == 'p'){
					intPage = 1;
				}else if(chrMenu == 'h'){
					intPage = 3;
				}else if(chrMenu == 'v'){
					intPage = 4;
				}else if(chrMenu == 'q'){
					intPage = 5;
				}
			}
			
			// Page 1 - Name and Start
			while(intPage == 1){
				background(con);
				con.println("\n\n\n\n\n\n\n                       What's your name?");
				con.print("                       ");
				strName = con.readLine();
				intTotal = 1000;
				intPage = 2;
			}
			
			// Page 2 - Gameplay
			while(intPage == 2){
				// Betting Money
				con.clear();
				background(con);
				con.println("\n                       Current money: $"+intTotal);
				con.println("\n                       How much money do you want to bet? \n                       You may only bet whole number values.\n                       You cannot bet more money than you have.\n");
				con.print("                       ");
				intBet = con.readInt();
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
				con.println("");
				for(intHandRow = 0; intHandRow < 5; intHandRow++){
					intPlayer[intHandRow][0] = intDeck[intHandRow][0]; // Card Value
					intPlayer[intHandRow][1] = intDeck[intHandRow][1]; // Card Suit
					System.out.println("Card #"+intHandRow+" Value: "+(intPlayer[intHandRow][0])+"	Suit: "+(intPlayer[intHandRow][1]));
				}
				// Console Printing: Player's Starting Hand
				con.clear();
				con.setDrawColor(new Color(102, 102, 102));
				con.fillRect(171, 25, 853, 191);
				con.println("\n						Player's Hand\n");
				for(intTestCount = 0; intTestCount < 5; intTestCount++){
					if(intPlayer[intTestCount][1] == 0){
						strSuit = "Diamonds";
					}else if(intPlayer[intTestCount][1] == 1){
						strSuit = "Clubs";
					}else if(intPlayer[intTestCount][1] == 2){
						strSuit = "Hearts";
					}else{
						strSuit = "Spades";
					}
					strValue = intPlayer[intTestCount][0] + "";
					if(intPlayer[intTestCount][0] == 11){
						strValue = "Jack";
					}else if(intPlayer[intTestCount][0] == 12){
						strValue = "Queen";
					}else if(intPlayer[intTestCount][0] == 13){
						strValue = "King";
					}
					con.println("		Card # "+intTestCount+"		Value: "+strValue+"		Suit: "+strSuit);

				}
				// Card Replacement
				con.println("\nEnter the card # for card(s) to replace. If you want to keep all your cards, enter \"-1.\"\nFor multiple cards, put a space between each number.\nExample: 0 1 3");
				strAllPositions = con.readLine();
				System.out.println("strAllPositions: "+strAllPositions);
				intLength = strAllPositions.length();
				if(!strAllPositions.equals("-1")){
					if(intLength == 1){
						strSwap[0] = strAllPositions.substring(0,1);
						for(intSwapCount = 1; intSwapCount <= 4; intSwapCount++){
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
					System.out.println("Player's Current Hand");
					for(intTestCount = 0; intTestCount < 5; intTestCount++){
						System.out.println("Position: "+intTestCount+"	Value: "+(intPlayer[intTestCount][0])+"	Suit: "+(intPlayer[intTestCount][1]));
					}
				}else{
					for(intSwapCount = 0; intSwapCount <= 4; intSwapCount++){
						strSwap[intSwapCount] = "-1";
					}
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
				// Check for any values that are outside of -1 to 4
				//for(intCount = 0; intCount < 5; intCount++){
					//if(intSwap[intCount] < -1 || intSwap[intCount] > 4){
						
					//}
				//}
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
				// Console Printing: Player's Replaced Hand
				con.println("						Player's New Hand\n");
				con.setDrawColor(new Color(102, 102, 102));
				con.fillRect(171, 310, 853, 191);
				for(intTestCount = 0; intTestCount < 5; intTestCount++){
					if(intPlayer[intTestCount][1] == 0){
						strSuit = "Diamonds";
					}else if(intPlayer[intTestCount][1] == 1){
						strSuit = "Clubs";
					}else if(intPlayer[intTestCount][1] == 2){
						strSuit = "Hearts";
					}else{
						strSuit = "Spades";
					}
					strValue = intPlayer[intTestCount][0] + "";
					if(intPlayer[intTestCount][0] == 11){
						strValue = "Jack";
					}else if(intPlayer[intTestCount][0] == 12){
						strValue = "Queen";
					}else if(intPlayer[intTestCount][0] == 13){
						strValue = "King";
					}
					
					con.println("		Card # "+intTestCount+"		Value: "+strValue+"		Suit: "+strSuit);
				}
				// Bubble Sort Player's Hand
				intPlayer = sortHand(intPlayer); 
				System.out.println("Player's New Hand, Sorted");
				for(intTestCount = 0; intTestCount < 5; intTestCount++){
					System.out.println("Card # "+intTestCount+"	Value: "+(intPlayer[intTestCount][0])+".	Suit: "+(intPlayer[intTestCount][1]));
				}
				// Calculate Prize Money
				System.out.println("Total Before Win/Loss: "+intTotal);
				intPrize = prize(intPlayer);
				System.out.println("Prize #: "+intPrize);
				intPrizeMoney = intPrize * intBet;
				System.out.println("Prize #"+intPrize+" * $"+intBet+" bet = "+intPrizeMoney);
				// Add or Subtract from Player's Total
				if(intPrize > 0){
					System.out.println("Player's Winnings: "+intPrizeMoney);
					con.println("\nYou won $"+intPrizeMoney);
					intTotal = intTotal + intPrizeMoney;
				}else if(intPrizeMoney == 0){
					intTotal = intTotal - intBet;
					con.println("\nYou lost: $"+intBet);
				}
				// Total
				con.println("Total: $"+intTotal);
				System.out.println("Player's total (including money gained/lost): "+intTotal);
				con.println("\nPlay again? (y)es or (n)o?");
				chrPlay = con.getChar();
				System.out.println("Play again? "+chrPlay);
				if(chrPlay != 'y'){
					while(chrPlay != 'y' && chrPlay != 'n'){
						chrPlay = con.getChar();
					}
					if(chrPlay == 'n'){
					TextOutputFile txtScores = new TextOutputFile("highscores.txt", true);
					txtScores.println(strName);
					txtScores.println(intTotal);
					System.out.println("Printed to leaderboard: \nName: "+strName+"	Score: $"+intTotal);
					con.repaint();
					con.clear();
					intPage = 4;
					}
				}
			}
			
			// Page 3 - Help
			while(intPage == 3){
				background(con);
				con.println("OBJECTIVE\nBet to win money");
				con.println("\nHOW TO PLAY\n1. Decide which cards you want to swap\n2a. Enter the card numbers, with a space between each one.\n2b. If you want to keep all your cards, enter -1");
				con.println("3. Your winnings will be determined based on your card combinations");
				con.println("\nYour winnings will be the prize number multiplied by the money you bet.\nIf you don't win, you lose the money you bet.\n");
				BufferedImage imgPrize = con.loadImage("Prize Numbers.jpg");
				BufferedImage imgHands = con.loadImage("Hands.png");
				con.drawImage(imgPrize,960,30);
				con.drawImage(imgHands,40,370);
				con.println("\nPress 'm' to return to menu.");
				chrMenu = con.getChar();
				if(chrMenu == 'm'){
					intPage = 0;
				}
			}
			
			// Page 4 - High Scores
			while(intPage == 4){
				background(con);
				// Find Number of Scores
				intLines = countScores();
				System.out.println("Lines: "+intLines);
				// Read Scores Into Array
				strHighScores = loadScores(intLines);
				// Sort Scores
				strHighScores = sortScores(strHighScores, intLines);
				// Print Array to Screen
				con.println("Leaderboard\n");
				printScores(strHighScores, con);
				// Navigation
				con.println("\nPress 'm' to return to menu.");
				while(chrMenu != 'm'){
					chrMenu = con.getChar();
					System.out.println("Menu navigation: "+chrMenu);
					if(chrMenu == 'm'){
						intPage = 0;
						System.out.println("Next page: "+intPage);
					}
				}
			}
			
			// Page 5 - Quit
			while(intPage == 5){
				con.closeConsole();
			}		
		}	
	}
	
	// Methods
	// Menu Graphics
	public static void menu(Console con){
		BufferedImage imgMenu = con.loadImage("Menu.jpg");
		con.drawImage(imgMenu, 0, 0);
		con.repaint();
	}
	// Background Graphics
	public static void background(Console con){
		BufferedImage imgMenu = con.loadImage("Background.png");
		con.drawImage(imgMenu, 0, 0);
	}
	// Prize Calculation
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
			if(intPlayer[0][0] == intPlayer[1][0] && intPlayer[2][0] == intPlayer[3][0] && intPlayer[0][0] != intPlayer[4][0]){
				intPrize = 2;
				System.out.println("2P Prize: "+intPrize);
			}else if(intPlayer[1][0] == intPlayer[2][0] && intPlayer[3][0] == intPlayer[4][0] && intPlayer[2][0] != intPlayer[3][0]){
				intPrize = 2;
				System.out.println("2P Prize: "+intPrize);
			}else if(intPlayer[0][0] == intPlayer[1][0] && intPlayer[3][0] == intPlayer[4][0]){
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
			intAdjacent = 0;
			for(intCount = 0; intCount <= 3; intCount++){
				if(intPlayer[intCount][0] == (intPlayer[intCount + 1][0] - 1)){
					intAdjacent = intAdjacent + 1;
					System.out.println("Consecutive cards: "+intAdjacent);
				}else if(intPlayer[intCount][0] == 1 && intPlayer[intCount + 1][0] == 10){ // Example: 1, 10, 11, 12, 13
					intAdjacent = intAdjacent + 1;
					System.out.println("Consecutive cards: "+intAdjacent);
				}else if(intPlayer[intCount][0] == 2 && intPlayer[intCount + 1][0] == 11){ // Example: 1, 2, 11, 12, 13
					intAdjacent = intAdjacent + 1;
					System.out.println("Consecutive cards: "+intAdjacent);
				}else if(intPlayer[intCount][0] == 3 && intPlayer[intCount + 1][0] == 12){ // Example: 1, 2, 3, 12, 13
					intAdjacent = intAdjacent + 1;
					System.out.println("Consecutive cards: "+intAdjacent);
				}else if(intPlayer[intCount][0] == 4 && intPlayer[intCount + 1][0] == 13){ // Example: 1, 2, 3, 4, 13
					intAdjacent = intAdjacent + 1;
					System.out.println("Consecutive cards: "+intAdjacent);
				}
			}
			if(intAdjacent == 4){
				intPrize = 4;
				System.out.println("S Prize: "+intPrize);
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
	// Count Scores
	public static int countScores(){
		TextInputFile txtScores = new TextInputFile("highscores.txt");
		int intLines = 0;
		String strData;
		while(txtScores.eof() == false){
			strData = txtScores.readLine();
			intLines++;
		}
		txtScores.close();
		return intLines/2;
	}
	// Read high score text into array
	public static String[][] loadScores(int intCount){
		String strScore[][] = new String[intCount][2];
		TextInputFile txtScores = new TextInputFile("highscores.txt");		
		int intRow;
		for(intRow = 0; intRow < intCount; intRow++){
			strScore[intRow][0] = txtScores.readLine();
			strScore[intRow][1] = txtScores.readLine();
		}
		txtScores.close();
		return strScore;
	}
	// Bubble Sorting Scores
	public static String[][] sortScores(String strHighScores[][], int intCount){
		int intBelow;
		int intCurrent;
		int intCounter;
		int intCounter2;
		String strTemp;
		for(intCounter2 = 0; intCounter2 < intCount-1; intCounter2++){
			for(intCounter = 0; intCounter < intCount-intCounter2-1; intCounter++){ 
				intBelow = Integer.parseInt(strHighScores[intCounter+1][1]);
				intCurrent = Integer.parseInt(strHighScores[intCounter][1]);
				if(intBelow > intCurrent){
					strTemp = strHighScores[intCounter+1][1];
					strHighScores[intCounter+1][1] = strHighScores[intCounter][1];
					strHighScores[intCounter][1] = strTemp;
					strTemp = strHighScores[intCounter+1][0];
					strHighScores[intCounter+1][0] = strHighScores[intCounter][0];
					strHighScores[intCounter][0] = strTemp;
				}
			}
		}
		return strHighScores;
	}
	// Print High Scores
	public static void printScores(String strScores[][], Console con){
		int intRow;
		con.println(("Name                       ").substring(0, 20) + ("Score                  ").substring(0, 10));
		con.println("");
		for(intRow = 0; intRow < 10; intRow++){
			con.println((strScores[intRow][0] + "                               ").substring(0, 20) + strScores[intRow][1]);
		}
	}
	// Bubble Sorting Hand
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
}
