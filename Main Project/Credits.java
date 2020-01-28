import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Credits extends JPanel
{
    private int x;
    private int y;
    private String text;
    
    public Credits()
    {
        x = -45;
        y = 150;
        text = "GAME OVER... \nMade by: Gabriel Vieira";
        setSize(800,600);
        
    }
    
    @Override //Shows you this method is from JPanel class, overriding previous method
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0, 0, 400, 300);
        g.setColor(Color.red);
        g.drawString(text, x, y);
    }
    
    public void run() throws InterruptedException
    {
        JFrame frame = new JFrame("Credits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Credits creditScreen = new Credits();
        frame.getContentPane().add(creditScreen);
        frame.setSize(800,600);
        frame.setVisible(true);
        while(true)
        {
            while(x <= getWidth())
            {
                x++;
                y = getHeight()/2;
                repaint();
                Thread.sleep(10);
            }
            while(x >= 0)
            {
                x--;
                y = getHeight()/2;
                repaint();
                Thread.sleep(10);
            }
        }
       
    }
}

