public class Tile 
{
	//Decides about mark type
    private Player player = null;
    
    //Marks player signature upon selection
    public void setPlayer(Player p_player) 
    {
        this.player = p_player;
    }
    //Return signature of player that selected this tile
    public Player getPlayer() 
    {
        return player;
    }
    //Checks if signature is placed upon selected tile
    public boolean isMarked() 
    {
        if (player != null) 
        {
            return true;
        }
        return false;
    }
    //Clears tile upon interrupted of finished game
    public void clear()
    {
    	player = null;
    }
}
