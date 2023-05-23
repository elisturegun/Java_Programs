/**
 * 2 pairs of Dice Game
 * @author Elis Turegun
 * @version 17.12.20
 */
public class Dice {
    
    // properties
    private Die die2;
    private Die die1;
    
    // constructors
    public Dice() {
        die1 = new Die(); // creating object of Die class
        die2 = new Die(); // creating object of Die class
        
    }
    
    // methods
    
    /**
     * Getter method for total of face values
     * @return getDie1FaceValue() + getDie2FaceValue()
     */
    public int getDiceTotal() {
        return getDie1FaceValue() + getDie2FaceValue();
    }
    
    /**
     * Getter method for face value of die1
     * @return die1.getFaceValue
     */
    public int getDie1FaceValue() {
        return die1.getFaceValue();
        
    }
    
    /**
     * Getter method for face value of die2
     * @return die2.getFaceValue
     */
    public int getDie2FaceValue() {
        return die2.getFaceValue();
        
    }
    
    /**
     * Method for rolling dice
     * @return total dice face value
     */
    public int roll() {
        return die1.roll() + die2.roll();
    }
    
    /**
     * String representation of face values of dice
     * @return die face values and total face value 
     */
    public String toString() {
        return "The face values are " + getDie1FaceValue() + " and " + getDie2FaceValue() +
         "\nDice total is " + getDiceTotal();
        
    }
}

/**
 * Dice Game
 * @author Elis Turegun
 * @version 17.12.20
 */
public class DiceGame {
    // properties
    private Dice dice; // creating object for Dice class
    
    //constructors
    public DiceGame() {
        dice = new Dice();
    }
    
    //methods
    
    /**
     * Method for playing dice game
     * rolling 2 pairs until get 6*6, reports how many times it is rolled
     * @return counter for times rolled
     */
    public int play() {
        int counter;
        
        counter = 1;
        
        do {
            dice.roll();
            counter++;
            
        } while ( dice.getDiceTotal() != 12 );
        
        return counter;
    }   
}
/**
 * Die rolling class
 * @author Elis Turegun
 * @version 17.12.20
 */
public class Die {
    
    // properties
    private int faceValue;
    
    // contructors 
    public Die() {
        faceValue = 0;
    }
    
    // methods
    
    /**
     * Getter method for face value of die
     * @return faceValue
     */
    public int getFaceValue() {
        return faceValue;    
    }
    
    /**
     * Method for rolling the die 
     * @return faceValue
     */
    public int roll() {
        
        final int MIN_VALUE = 1; //constant
        final int MAX_VALUE = 6; //constant
        
        int range;
        
        range = MAX_VALUE - MIN_VALUE + 1;
        
        this.faceValue = (int) (Math.random() * range) + MIN_VALUE;  // generating random values
        
        return faceValue;
    }
    
    /**
     * String representation of face value 
     * @return face value
     */
    public String toString() {
        return "The face value is " + getFaceValue();
    } 
}
/**
 * Rolling 2 pairs of dice game and reports the time rolled until get 6*6
 * @author Elis Turegun
 * @version 17.12.20
 */
public class DiceCalculator {
    public static void main(String[] args) throws Exception {
        //constants
        final int MAX_VALUE = 6; 
        final int MIN_VALUE = 1;
        
        // variables
        int dice1;
        int dice2;
        int counter; 
        int range; 
        
        // program code       
        counter = 1;
        dice1 = 0;
        dice2 = 0;
  
        range = MAX_VALUE - MIN_VALUE + 1;
        
        do {
            dice1 = (int) (Math.random() * range) + MIN_VALUE; 
            dice2 = (int) (Math.random() * range) + MIN_VALUE; 
            counter++;
            
        } while ( dice1 != MAX_VALUE && dice2 != MAX_VALUE );
        
        System.out.println("Number of rolls : " + counter );
        
    }
}

/**
 * Applying Dice Game
 * @author Elis Turegun
 * @version 17.12.20
 */
public class TestDiceGame {
    public static void main ( String [] args ) {
        
        //creating object for DiceGame class
        DiceGame diceGame;
        
        diceGame = new DiceGame();
        
        //program code
        System.out.println( "Times played : " + diceGame.play() );
        
    }
}

/**
 * Applying Die rolling
 * @author Elis Turegun
 * @version 17.12.20
 */
public class TestDie {
    public static void main ( String [] args ) {
        
        //variables
        Die die1; // creating an object for Die class
        Die die2; // creating an object for Die class
        
        die1 = new Die();
        die2 = new Die();
        
        //program code
        
        System.out.println( die1.roll() ); // calls roll method for die1
        System.out.println( die2.roll() ); // calls roll method for die2
        
        System.out.println( die1 ); // toString for die1
        System.out.println( die2 ); // toString for die2
   
    } 
}

