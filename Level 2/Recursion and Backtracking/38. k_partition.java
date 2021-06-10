import java.io.*;
import java.util.*;

public class Main {

    static int counter = 1;

    //conessf -> count of non-empty subset so far
    public static void solution(int i, int n, int k, int conessf, ArrayList < ArrayList < Integer >> ans) {
        if (i > n) {
            if (conessf == k) {
                System.out.print(counter + ". ");
                for (int s = 0; s < ans.size(); s++) {
                    System.out.print(ans.get(s) + " ");
                }
                System.out.println();
                counter++;
            }
            return;
        }

        for (int s = 0; s < k; s++) {
            //to combine with non-empty subsets
            if (ans.get(s).size() > 0) {
                ans.get(s).add(i);
                solution(i + 1, n, k, conessf, ans);
                ans.get(s).remove(ans.get(s).size() - 1);
            }
            //to add in first empty subset
            else {
                ans.get(s).add(i);
                solution(i + 1, n, k, conessf + 1, ans);
                ans.get(s).remove(ans.get(s).size() - 1);
                break;
            }

        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList < > ());
        }
        solution(1, n, k, 0, ans);

    }

}