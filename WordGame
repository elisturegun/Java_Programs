import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Stores words to an ArrayList from text file.
 * Outputs the maximum length of an element, frequency and counts of elements have same length 
 * @author Elis Türegün
 * @version 24.11.2020
*/
public class WordGame {
    
    /**
     * Finds maximum length of elements of arraylist
     * @param ArrayList list
     * @return int maximum length
     */
    public static int findMaxLength( ArrayList<Integer>list ) {
        int maxLength;
        
        maxLength = list.get(0);
        
        for(int i = 1; i < list.size(); i++ ){ // calculating maximum length
            if( list.get(i) > maxLength ){
                maxLength = list.get(i);
             }
         }
        return maxLength;
        
    }
    
    /**
     * Finds most frequent element of ArrayList
     * Finds frequencies of each element 
     * @param ArrayList lengthList
     * @return frenquencies and elements
     */
    public static String frequency ( ArrayList<Integer>lengthList) {
        ArrayList<Integer> uniqueElements;
        ArrayList<Integer> counts;
        int index;
        int maxCount;
        int newCount;
        
        uniqueElements = new ArrayList<Integer>();
        counts = new ArrayList<Integer>();
        maxCount = 0;
        
        for ( int element : lengthList ) {
            index = uniqueElements.indexOf( element );
            if (index != -1 ) {
                newCount = counts.get(index) + 1; //// increment its count
                counts.set(index, newCount);
            }
            else {
                uniqueElements.add(element);
                counts.add(1); //// add it to uniqueElements, set its count to 1 
            }
        }
        //// find maximum count, get the corresponding element
        index = -1;
        
        for(int i = 0; i < counts.size(); i++) {
            if (maxCount < counts.get(i)) {
                maxCount = counts.get(i);
                index = i;
            }
        }
        
        if ( !lengthList.contains( 1 ) ) {
            System.out.println("0 words of length 1");
        }
        
        for ( int c = 0; c < uniqueElements.size(); c++ ) {
            System.out.println( counts.get(c) + " words of length " + uniqueElements.get(c));
            
        }
        return "The most frequently occurring word length is " + uniqueElements.get(index) + " which occurs " + maxCount + " times.";
    }
    
    public static void main(String[] args) throws Exception {
        //constants
        final String FILE_NAME = "text";
        
        //variables
        ArrayList<String> worldList;
        ArrayList<Integer> lengthList;
        int length;
        
        //creating array list
        lengthList = new ArrayList<Integer>();
        worldList = new ArrayList<String>();

        Scanner scan = new Scanner ( new File( FILE_NAME + ".txt" ) );
        
        //initialization
        length = 0; 
        
        //program code
        
        while (scan.hasNext()) { //reading values from file 
            String word = scan.next();
            word = word.replaceAll("\\p{Punct}", ""); // erasing punctuations
            worldList.add(word);                      //adding words to the list
        }
        
        for ( int a = 0; a < worldList.size(); a++ ) { 
            length = worldList.get(a).length(); // calculating lengths of elements
            lengthList.add(length);             // storing lengths in a list
        }

        System.out.println( "The longest word has length " + findMaxLength(lengthList) );
        System.out.println();
        
        System.out.println( frequency( lengthList ) );
        System.out.println();
        
        scan.close();   
    } 
}
