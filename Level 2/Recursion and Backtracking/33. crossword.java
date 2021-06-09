import java.io.*;
import java.util.*;

public class Main {

    public static void solution(char[][] arr, String[] words, int vidx) {
        if (vidx == words.length) {
            print(arr);
            return;
        }

        String word = words[vidx];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                //to select a starting spot for word
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    //horizontally
                    if (canPlaceHorz(arr, i, j, word) == true) {
                        boolean[] pbm = placeHorz(arr, i, j, word); //placed by me
                        solution(arr, words, vidx + 1);
                        unplaceHorz(arr, i, j, word, pbm);
                    }

                    //vertically
                    if (canPlaceVert(arr, i, j, word) == true) {
                        boolean[] pbm = placeVert(arr, i, j, word);
                        solution(arr, words, vidx + 1);
                        unplaceVert(arr, i, j, word, pbm);
                    }

                }
            }
        }

    }

    public static boolean canPlaceHorz(char[][] arr, int i, int j, String word) {
        //to be a perfect fit
        int len = word.length();

        if (j > 0 && arr[i][j - 1] != '+') {
            return false;
        }
        if ((j + len > arr[0].length) || (j + len < arr[0].length && arr[i][j + len] != '+')) {
            return false;
        }

        //check every spot
        for (int c = 0; c < word.length(); c++) {
            if (arr[i][j + c] != '-' && arr[i][j + c] != word.charAt(c)) {
                return false;
            }
        }

        return true;

    }

    public static boolean[] placeHorz(char[][] arr, int i, int j, String word) {
        int len = word.length();
        boolean[] placedBM = new boolean[len]; //placed by me 

        for (int c = 0; c < len; c++) {
            if (arr[i][j + c] == '-') {
                arr[i][j + c] = word.charAt(c);
                placedBM[c] = true;
            }
        }

        return placedBM;
    }

    public static void unplaceHorz(char[][] arr, int i, int j, String word, boolean[] placedBM) {

        for (int c = 0; c < word.length(); c++) {
            if (placedBM[c] == true) {
                arr[i][j + c] = '-';
            }
        }

    }

    public static boolean canPlaceVert(char[][] arr, int i, int j, String word) {
        //to be a perfect fit
        int len = word.length();

        if (i > 0 && arr[i - 1][j] != '+') {
            return false;
        }
        if ((i + len > arr.length) || (i + len < arr.length && arr[i + len][j] != '+')) {
            return false;
        }

        //check every spot
        for (int r = 0; r < word.length(); r++) {
            if (arr[i + r][j] != '-' && arr[i + r][j] != word.charAt(r)) {
                return false;
            }
        }

        return true;

    }

    public static boolean[] placeVert(char[][] arr, int i, int j, String word) {
        int len = word.length();
        boolean[] placedBM = new boolean[len]; //placed by me 

        for (int r = 0; r < len; r++) {
            if (arr[i + r][j] == '-') {
                arr[i + r][j] = word.charAt(r);
                placedBM[r] = true;
            }
        }

        return placedBM;
    }

    public static void unplaceVert(char[][] arr, int i, int j, String word, boolean[] placedBM) {

        for (int r = 0; r < word.length(); r++) {
            if (placedBM[r] == true) {
                arr[i + r][j] = '-';
            }
        }

    }


    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }

        solution(arr, words, 0);

    }
}