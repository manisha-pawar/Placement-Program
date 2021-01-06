import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        
        //s1 -> convert n from sourceBase to decimal
        int res = anyBaseToDecimal(n,sourceBase);
        
        //s2 -> convert res from decimal to destBase
        int ans = decimalToAnyBase(res,destBase);
        
        System.out.println(ans);
    }
    
    public static int anyBaseToDecimal(int n,int b) {
        int ans=0;
        int pow=1;
        
        while(n > 0) {
            int rd = n % 10;
            n = n / 10;
            
            ans = ans + rd*pow;
            pow = pow*b;
        }
        
        return ans;
    }
    
    public static int decimalToAnyBase(int n,int b) {
        int ans=0;
        int pow=1;
        
        while(n > 0) {
            int rem = n % b;
            n = n / b;
            
            ans = ans + rem*pow;
            pow = pow*10;
        }
        
        return ans;
    }
}
