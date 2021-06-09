import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isItSafe(int[][] board, int i, int j, int d) {
        //check in ith row
        for (int c = 0; c < board[0].length; c++) {
            if (board[i][c] == d) {
                return false;
            }
        }

        //check in jth row
        for (int r = 0; r < board.length; r++) {
            if (board[r][j] == d) {
                return false;
            }
        }

        //check in submatrix
        int smrs = (i / 3) * 3; //sub-matrix row start
        int smcs = (j / 3) * 3; //sub-matrix col start

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[smrs + r][smcs + c] == d) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void solveSudoku(int[][] board, int i, int j) {
        if (j == board[0].length) {
            i++;
            j = 0;
        }

        if (i == board.length) {
            display(board);
            return;
        }

        if (board[i][j] == 0) {
            for (int d = 1; d <= 9; d++) {
                if (isItSafe(board, i, j, d) == true) {
                    board[i][j] = d;
                    solveSudoku(board, i, j + 1);
                    board[i][j] = 0;
                }
            }
        } else {
            solveSudoku(board, i, j + 1);
        }


    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }
}