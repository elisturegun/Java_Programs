import java.util.ArrayList;
/**
 * Library system to add, remove or find book in Library
 * @author Elis Türegün
 * @version 24.11.2020
 */
public class Library {
  
  //properties
  private ArrayList<LibraryBook> bookList;
  
  //constructor
  public Library() {
    bookList = new ArrayList<LibraryBook>();
  }
  
  /**
   * @check if the library is empty or not
   * @return true if the library is empty
   */
  public boolean isEmpty() {
    final int EMPTY = 0;
    
    return bookList.size() == EMPTY;
  }
  
  /**
   * Add book to the library system
   * @param author
   * @param title 
   * no return
   */
  public void add( String title, String author) {
    LibraryBook book;
    book = new LibraryBook( title, author);
    
    bookList.add( book );
    System.out.println("The book is added on library");
  }
  
  /**
   * Remove a requested book from library system
   * @param LibraryBoook object
   * @return true if the removing process worked right
   */
  public boolean remove( LibraryBook libBook ) {
    boolean check;
    
    check = false;
    
    for ( int i = 0; i <= bookList.size() -1; i++ ) {
      
      if ( bookList.get(i) == libBook ) {
        bookList.remove(i);
        check = true;
        System.out.println("The book is removed from library.");
      }
    }
    return check;
  }
  
  /**
   * Search books in library by its title
   * @param String title
   * @return LibraryBook object
   */
  public LibraryBook findByTitle( String title ) {
    LibraryBook anotherBook;
    anotherBook = null;
    
    for ( int i = 0; i <= bookList.size() -1; i++ ) {
      if ( bookList.get(i).getTitle().equals(title) ) {
        anotherBook = bookList.get(i);
      }
    }
    if ( anotherBook == null ) {
      System.out.println( "The book is not in the library!" ); 
    }
    
    return anotherBook;
  }
  
  /**
   * String representation oof LibraryBook
   * no parameter
   * @return string representation
   */
  public String toString() {
    String message;
    message = "";
    
    if ( isEmpty() ) {
      message = "Library is empty!";
    }
    else {
      for ( int a = 0; a <= bookList.size() - 1; a++ ) {
        message = bookList.get(a).toString() + "\n";
      }
    }   
    return message;
  }  
}
/**
 * Library application for loaning/returning book
 * @author Elis Turegun
 * @version 17.12.20
 */
public class LibraryBook {
    
    //properties
    private String title;
    private String author;
    private String dueDate;
    private int timesLoaned;
    
    //constructor
    public LibraryBook( String titleBook, String authorBook) {
        title = titleBook; 
        author = authorBook;
        dueDate = null;
        timesLoaned = 0;   
    }
    
    //copy contructor
    public LibraryBook ( LibraryBook otherBook ) {
        this.title = otherBook.title;
        this.author = otherBook.author;
        this.dueDate = otherBook.dueDate;
        this.timesLoaned = otherBook.timesLoaned;
    }
    
    //methods
    
    /**
     * Getter method for times loaned
     * @return int timesLoaned
     */
    public int getTimesLoaned() {
        return timesLoaned;
    }
    
    /**
     * Getter method for title
     * @return String title
     */
    public String getTitle() {
        return title; 
    }
    
    /**
     * Getter method for author
     * @return String author
     */
    public String getAuthor() {
        return author; 
    }
    
    /**
     * Checking if the book is available or not
     * @return boolean loanCheck
     */
    
    public boolean onLoan() { 
        boolean loanCheck;
        
        loanCheck = true;
        
        if ( dueDate == null ) {
            loanCheck = false;
            
        }
        else {
            loanCheck = true; 
        }
        return loanCheck;
    }
    
    /**
     * Method for loan the book from library
     * @param dueDateLoan
     */
    
    public void loanBook( String dueDateLoan ) {
        if( onLoan() ) {
            System.out.println("Book is busy...");
        }
        else { 
            timesLoaned++;
            dueDate = dueDateLoan;
            System.out.println("The book is loaned");
        }
    }
    
    /**
     * Method for giving back the book to the library
     */
    public void returnBook() {
        dueDate = null;
        System.out.println("The book is returned to the library");
    }
    
    /**
     * String representation of book information
     * @return title,author,times loaned, due date
     */
    public String toString() {
        return "Title : " + getTitle() + "  Author : " + getAuthor() + 
        " Times Loaned : " + getTimesLoaned() + " Due date : " + dueDate;
    }
    
    /**
     * check if the LibraryBooks are equal or not
     * @param LibraryBook book
     * @return true if they are same
     */
    
    public boolean equals ( LibraryBook firstBook ) {
        boolean check;
        
        check = false;
        
        if ( firstBook.getTitle().equals( title ) && firstBook.getAuthor().equals( author )) {
            check = true;
        }
        return check;
    }
    
    
    /**
     * Check if the LibraryBooks titles are equal or not
     * @param LibraryBook book
     * @return true if titles are same
     */
    public boolean hasSameTitle ( LibraryBook firstBook ) {
        boolean checkTitle;
        
        checkTitle = false;
        
        if ( firstBook.getTitle().equals( title ) ) {
            checkTitle = true;
        }
        return checkTitle;
    }
    
    /**
     * check if the LibraryBooks authors are equal or not
     * @param LibraryBook book
     * @return true if they have same authors
    */
    public boolean hasSameAuthor ( LibraryBook book ) {
        boolean checkAuthor;
        
        checkAuthor = false;
        
        if ( book.getAuthor().equals( author ) ) {
            checkAuthor = true;
        }
        return checkAuthor;
    }
}
import java.util.Scanner;
/**
 * Test class for Library class
 * @author Elis Türegün
 * @version 24.11.2020
 */
