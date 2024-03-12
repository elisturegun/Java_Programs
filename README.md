MY JAVA CODES

LibrarySystem.java

Java code consists of several classes and methods for a library management system. Here's a breakdown of each class:
1-	Library: This class represents a library and includes methods to add, remove, and find books in the library. It has properties such as bookList, which is an ArrayList containing LibraryBook objects. Methods include isEmpty() to check if the library is empty, add() to add a book, remove() to remove a book, findByTitle() to find a book by its title, and toString() to represent the library's information as a string.
2-	LibraryBook: This class represents a book in the library. It has properties like title, author, dueDate, and timesLoaned. Methods include getters for timesLoaned, title, and author, as well as methods like onLoan() to check if the book is on loan, loanBook() to loan the book, returnBook() to return the book, toString() to represent the book's information as a string, equals() to compare books for equality, and hasSameTitle() and hasSameAuthor() to check if books have the same title or author.
3-	LibraryTest: This class serves as a test class for the Library class. It includes a main() method where users can interact with the library system through a console menu. Users can choose options to show, find, or add books, and perform operations like loaning, returning, or removing books.
4-	TestLibraryBook: This class serves as a test class for the LibraryBook class. It includes a main() method to test various functionalities of the LibraryBook class, such as loaning, returning, and comparing books.

DeliverySystem.java

Java code implements a delivery management system with classes representing employees, customers, items, and deliveries. Here's a brief explanation of each component:
1-	Locatable Interface: Defines methods for getting and setting position coordinates.
2-	Person Abstract Class: Represents individuals with a name and position coordinates. It serves as the superclass for both employees and customers.
3-	Employee Class: Extends the Person class and represents company employees. Employees have a salary, can handle a maximum number of jobs, and can add, manage, and deliver packages.
4-	Customer Class: Extends the Person class and represents customers who can send items to other customers. Customers have a current item to send and can initiate deliveries through the company.
5-	Item Class: Represents items with weight and content. Items are used in deliveries.
6-	Delivery Abstract Class: Represents deliveries from senders to receivers. It includes package numbers and sender/receiver information. Subclasses (Mail and Package) define specific types of deliveries.
7-	Mail Class: Extends the Delivery class and represents mail deliveries with a fixed weight and content.
8-	Package Class: Extends the Delivery class and represents package deliveries with variable weights based on the items being delivered.
9-	Company Class: Implements the Locatable interface and represents a company that employs employees and manages customer deliveries. It can add employees, add customers, create deliverables, terminate contracts, and deliver packages.
10-	CompanyTester Class: Contains the main method to test the functionalities of the Company class and its related components. It creates instances of employees, customers, items, and the company and initiates deliveries to test delivery functionality.
Overall, the code provides a framework for managing employees, customers, items, and deliveries within a company, facilitating the logistics of package handling and delivery.

DiceGame.java

Java code consists of several classes related to a dice game:
1-	Dice Class: Represents a pair of dice. It contains methods for rolling the dice, getting the face value of each die, and getting the total value of the dice.
2-	DiceGame Class: Implements the logic for playing the dice game. It repeatedly rolls the dice until a specific condition is met (in this case, rolling a total of 12).
3-	Die Class: Represents a single die. It contains methods for rolling the die and getting its face value.
4-	DiceCalculator Class: A standalone class that simulates rolling two dice until both show the maximum value (6) and reports the number of rolls required.
5-	TestDiceGame Class: A test class that demonstrates how to use the DiceGame class by playing the game and printing the number of times it took to reach the target total.
6-	TestDie Class: A test class that demonstrates how to use the Die class by rolling two dice and printing their face values.
Overall, these classes provide a framework for simulating dice games and testing individual die rolls.

DocumentAnalyzerProgram.java

Java code comprises three classes:
1-	DocumentAnalyzer: This class contains the main method and is responsible for analyzing multiple documents. It prompts the user to enter the number of documents and their names. Then, it processes each document, allowing the user to choose from several options such as displaying the frequency of a word, finding the most frequent words and their appearances, calculating the TF-IDF (Term Frequency-Inverse Document Frequency) of a word, or quitting the program.
2-	Document: This class represents a document. It processes a text file, splits it into words, and calculates the count and frequency of a given word in the document. It also calculates the most frequent word in the document.
3-	Term: This class represents a term (word) in a document. It has properties for the word itself and a count representing how many times the word appears in the document. It also has methods to increment the count and retrieve the word.
Overall, this code provides functionality to analyze and process text documents, including tasks such as word frequency analysis and TF-IDF calculation.

ArithmeticCalculatorProgram.java

Java classes constitute a simple calculator application with binary and unary operations:
1-	Operation and Subclasses:
Operation: Abstract class defining common behavior for mathematical operations.
Subclasses (Addition, Subtraction, Multiplication, Division, Square, Cube, Root, Negation):   Implement specific arithmetic operations.
2-	CalculationButton and its Subclass:
CalculationButton: Abstract class representing a button for binary operations.
UnaryCalculationButton: Subclass of CalculationButton for unary operations.
3-	CalculatorPanel: Swing panel for the calculator interface, setting up UI components and event handling.
4-	CountInformer Interface:Interface defining a method for count updates.

BinaryToDecimal.java

Java method converts binary numbers to decimal. It takes a string representing a binary number as input and returns its equivalent decimal value.

BombGame.java

