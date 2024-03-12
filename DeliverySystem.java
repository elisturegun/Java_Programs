import java.util.ArrayList;
/**
 * Class implements Locatable, add customer, create delivery
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public class Company implements Locatable {
    
    //properties
    private final int EMPLOYEE_CAPACITY = 15;
    private Employee[] employees;
    private ArrayList<Customer> customers;
    private int numOfEmployees;
    private int employeeNo;
    private int packageNo;
    private int posX;
    private int posY;
    
    //constructor
    public Company(int x, int y) {
        posX = x;
        posY = y;
        numOfEmployees = 0;
        packageNo = 1;
        employees = new Employee[EMPLOYEE_CAPACITY];
    }
    
    //methods
    @Override
    /**
     * setter method for position coordinates
     */
    public void setPos(int x,int y) {
        posX = x;
        posY = y; 
    }
    
    @Override
    /**
     * @return x coordinate
     */
    public int getX() {
        return posX;
    }
    
    @Override
    /**
     * @return y coordinate
     */
    public int getY() {
        return posY;
    }
    
    /**
     * Adds an employee 
     * @param Employee emp
     * @return true if employee succesfully added
    */
    public boolean addEmployee( Employee emp ) {
       if( numOfEmployees < EMPLOYEE_CAPACITY ) {
           employees[numOfEmployees] = emp;
           numOfEmployees++;
           return true;
       }
       return false;
    }
    
    /**
     * Adds a customer
     * @param customer
     */
    public void addCustomer ( Customer customer ) {
        customers.add( customer);
    }
    
    /**
     * Terminates the contract of an employee
     * @param employeeIndex is the index 
     * @return true if employee is terminated
     */
    public boolean terminateContract( int employeeIndex ) {
        if ( employeeIndex < EMPLOYEE_CAPACITY && employees[employeeIndex] != null ) {
            for ( int i = employeeIndex + 1; i < numOfEmployees; i++ ) {
                employees[i-1] = employees[i];
            }
            numOfEmployees--;
            return true;
        }  
        return false;
    }
    
    /**
     * Creates a delivery object, if employee is aviable
     * @param sendItem, sender, receiver
     * @return true if item sent
     */
    public boolean createDeliverable( Item sendItem , Customer sender , Customer receiver ) {
        for ( int i = 0; i < numOfEmployees; i++ ) {
            if ( employees[i].getAvailability() ) {
                employees[i].addJob( sendItem , sender , receiver , this.packageNo );
                this.packageNo++;
                return true;
            }
        } 
        return false;
    }
    
    /**
    * Deliver all the packages via Employees and print the delivery information.
    * Type, no, sender and receiver info (name and location) for each delivery.
    */
    public void deliverPackages() {
        for ( int i = 0; i < numOfEmployees; i++ ) {
            employees[i].deliverPackages();
        }
    }
    
    @Override
     /**
     * @return String representation of the company
     */
    public String toString() {
        String result = "";
        result = result + "Coordinates of company: " + posX + " , " + posY + "\n" +  "\n";
        
        for ( int i = 0; i < numOfEmployees; i++ ) {
            result = result + employees[i] + "\n" + "\n";
        }
        
        for ( int i = 0; i < customers.size(); i++ ) {
            result = result + customers.get(i) + "\n" + "\n";
        }
        
        return result;
    }        
    
}

