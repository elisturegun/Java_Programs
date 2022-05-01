import java.util.*;
/**
 * Recursion methods 
 * @author Oyku Elis Turegun
 * @version  14.04.2021
*/ 
public class Recursion {
    
    public static void main(String[] args) {
        //scanner
        Scanner scan = new Scanner( System.in );
        
        //constants
        final String SEPERATOR = "------------------------------";
        
        //variables
        int digit;
        
        //program code
        
        // PART A: "r" removing
        System.out.println( "PART A: 'r' removing" );
        
        String str = "references";
        String resultStr = removeR( str );
        
        System.out.println( str );
        System.out.println( resultStr );
        
        System.out.println( SEPERATOR );
        
        // PART B: decimal to hexidecimal
        System.out.println( "PART B: decimal to hexidecimal" );
        
        System.out.println( "Decimal value : 1587" );
        System.out.println( "Dexahecimal value : " + decToHeximal( 1587 ) );
        
        System.out.println( SEPERATOR );
       
        //PART C : lexicographic (effectively alphabetic) order
        ArrayList<String> list = new ArrayList<>();
        System.out.println( "PART C : lexicographic (effectively alphabetic) order" );
        
        list.add("car");
        list.add("abcdf");
        list.add("cbf");
        
        for ( int i = 0; i < list.size(); i++ ) {
            System.out.print( list.get(i) + ", " );
        }
        System.out.println();
        
        System.out.println( "LexicoGraphic or not: " + isLexicoGraphic( list ) );
        
        System.out.println( SEPERATOR );
        
        //PART D : reversed string
        System.out.println( "PART D : reversed string" );
        System.out.println( "String is 'computer' ");
        System.out.println( "Reversed string is " + reversedString( "computer" ));
        
        System.out.println( SEPERATOR );
       
        //PART E : digit
        System.out.println( "PART E : digit operation" );
        System.out.print( "Please enter the number of digits: " );
        digit = scan.nextInt(); 
        
        displayNumbers( (int) Math.pow( 10, digit-1 ), (int) Math.pow( 10, digit ));
        
        
        scan.close();
    } 
    
    /**
     * recursive method for removing "r" from string
     * @param String str
     * @return String without "r" characters
     */
    public static String removeR( String str ) {
        //base
        if ( str.length() <= 0 ) {
            return str;
        }
        //checking first character
        if ( str.charAt(0) == 'r' ) {
            return removeR( str.substring(1) );
        }
        //recursion part
        return str.charAt(0) + removeR( str.substring(1) );
    }
    
    /**
     * Converting decimal to hexadecimal by recursion
     *@param decimal value
     *@return decaheximal value 
     */
    public static String decToHeximal( int decimal ) {
        //decaheximal numbers
        String[] remainders = { "0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
        String remainderString = "";
        // base
        if ( decimal == 0 ) {
            return "";
        }
        int remainder = decimal % 16;
        remainderString = remainders[remainder] + remainderString;
        // recursion
        return decToHeximal( decimal/16 ) + remainderString; 
    }
    
    /**
     * Checking whether an arraylist's elements are sorted in lexicographic(alphabetic) order or not.
     * @param list 
     * @return boolean true or false
     */
    public static boolean isLexicoGraphic( ArrayList<String> list){
        //base
        if ( list.size() <= 1 ){
            return true;
        }
        int result = list.get(0).compareTo( list.get(1));
        if ( result > 0 ) {
            return false;
        }
        else {
            list.remove(0);
            return isLexicoGraphic(list);
        }
    }
    
    /**
     * Reversing a string.
     * @param str 
     * @return reversed form of str
     */
    public static String reversedString ( String str ) {
        // base 
        if ( str.equals("") ) {
            return "";
        }
        // recursion part
        return reversedString( str.substring( 1 ) ) + str.charAt( 0 );
    }
    
    /**
     * Displays numbers starting from a value up to the end 
     * numbers are even, digits in increasing order
     * @param start value
     * @param end value
     */
    public static void displayNumbers( int start, int end ) {
        if (  end < start ) {
            // base 
        }
        if ( start <= 0 ) {
            // base
        }
        // checking if the number is pleasing the requirements
        if ( numberCheck( start) ) {
            System.out.print( start + " " );
        }
        while ( start <= end ) {
            // recursion part
            displayNumbers( start + 1, end );
        }
    }
    
    /** 
     * @param number num
     * @return true or false.
     */
    public static boolean numberCheck( int num ) {
        
        int bigdigit = 10; 
        int currTerm;
        
        // even or not.
        if ( num % 2 != 0 ) {
            return false;
        }
        while (num > 0 ) {
            // last digit 
            currTerm = num % 10;
            if (bigdigit <= currTerm) {
                return false;
            }
            bigdigit = currTerm;
            // other digits
            num = num / 10;
        }
        return true;
    }      
}
