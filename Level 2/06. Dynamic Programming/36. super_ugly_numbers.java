//way 1 , T : O(n*k)
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[]dp = new int[n+1];
        int[]ptr = new int[primes.length];
        
        Arrays.fill(ptr,1);
        
        dp[1] = 1;
        
        for(int i=2; i <= n;i++) {
            
            //contendors
            int min = Integer.MAX_VALUE;
    
            for(int k=0; k < primes.length;k++) {
                int c = primes[k] * dp[ptr[k]];
                min = Math.min(min,c);
            }
            
            dp[i] = min;
            
            for(int k=0; k < primes.length;k++) {
                int c = primes[k] * dp[ptr[k]];
                
                if(c == min) {
                    ptr[k]++;
                }
            }
            
        }
        
        return dp[n];
    }
}


//way 2 , T : O(n*logk)
class Solution {
    public static class Pair implements Comparable<Pair>{
        int prime;
        int ptr;
        int val;
        
        Pair() {
            
        }
        
        Pair(int prime,int ptr,int val) {
            this.prime = prime;
            this.ptr = ptr;
            this.val = val;
        }
        
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
        
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[]dp = new int[n+1];
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        
        for(int i=0; i < primes.length;i++) {
            Pair p = new Pair(primes[i],1,primes[i]*1);
            pq.add(p);
        }
        
        dp[1] = 1;
        
        for(int i=2; i <= n;) {
            Pair top = pq.remove();
            
            if(dp[i-1] != top.val) {
                dp[i] = top.val;
                i++;
            }
            
            int np = top.ptr + 1;
            int nv = (top.prime)*(dp[top.ptr]);
            
            pq.add(new Pair(top.prime,np,nv));
            
        }
        
        return dp[n];
    }
}
