import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Bomb button class for bomb game
 * @author Oyku Elis Turegun 21902976
 * @version 31.03.2021
*/ 
public class BombButton extends JButton {
    //properties
    private JComponent bombPaint = new BombComponent();
    private boolean paint = false;
    
    public BombButton( String str) {
        super(str);
        setFont( new Font( Font.SANS_SERIF , Font.BOLD , 20));
        this.add( bombPaint);
        addActionListener( new ButtonAction());
    }
    /**
     * Listener for button actions
     */
    public class ButtonAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {
            setEnabled(false); //inhibits the button
            setText("");
            paint = true; 
            repaint();
        }
    }
    /**
     * Paints image for bomb
     */
    public class BombComponent extends JComponent {
        @Override
        public void paintComponent( java.awt.Graphics graph ) {
            if ( paint) {
                Graphics2D gra = (Graphics2D) graph;
                
                
                gra.setColor( Color.RED);
                gra.setStroke( new BasicStroke( 3));
                gra.drawArc( 30 , 22 , 40 , 50, 90 , 75);
                
                gra.setColor( Color.GRAY);
                gra.fillRect( 25 , 27 , 15 , 12 ); 
                
                gra.setColor( Color.BLACK);
                gra.fillOval( 12 , 30 , 35 , 35 );
                
                
            }
        }
    }
}


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Test class for Bomb Game 
 * @author Oyku Elis Turegun 21902976
 * @version 31.03.2021
*/ 
public class BombGame {
    public static void main( String [] args ) {                
        //constants
        final int WIDTH = 485;
        final int HEIGHT = 600;
        //variables
        JPanel panel = new GamePanel();
        JFrame frame = new JFrame();
        
        //program Code
        frame.setSize( WIDTH , HEIGHT );
        frame.setTitle( "BOMB GAME");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( panel );
        frame.setVisible(true);
    }  
}

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Panel to play bomb game 
 * @author Oyku Elis Turegun
 * @version 31.03.2021
*/ 
public class GamePanel extends JPanel {
    //constants
    private final int COLUMN = 5;
    private final int ROW = 5;
    
    //properties
    private JButton[] listButton = new JButton[ ROW * COLUMN ];
    private int locat1;
    private int locat2;
    private int locatPrize;
    private int actions;
    private boolean gameOver = false;
    private JPanel buttonPanel;
    private JPanel labelPanel;
    private JLabel actionsLabel;
    
    
    /**
     * Creates panels and its elements
     */
    public GamePanel() {
        this.setLayout( new BorderLayout());
        buttonPanel = new JPanel();
        labelPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout( 0 , COLUMN ));
        
        createAllButtons();
        this.add( buttonPanel , BorderLayout.CENTER);
        
        actions = 0;
        actionsLabel = new JLabel( "Number Guessed: " + actions );
        
        labelPanel.add( actionsLabel );
        this.add( labelPanel , BorderLayout.NORTH );
    }
    
    /**
     * Increasing the guesses
     */
    public class IncrementAction implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ) {
            actions++;
            actionsLabel.setText( "Number Guessed: " + actions);
        }
    }
    /**
     * Winning game situation
     */
    public class WinTheGame implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event) {
            if ( !gameOver ) {
                actionsLabel.setText( "You Won After " + actions + " Guesses");
                gameOver = true;
                gameEnded();
            }
        }
    } 
    /**
     * Losing game sitution
     */
    public class LoseTheGame implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event) {
            if ( !gameOver ) {
                actionsLabel.setText( "Game Over After " + actions + " Guesses");
                gameOver = true;
                gameEnded();
            }
        }
    }
    /**
     * Creates the all butons
     */
    private void createAllButtons() {           
        do {
            locat1 = (int) ( Math.random() * ( ROW * COLUMN ) );
            locat2 = (int) ( Math.random() * ( ROW * COLUMN ) );
            locatPrize = (int) ( Math.random() * ( ROW * COLUMN ) );
        } while( (locat1 == locatPrize) || (locat1 == locat2) || (locat2 == locatPrize) );
    
        for ( int j = 0; j < ROW * COLUMN; j++ ) {
            if ( j == locat1 || j == locat2 ) {
                listButton[j] = new BombButton( "" + ( j + 1) );
                listButton[j].addActionListener( new LoseTheGame());
                buttonPanel.add( listButton[j]);
            }
            else if ( j == locatPrize ) {
                listButton[j] = new PrizeButton( "" + ( j + 1) );
                listButton[j].addActionListener( new WinTheGame());
                buttonPanel.add( listButton[j]);
            }
            else {
                listButton[j] = new RegularButton( "" + ( j + 1) );
                listButton[j].addActionListener( new IncrementAction());
                buttonPanel.add( listButton[j]);
            }
        }
    }
    /**
     * Shows the prize and bomb buttons
     */
    private void gameEnded() {
        for ( int j = 0; j < listButton.length; j++ ) {
            if ( j == locat1 || j == locat2 ) {
                listButton[j].doClick();
            }
            else if ( j == locatPrize ) {
                listButton[j].doClick();
            }
            else {
                listButton[j].setEnabled( false );
            }
        }
    }  
}


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;

/**
 * Prize button class for bomb game
 * @author Oyku Elis Turegun 21902976
 * @version 31.03.2021
*/ 
public class PrizeButton extends JButton {
    Font prizeFont;
    
    public PrizeButton( String str ) {
        super( str );
        setFont( new Font( Font.SANS_SERIF , Font.BOLD , 20 ));
        prizeFont = new Font( Font.SERIF, Font.PLAIN, 60 );
        addActionListener( new ButtonAction());
    }
    
    /**
     * Changing the font
     * @param font is the font that for prize button
     */
    private void changeFontOnAction( Font fontAction) {
        this.setFont( fontAction );
    }
    
    /**
     * ActionListener for the prize button
     */
    public class ButtonAction implements ActionListener {
        
        /**
         * Setting text to star emoji for prize button
         */
        public void actionPerformed( ActionEvent event ) {
            setText( "★" );
            changeFontOnAction( prizeFont );
            setForeground( Color.ORANGE );
        }
    } 
}

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Class for empty&regular squares in the bomb game
 * @author Oyku Elis Turegun
 * @version 31.03.2021
*/ 
public class RegularButton extends JButton {
    public RegularButton( String str ) {
        super( str );
        setFont( new Font( Font.SANS_SERIF , Font.BOLD , 20));
        addActionListener( new ButtonAction());
    }
    
    /**
     * Action listener for regular empty buttons
     */
    public class ButtonAction implements ActionListener {
    
        @Override
        public void actionPerformed( ActionEvent event ) {
            setEnabled( false);
        }
    }   
}

