import arc.*;
import java.awt.image.BufferedImage;


public class cptmethods{
	// Main
	public static void main(String[] args){
		Console con = new Console();
	}
	// Menu
	public static void menu(Console con){
		BufferedImage imgMenu = con.loadImage("Menu.jpg");
		con.drawImage(imgMenu, 0, 0);
	}
	// Load Leaderboard
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
	// Sort Scores
	public static String[][] sortScores(String strHighScores[][], int intCount){
		int intBelow;
		int intCurrent;
		int intCounter;
		int intCounter2;
		String strTemp;
		for(intCounter2 = 0; intCounter2 < intCount-1; intCounter2++){
			for(intCounter = 0; intCounter < intCount-intCounter2-1; intCounter++){ 
				intBelow = Integer.parseInt(strHighScores[intCounter+1][2]);
				intCurrent = Integer.parseInt(strHighScores[intCounter][2]);
				if(intBelow > intCurrent){
					strTemp = strHighScores[intCounter+1][2];
					strHighScores[intCounter+1][2] = strHighScores[intCounter][2];
					strHighScores[intCounter][2] = strTemp;
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
	// Print Scores
	public static void printScore(String HighScores, int intCount, Console con){
		int intRow;
		for(intRow = 0; intRow < intCount; intRow++){
		}
	}
}
