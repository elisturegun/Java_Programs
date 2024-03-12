 /**
    * Taking a string and returns the reversed version
    * @param s string
    * @return result of reversing operation
    */
    public static String reverse ( String s ) {
        String resultReverse;
        
        resultReverse = "";
        
        for ( int i = s.length() - 1; i >= 0; i-- ) {
            resultReverse = resultReverse + s.charAt(i);
        }
        return resultReverse;
    }
    
