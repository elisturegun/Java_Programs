/**
 * Addition operation class
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class Addition extends Operation{

    //constructor
    public Addition() {

    }

    //methods

    /**
     * adding method
     * @param a
     * @param b
     * @return a+b
     */
    public int calculateResult(int a, int b){
        count();
        return a+b;
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Calculatin button class for binary operations
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class CalculationButton extends JButton implements ActionListener {

    //properties
    CalculationButton calBut;
    JTextField number1;
    JTextField number2;
    JLabel result;
    Operation opr;
    CountInformer informer;
    String name;


    //constructor
    public CalculationButton(Operation opr, CountInformer info){
        super();
        informer = info;
        this.addActionListener(this);
        this.opr = opr;
    }


    /**
     * setter method for arranging textfields to properties
     * @param field1
     * @param field2
     */
    public void setFields(JTextField field1, JTextField field2){
        number1 = field1;
        number2 = field2;
    }

    /**
     * setting Jlabel to given parameter
     * @param label
     */
    public void setResultLabel(JLabel label){
        result = label;
    }


    /**
     * actionperformed class for binary operations, calling spesific calculations
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Division division = new Division();
        Multiplication mul = new Multiplication();

            if (addition.getClass() == opr.getClass()) {
                int first = Integer.valueOf(number1.getText());
                int sec = Integer.valueOf(number2.getText());
                opr.calculateResult(first, sec);
                result.setText("Result: " + addition.calculateResult(first, sec));
                informer.countUpdated();

            } else if (subtraction.getClass() == opr.getClass()) {
                int first = Integer.valueOf(number1.getText());
                int sec = Integer.valueOf(number2.getText());
                opr.calculateResult(first, sec);
                result.setText("Result: " + subtraction.calculateResult(first, sec));
                informer.countUpdated();

            } else if (division.getClass() == opr.getClass()) {
                int first = Integer.valueOf(number1.getText());
                int sec = Integer.valueOf(number2.getText());
                opr.calculateResult(first, sec);
                result.setText("Result: " + division.calculateResult(first, sec));
                informer.countUpdated();
            }
            else if (mul.getClass() == opr.getClass()) {
                int first = Integer.valueOf(number1.getText());
                int sec = Integer.valueOf(number2.getText());
                opr.calculateResult(first, sec);
                result.setText("Result: " + mul.calculateResult(first, sec));
                informer.countUpdated();
            }
        }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Calculator panel
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */

public class CalculatorPanel extends JPanel implements CountInformer{

    //properties
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private static Operation[] arr = new Operation[8];
    final int FIELD_WIDTH = 10;
    JLabel countResult;

    //main method
    public static void main( String [] args){
        CalculatorPanel newPanel = new CalculatorPanel();
    }

    //constructor for creating ui elements
    public CalculatorPanel(){

        //creating operation instances
        Operation oprAdd = new Addition();
        arr[0] = oprAdd;
        Operation oprSub = new Subtraction();
        arr[1] = oprSub;
        Operation oprMul = new Multiplication();
        arr[2] = oprMul;
        Operation oprDiv = new Division();
        arr[3] = oprDiv;
        Operation oprSquare = new Square();
        arr[4] = oprSquare;
        Operation oprRoot = new Root();
        arr[5] = oprRoot;
        Operation oprCube = new Cube();
        arr[6] = oprCube;
        Operation oprNeg = new Negation();
        arr[7] = oprNeg;


        final int FIELD_WIDTH = 10;

        //labels
        JLabel num1 = new JLabel("Number 1:");
        JLabel num2 = new JLabel("Number 2:");

        JLabel resultLabel = new JLabel("Result:                 ");

        //textfields
        JTextField field1 = new JTextField(FIELD_WIDTH);
        JTextField field2 = new JTextField(FIELD_WIDTH);


        //ADD BUTTON - BINARY
        JButton addButton =  new CalculationButton(oprAdd, this);
        addButton.setText("Addition");
        ((CalculationButton) addButton).setFields(field1,field2);
        ((CalculationButton) addButton).setResultLabel(resultLabel);

        //SUBTRACT BUTTON - BINARY
        JButton subButton =  new CalculationButton(oprSub,this);
        subButton.setText("Subtract");
        ((CalculationButton) subButton).setFields(field1,field2);
        ((CalculationButton) subButton).setResultLabel(resultLabel);

        //DIVIDE BUTTON - BINARY
        JButton divButton =  new CalculationButton(oprDiv,this);
        divButton.setText("Divide");
        ((CalculationButton) divButton).setFields(field1,field2);
        ((CalculationButton) divButton).setResultLabel(resultLabel);

        //MULTIPLICATION BUTTON - BINARY
        JButton mulButton =  new CalculationButton(oprMul,this);
        mulButton.setText("Multiply");
        ((CalculationButton) mulButton).setFields(field1,field2);
        ((CalculationButton) mulButton).setResultLabel(resultLabel);

        //ROOT BUTTON - UNARY
        JButton rootButton =  new UnaryCalculationButton(oprRoot, this);
        rootButton.setText("3th root");
        ((UnaryCalculationButton) rootButton).setFields(field1,field2);
        ((UnaryCalculationButton) rootButton).setResultLabel(resultLabel);
        rootButton.setBackground(Color.RED);

        //SQUARE BUTTON - UNARY
        JButton squareButton =  new UnaryCalculationButton(oprSquare,this);
        squareButton.setText("Square");
        ((UnaryCalculationButton) squareButton).setFields(field1,field2);
        ((UnaryCalculationButton) squareButton).setResultLabel(resultLabel);
        squareButton.setBackground(Color.RED);

        //CUBE BUTTON - UNARY
        JButton cubeButton =  new UnaryCalculationButton(oprCube,this);
        cubeButton.setText("Cube");
        ((UnaryCalculationButton) cubeButton).setFields(field1,field2);
        ((UnaryCalculationButton) cubeButton).setResultLabel(resultLabel);
        cubeButton.setBackground(Color.RED);

        //NEGATION BUTTON - UNARY
        JButton negButton =  new UnaryCalculationButton(oprNeg,this);
        negButton.setText("Negation");
        negButton.setBackground(Color.RED);
        ((UnaryCalculationButton) negButton).setFields(field1,field2);
        ((UnaryCalculationButton) negButton).setResultLabel(resultLabel);


        //adding components
        JPanel panel = new JPanel();

        panel.add(num1);
        panel.add(field1);

        panel.add(num2);
        panel.add(field2);

        panel.add(resultLabel);

        //binary operations
        panel.add(addButton);
        panel.add(subButton);
        panel.add(divButton);
        panel.add(mulButton);


        //unary operations
        panel.add(rootButton);
        panel.add(squareButton);
        panel.add(cubeButton);
        panel.add(negButton);

        //count results
        countResult = new JLabel("");
        panel.add(countResult);

        //displaying frame
        JFrame frame = new JFrame("Calculator");

        frame.add(panel);

        frame.setVisible(true);
        frame.setSize( WIDTH , HEIGHT);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void calculateAndUpdateCountMessage(){

        int numberOfTimesCalled;
        //setText
        String str = "Add: " +arr[0].getNumOfOpr()+"Subtraction: "+arr[1].getNumOfOpr()+"Multiplication: "+arr[2].getNumOfOpr()+"Division: "+arr[3].getNumOfOpr()+"3th root: "+arr[4].getNumOfOpr()+"Square: "+arr[5].getNumOfOpr()+"Cube: "+arr[6].getNumOfOpr()+"Negation: "+arr[7].getNumOfOpr();
        countResult.setText(str);
    }


    @Override
    public void countUpdated() {
        calculateAndUpdateCountMessage();
    }
}

/**
 * Count informer interface with one method countupdated
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */public interface CountInformer {

    void countUpdated();
}

/**
 * Cube operation class
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class Cube extends Operation{

     //constructor
     public Cube(){}

    /**
     * method for calculating the third power of a number
     * @param a
     * @param b
     * @return math.pow(a,3)
     */
    @Override
    int calculateResult(int a, int b) {
        return (int) Math.pow(a,3);
    }
}

/**
 * Division operation class
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class Division extends Operation{
    Operation opr;

    //constructor
    public Division(){

    }

    /**
     * division method
     * @param a
     * @param b
     * @return a/b
     */
    public int calculateResult(int a, int b){
        count();
        return a/b;
    }
}

/**
 * multiplication operation class
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class Multiplication extends Operation{

    //constructor
    public Multiplication(){}

    /**
     * multiply the parameters
     * @param a
     * @param b
     * @return a*b
     */
    @Override
    int calculateResult(int a, int b) {
        return a*b;
    }
}

