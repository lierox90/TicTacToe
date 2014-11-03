import java.awt.EventQueue;
import java.io.IOException;

public class Main 
{
	static GUI visualisation;
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                	visualisation = new GUI();
				} 
                catch (IOException e) 
				{
					e.printStackTrace();
				}
            }
        });
    }
}
