import java.io.*;
import java.util.*;

public class Main {
    static String[] items = {
        "+-",
        "-+",
        "XX"
    };

    public static boolean countValid(int[] top, int[] left, int[] right, int[] bottom, char[][] ans) {
        //column traversal -> top,bottom
        for (int j = 0; j < ans[0].length; j++) {
            int p = 0;
            int m = 0;
            for (int i = 0; i < ans.length; i++) {
                if (ans[i][j] == '+') {
                    p++;
                } else if (ans[i][j] == '-') {
                    m++;
                }
            }

            if (top[j] != -1 && top[j] != p) {
                return false;
            }
            if (bottom[j] != -1 && bottom[j] != m) {
                return false;
            }
        }


        //row traversal -> left, right
        for (int i = 0; i < ans.length; i++) {
            int p = 0;
            int m = 0;
            for (int j = 0; j < ans[0].length; j++) {
                if (ans[i][j] == '+') {
                    p++;
                } else if (ans[i][j] == '-') {
                    m++;
                }
            }

            if (left[i] != -1 && left[i] != p) {
                return false;
            }
            if (right[i] != -1 && right[i] != m) {
                return false;
            }
        }

        return true;


    }

    public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans,
        int row, int col) {
        if (col == arr[0].length) {
            row++;
            col = 0;
        }

        if (row == arr.length) {
            //valid -> count
            if (countValid(top, left, right, bottom, ans) == true) {
                print(ans);
                return true;
            }
            return false;
        }

        char ch = arr[row][col];


        if (ch == 'L') {
            //place items horizontally
            for (int i = 0; i < 3; i++) {
                String item = items[i];
                if (isItSafe(ans, row, col, item, 'h')) {
                    //place
                    ans[row][col] = item.charAt(0);
                    ans[row][col + 1] = item.charAt(1);
                    //make call to next box
                    boolean isAns = solution(arr, top, left, right, bottom, ans, row, col + 2);
                    //unplace
                    ans[row][col] = 'e';
                    ans[row][col + 1] = 'e';

                    if (isAns == true) {
                        return true;
                    }
                }


            }
        } else if (ch == 'T') {
            //place items vertically
            for (int i = 0; i < 3; i++) {
                String item = items[i];
                if (isItSafe(ans, row, col, item, 'v')) {
                    //place
                    ans[row][col] = item.charAt(0);
                    ans[row + 1][col] = item.charAt(1);
                    //make call to next box
                    boolean isAns = solution(arr, top, left, right, bottom, ans, row, col + 1);
                    //unplace
                    ans[row][col] = 'e';
                    ans[row + 1][col] = 'e';

                    if (isAns == true) {
                        return true;
                    }
                }


            }

        } else {
            boolean isAns = solution(arr, top, left, right, bottom, ans, row, col + 1);
            if (isAns == true) {
                return true;
            }
        }

        return false;


    }

    public static boolean isItSafe(char[][] ans, int row, int col, String item, char marker) {
        char ch1 = item.charAt(0);
        char ch2 = item.charAt(1);

        if (item.equals("XX") == true) {
            return true;
        }

        if (marker == 'h') {
            //to check ch1 validity -> sign wise
            int r = row;
            int c = col;
            if ((r > 0 && ans[r - 1][c] == ch1) || (c > 0 && ans[r][c - 1] == ch1)) {
                return false;
            }
            //to check ch2 validity -> sign wise
            r = row;
            c = col + 1;
            if ((r > 0 && ans[r - 1][c] == ch2) || (c + 1 < ans[0].length && ans[r][c + 1] == ch2)) {
                return false;
            }
        } else {
            //to check ch1 validity -> sign wise
            int r = row;
            int c = col;
            if ((r > 0 && ans[r - 1][c] == ch1) || (c > 0 && ans[r][c - 1] == ch1) || (c + 1 < ans[0].length && ans[r][c + 1] == ch1)) {
                return false;
            }
            //to check ch2 validity -> sign wise
            r = row + 1;
            c = col;
            if ((c > 0 && ans[r][c - 1] == ch2)) {
                return false;
            }
        }

        return true;
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        char[][] arr = new char[m][n];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = scn.nextInt();
        }
        int[] left = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = scn.nextInt();
        }
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            right[i] = scn.nextInt();
        }
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            bottom[i] = scn.nextInt();
        }

        //write your code here
        char[][] ans = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = 'e';
            }
        }

        boolean isAns = solution(arr, top, left, right, bottom, ans, 0, 0);

        if (isAns == false) {
            System.out.println("No Solution");
        }
    }


}