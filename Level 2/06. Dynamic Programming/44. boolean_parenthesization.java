//https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1

//simple
class Solution{
    static class Pair {
        int tc;
        int fc;
        
        Pair() {
            
        }
        
        Pair(int tc,int fc) {
            this.tc = tc;
            this.fc = fc;
        }
    }
    
    static int countWays(int N, String S){
        
        String s1 = ""; //operands
        String s2 = ""; //operators
        
        for(int i=0; i < S.length();i++) {
            if(S.charAt(i) == 'T' || S.charAt(i) == 'F') {
                s1 += S.charAt(i);
            }
            else {
                s2 += S.charAt(i);
            }
        }
        
        
        Pair[][]dp = new Pair[s1.length()][s1.length()];
        
        for(int d=0;d < dp.length;d++) {
            for(int i=0,j=d; j < dp[0].length;i++,j++) {
                if(d == 0) {
                    int tc = s1.charAt(i) == 'T' ? 1 : 0;
                    int fc = s1.charAt(i) == 'F' ? 1 : 0;
                    
                    dp[i][j] = new Pair(tc,fc);
                }
                else if(d == 1) {
                    boolean op1 = s1.charAt(i) == 'T' ? true : false;
                    boolean op2 = s1.charAt(j) == 'T' ? true : false;
                    char opr = s2.charAt(i);
                    
                    dp[i][j] = calculate(op1,op2,opr);
                }
                else {
                    int tc = 0;
                    int fc = 0;
                    
                    for(int k = i; k < j;k++) {
                        Pair lans = dp[i][k];
                        Pair rans = dp[k+1][j];
                        
                        Pair ans = helper(lans,rans,s2.charAt(k));
                        tc += ans.tc;
                        fc += ans.fc;
                    }
                    dp[i][j] = new Pair(tc,fc);
                }
            }
        }
        

        Pair ans = dp[0][dp[0].length-1];
        return ans.tc;
    }
    
    
    public static Pair calculate(boolean op1,boolean op2, char opr) {
        boolean res = false;
        
        if(opr == '|') {
            res = op1 | op2;
        }
        else if(opr == '&') {
            res = op1 & op2;
        }
        else {
            res = op1 ^ op2;
        }
        
        if(res == true) {
            return new Pair(1,0);
        }
        else {
            return new Pair(0,1);
        }
    }
    
    public static Pair helper(Pair lans,Pair rans,char opr) {
        int lt = lans.tc;
        int lf = lans.fc;
        int rt = rans.tc;
        int rf = rans.fc;
        
        int tc = 0;
        int fc = 0;
        
        if(opr == '|') {
            tc = lt * rt + lt * rf + lf * rt;
            fc = lf * rf;
        }
        else if(opr == '&') {
            tc = lt * rt;
            fc = lt * rf + lf * rt + lf * rf;
        }
        else {
            tc = lt * rf + lf * rt;
            fc = lt * rt + lf * rf;
        }
        
        return new Pair(tc,fc);
    }

}





//by applying modulo as asked by question
class Solution{
    static int m = 1003;
    
    static class Pair {
        int tc;
        int fc;
        
        Pair() {
            
        }
        
        Pair(int tc,int fc) {
            this.tc = tc;
            this.fc = fc;
        }
    }
    
    static int countWays(int N, String S){
        
        String s1 = ""; //operands
        String s2 = ""; //operators
        
        for(int i=0; i < S.length();i++) {
            if(S.charAt(i) == 'T' || S.charAt(i) == 'F') {
                s1 += S.charAt(i);
            }
            else {
                s2 += S.charAt(i);
            }
        }
        
        
        Pair[][]dp = new Pair[s1.length()][s1.length()];
        
        for(int d=0;d < dp.length;d++) {
            for(int i=0,j=d; j < dp[0].length;i++,j++) {
                if(d == 0) {
                    int tc = s1.charAt(i) == 'T' ? 1 : 0;
                    int fc = s1.charAt(i) == 'F' ? 1 : 0;
                    
                    dp[i][j] = new Pair(tc,fc);
                }
                else if(d == 1) {
                    boolean op1 = s1.charAt(i) == 'T' ? true : false;
                    boolean op2 = s1.charAt(j) == 'T' ? true : false;
                    char opr = s2.charAt(i);
                    
                    dp[i][j] = calculate(op1,op2,opr);
                }
                else {
                    int tc = 0;
                    int fc = 0;
                    
                    for(int k = i; k < j;k++) {
                        Pair lans = dp[i][k];
                        Pair rans = dp[k+1][j];
                        
                        Pair ans = helper(lans,rans,s2.charAt(k));
                        tc =  (tc % m + ans.tc % m) % m;
                        fc =  (fc % m + ans.fc % m) % m;
                    }
                    dp[i][j] = new Pair(tc,fc);
                }
            }
        }
        

        Pair ans = dp[0][dp[0].length-1];
        return ans.tc;
    }
    
    
    public static Pair calculate(boolean op1,boolean op2, char opr) {
        boolean res = false;
        
        if(opr == '|') {
            res = op1 | op2;
        }
        else if(opr == '&') {
            res = op1 & op2;
        }
        else {
            res = op1 ^ op2;
        }
        
        if(res == true) {
            return new Pair(1,0);
        }
        else {
            return new Pair(0,1);
        }
    }
    
    public static Pair helper(Pair lans,Pair rans,char opr) {
        int lt = lans.tc;
        int lf = lans.fc;
        int rt = rans.tc;
        int rf = rans.fc;
        
        int tc = 0;
        int fc = 0;
        
        if(opr == '|') {
            tc = (((lt % m * rt % m) % m + (lt % m * rf % m) % m) % m + ( lf % m * rt % m) % m) % m;
            fc = (lf  % m * rf % m) % m;
        }
        else if(opr == '&') {
            tc = (lt % m * rt % m) % m;
            fc = (((lt  % m * rf % m) % m + (lf  % m * rt % m) % m) % m + (lf % m * rf % m) % m) % m;
        }
        else {
            tc = ((lt % m * rf % m) % m + ( lf % m  * rt % m) % m) % m;
            fc = ((lt % m * rt % m) + (lf % m * rf % m)) % m;
        }
        
        return new Pair(tc,fc);
    }

}