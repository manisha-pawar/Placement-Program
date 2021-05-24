//place N Queens in n*n box such that each row contains a queen(without safety check)
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        placeNQueens(0,"",n); // i , j , queen places so far, path so far
    }
    
    public static void placeNQueens(int row,String psf,int n) {
        if(row == n) {
            System.out.println(psf);
            return;
        }
        
        for(int col=0;col < n;col++) {
            //place queen at row,col
            placeNQueens(row+1,psf+row+"-"+col+" ",n);
        }
        
    }

    // public static void printNQueens(int[][] chess, String qsf, int row) {

    // }
}
