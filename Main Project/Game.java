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


public class Game extends JPanel
{
    private JFrame window;
    private JPanel textPanel , inputPanel, mainMenuPanel, mainTextPanel, startButtonPanel, choiceButtonPanel, playerPanel;
    private JLabel textLabel, mainMenuLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelNumber;
    private JTextField inputName;
    JButton startButton, enterButton, choice1, choice2, choice3, choice4; 
    private JTextArea mainTextArea;
    
    // Result an action in response to player choice
    InputHandler iHandler = new InputHandler();
    TitleScreenH tsH = new TitleScreenH();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
    private Font doom; // Custom Font
    Container con;// Container acts as a base to place several components
    
    private String position;
    Player player = new Player(); // Player Profile
    int hpint = player.getHP();
    
    Enemy z = new Zombie(50, 25);
    int enemyHPZ = z.getEnemyHP();
    
    Enemy s = new Skeleton(45, 20);
    int enemyHPS = s.getEnemyHP();
    
    Enemy o = new Orc(60, 25);
    int enemyHPO = o.getEnemyHP();
    
    private ImageIcon zombieimg = new ImageIcon("zombieimg.png");
    private ImageIcon skeletonimg = new ImageIcon("skeletonimg.png");
    private ImageIcon orcimg = new ImageIcon("orcimg.jpg");
    
    public static void main(String [] args)
    {
        Game game = new Game();
        game.mainMenu();
      
    }
    
    public void mainMenu()
    {
        //This allows us to to import a custom font and prevent errors
        try{
            doom = Font.createFont(Font.TRUETYPE_FONT, new File("doom.ttf")).deriveFont(90f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("doom.ttf")));
        }
        catch(IOException | FontFormatException e){
        
        }
        
        //Creates window/box that contains the options
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
        //Creates the JPanel for the game's Main Menu
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBounds(100,100,600,150);
        mainMenuPanel.setBackground(Color.black);
       
