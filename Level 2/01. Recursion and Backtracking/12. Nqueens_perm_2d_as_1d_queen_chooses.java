import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        //vertical
        for(int i=0; i < chess.length;i++) {
            if(chess[i][col] != 0) {
                return false;
            }
        }
        
        //horizontal
        for(int j=0; j < chess.length;j++) {
            if(chess[row][j] != 0) {
                return false;
            }
        }
        
        //top-left
        for(int i=row-1,j=col-1; i >= 0 && j >= 0 ;i--,j--) {
            if(chess[i][j] != 0) {
                return false;
            }
        }
        
        
        //top-right
        for(int i=row-1,j=col+1; i >= 0 && j < chess.length ;i--,j++) {
            if(chess[i][j] != 0) {
                return false;
            }
        }
        
        //bottom-left
        for(int i=row+1,j=col-1; i < chess.length && j >= 0 ;i++,j--) {
            if(chess[i][j] != 0) {
                return false;
            }
        }
        
        //bottom-right
        for(int i=row+1,j=col+1; i < chess.length && j < chess.length ;i++,j++) {
            if(chess[i][j] != 0) {
                return false;
            }
        }
        
        return true;
        
        
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if(qpsf == tq) {
            for(int i=0; i < chess.length;i++) {
                for(int j=0; j < chess.length;j++) {
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
        
        for(int b = 0; b < chess.length*chess.length;b++) {
            int i = b / chess.length;
            int j = b % chess.length;
            
            if(chess[i][j] == 0 && IsQueenSafe(chess,i,j)) {
                chess[i][j] = qpsf+1;
                nqueens(qpsf+1,tq,chess);
                chess[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}