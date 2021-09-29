import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int leastNoSquares = count(n);
        System.out.println(leastNoSquares);

    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as an integer
    // It should return the required output

    private static int count(int n) {
        //Write your code here
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - (j * j)], min);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }
}