These Java classes constitute a simple bomb game GUI application. Here's a brief explanation of each class:
1-	BombButton: Represents a button in the game. When clicked, it disables itself and reveals a graphical representation of a bomb.
2-	BombGame: Contains the main method to launch the bomb game. It creates a frame and adds a panel to it.
3-	GamePanel: Panel where the bomb game is played. It contains buttons arranged in a grid layout. Some buttons are bombs, some are prizes, and others are regular buttons. It handles game logic, such as incrementing guesses, determining win/loss conditions, and revealing bombs/prizes at the end of the game.
4-	PrizeButton: Represents a button that reveals a prize when clicked. It changes its text to a star emoji and adjusts its font and color.
5-	RegularButton: Represents a regular empty button in the game. When clicked, it disables itself.
Overall, these classes work together to create a simple bomb game interface where players click buttons to guess and reveal bombs or prizes.

ConvertingNumberSystems.java

This Java code consists of two classes:
1-	Converting: This class extends JPanel and provides functionality to convert between decimal, binary, and hexadecimal numbers. It includes methods to convert decimal to binary, decimal to hexadecimal, hexadecimal to decimal, hexadecimal to binary, binary to decimal, and binary to hexadecimal. Each conversion method is implemented as an ActionListener subclass, and it updates the corresponding text fields accordingly. The class also contains constants for hexadecimal letters and methods to handle conversions between hexadecimal letters and decimal numbers.
2-	Test: This class contains the main method to test the functionality of the Converting class. It creates a JFrame and adds an instance of the Converting class as a panel to it.
Overall, this code provides a graphical user interface (GUI) for converting between decimal, binary, and hexadecimal numbers.

DecimalToBinary.java

This Java method toBinary converts a decimal number to its binary representation.

Drawing2DArrays.java

Java code defines a class named FillBox that contains methods for creating, filling, and printing a two-dimensional array representing a box. Here's a brief explanation of each method:
1-	main method: It creates two two-dimensional arrays of characters, one with dimensions 25x25 and the other with dimensions 49x49. It then draws a figure inside each array and prints them.
2-	createArray method: It creates a new two-dimensional array with the specified number of rows and columns. It fills the edges of the array with the character '#' and leaves the inside blank.
3-	printArray method: It prints all elements of a two-dimensional array by visiting each element with nested for loops.
4-	fillBox method: It fills the inside of the box represented by the two-dimensional array with a given character (ch). It recursively checks neighboring cells to see if they are empty and fills them if they are.
5-	drawFigure method: It recursively divides the box into quadrants until the size of the box is smaller than 7x7. At that point, it fills the remaining space with a given character ('*') using the fillBox method.
Overall, this code demonstrates a recursive approach to filling a two-dimensional array representing a box and dividing it into quadrants.

FibonacciNumbers.java

The code comprises three classes: IntBag, Fibonacci, and Test.
1-	IntBag class manages a collection of integers, offering methods to add, remove, and find values.
2-	Fibonacci class calculates and prints Fibonacci numbers, utilizing an IntBag object to store and display them.
3-	Test class includes the main() method, allowing users to interact with the IntBag collection through a menu-driven interface.

MonteCarloSimulator.java

Java code simulates a Monte Carlo simulation to estimate the value of π. Here's a breakdown of each class:
1-	MonteCarloSimulator: This class contains the main method where the Monte Carlo simulation is performed. It prompts the user to input the number of tries for the simulation. It creates instances of Rectangle and Circle objects to represent the simulation area and the inscribed circle. Inside a loop, it generates random points within the rectangle and checks if they fall within the circle, updating the 'hits' count accordingly. Finally, it calculates and prints an estimate for the value of π based on the ratio of hits to tries.
2-	Circle: This class represents a circle with a center point and a radius. It has methods to set and get the radius, get the center point, set a new center point, check if a given point is within the circle, and provide a string representation of the circle.
3-	Point: This class represents a point in a 2D coordinate system. It has methods to set and get the x and y coordinates of the point and provide a string representation of the point.
4-	Rectangle: This class represents a rectangle with a corner point, width, and height. It has methods to set and get the width and height, get the corner point, set a new corner point, check if a given point is within the rectangle, generate a random point within the rectangle, and provide a string representation of the rectangle.
Overall, this code simulates random points within a rectangle and estimates the value of π based on the ratio of points falling within an inscribed circle.

Polynomials.java

The code covers a wide range of polynomial operations, including addition, subtraction, multiplication, composition, and division, along with evaluation and string representation of polynomials.

RecursiveMethods.java

The code consists of five parts:
1-	Part A: Removes 'r' characters from a string recursively.
2-	Part B: Converts decimal to hexadecimal recursively.
3-	Part C: Checks if strings are in alphabetical order recursively.
4-	Part D: Reverses a string recursively.
5-	Part E: Displays even numbers with increasing digits recursively.

WordGame.java

Java program reads words from a text file, removes punctuation, and stores them in an ArrayList. It then calculates and outputs the maximum length of a word, as well as the frequency of each word length and the most frequently occurring word length.
The findMaxLength method calculates the maximum length of the words in the ArrayList.
The frequency method determines the most frequently occurring word length and its frequency, while also printing the frequencies of each word length.
In the main method, the program reads words from a text file, stores them in an ArrayList, calculates word lengths, and prints the maximum word length and word length frequencies.

