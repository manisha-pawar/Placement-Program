import java.io.*;
import java.util.*;

public class Main {

    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }


    public static void goldMine(int[][] gold) {
        int n = gold.length;
        int m = gold[0].length;

        int[][] dp = new int[n][m];

        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    dp[i][j] = gold[i][j];
                } else if (i == 0) {
                    //nbr -> d2,d3
                    dp[i][j] = gold[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == n - 1) {
                    //nbr -> d1,d2
                    dp[i][j] = gold[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                } else {
                    //nbr -> d1,d2,d2
                    dp[i][j] = gold[i][j] + Math.max(dp[i + 1][j + 1], Math.max(dp[i - 1][j + 1], dp[i][j + 1]));
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i][0] > ans) {
                ans = dp[i][0];
            }
        }

        System.out.println(ans);

        printPath(dp, ans);
    }


    public static void printPath(int[][] dp, int ans) {
        ArrayDeque < Pair > q = new ArrayDeque < > ();

        int n = dp.length;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == ans) {
                q.add(new Pair(i + " ", i, 0));
            }
        }


        while (q.size() > 0) {
            Pair rem = q.remove();

            int i = rem.i;
            int j = rem.j;
            String psf = rem.psf;

            if (j == dp[0].length - 1) {
                System.out.println(psf);
                continue;
            }


            if (i == 0) {
                //d2,d3
                int max = Math.max(dp[i][j + 1], dp[i + 1][j + 1]);

                if (dp[i][j + 1] == max) {
                    q.add(new Pair(psf + "d2 ", i, j + 1));
                }
                if (dp[i + 1][j + 1] == max) {
                    q.add(new Pair(psf + "d3 ", i + 1, j + 1));
                }
            } else if (i == n - 1) {
                //d1,d2
                int max = Math.max(dp[i - 1][j + 1], dp[i][j + 1]);

                if (dp[i - 1][j + 1] == max) {
                    q.add(new Pair(psf + "d1 ", i - 1, j + 1));
                }
                if (dp[i][j + 1] == max) {
                    q.add(new Pair(psf + "d2 ", i, j + 1));
                }
            } else {
                //d1,d2,d3
                int max = Math.max(dp[i + 1][j + 1], Math.max(dp[i - 1][j + 1], dp[i][j + 1]));

                if (dp[i - 1][j + 1] == max) {
                    q.add(new Pair(psf + "d1 ", i - 1, j + 1));
                }
                if (dp[i][j + 1] == max) {
                    q.add(new Pair(psf + "d2 ", i, j + 1));
                }
                if (dp[i + 1][j + 1] == max) {
                    q.add(new Pair(psf + "d3 ", i + 1, j + 1));
                }

            }

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        //write your code here
        goldMine(arr);
    }


}