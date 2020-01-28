import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import java.io.File;
import java.io.IOException;

class deathScreen{
    
    private JFrame window;
    private JPanel textPanel , inputPanel, deathPanel, buttonPanel;
    private JLabel textLabel, deathLabel;
    JButton retryButton, exitButton;
    
    DeathScreenHandlerRETRY dsHR = new DeathScreenHandlerRETRY();
    DeathScreenHandlerEXIT dsHE= new DeathScreenHandlerEXIT();
    
    private Font doom; //Custom Font
    Container con;//Container acts as a base to place several components
    
    
    public deathScreen(){
        //This allows us to to import a custom font and prevent errors
        try{
            doom = Font.createFont(Font.TRUETYPE_FONT, new File("doom.ttf")).deriveFont(90f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("doom.ttf")));
        }
        catch(IOException | FontFormatException e){
        
        }
        
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
        //Creates the JPanel for the game's Main Menu
        deathPanel = new JPanel();
        deathPanel.setBounds(100,100,600,150);
        deathPanel.setBackground(Color.black);
       
        deathLabel = new JLabel("DUNGEON DOOM"); //game name
        deathLabel.setForeground(Color.red); //text colour
        deathLabel.setFont(doom); //imports custom font
        
        //BUTTON PANEL
        buttonPanel = new JPanel();
        buttonPanel.setBounds(250,350,300,150);
        buttonPanel.setLayout(new GridLayout(4,1));
        buttonPanel.setBackground(Color.red);
        
        //RETRY BUTTON
        retryButton = new JButton("RETRY");
        retryButton.setBackground(Color.black);
        retryButton.setForeground(Color.red);
        retryButton.setFont(doom);
        retryButton.setOpaque(true);
        retryButton.setBorderPainted(false);
        retryButton.addActionListener(dsHR);
        
        //EXIT BUTTON
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.red);
        exitButton.setFont(doom);
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);
        exitButton.addActionListener(dsHE);
        
        buttonPanel.add(retryButton);
        buttonPanel.add(exitButton);
        con.add(buttonPanel);
    }
    
    public class DeathScreenHandlerRETRY implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            System.exit(0);
        }
    }
    
    public class DeathScreenHandlerEXIT implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            System.exit(0);
        }
    }
}