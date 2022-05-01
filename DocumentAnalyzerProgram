import java.awt.*;
import java.io.FileNotFoundException;
import java.util.*;
public class DocumentAnalyzer {

    public static void main(String []args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        String docName;
        int numOfText;
        String option;
        String searchWord;
        Document doc;
        Document[] docs = new Document[100];


        System.out.print("Enter the number of documents: ");
        numOfText = scan.nextInt();

        int number = 0;

        do{
            System.out.print("Enter the name of document " + (number + 1) + ": ");
            docName = scan.next();

            Document newDoc = new Document(docName);

            docs[number] = newDoc;
            docs[number].processDocument();

            number++;

        }while(number < numOfText);


        do {
            System.out.println("Menu Options");
            System.out.println("1. Display the frequency of a word");
            System.out.println("2. Display the most frequent words and their number of appearances in each document");
            System.out.println("3. Calculate the tf-idf of a word");
            System.out.print("Enter the option (enter 4 to quit): ");
            option = scan.next();

            if(option.equals("1")) {

                System.out.print("Enter the word which you want to find the frequency: ");
                searchWord = scan.next();

                for (int i = 0; i < docs.length; i++) {
                    if (docs[i] != null) {
                        System.out.println("Document " + (i + 1));
                        System.out.println("Word: " + searchWord);
                        System.out.println("Term Frequency: " + docs[i].getFrequency(searchWord));
                    }
                }
            }

            if( option.equals("2")){
                for(int j = 0; j < docs.length; j++){
                    if(docs[j] != null) {
                        System.out.println(docs[j].mostFrequent(docs[j]));
                    }
                }
            }

            if( option.equals("3")){

                System.out.print("Enter the word which you want to calculate tf-idf: ");
                String term = scan.next();

                for (int i = 0; i < docs.length; i++) {
                    if (docs[i] != null) {
                        System.out.println("Document " + (i + 1));
                        System.out.println("Word: " + term);
                        System.out.println("tf-idf: " + calcTfIdf(term,docs[i],docs));
                    }
                }

            }
            if ( option.equals("4")){
                System.out.println("Goodbye!");
                break;
            }
        }while(option != "4" );



    scan.close();
    }

    public static double calcTfIdf(String word, Document document, Document[] docs) throws FileNotFoundException {
        double tf;
        double idf;
        double size = 0;
        double tfidf;

        tf = document.getFrequency(word);

        for(int i = 0; i < docs.length; i++){
            if( docs[i] != null){
                size++;
            }
        }

        double count = 0;
        for(int k = 0; k < size; k++ ){
            if( docs[k].getCount(word) != 0){
                count++;
            }
        }

        idf = Math.log(size/count);

        tfidf = tf * idf;

       return tfidf;

    }
}

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

/**
 * a java class to process an text file, split into words
 * calculating the desired word's count and frequency in the text
 * @author Oyku ELis Turegun 21902976
 * @version 26.10.2021
 */
public class Document {

    //properties
    private String fileName;
    private Term arr[] = new Term[10000];

    //constructors
    public Document( String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    public Document ( Document otherdoc) throws FileNotFoundException {
        fileName = otherdoc.fileName;
        processDocument();
    }

    //methods

    /**
     * method for processing an text file by using file and scanner classes
     * creating an term object for each word in the text file and assign it to an term array element
     * @throws FileNotFoundException
     */
    public void processDocument() throws FileNotFoundException {
        String nameOfFile = fileName;
        File name = new File( nameOfFile );
        Scanner scan = new Scanner( name );
        scan.useDelimiter("[^A-Za-z]+");
        int count = 0;
        String newTerm;
        Term term;

        while(scan.hasNext()) {
            newTerm = scan.next();
            term = new Term(newTerm);
            arr[count] = term;
            count++;
        }

    }

    /**
     * getter method for Term array
     * @return arr
     */
    public Term[] getArr(){
        return arr;
    }

    /**
     * method for calculating current size of an array
     * @param arr an term array
     * @return size
     */
    public int getSize( Term[] arr){
        int num = 0;
        for( int k = 0; k < arr.length; k++){
            if(arr[k] != null){
                num++;
            }
        }
        return num;
    }

    /**
     * method for counting the given word in term array we found on the process document method
     * @param word
     * @return the count
     * @throws FileNotFoundException
     */
    public int getCount(String word) throws FileNotFoundException {
        int count = 0;
        for( int m = 0; m < getSize(getArr()); m++){
            if(arr[m].getWord().equals(word)){
                count++;
            }
        }
        return count;
    }

    /**
     * method for finding the frequency of a word in the given file
     * @param word
     * @return frequency
     * @throws FileNotFoundException
     */
    public double getFrequency(String word) throws FileNotFoundException {
        double frequency= 0;

        if( getCount(word) != 0) {
            frequency = (double) getCount(word) / (double) getSize(getArr());
        }
        else if ( getCount(word) == 0) {
            frequency = 0;
        }
        return frequency;
    }

    /**
     * method for calculating the most frequent term( word) on the file
     * @param doc
     * @return most frequent word
     * @throws FileNotFoundException
     */
    public String mostFrequent( Document doc) throws FileNotFoundException {

        int most = getCount( doc.getArr()[0].getWord());

        String word = doc.getArr()[0].getWord();

        for(int s = 1; s < getSize(doc.getArr()); s++){
            if(most < doc.getCount(doc.getArr()[s].getWord())){
                most = doc.getCount(getArr()[s].getWord());
                word = getArr()[s].getWord();
            }

        }
        return "Word: " + word + "\nNumber of appearance: " + most;
    }
}

/**
 * java class for an term object has property string word
 * @author Oyku Elis Turegun 21902976
 * @version 26.10.2021
 */
public class Term {

    //properties
    private int count;
    private String word;

    //constructors
    public Term( String word){
        count = 0;
        this.word = word;
    }

    /**
     * method increases the count by one each time its called
     */
    public void incrementCount(){
        count++;
    }

    /**
     * getter method for word
     * @return String word
     */
    public String getWord(){
        return word;
    }

    /**
     * setter method for word variable
     * @param word
     */
    public void setWord( String word){
        word = this.word;
    }

}

