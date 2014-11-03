import java.util.ArrayList;
import java.util.List;


public class WinnerChecker 
{
	private Game currentGame;
	
	//metoda ustawia zmienna game zadana zmienna
	public WinnerChecker(Game p_game)
	{
	this.currentGame = p_game;
	}
	//Sprawdzenie czy istnieje poziomowa kombinacja, ktora wygrywa 
	private Player checkHorizontal() 
	{
		List<ArrayList<Tile>> field = currentGame.getTable();
        Player currPlayer;
        Player lastPlayer = null;
        for(int i = 0, len = field.size(); i < len; i++) 
        {
            lastPlayer = null;
            int successCounter = 1;
            for(int j = 0, len2 = field.get(i).size(); j < len2; j++) 
            {
                currPlayer = field.get(i).get(j).getPlayer();
                if(currPlayer == lastPlayer && (currPlayer != null && lastPlayer !=null)) 
                {
                    successCounter++;
                    if(successCounter == len2) 
                    {
                        return currPlayer;
                    }
                }
                lastPlayer = currPlayer;
            }
        }
        return null;
    }
	//Sprawdzenie czy istnieje pionowa kombinacja, ktora wygrywa 
	private Player checkVertical() 
	{
		List<ArrayList<Tile>> field = currentGame.getTable();
        Player currPlayer;
        Player lastPlayer = null;
        for(int i = 0, len = field.size(); i < len; i++) 
        {
            lastPlayer = null;
            int successCounter = 1;
            for(int j = 0, len2 = field.get(i).size(); j < len2; j++)
            {
                currPlayer = field.get(j).get(i).getPlayer();
                if(currPlayer == lastPlayer && (currPlayer != null && lastPlayer !=null))
                {
                    successCounter++;
                    if(successCounter == len2) 
                    {
                        return currPlayer;
                    }
                }
                lastPlayer = currPlayer;
            }
        }
        return null;
    }
	//Sprawdzenie czy istnieje diagonalna od lewej strony kombinacja, ktora wygrywa 
	private Player checkDiagonalLeft() 
	{
		List<ArrayList<Tile>> field = currentGame.getTable();
	    Player currPlayer;
	    Player lastPlayer = null;
	    int successCounter = 1;
	    for(int i = 0, len = field.size(); i < len; i++) 
	    {
	    	currPlayer = field.get(i).get(i).getPlayer();
	        if(currPlayer != null) 
	        {
	        	if(lastPlayer == currPlayer) 
	        	{
	        		successCounter++;
	                if(successCounter == len) 
	                {
	                	return currPlayer;
	                }
	            }
	        }
	        lastPlayer = currPlayer;
	    }
	    return null;
	}
	 
	//Sprawdzenie czy istnieje diagonalna od prawej strony kombinacja, ktora wygrywa 
	private Player checkDiagonalRight() 
	{
		List<ArrayList<Tile>> field = currentGame.getTable();
	    Player currPlayer;
	    Player lastPlayer = null;
	    int successCounter = 1;
	    for(int i = 0, len = field.size(); i < len; i++) 
	    {
	    	currPlayer = field.get(i).get(len - (i + 1)).getPlayer();
	        if(currPlayer != null) 
	        {
	        	if(lastPlayer == currPlayer) 
	            {
	        		successCounter++;
	                if(successCounter == len) 
	                {
	                	return currPlayer;
	                }
	            }
	        }
	        lastPlayer = currPlayer;
	    }
	    return null;
	}
	 
	//metoda, ktora po kolei sprawdza czy istneje mozliwa wygrywalna kombinacja
	//jesli istneje taka kombinacja, to zwraca m_player
	//jesli takiej kombinacji nie ma, to zwraca null
	public Player check()
	{
		Player m_player = null;
		m_player = checkHorizontal();
		if(m_player == null)
			m_player = checkVertical();
		if(m_player == null)
			m_player = checkDiagonalLeft();
		if(m_player == null)
			m_player = checkDiagonalRight();
		return m_player;
	}
}
