import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int[] coins, int rem_tar,int lci, String asf) {
       if(rem_tar < 0) {
           return;
       }
       
       if(rem_tar == 0) {
           System.out.println(asf + ".");
           return;
       }
       
       for(int i = lci; i < coins.length;i++) {
           coinChange(coins,rem_tar-coins[i],i,asf + coins[i] + "-");
       }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(coins,amt,0,"");
    }
}