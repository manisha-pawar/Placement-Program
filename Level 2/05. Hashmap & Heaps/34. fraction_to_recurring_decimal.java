class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        
        boolean flag = true; //pos
        
        if(numerator < 0 && denominator < 0) {
            //num and den both are -ve
            flag = true;
        }
        else if(numerator < 0) {
            //only num is -ve
            flag = false;    
        }
        else if(denominator < 0) {
            //only den is negative
            flag = false;
        }
        else {
            //both num and den are +ve
            flag = true;
        }
        
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
       
        long q = num / den;
        long rem = num % den;
        
        
        String p1 = q + "";
        String p2 = "";
        
        HashMap<Long,Integer>map = new HashMap<>(); //rem vs pos
        
      
        if(rem == 0) {
            //this division is settled
            if(flag == true) {
                return p1;
            }
            else {
                return  "-" + p1;
            }
        }
        else {
            while(rem != 0) {
                if(map.containsKey(rem) == true) {
                    int pos = map.get(rem);
                    p2 = p2.substring(0,pos) + "(" + p2.substring(pos) + ")";
                    break;
                }
                
                map.put(rem,p2.length());
                
                num = rem*10;
                q = num / den;
                rem = num % den;
                p2 += q;
            }
        }
        
        if(flag == true) {
            return p1 + "." + p2;
        }
        else {
            return  "-" + p1 + "." + p2;
        }
        
    }
}