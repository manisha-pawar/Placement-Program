import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int N, int[][] chess){
        if(qpsf == N) {
            //print answer
            for(int i=0; i < N;i++) {
                for(int j=0; j < N;j++) {
                    if(chess[i][j] == 0) {
                        System.out.print("-	");
                    }
                    else {
                        System.out.print("q" + chess[i][j] + "	");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        //which box to select
        for(int i=0; i < N;i++) {
            for(int j=0; j < N;j++) {
                if(chess[i][j] == 0) {
                    chess[i][j] = qpsf+1;
                    queensPermutations(qpsf+1,N,chess);
                    chess[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}