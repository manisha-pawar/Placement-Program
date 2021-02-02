//Place N queens in n*n matrix (without any safety check)
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        placeNQueens(0,0,0,"",n); // i , j , queen places so far, path so far
    }
    
    public static void placeNQueens(int i,int j,int qpsf,String psf,int n) {
        if(i == n) {
            if(qpsf == n) {
                System.out.println(psf + " " + qpsf);
            }
            return;
        }
        
        //yes choice
        if(j+1 < n) {
            placeNQueens(i,j+1,qpsf+1,psf + i +"-" + j + "\t",n);
        }
        else {
            placeNQueens(i+1,0,qpsf+1,psf + i +"-" + j + "\t",n);
        }
        
        //no choice
        if(j+1 < n) {
            placeNQueens(i,j+1,qpsf,psf,n);
        }
        else {
            placeNQueens(i+1,0,qpsf,psf,n);
        }
    }

    // public static void printNQueens(int[][] chess, String qsf, int row) {

    // }
}
