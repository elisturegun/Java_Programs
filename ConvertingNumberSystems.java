import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * class for converting 
 * @author Oyku Elis Turegun 21902976
 * @version 31.03.2021 
 */
public class Converting extends JPanel {
    
    //constants
    private final String[] LETTERS = { "A" , "B" , "C" , "D" , "E" , "F" };
    
    //properties
    private JTextField decimalText;
    private JTextField binaryText;
    private JTextField heximalText;
    

    public Converting() {
        this.setLayout(new GridLayout(0 , 2));
        createPanelComponents();
    }


    private void createPanelComponents() {
        JLabel binaryLab = new JLabel("Binary: ");
        JLabel decimalLabel = new JLabel("Decimal: ");
        JLabel heximalLabel = new JLabel("Hex: ");


        decimalText = new JTextField();
        decimalText.addActionListener(new DecimalAction());
        
        this.add(decimalLabel);
        this.add(decimalText);
        
        heximalText = new JTextField();
        heximalText.addActionListener (new HexAction());
        
        this.add(heximalLabel);
        this.add(heximalText);
        
        binaryText = new JTextField();
        binaryText.addActionListener (new BinaryAction());
        
        this.add(binaryLab);
        this.add(binaryText);
    }


    public class DecimalAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            binaryText.setText( decimalToBinary(Integer.parseInt(decimalText.getText())));
            heximalText.setText( decimalToHex(Integer.parseInt(decimalText.getText())));
            
        }
    }


    public class HexAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            binaryText.setText( hexToBinary( heximalText.getText()));
            decimalText.setText( hexToDecimal( heximalText.getText())); 
        }
    }


    public class BinaryAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            decimalText.setText( binaryToDecimal( binaryText.getText()));
            heximalText.setText( binaryToHex( binaryText.getText()));
        }
    }


    private String binaryToDecimal(String bin) {
        int step;
        int result = 0;

        for (int x = bin.length(); x > 0; x-- ) {
            String num = "" + bin.charAt( x - 1 );
            if ( num.equals("1") ) {
                int powResult = 1;
                step = bin.length() - x;
                for ( int counter = 0; counter < step; counter++ ) {

                    powResult = powResult * 2;
                }
                result = result + powResult;
            }
        }
        return "" + result;
    }

    private String decimalToBinary(int tenBase) {

        if (tenBase == 0 ) {
            return "" + 0;
        }
        String binaryRep = "";
        for (int remainder; tenBase > 0; tenBase = tenBase / 2 ) {
            remainder = tenBase % 2;
            binaryRep = remainder + binaryRep;
        }
        if ( tenBase < 0 ) {
            return "minus " + binaryRep;
        }
        else {
            return binaryRep;
        }
    }

    private String decimalToHex(int baseTen) {

        String hexStr = "";
        String sRemainder;

        if (baseTen == 0 ) {
            return "0";
        }
        for (int remainder; baseTen > 0; baseTen = baseTen / 16 ) {
            remainder = baseTen % 16;
            if ( remainder >= 10 ) {
                sRemainder = toHexLetter(remainder);
            }
            else {
                sRemainder = "" + remainder;
                hexStr = sRemainder + hexStr;
            }
        }
        return hexStr;
    }


    private String hexToDecimal(String hex) {

        int result = 0;
        for (int x = 0; x < hex.length() ; x++ ) {
            String num = "" + hex.charAt(x);

            if ( num.equalsIgnoreCase(LETTERS[0] )) {
                num = "" + 10;
            }
            if ( num.equalsIgnoreCase(LETTERS[5] )) {
                num = "" + 15;
            }
            if ( num.equalsIgnoreCase(LETTERS[1] )) {
                num = "" + 11;
            }
            if ( num.equalsIgnoreCase(LETTERS[2] )) {
                num = "" + 12;
            }
            if ( num.equalsIgnoreCase(LETTERS[3] )) {
                num = "" + 13;
            }
            if ( num.equalsIgnoreCase(LETTERS[4] )) {
                num = "" + 14;
            }
        
            int power = (hex.length() - x) - 1;
            int powerResult = (int) (Double.parseDouble(num) *  Math.pow(16 , power ) );

            result += powerResult;
        }
        return "" + result;
    }


    private String hexToBinary(String hex) {
        if (hex.equals("0")) {
            return "0";
        }

        else {
            return decimalToBinary(Integer.parseInt(hexToDecimal(hex)));  //Parse
        }
    }


    private String binaryToHex(String bin) {

        if ( bin.equals("0")) {
            return "0";
        }
        else {
            return decimalToHex(Integer.parseInt(binaryToDecimal(bin)));
        }
    }

    private String toHexLetter(int i) {

        String heximalNum = "";
        if (i == 10 ) {
            heximalNum = LETTERS[0];
        }
        if (i == 14 ) {
            heximalNum = LETTERS[4];
        }
        if (i == 11 ) {
            heximalNum = LETTERS[1];
        }
        if (i == 12 ) {
            heximalNum = LETTERS[2];
        }
        if (i == 13 ) {
            heximalNum = LETTERS[3];
        }
        if (i == 15 ) {
            heximalNum = LETTERS[5];
        }
        return heximalNum;
    }
}

import javax.swing.*;

/**
 * Test class for converting class
 * @author Oyku Elis Turegun
 * @version 31.03.2021 
 */

public class Test {

    public static void main(String[] args) {
        //variables
        JFrame converterFrame = new JFrame();
        JPanel panel = new Converting();
        
        //program code
        converterFrame.add(panel);
        converterFrame.setSize(300, 300);
        converterFrame.setTitle("Binary Operator");
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converterFrame.setVisible(true);
    }
}