/**
 * Negation operation class
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class Negation extends Operation{

    //constructor
    public Negation(){}

    /**
     * turning the parameter to negative one
     * @param a
     * @param b
     * @return -a
     */
    @Override
    int calculateResult(int a, int b) {
        return -a;
    }
}

/**
 * Operation superclass
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public abstract class Operation {

    private int numOfOpr;
    private boolean checkBinary;
    private String name;


    /**
     * increment the count of certain calculation
     */
    public void count() {
        numOfOpr =  numOfOpr+1;
    }

    /**
     * getter method for count
     * @return numofopr
     */
    public int getNumOfOpr(){
        return numOfOpr;
    }

    /**
     * abstract calculation method
     * @param a
     * @param b
     */
    abstract int calculateResult(int a, int b);
}

/**
 * 3th root operation class
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class Root extends Operation{

    //constructor
    public Root(){

    }

    /**
     * taking third root of the paramater
     * @param a
     * @param b
     * @return math.cbrt function
     */
    public int calculateResult(int a, int b){
        count();
        return (int) Math.cbrt(a);
    }
}

/**
 * Square operation class
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class Square extends Operation {

    //constructor
    public Square(){

    }

    /**
     * tahing square of paramter
     * @param a
     * @param b
     * @return a*a
     */
    public int calculateResult(int a, int b){
        count();
        return a*a;
    }
}

