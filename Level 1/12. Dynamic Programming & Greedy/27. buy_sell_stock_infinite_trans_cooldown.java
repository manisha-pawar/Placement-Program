import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]prices = new int[n];
        
        for(int i=0;i < n;i++) {
            prices[i] = scn.nextInt();
        }
        
        int ans = infiniteTranscnCooldown(prices);
        
        System.out.println(ans);
    }
    
    public static int infiniteTranscnCooldown(int[]prices) {
        int obdp = -prices[0]; //old buy day profit
        int osdp = 0; // old sell day profit
        int ocdp = 0; //old cooldown day profit
        
        for(int i=1; i < prices.length;i++) {
            int nbdp = 0;
            int nsdp = 0;
            int ncdp = 0;
            
            //new buy day profit
            if(ocdp - prices[i] < obdp) {
                nbdp = obdp;
            }
            else {
                nbdp = ocdp - prices[i];
            }
            
            //new sell day profit
            if(obdp + prices[i] < osdp) {
                nsdp = osdp;
            }
            else {
                nsdp = obdp + prices[i];
            }
            
            //new cooldown day profit
            if(osdp < ocdp) {
                ncdp = ocdp;
            }
            else {
                ncdp = osdp;
            }
            
            obdp = nbdp;
            osdp = nsdp;
            ocdp = ncdp;
        }
        
        return osdp;
    }

}