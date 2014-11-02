
public class Game {
	
	private Player player1;
	private Player player2;
	private Player activePlayer;
	
	private Tile[][] table;
	
	private int squareCount=9;
	private int filled;
	
	private WinnerChecker winCheck;

	// Tworzy dwuch graczy i zaznacza jednego jako "player1"
	
	private void resetPlayers(){
		player1 = new Player("X");
        player2 = new Player("O");
        setActive(player1);
	}

	//Wyczyszcza tablice
	
	private void resetTable() {
        for (int i = 0, l = table.length; i < l; i++) {
            for (int j = 0, l2 = table[i].length; j < l2; j++) {
                table[i][j].fill(null);
            }
        }
        filled = 0;
    }

	// Zwraca wartość table
	 public Tile[][] getTable() {
	        return table;
	 }
	 
	 // Ustawia wartość activePlayer
	 private void setActive(Player player) {
	        activePlayer = player;
	 }
	 
	 // Zwraca wartość activePlayer
	 public Player getActive() {
	        return activePlayer;
	 }
	 
	 // Sprawdza czy wybrana klatka jest zajęta
	 // Jerzeli klatka jest wolna ustawia odpowiednią figure
	 public boolean makeTurn(int x, int y) {
	        if (table[x][y].isTableFilled{
	            return false;
	        }
	        table[x][y].fill(getActive());
	        filled++;
	        switchPlayers();
	        return true;
	    }
	 
	 // Sprawdza który player jest aktywny i przepisuje wynik do activePlayer
	 public void switchPlayers() {
	        activePlayer = (activePlayer == player1) ? player2 : player1;
	    }

	 // Zwraca wartość squareCount
	 public boolean isTableFilled() {
	        return squareCount == filled;
	    }
	 
	 public int check(){
		 
	 
		 
	 }
 
}