/**
 * Subtraction operation class
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class Subtraction extends Operation {

    //constructor
    public Subtraction(){
    }


    /**
     * subtract b form a parameter
     * @param a
     * @param b
     * @return a-b
     */
    public int calculateResult(int a, int b){
        count();
        return a-b;
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
/**
 * Calculation button class for unary operations
 * @author Oyku Elis Turegun 21902976
 * @version 17.11.2021
 */
public class UnaryCalculationButton extends CalculationButton {

    //constructor
    public UnaryCalculationButton(Operation opr, CountInformer info){
        super(opr,info);
        this.addActionListener(this);
        this.opr = opr;
    }

    /**
     * setting textfields
     * @param field1
     * @param field2
     */
    public void setFields(JTextField field1, JTextField field2){
        number1 = field1;
        number2 = field2;
    }

    /**
     * setting result label
     * @param label
     */
    public void setResultLabel(JLabel label){
        result = label;
    }


    /**
     * actionperformed class for unary operation
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Square square = new Square();
        Root root = new Root();
        Cube cube = new Cube();
        Negation neg = new Negation();

        if (root.getClass() == opr.getClass()) {
            int first = Integer.valueOf(number1.getText());
            int sec = Integer.valueOf(number2.getText());
            opr.calculateResult(first, sec);
            result.setText("Result: " + root.calculateResult(first, sec));
            number2.setText("");
            informer.countUpdated();
        }
        else if (square.getClass() == opr.getClass()) {
            int first = Integer.valueOf(number1.getText());
            int sec = Integer.valueOf(number2.getText());
            opr.calculateResult(first, sec);
            result.setText("Result: " + square.calculateResult(first, sec));
            number2.setText("");
            informer.countUpdated();
        }
        else if (cube.getClass() == opr.getClass()) {
            int first = Integer.valueOf(number1.getText());
            int sec = Integer.valueOf(number2.getText());
            opr.calculateResult(first, sec);
            result.setText("Result: " + cube.calculateResult(first, sec));
            number2.setText("");
            informer.countUpdated();
        }
        else if (neg.getClass() == opr.getClass()) {
            int first = Integer.valueOf(number1.getText());
            int sec = Integer.valueOf(number2.getText());
            opr.calculateResult(first, sec);
            result.setText("Result: " + neg.calculateResult(first, sec));
            number2.setText("");
            informer.countUpdated();
        }
    }
}
