import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int N, boolean[][] chess, int lcno) {
        if(qpsf == N) {
            for(int i=0; i < N;i++) {
                for(int j=0; j < N;j++) {
                    if(chess[i][j] == true) {
                        System.out.print("q	");
                    }
                    else {
                        System.out.print("-	");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int b = lcno+1; b < N*N;b++) {
            int i = b / N;
            int j = b % N;
            
            chess[i][j] = true;
            queensCombinations(qpsf+1,N,chess,b);
            chess[i][j] = false;
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}