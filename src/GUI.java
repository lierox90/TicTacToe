import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        //Game object
        game = new Game();
        game.reset();
        //Buttons Grid
        buttons = new ArrayList<ArrayList<JButton>>();
        for(int i=0;i<3;i++)
        {
        	buttons.add(new ArrayList<JButton>());
            for(int j=0;j<3;j++)
            {
            	buttons.get(i).add(new JButton());
            	final int x = i;
            	final int y = j;
            	buttons.get(i).get(j).addActionListener(new ActionListener() 
            	{ 
            		public void actionPerformed(ActionEvent e)
                    {
            			String playerSymbol = game.getActive().getName();
                    	if(game.makeTurn(x, y))
                    	{
                    		buttons.get(x).get(y).setText(playerSymbol);
                    		switch (game.check()) 
                    		{
					            case 0:  System.out.println("Draw");
					                     break;
					            case 1:  System.out.println("Won X");
					                     break;
					            case 2:  System.out.println("Won O");
					                     break;
					            default: System.out.println("Nothing");
					                     break;
                    		}
                    		//System.out.println("Marked");
                    	}
                    	else
                    	{
                    		//System.out.println("Already taken");
                    	}
                    	
                    }
                });
            }
        }
        setButtons();
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

