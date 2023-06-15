import arc.*;

public class menutest{
	public static void main(String[] args){
		Console con = new Console();
		char chrMenu = 'p';
		char chrStart = 's';
		char chrPlay = 'y';
		while(chrMenu == 'p' || chrMenu == 'v' || chrMenu == 'h'){
			con.println("p, v, h, q?");
			chrMenu = con.getChar();
			System.out.println("chrMenu: "+chrMenu);
			if(chrMenu == 'p'){
				while(chrPlay == 'y'){
					con.println("gameplay \n play again? n or y");
					chrPlay = con.getChar();
				}
				con.println("add player's name to leaderboard");
			}else if(chrMenu == 'v' || chrMenu == 'h'){
				chrPlay = 'n';
				while(chrPlay == 'n'){
					con.println("help/scores \n back to menu n or y");
					chrPlay = con.getChar();
				}
			}
		}
		con.println("quit");
	}
}
