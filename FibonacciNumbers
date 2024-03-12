import java.util.Iterator;
public class IntBag implements Iterator
{
    //properties
    private int index;
    private int[] bag;
    private int valid;


    //constructors
    public IntBag() {
        bag = new int[ 100 ];
        valid = 0;
        index = 0;
    }

    public IntBag( int maxNumOfElements ) {
        bag = new int[ maxNumOfElements ];
        valid = 0;
        index = 0;
    }

    // methods
    public void add( int value ) {
        if( valid < bag.length ) {
            bag[valid] = value;
            valid++;
        }
        else
            System.out.println( "Capacity is full!" );
    }

    public void addTo( int index, int value ) {
        if( index >= 0 && index <= valid ) {
            if( valid >= bag.length ) {
                int[] newArray = new int[ bag.length * 10 ];//newArray is created if our array is exceeded
                for( int i: bag ) {
                    newArray[i] = bag[i];
                }
                bag = newArray;
            }

            if( valid != 0 ) {
                for( int i = valid - 1; index <= i; i-- ) {
                    bag[ i + 1 ] = bag[ i ];
                }
                bag[index] = value;
                valid++;
                System.out.println( "Done" );
            }
        }
    }


    public void remove( int index ) {
        if( index < valid ) {
            for( int i = 1; i < valid - index; i++) {
                bag[index + i - 1] = bag[index + i];
            }
            valid--;
            System.out.println( "Done" );
        }
        else
            System.out.println( "Please enter a valid index" );
    }

    public boolean contains( int value ) {
        for( int i = 0; i < valid; i++) {
            if( bag[i] == value ) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String str;
        int length;

        str = "[";
        length = 0;

        for( int i = 0; i < valid; i++) {
            str = str + bag[i] + ",";
        }
        length = str.length();
        str = str.substring( 0, length - 1 ) + "]";
        return str;
    }

    public int size() {
        return valid;
    }

    public int get( int index ) {
        if( index < valid ) {
            return bag[index];
        }
        else {
            return -1;
        }
    }

    public String findAll( int value ) {
        boolean found;
        String str;

        str = "";
        found = false;

        for( int i = 0; i < valid; i++) {
            if( bag[i] == value ) {
                found = true;
            }
            if( found == true ) {
                str = str + i + ",";
            }
            found = false;
        }
        return ("The locations(indexes) of the value are: " + str);
    }

    public Iterator iterator() {
        IntBagIterator i;
        i = new IntBagIterator( this );
        return i;
    }

    public Object next() {
        Integer i;
        i = bag[index];
        index++;
        return i;
    }

    public boolean hasNext() {
        return index < valid;
    }

    public int nextInt() {
        index++;
        return bag[index];
    }
}   
/**
 * An Fibonacci seris class 
 * @author Oyku Elis Turegun
 * @version 18.06.2021
 */
public class Fibonacci {
    //properties
    private int num1;
    private int num2;
    private int nextNum;
    private IntBag newBag = new IntBag();
    
    //constructor
    public Fibonacci() {
        num1 = 0;
        num2 = 1;
        newBag.bag[0] = num1;
        newBag.bag[1] = num2;
    }
    
    /**
     * method for calculating next fibonacci number
     * and collects them as IntBag
     * @param int n
     */
    public void printNext( int n) {
        System.out.println( " " +num1 + "\n " + num2);
        for ( int i = 2; i < n; i++)  {
            nextNum = num1 + num2;
            System.out.println( " " + nextNum );
            num1 = num2;
            num2 = nextNum;    
        }
    }
    
    /**
     * Main method for printing 40 fibonacci numbers
     */
    public static void main( String [] args ) {
        
        Fibonacci fib;
        fib = new Fibonacci();
        fib.printNext(40);
        
    }
    
}

import java.util.Arrays;
/**
 * An Integer Bag class to store int values
 * @author Oyku Elis Turegun
 * @version 18.06.2021
 */
public class IntBag {
    //properties
    int [] bag;
    
    //constructors
    public IntBag() {
        bag = new int[4];
    }
    
    
    /**
     * adding method for adding a new number to the bag
     * @param int newNum
     */
    public void add(int newNum ) {
        
        int maxCapacity = bag.length* 2;
        int [] newBag = new int[maxCapacity];
        for(int k = 0; k < bag.length; k++ ) {
            newBag[k] = bag[k];
        }
        for ( int j = 0; j < newBag.length-1; j++) {
            if( newBag[j] <= 0 ) {
                newBag[j] = newNum;
                newBag[j+1] = -1;
            }
        }  
    }
    
