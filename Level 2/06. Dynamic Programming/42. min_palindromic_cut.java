//T : O(n^3)
class Solution {
    public static int minPalindromicCut(String s) {
        //write your code here

        int[][] dp = new int[s.length()][s.length()];

        for (int d = 0; d < dp.length; d++) {
            for (int i = 0, j = d; j < dp[0].length; i++, j++) {
                if (d == 0) {
                    dp[i][j] = 0;
                } else if (d == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int lans = dp[i][k];
                        int rans = dp[k + 1][j];

                        if (lans + rans < min) {
                            min = lans + rans;
                        }
                    }

                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[0][dp[0].length - 1];
    }
}



//T : O(n^2)
class Solution {
    public int minCut(String s) {

        int[] dp = new int[s.length()];
        boolean[][] pal = longestPalSubstring(s);

        //dp[i] -> i to end
        dp[dp.length - 1] = 0;

        for (int i = dp.length - 2; i >= 0; i--) {

            if (pal[i][s.length() - 1] == true) {
                dp[i] = 0;
                continue;
            }

            int min = Integer.MAX_VALUE;

            //to select a valid prefix
            for (int k = i; k < dp.length - 1; k++) {
                if (pal[i][k] == true) {
                    min = Math.min(min, dp[k + 1]);
                }
            }

            dp[i] = min + 1;
        }

        return dp[0];
    }

    public static boolean[][] longestPalSubstring(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int d = 0; d < dp.length; d++) {
            for (int i = 0, j = d; j < dp[0].length; i++, j++) {
                if (d == 0) {
                    dp[i][j] = true;
                } else if (d == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) ? true : false;
                }
            }
        }

        return dp;
    }
}