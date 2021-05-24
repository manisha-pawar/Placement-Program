//place N queens in n*n board(such that all queens are safe)
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[][]mat=new int[n][n];
        printNQueens(mat,"",0);
    }

    public static void printNQueens(int[][] chess, String psf, int row) {
        if(row == chess.length) {
            System.out.println(psf+".");
            return;
        }
        
        for(int col = 0; col < chess.length;col++) {
            if(isQueenSafe(chess,row,col) == true) {
                chess[row][col] = 1;
                printNQueens(chess,psf + row + "-" + col+", ",row+1);
                chess[row][col] = 0;
            }
        }
    }
    
    public static boolean isQueenSafe(int[][]chess,int row,int col) {
        //upper side - col check
        for(int i=row-1;i>=0;i--) {
            if(chess[i][col] == 1) {
                return false;
            }
        }
        
        //upper side left diagonal
        for(int i=row-1,j=col-1; i >= 0 && j >= 0 ; i--,j--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        
        //upper side right diagonal
        for(int i=row-1,j=col+1; i >= 0 && j < chess.length ; i--,j++) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
}
