import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int y = solution(n - 1, k);
        int x = (y + k) % n;

        return x;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n, k));
    }

}