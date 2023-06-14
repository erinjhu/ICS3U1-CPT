import arc.*;

public class prizetest{
	public static void main(String[] args){
		Console con = new Console();
		
		int intPlayer[][] = new int[5][2];
		int intPrize;
		int intCount;
		int intRow;
		int intTestCount;
		
		/*for(intCount = 0; intCount < 5; intCount++){
			con.println("Card #"+intCount);
			con.println("Value: ");
			intPlayer[intCount][0] = con.readInt();
			con.println("Suit");
			intPlayer[intCount][1] = con.readInt();
		}*/
		
		// Read from file
		TextInputFile txtDeck = new TextInputFile("prizetest.txt");
		for(intRow = 0; intRow < 5; intRow++){
			intPlayer[intRow][0] = txtDeck.readInt();
			intPlayer[intRow][1] = txtDeck.readInt();
			System.out.println("intRow: "+intRow+"	Value: "+intPlayer[intRow][0]+"	Suit: "+intPlayer[intRow][1]);
		}
		txtDeck.close();
		// Sort
		intPlayer = cpt2.sortHand(intPlayer); 

		// Print
		System.out.println("Sorted");
		for(intRow = 0; intRow < 5; intRow++){
			System.out.println("intRow: "+intRow+"	Value: "+intPlayer[intRow][0]+"	Suit: "+intPlayer[intRow][1]);
		}
		
		intPrize = cpt2.prize(intPlayer);
	
		
		
	}
}
