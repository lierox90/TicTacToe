import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;


public class Game {
	
	private Player player1;
	private Player player2;
	private Player activePlayer;
	
	private List<ArrayList<Tile>> table;
	
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
        
        table = new ArrayList<ArrayList<Tile>>();
        for(int i=0;i<3;i++)
        {
        	table.add(new ArrayList<Tile>());
            for(int j=0;j<3;j++)
            {
            	table.get(i).add(new Tile());
            }
        }
        
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
        for (int i = 0, l = table.size(); i < l; i++) 
        {
            for (int j = 0, l2 = table.get(i).size(); j < l2; j++) 
            {
               table.get(i).get(j).clear();
            }
        }
        filled = 0;
    }

	// Zwraca wartosc tables
	 public List<ArrayList<Tile>> getTable() {
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
	        if (table.get(x).get(y).isMarked()){
	            return false;
	        }
	        table.get(x).get(y).setPlayer(getActive());
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
		 if(!isTableFilled())
			 code = -1;
		 return code;
	 }
	 
	 }
 

