 /**
    * This method converts numbers based on binary system to decimal.
    * @param base2 is a string parameter
    * @return decimal number 
    */
    public static int toDecimal ( String base2 ) {
        double base10;
        
        base10 = 0;
        base2 = base2.replaceAll("\\s", "");

        for ( int k = 0; k <= base2.length() - 1; k++ ) {
            if ( base2.charAt(k) == '1' ) {
                base10 = base10 + power ( 2, base2.length() - k - 1 ); 
            }
        }
        return (int) base10;  
    }
    