/**
 * Test class for CS102 Lab04 assignment
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public class CompanyTester 
{
    public static void main(String[] args) 
    {
        //constants
        final String SEPERATOR = "----------------------------------";
        
        //variables
        Company company = new Company( 10, 20 );
        
        //program code
        Employee employee1 = new Employee( 2000, "Employee 1" );
        System.out.println( "Employe 1" );
        employee1.adjustSalary( 800 );
        System.out.println( employee1.toString() );
        System.out.println(SEPERATOR);
        
        Employee employee2 = new Employee( 100, "Employee 2" );
        System.out.println( "Employee 2" );
        employee2.adjustSalary( 1000 );
        System.out.println( employee2.toString() );
        System.out.println(SEPERATOR);
        boolean checkEmployee = company.addEmployee( employee2 );
        if ( checkEmployee ){
            System.out.println( "Employee Added" );
        }
        else if ( !checkEmployee ) {
            System.out.println( "Employee cannot be added" );
        }
        System.out.println(SEPERATOR);
        
        Item item1 = new Item( 0.1, "Paper" );
        Item item2 = new Item( 1.5, "Table" );
        Item item3 = new Item( 0.9, "Notebook" );
        Item item4 = new Item( 2, "iPad" );
        Item item5 = new Item( 0.04, "Bag" );
        Item item6 = new Item( 0.07, "Rubber" );
        
        
        System.out.println( "Delivery 1" );
        Customer sender1 = new Customer( "Sender 1" );
        Customer receiver1 = new Customer( "Receiver 1" );
        checkEmployee = sender1.sendItem( company, item1, receiver1 );
        if ( checkEmployee ) {
            System.out.println( "Created delivery!" );
        }
        else {
            System.out.println( "Employee is not available!" );
        }
        System.out.println(SEPERATOR);
        
        
        System.out.println( "Delivery 2" );
        Customer sender2 = new Customer( "Sender 2" );
        Customer receiver2 = new Customer( "Receiver 2" );
        checkEmployee = sender2.sendItem( company, item2, receiver2 );
        if ( checkEmployee ) {
            System.out.println( "Created delivery!" );
        }
        else {
            System.out.println( "Employee is not available!" );
        }
        System.out.println(SEPERATOR);
        
        //number 3
        System.out.println( "Delivery 3" );
        Customer sender3 = new Customer( "Sender 3" );
        Customer receiver3 = new Customer( "Receiver 3" );
        checkEmployee = sender3.sendItem( company, item3, receiver3 );
        if ( checkEmployee ) {
            System.out.println( "Created delivery!" );
        }
        else {
            System.out.println( "Employee is not available!" );
        }
        System.out.println(SEPERATOR);
        
        
        System.out.println( "Delivery 4" );
        Customer sender4 = new Customer( "Sender 4" );
        Customer receiver4 = new Customer( "Receiver 4" );
        checkEmployee = sender4.sendItem( company, item4, receiver4 );
        if ( checkEmployee ) {
            System.out.println( "Created delivery!" );
        }
        else {
            System.out.println( "Employee is not available!" );
        }
        System.out.println(SEPERATOR);
        
        
        System.out.println( "Delivery 5" );
        Customer sender5 = new Customer( "Sender 5" );
        Customer receiver5 = new Customer( "Receiver 5" );
        checkEmployee = sender5.sendItem( company, item5, receiver5 );
        if ( checkEmployee ) {
            System.out.println( "Created delivery!" );
        }
        else {
            System.out.println( "Employee is not available!" );
        }
        System.out.println(SEPERATOR);
        
        System.out.println( "Delivery 6" );
        Customer sender6 = new Customer( "Sender 6" );
        Customer receiver6 = new Customer( "Receiver 6" );
        checkEmployee = sender6.sendItem( company, item6, receiver6 );
        if ( checkEmployee ) {
            System.out.println( "Created delivery!" );
        }
        else {
            System.out.println( "Employee is not available!" );
        }
        System.out.println(SEPERATOR);
        
        
        System.out.println( "Information of employee 2" );
        System.out.println( employee2.toString() );
        
        
        System.out.println(SEPERATOR);
        System.out.println( "Deliver all the packages ");
        System.out.println(SEPERATOR);
        company.deliverPackages();
        
 
    }// end of main
 
 }//end of class

/**
 * Class extends Person, set item, send item
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public class Customer extends Person {
    //properties 
    private Item currentItem;
    
    //constructor
    public Customer(String name) {
        super(name);
    }
    
    //methods
    
    /**
     * getter method for item property
     * @return currentItem
     */
    public Item getItem() {
        return currentItem;
    }
    
    /**
     * setter method for currentItem
     * @param Item currentItem
     */
    public void setItem(Item currentItem) {
        this.currentItem = currentItem;
    }
    
    /**
     * String representation of customer
     * @return properties of item
     */
    public String toString() {
        if ( currentItem == null ) {
            return this.getName() + "\n" + "There is no item";
        }
        return this.getName() + "\n" + currentItem;
    }
    
    /**
     * sends the current item
     * @param company, item, receiver
     * @return true if item is sent
     */
    public boolean sendItem(Company company, Item item, Customer receiver) {
        boolean check = false;
        if ( currentItem != null ) {
            if ( company.createDeliverable(currentItem, this , receiver ) )
                check = true;
        }
        else if ( currentItem == null ) {
            if ( company.createDeliverable(item , this , receiver ) ) {
                check = true;
            }
        }

        return check;
    }
}

/**
 * Abstarct class gets the properties sender, receiver, package no
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public abstract class Delivery {
    //properties
    private int packageNo;
    private Customer sender;
    private Customer receiver;
    
    //contructor
    protected Delivery(Customer sender, Customer receiver, int packageNo) {
        this.sender = sender;
        this.receiver = receiver;
        this.packageNo = packageNo;
    }
    //methods
    
    /**
     * abstract getter method for weight
     */
    public abstract double getWeight();
    
    /**
     * getter method for sender property
     * @return Customer sender
     */
    public Customer getSender() {
        return sender;
    }
    
    /**
     * getter method for receiver property
     * @return Customer receiver
     */
    public Customer getReceiver() {
        return receiver;
    }
    
    /**
     * getter method for packageNo property
     * @return int packageNo
     */
    public int getPackageNo() {
        return packageNo;
    }
}

