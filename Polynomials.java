/**
 * Polynomial class for Java
 * @author Elis Turegun 21902976
 * @version 10.02.21
 */
public class Polynomial {
     
    //properties
    
    private int exp;
    private double coe;
    private double [] coefficientList;

    
    //constructors
    
    public Polynomial( double coe, int exp) {
        if (exp >= 0) {
            coefficientList = new double[exp+1];
            coefficientList[exp] = coe;
            exp = 0;
            for (int i = 0 ; i <= coefficientList.length - 1; i++) {
                if (coefficientList[i] != 0) {
                    exp = i;
                }
            }
        }
    }
    
    // default constructor
    public Polynomial() {
        coefficientList = new double[1];
        coefficientList[0] = 0;
    }
    
    public Polynomial( double[] arr ) {
        coefficientList = arr;
        exp = 0;
        for ( int i = 0; i < coefficientList.length; i++ ) {
            if ( coefficientList[i] != 0 ) {
                exp = i;
            
            }
        }
 
    }
    
    //methods
    
    public double getCoe() {
        return coe;
        
    }
    public int getExp() {
        return exp;
        
    }

    /**
     * Getter method for coefficient
     * @param int degree
     * @return coefficient of term with given degree
     */
    public double getCoefficient( int degree )
    {
        if ( degree < coefficientList.length && coefficientList.length != 1 ) {
            return coefficientList[degree];
        }
        else {
            if ( coefficientList.length == 1 && getDegree() == degree) {
                return coefficientList[0];
            }
            else {
                return 0;
            }
        }
    }
    
    /**
     * Getter method for degree of polynomial
     * @return int degree
     */
    public int getDegree() {
        if ( coefficientList.length == 1 && getExp() != 0 ) {
            return getExp();
        }
        else {
            return coefficientList.length-1;   
        }
    }
    
    /**
     * String representation of polynomial
     * @return polynomial expression
     */
    public String toString() {
        if      (getDegree() == -1) {
            return "0";
        }
        else if (getDegree() ==  0) {
            return "" + coefficientList[0];
        }
        else if (getDegree() ==  1) {
            return coefficientList[1] + "x + " + coefficientList[0];
        }
        else
        {
            String result = coefficientList[getDegree()] + "x^" + getDegree();
            for (int i = getDegree() - 1; i >= 0; i--) {
                if (coefficientList[i] > 0.0) {
                    result = result + " + " + (coefficientList[i]);
                    if (i == 1) {
                        result = result + "x";
                    } else if (i > 1) {
                        result = result + "x^" + i;
                    }
                } else if (coefficientList[i] < 0.0) {
                    result = result + " - " + (-coefficientList[i]);
                    if (i == 1) {
                        result = result + "x";
                    } else if (i > 1) {
                        result = result + "x^" + i;
                    }
                }
            }
            return result;
        }
    }

        
        
    /**
     * Evaluating polynomial expression with given x
     * @param double x
     * @return result of evaluation
     */
    public double eval( double x ) {
        double resultEval;
        resultEval = 0;
        if ( coefficientList.length == 1 ) {
            resultEval = resultEval + coe * Math.pow(x,exp);
        }
        else {
            for ( int i = 0; i < coefficientList.length; i++ ) {
                resultEval = resultEval + coefficientList[i]*Math.pow(x,i);
            }
        }
        return resultEval;
    }
    
    /**
     * Horner method
     * @param double x
     * @return result of evaluation
     */
    public double eval2( double x ) {
        double resultEval2;
        resultEval2 = 0;
        if ( coefficientList.length == 1 ) {
            resultEval2 = resultEval2 + coe * Math.pow(x,exp);
        }
        else {
            for (int i = coefficientList.length - 1; i >= 0; i--) {
                resultEval2 = coefficientList[i] + (x * resultEval2);
            }
        }
        return resultEval2;
    }
    
    /**
     * Adding two polynomial
     * @param Polynomial p2
     * @return result of adding process
     */
    
    public Polynomial add(Polynomial p2){
        Polynomial poly;
        int degree = getDegree();
        
        if (p2.getDegree() > degree){
          degree = p2.getDegree();
        }
        double[] coefficients = new double[degree+1];
        
        for(int i=0; i <= getDegree(); i++) {
          coefficients[i] += getCoefficient(i);
        }
        
        for(int i=0; i <= p2.getDegree(); i++) {
          coefficients[i] += p2. getCoefficient(i);
          
        }
        poly = new Polynomial(coefficients);

        return poly;
      }
      

    /**
     * Substracting two polynomial
     * @param Polynomial p2
     * @return result of substraction process
     */
    
    public Polynomial sub( Polynomial p2 )
    {
        int degree = Math.max ( getDegree(), p2.getDegree() );
        double[] coefficients = new double[ degree + 1];
        for ( int index = 0; index < coefficients.length; index++ )
        {
            coefficients[index] = - ( getCoefficient(index) - p2.getCoefficient(index));
        }
        exp = coefficients.length-1;
        return new Polynomial( coefficients );
    }
    