public class LibraryTest {
  public static void main ( String [] args ) {
    Scanner scan = new Scanner ( System.in );
    
    final String SEPERATOR = "------------";
    final int OPTION_1 = 1;
    final int OPTION_2 = 2;
    final int OPTION_3 = 3;
    final int OPTION_4 = 4;
    
    final int LOAN = 1;
    final int RETURN = 2;
    final int REMOVE = 3;
    final int BACK_TO_MENU = 4;
    
    
    int userSelection;
    int operationChoice;
    String titleFromUser;
    String authorFromUser;
    Library library;
    LibraryBook book;
    
    library = new Library();
    operationChoice = 0;
    book = null;
    
    System.out.println( "Welcome to the library! ");
    System.out.println( SEPERATOR );
    
    do {
      System.out.println( "Menu");
      System.out.println( "1) Show\n2) Find\n3) Add\n4) Exit");
      System.out.print( "Please select one : ");
      userSelection = scan.nextInt();
      
      System.out.println( SEPERATOR );
      
      // show book information
      if ( userSelection == OPTION_1 ) { 
        System.out.println("BOOK INFORMATION");
        System.out.println( library.toString() );
        System.out.println( SEPERATOR );
      }
      // find book by title
      else if ( userSelection == OPTION_2 ) {
        System.out.print("Enter the title : ");
        titleFromUser = scan.nextLine();
        titleFromUser = scan.nextLine();
        
        book = library.findByTitle( titleFromUser );
        
        do {
          System.out.println( "1) Loan\n2) Return\n3) Remove\n4) Back to menu");
          System.out.print( "Please select one : ");
          operationChoice = scan.nextInt();
          
          if ( operationChoice == LOAN ) { //loan the book
            book.loanBook( "24.02.20" );
            System.out.println( SEPERATOR );
          }
          else if ( operationChoice == RETURN ) { //return book
            book.returnBook();
            System.out.println( SEPERATOR );
          }
          else if ( operationChoice == REMOVE ) { //remove book
            library.remove( book );
            book = null;
            System.out.println( SEPERATOR );
          }
          
        }while( operationChoice != BACK_TO_MENU );     
      }
      else if ( userSelection == OPTION_3 ) { // adding book to the library
        System.out.println("ADDING BOOK");
        System.out.print("Enter the title : ");
        titleFromUser = scan.nextLine();
        titleFromUser = scan.nextLine();
        
        System.out.print("Enter the author : ");
        authorFromUser = scan.nextLine();
        
        System.out.println();
        book = new LibraryBook( titleFromUser, authorFromUser );
        
        library.add( titleFromUser, authorFromUser);
        
        System.out.println( SEPERATOR );
      } 
    } while ( userSelection != OPTION_4 );
    
    System.out.println("Exit... Bye!");
    scan.close();  
  }   
}
/**
 * Applying library application
 * @author Elis Turegun
 * @version 24.12.20
 */
public class TestLibraryBook {
    public static void main ( String [] args ) {
        
        // creating object for LibraryBook class
        LibraryBook book1; 
        LibraryBook book2;
        LibraryBook book3;
        LibraryBook book4;
        
        book1 = new LibraryBook( "cs101", "david");
        book4 = book1;
        
        book2 = new LibraryBook( "cs102","aynur");
        
        book3 = new LibraryBook( "cs102", "aynur" );
        
        
        //program code
        
        // toString method testing
        System.out.println( book1.toString() );
        System.out.println( book2.toString() );
        System.out.println();
        System.out.println();
        
        // loanBook method testing
        book1.loanBook( "16.12.20" );
        book2.loanBook( "17.12.20" );

        System.out.println( book1.toString() );
        System.out.println( book2.toString() );
        System.out.println();
        System.out.println();
        
        // onLoan method testing
        book1.onLoan();
        book2.onLoan();
        
        System.out.println();
        
        // returnBook method testing
        book1.returnBook();
        book2.returnBook();
        
        book1.loanBook( "01.01.21" );
        book2.loanBook( "05.01.21" );
        System.out.println();
        
        System.out.println( book1.toString() );
        System.out.println( book2.toString() );
        System.out.println();
        System.out.println();
        
        book1.returnBook();
        book2.returnBook();
        
        System.out.println( book1.toString() );
        System.out.println( book2.toString() );
        System.out.println();
        
        //Difference between .equals() method and == operator
        //Main difference between .equals() method and == operator is that one is method and other is operator.
        //We can use == operators for reference comparison (address comparison) and .equals() method for content comparison. In simple words,
        // == checks if both objects point to the same memory location whereas .equals() evaluates to the comparison of values in the objects
        //If a class does not override the equals method, 
        //then by default it uses equals(Object o) method of the closest parent class that has overridden this method
        //When we use == operator for s1 and s2 comparison then the result is false as both have different addresses in memory.
        //Using equals, the result is true because its only comparing the values given in s1 and s2.
        
        //Comparing two references to a single object
        System.out.println( book1 == book4 );
        System.out.println( book1.equals( book4 ) );
        System.out.println();
        
        
        //Comparing two references to two individual objects with different properties
        System.out.println( book1 == book2 );
        System.out.println( book1.equals( book2 ) );
        System.out.println();
        
        //Comparing two references to two individual objects with identical relevant properties
        System.out.println( book2 == book3 );
        System.out.println( book2.equals(book3) );
        
        //System.out.println( book1.hasSameTitle( book8 ) ) 
        //System.out.println( book1.hasSameAuthor( book8 ) )  
    }
}
