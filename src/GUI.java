import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame 
{
	Game game;
	List<List<JButton>> buttons;
    public GUI() throws IOException 
    {
    	//Window init
        super("TicTacToe");
        setSize(800, 600);
        setResizable( false );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        //Buttons Grid
        for(int i=0;i<3;i++)
        {
        	buttons.add(new ArrayList<JButton>());
            for(int j=0;j<3;j++)
            {
            	buttons.get(i).add(new JButton());
            }
        }
        //Game object
        game = new Game();
        // Main addition
        this.setBackground(new Color(255,255,255));
    }
}