    /**
     * adding method for adding a new number to spesific index in the bag
     * @param int newNum, int index
     */
    public void add(int newNum, int index ) {
        if ( index > 0 ) { 
            if ( index < bag.length ) {
                int term = bag[index];
                bag[index] = newNum;
                for(int j = index; bag[j] >= 0 && bag.length -1 > j; j++) {
                    bag[j] = term;
                    term = bag[j+1];
                }
            }
            else if ( index >= bag.length ) {
                int maxCapacity = bag.length* 2;

                int [] newBag = new int[maxCapacity];
                
                for(int k = 0; k < bag.length; k++ ) {
                    newBag[k] = bag[k];
                }
                int term = newBag[index];
                newBag[index] = newNum;
                
                for(int j = index; newBag[j] >= 0 && newBag.length -1 > j; j++) {
                    newBag[j] = term;
                    term = newBag[j+1];
                }    
            }
        }
        else {
            System.out.println("Invalid index");
        }       
    }
    
    /**
     * checking if the given value is in the bag oor not
     * @param int value
     * @return boolean check 
     */
    public boolean hasValue( int value ) {
        boolean check = false;
        for ( int a = 0; a < bag.length; a++) {
            if ( bag[a] == value ) {
                check = true;
            }
        }
        return check;   
    }
    
    /**
     * finding certain value in the given index
     * @param int index
     * @return currentSize
     */
    public int findValue( int index ) {
        if(index >= bag.length) {
            System.out.println("Index is not valid");
        }
        return bag[index];
    }
    
    /**
     * method to calculate current size
     * @return currentSize
     */
    public int findSize(IntBag bag2) {
        int currentSize = 0;
        for(int j = 0; j < bag2.bag.length; j++ ) {
            if ( bag2.bag[j] >= 0 ) {
                currentSize++;
            }
        }
        return currentSize;
    }
    
    /**
     * String representation of a bag
     */
    public String toString( IntBag bag2) {
        String result = "Values: ";
        for ( int i = 0; i < bag2.bag.length; i++) {
            if( bag2.bag[i] > 0 ) {
                result = result + " " + bag2.bag[i] + " "; 
            }
        }
        result = result + "\n Size: " + findSize(bag2);
        return result;
    }

}

import java.util.Scanner;
public class Test {
    public static void main ( String [] args ) {
        //variables
        int userChoice;
        int capacity = 0;
        int value;
        int index;
        Scanner scan = new Scanner(System.in);
        
        //creating IntBag object
        IntBag newBag = new IntBag();
        System.out.println("WELCOME TO THE MENU\nPLEASE SELECT AN OPTION");
    

            do {
                System.out.println(" 1- Create a new empty collection(any previous values are lost!");
                System.out.println(" 2- Read a set of positive values into the collection (use zero to indicate all the values have been entered.");
                System.out.println(" 3- Print the collection of values.");
                System.out.println(" 4- Add a value to the collection of values at a specified location");
                System.out.println(" 5- Remove the value at a specified location from the collection of values");
                System.out.println(" 6- Remove all instances of a value within the collection* (see note below)");
                System.out.println(" 7- Quit the program.");
                
                userChoice = scan.nextInt();
                if ( userChoice == 1 ) {
                    System.out.print("Please enter a capacity: ");
                    capacity = scan.nextInt();
                }
                if ( userChoice == 2 ) {
                    for( int i = 1; i < capacity; i++ ) {
                        System.out.print("Please enter a value: ");
                        newBag.add( scan.nextInt());
                    }
                }
                if ( userChoice == 3 ) {
                    System.out.println(newBag.toString(newBag)); 
                }
                if ( userChoice == 4 ) {
                    System.out.println("Enter a value: ");
                    value = scan.nextInt();
                    
                    System.out.println("Enter an index : ");
                    index = scan.nextInt();
                    
                    newBag.add(value,index);
                    
                }
                if ( userChoice == 5 ) {
                    
                }
                if ( userChoice == 6 ) {
                    
                }
                if ( userChoice == 7 ) {
                    System.out.println("GOODBYE!");
                }
        }while (userChoice != 7);
        
        }
}

