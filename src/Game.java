
public class Game {
	
	private Player player1;
	private Player player2;
	private Player activePlayer;
	
	private Tile[][] table;
	
	private int squareCount = 9;
	private int filled;
	
	private WinnerChecker winCheck;
	
	//konstruktor do tworzenia nowych graczy i sadzia na poczatku gry
	public Game()
	{
		player1 = new Player();
		player1.setName("X");
        player2 = new Player();
        player2.setName("O");
        
        winCheck = new WinnerChecker(this);
	}

	// Tworzy dwuch graczy i zaznacza jednego jako "player1"
	
	private void resetPlayers(){
		player1.setName("X");
        player2.setName("O");
        setActive(player1);
	}

	//Wyczyszcza tablice
	
	private void resetTable() {
        for (int i = 0, l = table.length; i < l; i++) {
            for (int j = 0, l2 = table[i].length; j < l2; j++) {
               table[i][j].isMarked();
            }
        }
        filled = 0;
    }

	// Zwraca wartosc table
	 public Tile[][] getTable() {
	        return table;
	 }
	 
	 // Ustawia wartosc activePlayer
	 private void setActive(Player player) {
	        activePlayer = player;
	 }
	 
	 // Zwraca wartosc activePlayer
	 public Player getActive() {
	        return activePlayer;
	 }
	 
	 // Sprawdza czy wybrana klatka jest zajęta
	 // Jerzeli klatka jest wolna ustawia odpowiednią figure
	 public boolean makeTurn(int x, int y) {
	        if (table[x][y].isMarked()){
	            return false;
	        }
	        table[x][y].setPlayer(getActive());
	        filled++;
	        switchPlayers();
	        return true;
	    }
	 
	 // Sprawdza który player jest aktywny i przepisuje wynik do activePlayer
	 public void switchPlayers() {
	        activePlayer = (activePlayer == player1) ? player2 : player1;
	    }

	 // Zwraca wartosc squareCount
	 public boolean isTableFilled() {
	        return squareCount == filled;
	    }
	 //metoda sluzaca do sprawdzania kto z graczy wygral albo czy jest remis i zwracajaca wartosc
	 //code, ktora bedzie odpowiedziana za odpowiednie pop-upy
	 public int check(){
		 int code=-1;
		 Player playCheck = winCheck.check();
		 if(playCheck == null)
			 code = 0;
		 if(playCheck.getName() == "X")
			 code = 1;
		 if(playCheck.getName() == "O")
			 code = 2;
		 return code;
	 }
	 
	 }
 