/**
 * Class extends Person, deliver packages, adjust salary
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public class Employee extends Person {
    //properties
    protected final int MAX_JOBS = 5;
    protected int currentJobs = 0; 
    protected Delivery[] deliveries; //The undelivered packages, mails are held here.
    protected double salary;
    protected int employeeNo;
    protected boolean available;

    //constructor
    public Employee(int employeeNo, String name) {
        super( name );
        this.employeeNo = employeeNo;
    }
    
    //methods
    
    /**
     * Assign parameter value to salary property  
     * @param double value
     */
    public void adjustSalary(double value) {
        salary = value;
    }
    
    /**
     * checks availability of employee
     * @return true if employee is available
     */
    public boolean getAvailability() {
        if ( currentJobs < MAX_JOBS ) {
            available = true;
        }
        available = false;
        return available;
    }
    
    /**
     * Adds a deliver job
     * @param sendItem, sender, receiver, package no
     */
    public void addJob(Item sendItem, Customer sender, Customer receiver,int packageNo) {
        if ( sendItem.getWeight() <= 0.1 ) {
            Mail newMail = new Mail(sendItem.getContent(), sender, receiver, packageNo );
            if ( this.getAvailability() ) {
                deliveries[currentJobs] = newMail;
                currentJobs++;
            }
        }
        else {
            Package newPack = new Package( sendItem , sender , receiver , packageNo );
            if ( this.getAvailability() )
            {
                deliveries[currentJobs] = newPack;
                currentJobs++;
            }  
        }
    }
    
    /**
     * Delivers all the packages
     */
    public void deliverPackages() {
        for ( int i = 0; i < currentJobs; i++ )
        {
            System.out.println( deliveries[i]);
            System.out.println();
            deliveries[i] = null;
        }
        currentJobs = 0;
    }
    
    /**
     * String representation of employee information
     * @return properties of employee
     */
    @Override
    public String toString() {
        if( currentJobs == MAX_JOBS ) {
            return "Name: " + getName() + "\n" + "No: " + employeeNo + "\n" + "Salary: " + salary + "\n" + "Current jobs: " + currentJobs + 
            "\n" + "The employee is unavaiable";
        }
        return "Name: " + getName() + "\n" + "No: " + employeeNo + "\n" + "Salary: " + salary + "\n" + "Current jobs: " + currentJobs;
    }
}

/**
 * Class that get weight , get content
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public class Item {
    //properties
    private double weight;
    private String content;
    
    //contructor
    public Item(double weight, String content) {
        this.weight = weight;
        this.content = content;
    }
    
    //methods
    
     /**
     * getter method for weight property
     * @return weight of item
     */
    public double getWeight() {
        return weight;
    }
    
     /**
     * getter method for content property
     * @return String content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * String representation of item
     * @return properties of ıtem
     */
    public String toString() {
        return " weight = " + getWeight() + " content = " + getContent();
    }
}

/**
 * interface has 3 methods
 * for coordinates and set position 
 */
public interface Locatable {
    int getX();
    int getY();
    void setPos( int x, int y ); 
}

/**
 * Class extends Delivery, assign delivery and get weight
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public class Mail extends Delivery {
    //properties
    private String content;
    
    //contructor
    public Mail(String content, Customer sender, Customer receiver, int packageNo) {
        super( sender, receiver, packageNo );
        this.content = content;
    }
    //methods
    
    /**
     * getter method for weight property
     * @return 0.1
     */
    public double getWeight() {
        return 0.1;
    }
    
    /**
     * String representation of mail
     * @return properties of mail
     */
    public String toString() {
        return "sender = " + getSender() + " receiver = " + getReceiver() + " package no = " + getPackageNo() + "content = " + content;
    }
}

/**
 * Class extends Delivery, get wieght, create delivery
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public class Package extends Delivery {
    //properties
    Item packedItem;
    
    //contructor
    public Package(Item content, Customer sender, Customer receiver, int packageNo) {
        super( sender,receiver,packageNo );
        packedItem = content; 
    }
    
    //methods
    
    /**
     * getter method for weight property
     * @return weight of item
     */
    public double getWeight() {
        return packedItem.getWeight();
    }
    
    /**
     * String representation of packedItem
     * @return properties of ıtem
     */
    public String toString() {
        return packedItem.toString();
    }
    
}

/**
 * Abstract class implements Locatable interface type, get/set name, x and y coordinates
 * @author Oyku Elis Turegun 21902976
 * @version 10.03.21
 */
public abstract class Person implements Locatable{
    //properties
    private String name;
    private int posX;
    private int posY;
    
    //contructor
    protected Person (String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY; 
    }
    
    protected Person(String name) {
        this.name = name;
        this.posX = 0;
        this.posY = 0;
    }
    //methods
    
    /**
     * getter method for name property
     * @return String name
     */
    public String getName() {
        return name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    
    /**
     * getter method for posX property
     * @return int posX
     */
    public int getX() {
        return posX;
    }
    
    /**
     * getter method for posy property
     * @return int posY
     */
    public int getY() {
        return posY;
    }
    
    /**
     * setter method for position 
     * assign x to posX, y to posY
     * @param int x, int y
     */
    public void setPos( int x, int y ) {
        posX = x;
        posY = y;
    }
    
}


