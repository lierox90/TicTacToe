import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class GUI extends JFrame 
{
	//Declaration of all used objects
	private Game game;
	private List<ArrayList<JButton>> buttons;
	private int width = 300;
	private int heigh = width+100;
	private Icon buttonX;
    private Icon buttonO;
    private JButton reset;
    private JLabel panelX;
    private JLabel panelO;
    private Border border;
    
    //Constructor creating visible window
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
        //Border marking selected user
        border = BorderFactory.createLineBorder(Color.BLUE, 5);
        //Symbols
        buttonX = new ImageIcon(getClass().getResource("/resources/buttons/fire40.png"));
        buttonO = new ImageIcon(getClass().getResource("/resources/buttons/water12.png"));
        //Reset button
        reset = new JButton("Reset");
        reset.setBounds(width/2-40, 10, 80, 40);
        reset.addActionListener(new ActionListener() 
    	{ 
    		public void actionPerformed(ActionEvent e)
            {
    			game.reset();
    			reset();
            }
    		
        });
        //Active player panels
        panelX = new JLabel(buttonX);
        panelX.setBounds(6, 6, buttonX.getIconWidth(), buttonX.getIconHeight());
        panelX.setBorder(border);
        panelO = new JLabel(buttonO);
        panelO.setBounds(width-6-buttonX.getIconWidth(),6, buttonO.getIconWidth(), buttonO.getIconHeight());
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
            	//Action listener performing selection of certain tile
            	buttons.get(i).get(j).addActionListener(new ActionListener() 
            	{ 
            		public void actionPerformed(ActionEvent e)
                    {
            			String playerSymbol = game.getActive().getName();
                    	if(game.makeTurn(x, y))
                    	{
                    		if(playerSymbol == "X")
                    		{
                    			buttons.get(x).get(y).setIcon(buttonX);
                    			panelX.setBorder(null);
                    			panelO.setBorder(border);
                    		}
                    		else
                    		{
                    			buttons.get(x).get(y).setIcon(buttonO);
                    			panelX.setBorder(border);
                    			panelO.setBorder(null);
                    		}
                    		//Checking conditions of win
                    		switch (game.check()) 
                    		{
					            case 0:
					            {
					            	JOptionPane.showMessageDialog(null, "Remis");
					            	game.reset();
					            	reset();
					            	break;
					            }
					                     
					            case 1:
					            {
					            	JOptionPane.showMessageDialog(null, "Wygra³ Ogieñ");
					            	game.reset();
					            	reset();
					            	break;
					            }					            		
					            case 2:
					            {
					            	JOptionPane.showMessageDialog(null, "Wygra³a Woda");
					            	game.reset();
					            	reset();
					            	break;
					            }
                    		}
                    	}                    	
                    }
                });
            }
        }
        //Visual placement of butons
        setButtons();
        //Proper object inclusion into main Frame
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
    //GUI reset
    void reset()
    {
    	for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
            	buttons.get(i).get(j).setIcon(null);
            }
        }
		panelX.setBorder(border);
		panelO.setBorder(null);
    }
    //Provieds coordinates for visual placement of buttons
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

