//based on two type of faiths

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        print(1, 1, n);
    }

    public static void print(int r, int c, int n) {
        //base case
        if (r == n + 1) {
            return;
        }

        if (c < r) {
            System.out.print("*\t");
            //same row next col
            print(r, c + 1, n);
        } 
        else if (c == r) {
            //last star of 'r' row
            System.out.print("*\n");
            //next row first col
            print(r + 1, 1, n);
        }
    }
}
