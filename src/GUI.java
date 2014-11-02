import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;

public class GUI extends JFrame 
{
    public GUI() throws IOException 
    {
        super("TicTacToe");
        setSize(800, 630);
        setResizable( false );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        // Main addition
        this.setBackground(new Color(255,255,255));
    }
}

