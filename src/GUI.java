import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame 
{
	private Game game;
	private List<ArrayList<JButton>> buttons;
	private int width = 300;
	private int heigh = width+100;
	private Icon smallX;
    private Icon smallO;
	private Icon buttonX;
    private Icon buttonO;
    public GUI() throws IOException 
    {
    	//Window init
        super("TicTacToe");
        setSize(width, heigh);
        setResizable( false );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        //Symbols
        smallX = new ImageIcon(getClass().getResource("/resources/active/delete30.png"));
        smallO = new ImageIcon(getClass().getResource("/resources/active/circle107.png"));
        buttonX = new ImageIcon(getClass().getResource("/resources/buttons/delete30.png"));
        buttonO = new ImageIcon(getClass().getResource("/resources/buttons/circle107.png"));
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
                    		if(playerSymbol == "X")
                    			buttons.get(x).get(y).setIcon(buttonX);
                    		else
                    			buttons.get(x).get(y).setIcon(buttonO);
                    		switch (game.check()) 
                    		{
					            case 0:
					            {
					            	System.out.println("Draw");
					            	JOptionPane.showMessageDialog(null, "Remis");
					            	break;
					            }
					                     
					            case 1:
					            {
					            	System.out.println("Won X");
					            	JOptionPane.showMessageDialog(null, "Wygra³ Gracz X");
					            	break;
					            }					            		
					            case 2:
					            {
					            	System.out.println("Won O");
					            	JOptionPane.showMessageDialog(null, "Wygra³ Gracz Y");
					            	break;
					            }
					            default:
					            {
					            	System.out.println("Nothing");
					            	break;
					            }
                    		}
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

