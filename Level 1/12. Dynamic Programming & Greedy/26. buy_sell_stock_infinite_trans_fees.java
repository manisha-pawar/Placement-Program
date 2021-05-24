import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[]prices = new int[n];
        
        for(int i=0;i<n;i++) {
            prices[i] = scn.nextInt();
        }
        
        int fees = scn.nextInt();
        int ans = infiniteTranscnFees(prices,fees);
        
        System.out.println(ans);
    }
    
    public static int infiniteTranscnFees(int[]prices,int fees) {
        int obdp = -prices[0]; // old buy day profit 'ending at buy'
        int osdp = 0; //old sell day profit 'ending at sell'
        
        for(int i=1; i < prices.length;i++) {
            int nbdp = 0;
            int nsdp = 0;
            
            //new buy day profit
            if(osdp - prices[i] < obdp) {
                nbdp = obdp;
            }
            else {
                nbdp = osdp - prices[i];
            }
            
            //new sell day profit
            if(obdp + prices[i] - fees < osdp) {
                nsdp = osdp;
            }
            else {
                nsdp = obdp + prices[i] - fees;
            }
            
            osdp = nsdp;
            obdp = nbdp;
        }
        
        return osdp;
    }

}