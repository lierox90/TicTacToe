import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI extends JFrame 
{
	private Game game;
	private List<ArrayList<JButton>> buttons;
	private int width = 300;
	private int heigh = width+100;
	private Icon buttonX;
    private Icon buttonO;
    private JButton reset;
    private JLabel panelX;
    private JLabel panelO;
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
        buttonX = new ImageIcon(getClass().getResource("/resources/buttons/delete30.png"));
        buttonO = new ImageIcon(getClass().getResource("/resources/buttons/circle107.png"));
        //Reset button
        reset = new JButton("Reset");
        reset.setBounds(width/2-20, 10, 40, 40);
        //active player panels
        panelX = new JLabel(buttonX);
        panelX.setBounds(10, 10, buttonX.getIconWidth(), buttonX.getIconHeight());
        panelO = new JLabel(buttonO);
        panelO.setBounds(width-10-buttonX.getIconWidth(),10, buttonO.getIconWidth(), buttonO.getIconHeight());
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
            	buttons.get(i).get(j).setFocusable(false);
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
					            	JOptionPane.showMessageDialog(null, "Remis");
					            	break;
					            }
					                     
					            case 1:
					            {
					            	JOptionPane.showMessageDialog(null, "Wygra³ Gracz X");
					            	break;
					            }					            		
					            case 2:
					            {
					            	JOptionPane.showMessageDialog(null, "Wygra³ Gracz O");
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
        this.add(panelX);
        this.add(panelO);
        this.add(reset);
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

