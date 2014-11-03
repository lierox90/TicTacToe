public class Tile 
{
    private Player player = null;
    
    //metoda ustawia zmienna player zadanej zmiennej
    public void setPlayer(Player p_player) 
    {
        this.player = p_player;
    }
    //metoda sprawdza czy pole nie jest zajete
    public boolean isMarked() 
    {
        if (player != null) 
        {
            return true;
        }
        return false;
    }
    //metoda zwraca zmienna player
    public Player getPlayer() 
    {
        return player;
    }
    public void clear()
    {
    	player = null;
    }
}
