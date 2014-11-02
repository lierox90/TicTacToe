import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame 
{
	private Game game;
	private List<ArrayList<JButton>> buttons;
	private int width = 300;
	private int heigh = width+100;
    public GUI() throws IOException 
    {
    	//Window init
        super("TicTacToe");
        setSize(width, heigh);
        setResizable( false );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        //Buttons Grid
        buttons = new ArrayList<ArrayList<JButton>>();
        for(int i=0;i<3;i++)
        {
        	buttons.add(new ArrayList<JButton>());
            for(int j=0;j<3;j++)
            {
            	buttons.get(i).add(new JButton());
            }
        }
        setButtons();
        //Game object
        game = new Game();
        // Main addition
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
            	this.add(buttons.get(i).get(j));
            }
        }
        this.setBackground(new Color(255,255,255));
    }
    void setButtons()
    {
    	int step = (width-6)/3;
    	int initH = heigh-width-23;
    	int initW = 0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
            	buttons.get(i).get(j).setBounds(initW, initH, step, step);
            	initW += step;
            }
            initW = 0;
            initH += step;
        }
    }
}