        mainMenuLabel = new JLabel("DUNGEON DOOM"); //game name
        mainMenuLabel.setForeground(Color.red); //text colour
        mainMenuLabel.setFont(doom); //imports custom font
       
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.red); //Panel border colour
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black); //Background colour of button
        startButton.setForeground(Color.red); //Text Colour
        startButton.setFont(doom);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false); //both remove white fill
        startButton.addActionListener(tsH); //adds click functionality
        
        mainMenuPanel.add(mainMenuLabel);
        startButtonPanel.add(startButton);
        
        con.add(mainMenuPanel);
        con.add(startButtonPanel);
        
        window.add(mainMenuPanel);
        window.add(startButtonPanel);
        window.setVisible(true);
    }
    
    //Method that launches game after button is clicked
    public class TitleScreenH implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            nameInput();
        }
    }
    
    public void nameInput()
    {
        window = new JFrame();
        window.setSize(800, 600); //x & y axis
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();
        
        textPanel = new JPanel();
        textPanel.setBounds(150, 250, 500, 100);
        textPanel.setBackground(Color.black);
        textLabel = new JLabel("To begin your adventure, enter your name.");
        textLabel.setForeground(Color.red);
        textLabel.setFont(normalFont);
        textPanel.add(textLabel);
        con.add(textPanel);
        
        inputPanel = new JPanel();
        inputPanel.setBounds(150,450,500,50);
        inputPanel.setBackground(Color.black);
        inputPanel.setLayout(new GridLayout(1,2));
        
        window.setVisible(true);
        
        inputName = new JTextField();
        inputPanel.add(inputName);
        
        enterButton = new JButton("ENTER");
        enterButton.setForeground(Color.black);
        enterButton.addActionListener(iHandler); //recieves action events from user
        inputPanel.add(enterButton);
        con.add(inputPanel);
    }
    
    //Outcome after ENTER button is clicked
    public class InputHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            textLabel.setVisible(false);
            inputPanel.setVisible(false);
            String name = inputName.getText();
            
            if (name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a name that contains characters.", null, JOptionPane.INFORMATION_MESSAGE);
                nameInput();
            }
            else
            {
                //Creates player object
                player.setName(name);
                introduction_p1();
            
            }
            
        }
    }
    
    public void introduction_p1()
    {
        position = "outside";
        
        mainMenuPanel.setVisible(false);
        startButtonPanel.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        
        //References player class to obtain HP and player name 
        String name = player.getName();
        int hpint = player.getHP();
        
        String hp = Integer.toString(hpint);
       
        //Main objective text body
        mainTextArea = new JTextArea(name +", do you wish to enter?");
        
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.red);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); //text lines automatically
        
        mainTextPanel.add(mainTextArea);
        
        //Choice box for player actions:
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        
        //Section that creates user choice options, defining their font/colour and adding it to the JPanel
        choice1 = new JButton("");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.red); //Text Colour
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setText("Yes I do!");
        choice1.addActionListener(choiceHandler); //Allows a resonse when clicked
        choice1.setActionCommand("c1");
        
        choice2 = new JButton("");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.red);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setText("Perhaps another day...");
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        
        choice3 = new JButton("");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.red);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setText("");
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choice3.setVisible(true);
        
        choice4 = new JButton("");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.red);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setText("");
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choice4.setVisible(true);
        
        //Section that displays the player's status
        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        
        hpLabelNumber = new JLabel(hp);
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
       
    }
    
    public void dungeon_p2()
    {
        position = "dungeon_main";
        mainTextArea.setText("You have entered into darkness. \nYou see 2 seperate pathways by your sides, however the path to your right seems to be trapped. \n Which do you follow?");
        
        choice1.setText("Left");
        choice2.setText("Right");
        choice3.setText("");
    
    }
    
    
    public void dungeon_p2_return()
    {
        position = "dungeon_main";
        mainTextArea.setText("You return to the entrance. \nYou see 2 seperate pathways by your sides. \n Which do you follow?");
        
        choice1.setText("Left");
        choice2.setText("Right");
        choice3.setText("");
    
    }
    
    public void dungeon_p3_l()
    {
        position = "dungeon_l1";
        mainTextArea.setText("You notice a pungent smell in the air. \nOn the walls is a scribbled drawn Eagle... \n In front of you is a SLIGHTLY OPENED wooden door. \n What do you do?");
        
        choice1.setText("Open the door...");
        choice2.setText("Head back");
        choice3.setText("");
    
    }
    
    public void Combat1()
    {
        position = "Combat";
        
        choice2.setVisible(true);
        choice3.setVisible(true);
     
        mainTextArea.setText("The ZOMBIE is approaching you..." + "\nHP: " + z.getEnemyHP() + "\n\n How do you wish to proceed?");
        choice1.setText("FIGHT the ZOMBIE");
        choice2.setText("Attempt to flee");
        choice3.setText("Inspect Zombie");
       
       
    }
    
    public void Combat2()
    {
        position = "Combat2";
        
        choice2.setVisible(true);
        choice3.setVisible(true);
     
        mainTextArea.setText("The ORC is approaching you..." + "\nHP: " + o.getEnemyHP() + "\n\n How do you wish to proceed?");
        choice1.setText("FIGHT the ORC");
        choice2.setText("Attempt to flee");
        choice3.setText("Inspect Orc");
       
       
    }
    
    public void Combat3()
    {
        position = "Combat3";
        
        choice2.setVisible(true);
        choice3.setVisible(true);
     
        mainTextArea.setText("The SKELETON is approaching you..." + "\nHP: " + o.getEnemyHP() + "\n\n How do you wish to proceed?");
        choice1.setText("FIGHT the SKELETON");
        choice2.setText("Attempt to flee");
        choice3.setText("Inspect SKELETON");
       
       
    }
    
    public void dungeon_p4_l()
    {
        mainTextArea.setText("You see 3 doors in front of you. \n Left = bat symbol, Middle = eagle symbol, Right = wolf symbol. \n which do you enter?" );
        
        choice1.setText("Left");
        choice2.setText("Middle");
        choice3.setText("Right");
    }
    
    public void door_middle()
    {
        position = "middle";
        
        JOptionPane.showMessageDialog(null, "YOU FOUND THE GOLD AND WON THE GAME", "YOU WIN", JOptionPane.INFORMATION_MESSAGE);
        
        
    }
    
    
    // COMBAT METHODS ____________________________________________________________________________________________________________________
    public void playerCombatZ()
    {
        position = "playerCombatZ";
        
        int playerDamage = player.getPlayerDamage();
        
        mainTextArea.setText("You sliced the enemy and dealt +" + playerDamage + " damage!");
        
        int enemyHP = z.getEnemyHP();
        
        enemyHPZ = enemyHPZ - playerDamage;
        z.setEnemyHP(enemyHPZ);
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        
    }
    
    public void playerCombatO()
    {
        position = "playerCombatO";
        
        int playerDamage = player.getPlayerDamage();
        
        mainTextArea.setText("You sliced the enemy and dealt +" + playerDamage + " damage!");
        
        int enemyHP = o.getEnemyHP();
        
        enemyHPZ = enemyHPZ - playerDamage;
        o.setEnemyHP(enemyHPZ);
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        
    }
    
    public void playerCombatS()
    {
        position = "playerCombatS";
        
        int playerDamage = player.getPlayerDamage();
        
        mainTextArea.setText("You sliced the enemy and dealt +" + playerDamage + " damage!");
        
        int enemyHP = s.getEnemyHP();
        
        enemyHPZ = enemyHPZ - playerDamage;
        s.setEnemyHP(enemyHPZ);
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        
    }
    
    public void enemyCombatZ()
    {
        position = "enemyCombatZ";
        
        int enemyDamage = z.getEnemyDamage();
        
        mainTextArea.setText("The Zombie attacked you and dealt " + enemyDamage + " damage.");
        player.setHP(enemyDamage);
        int hpint = player.getHP();
        
        String hp = Integer.toString(hpint);
        hpLabelNumber.setText(hp);
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        
        if (hpint < 1)
        {
            JOptionPane.showMessageDialog(null, "YOU HAVE BEEN SLAIN", "YOU DIED", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void enemyCombatS()
    {
        position = "enemyCombatS";
        
        int enemyDamage = s.getEnemyDamage();
        
        mainTextArea.setText("The Skeleton attacked you and dealt " + enemyDamage + " damage.");
        player.setHP(enemyDamage);
        int hpint = player.getHP();
        
        String hp = Integer.toString(hpint);
        hpLabelNumber.setText(hp);
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        
        if (hpint < 1)
        {
            JOptionPane.showMessageDialog(null, "YOU HAVE BEEN SLAIN", "YOU DIED", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void enemyCombatO()
    {
        position = "enemyCombatO";
        
        int enemyDamage = o.getEnemyDamage();
        
        mainTextArea.setText("The Orc attacked you and dealt " + enemyDamage + " damage.");
        player.setHP(enemyDamage);
        int hpint = player.getHP();
        
        String hp = Integer.toString(hpint);
        hpLabelNumber.setText(hp);
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        
        if (hpint < 1)
        {
            JOptionPane.showMessageDialog(null, "YOU HAVE BEEN SLAIN", "YOU DIED", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
    }
    
    // VIEW ZOMBIE IMAGE
    public void inspectZ()
    {   
        position = "inspectZ";
        
        String enemyName = z.enemyName();
        
        mainTextArea.setText("");
        choice1.setText("Return");
        choice2.setVisible(false);
        choice3.setVisible(false);
        JOptionPane.showMessageDialog(null, "A ZOMBIE has appeared! His name is " + enemyName + "!", "ENEMY SPOTTED", JOptionPane.INFORMATION_MESSAGE, zombieimg);
    }
    
    // VIEW ORC IMAGE
    public void inspectO()
    {   
        position = "inspectO";
        
        String enemyName = o.enemyName();
        
        mainTextArea.setText("");
        choice1.setText("Return");
        choice2.setVisible(false);
        choice3.setVisible(false);
        JOptionPane.showMessageDialog(null, "An ORC has appeared! His name is " + enemyName + "!", "ENEMY SPOTTED", JOptionPane.INFORMATION_MESSAGE, orcimg);
    }
    
    public void inspectS()
    {   
        position = "inspectS";
        
        String enemyName = s.enemyName();
        
        mainTextArea.setText("");
        choice1.setText("Return");
        choice2.setVisible(false);
        choice3.setVisible(false);
        JOptionPane.showMessageDialog(null, "A SKELETON has appeared! His name is " + enemyName + "!", "ENEMY SPOTTED", JOptionPane.INFORMATION_MESSAGE, skeletonimg);
    }
    
    // OUTCOMES OF BATTLES
    public void win()
    {
        position = "win";
        
        mainTextArea.setText("You have defeated the creature and move onwards.");
        
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        
    }
    
    public void lose()
    {
        position = "lose";
        
        mainTextArea.setText("YOU DIED! \nGAME OVER");
        
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        
    }
    
    public void win2()
    {
        position = "win";
        
        mainTextArea.setText("You have defeated but the door behind you locked \nand you starved to death \n THE END.");
        
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        
    }
    
    public class ChoiceHandler implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        String playerChoice = event.getActionCommand();
        
        switch(position)
        {
            case "outside":
                switch(playerChoice)
                {
                    case "c1": dungeon_p2(); break;
                    case "c2": System.exit(0); break;
                    case "c3": break;
                    case "c4": break;
                } break;
                
            case "dungeon_main":
                switch(playerChoice)
                {
                    case "c1": dungeon_p3_l(); break;
                    case "c2": Combat2(); break;
                    case "c3": break;
                } break;
                
            case "Combat2":
                switch(playerChoice)
                {
                    case "c1": playerCombatO(); break;
                    case "c2": dungeon_p2_return(); break;
                    case "c3": inspectO(); break;
                } break;
                
            
                case "playerCombatO":
                switch(playerChoice)
                {
                    case "c1": 
                        if(enemyHPO<1)
                        {
                            win2(); 
                        }
                        else
                        {
                            enemyCombatO();
                        }
                       
                     break;
                } break;
                
                case "enemyCombatO":
                switch(playerChoice)
                {
                    case "c1": 
                        if(hpint<1)
                        {
                           lose(); 
                        }
                        else
                        {
                            Combat2();
                        }
                        
                    break;
                } break;
                
            case "inspectO":
                switch (playerChoice)
                {
                    case "c1": Combat2(); break;
                } break;
                
            case "dungeon_l1":
                switch(playerChoice)
                {
                    case "c1": Combat1(); break;
                    case "c2": dungeon_p2_return(); break;
                } break;
             
            case "Combat":
                switch(playerChoice)
                {
                    case "c1": playerCombatZ();break;
                    case "c2": break;
                    case "c3": inspectZ(); break;
                } break;
                
            case "playerCombatZ":
                switch(playerChoice)
                {
                    case "c1": 
                        if(enemyHPZ<1)
                        {
                            win(); 
                        }
                        else
                        {
                            enemyCombatZ();
                        }
                     break;
                } break;
                
            
            case "enemyCombatZ":
                switch(playerChoice)
                {
                    case "c1": 
                        if(hpint<1)
                        {
                           lose(); 
                        }
                        else
                        {
                            Combat1();
                        }
                        
                    break;
                } break;
                
            case "inspectZ":
                switch (playerChoice)
                {
                    case "c1": Combat1(); break;
                    case "c2": break;
                    case "c3": break;
                } break;
                
            case "win":
                switch(playerChoice)
                {
                    case "c1": dungeon_p4_l(); break;
                    case "c2": break;
                    case "c3": break;
                }
                
            case "dungeon_p4_l":
                switch(playerChoice)
                {
                    case "c1": Combat3(); break;
                    case "c2": door_middle();break;
                    case "c3": lose(); break;
                }
                
            case "Combat3":
                switch(playerChoice)
                {
                    case "c1": playerCombatS(); break;
                    case "c2": dungeon_p4_l(); break;
                    case "c3": inspectS(); break;
                } break;
            
            case "playerCombatS":
                switch(playerChoice)
                {
                    case "c1": 
                        if(enemyHPS<1)
                        {
                            win(); 
                        }
                        else
                        {
                            enemyCombatS();
                        }
                     break;
                } break;   
                
            case "enemyCombatS":
                switch(playerChoice)
                {
                    case "c1": 
                        if(hpint<1)
                        {
                           lose(); 
                        }
                        else
                        {
                            Combat3();
                        }
                    break;
                } break;
                
            case "inspectS":
                switch (playerChoice)
                {
                    case "c1": Combat3(); break;
                } break;    
        
        }
    }
}
    
    
}

    

    