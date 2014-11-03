import java.util.ArrayList;
import java.util.List;

public class Game 
{
	//Declaration of used variables
	private Player player1;
	private Player player2;
	private Player activePlayer;
	private List<ArrayList<Tile>> table;
	private int squareCount = 9;
	private int filled;
	private WinnerChecker winCheck;
	//Game type object constructor
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
	//Reseting players after interrupted or finished games
	private void resetPlayers()
	{
		player1.setName("X");
        player2.setName("O");
        setActive(player1);
	}
	//Reseting board after interrupted or finished games
	private void resetTable() 
	{
        for (int i = 0, l = table.size(); i < l; i++) 
        {
            for (int j = 0, l2 = table.get(i).size(); j < l2; j++) 
            {
               table.get(i).get(j).clear();
            }
        }
        filled = 0;
    }
	//Reset functionality wrapper, visible outside of class scope
	public void reset()
	{
		resetPlayers();
		resetTable();
	}
	//Returns game board
	public List<ArrayList<Tile>> getTable()
	{
        return table;
    }
	//Sets current player
	public void setActive(Player player) 
	{
        activePlayer = player;
	}
	//Return current player
	public Player getActive() 
	{
	    return activePlayer;
	}
	//Conducts move if possible
	public boolean makeTurn(int x, int y) 
	{
		if (table.get(x).get(y).isMarked())
	    {
			return false;
	    }
	    table.get(x).get(y).setPlayer(getActive());
	    filled++;
	    switchPlayers();
	    return true;
	}
	//Switches currently selected player
	public void switchPlayers() 
	{
		activePlayer = (activePlayer == player1) ? player2 : player1;
	}
	//Checks if game board is maximally filled
	public boolean isTableFilled() 
	{
		return squareCount == filled;
	}
	//Wrapper for checking possible victory
	public int check()
	{
		int code=-1;
		Player playCheck = winCheck.check();
		if(playCheck == null)
		{
			if(!isTableFilled())
				code = -1;
			else
				code = 0;
		}
		else
		{
			if(playCheck.getName() == "X")
				code = 1;
			if(playCheck.getName() == "O")
				code = 2;
		}
		return code;
	}
}
 

