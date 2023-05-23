 /**
    * This method converts numbers on decimal base to binary.
    * @param decimalNumber
    * @return binary version
    */
    public static String toBinary ( int decimalNumber ) {
        String firstStr;
        String binaryStr;
        int remainder;
        
        firstStr = "";
        binaryStr = "";
        
        do {
            remainder = decimalNumber % 2;
            firstStr = firstStr + remainder;
            decimalNumber = decimalNumber / 2;  
            
        } while ( decimalNumber > 0 );
        
        for ( int x = firstStr.length()-1; x >= 0; x-- ) {
            binaryStr = binaryStr + firstStr.charAt(x);
            
        }
        return binaryStr;    
    }
