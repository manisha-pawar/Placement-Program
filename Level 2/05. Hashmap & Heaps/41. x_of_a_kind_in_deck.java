class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int ele : deck) {
            int nf = map.getOrDefault(ele,0) + 1;
            map.put(ele,nf);
        }
        
        //find collective gcd of the frequencies
        int ans = 0;
        
        for(int key : map.keySet()) {
            ans = gcd(ans,map.get(key));
        }
        
        return ans > 1;
    }
    
    
    public static int gcd(int a,int b) {
        if(a == 0) {
            return b;
        }
        else if(b == 0) {
            return a;
        }
        
        int divisor = a;
        int dividend = b;
        
        while(dividend % divisor != 0) {
            int q = dividend / divisor;
            int rem = dividend % divisor;
            
            dividend = divisor;
            divisor = rem;
            
        }
        
        return divisor;
    }
}