    /**
     * Multiplying two polynomial
     * @param Polynomial p2
     * @return result of multiplication process
     */
    
    public Polynomial mul( Polynomial p2 ){
        double[] coefficients = new double[getDegree() + p2.getDegree() + 1];
        for( int i = 0; i <= getDegree(); i++ ) {
            for( int j = 0; j <= p2.getDegree(); j++ ) {
                coefficients[ i + j ] += ( this.getCoefficient(i ) * p2.getCoefficient( j ) );
            }
        }  
        return new Polynomial( coefficients );
    }
    
    /**
     * Composing p2 polynomial into this.polynomial
     * @param Polynomial p2
     * @return result polynomial
     */
    
    public Polynomial compose( Polynomial p2 ) {
        Polynomial c = new Polynomial( 0, 0 );
        if ( coefficientList.length == 1 && p2.coefficientList.length == 1 ) {
            double coef = coefficientList[0] * Math.pow( p2.coefficientList[0], getDegree());
            int deg = getDegree() * p2.getDegree();
            Polynomial term = new Polynomial( coef, deg );
            c = term;
        }
        else {
            for( int i = getDegree(); i >= 0; i-- ) {
                Polynomial term = new Polynomial( coefficientList[ i ], 0 );
                c = term.add( p2.mul( c ) );
            }
        }
        return c;
    }
  
    /**
     * Dividing this.polynomial to p2 plynommail
     * @param Polynomial p2
     * @return quotient of division process
     */
    
    public Polynomial div(Polynomial p2) {
        Polynomial result = new Polynomial();
        Polynomial poly = new Polynomial(coefficientList);
        final int LOOP = poly.getDegree() - p2.getDegree();

            for (int i = 1; i<= LOOP; i++) {
              
                int deg = poly.getDegree() - p2.getDegree();
                double coef = poly.getCoefficient(poly.getDegree()) / p2.getCoefficient(p2.getDegree());
                
                Polynomial term = new Polynomial(coef, deg);
                poly = poly.sub(p2.mul(term));
                result = result.add(term);
            }
        return result;
    }
}

/**
 * Test class with main method for Polynomial class
 * @author Elis Turegun 21902976
 * @version 10.02.21
 */
public class Tester {
    public static void main (String [] args) {
        
        //variables
        
        final String SEPERATOR = "-----------------------------------";
        double[] arr = { 3,4,5,2};
        double[] arr2 = { 2,4,1};
        double[] arr3 = { 3,4,1};
        double[] arr4 = { 2,1};
        double[] arr7 = { 4,4,1};

        
        Polynomial p5 = new Polynomial( arr );
        Polynomial p4 = new Polynomial( arr2 );
        
        Polynomial p7 = new Polynomial( arr3 );
        Polynomial p8 = new Polynomial( arr4 );
        Polynomial p11 = new Polynomial( arr7 );
        
        
        Polynomial p6 = new Polynomial( 3,5 );
        Polynomial p12 = new Polynomial( 2,4);
        
        
        //program code
        
        
        System.out.println(p5.getCoefficient(3));
        System.out.println(p5.getDegree());
        System.out.println(p5.eval(2));
        System.out.println(p5.eval2(2));
        System.out.println(p5.toString());
        System.out.println(SEPERATOR);

        Polynomial p3 = new Polynomial( 4, 5 );
        System.out.println(p3.toString());
        System.out.println(p3.getCoefficient(3));
        System.out.println(p3.getDegree());
        System.out.println(p3.eval(2));
        System.out.println(p3.eval2(2));
        System.out.println(SEPERATOR);
        
        Polynomial p1 = new Polynomial();
        System.out.println(p1.toString());
        System.out.println(p1.getCoefficient(1));
        System.out.println(p1.getDegree());
        System.out.println(p1.eval(2));
        System.out.println(p1.eval2(2));
        System.out.println(SEPERATOR);
        
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println( p4.add(p5));
        System.out.println(SEPERATOR);
        
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println(p4.sub(p5));
        System.out.println(SEPERATOR);
        System.out.println(p7.toString());
        System.out.println(p8.toString());
        System.out.println(p7.compose(p8));
        System.out.println(SEPERATOR);
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println(p4.mul(p5));
        System.out.println(SEPERATOR);
        
        System.out.println(p6.toString());
        System.out.println( p12.toString());
        System.out.println( p6.add(p12));
        System.out.println(p6.sub(p12));
        System.out.println(p6.mul(p12));
        System.out.println(p6.compose(p12));
        
        
        System.out.println(p6.div(p12));
        System.out.println(SEPERATOR);
        System.out.println(p11.toString());
        System.out.println(p8.toString());
        System.out.println(p11.div(p8)); 
        
        
        System.out.println(SEPERATOR);

    }
}


