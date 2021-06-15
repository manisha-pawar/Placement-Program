import java.io.*;
import java.util.*;

public class Main {


    public static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int conessf, ArrayList < ArrayList < Integer >> ans) {
        //write your code here

        if (vidx == arr.length) {
            if (conessf == k) {
                //if sum of each subset is equal or not
                for (int i = 0; i < subsetSum.length - 1; i++) {
                    if (subsetSum[i] != subsetSum[i + 1]) {
                        return;
                    }
                }

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print(ans.get(i) + " ");
                }
                System.out.println();

            }
            return;
        }

        int ce = arr[vidx];

        for (int s = 0; s < k; s++) {
            //to combine with non-empty
            if (ans.get(s).size() > 0) {
                ans.get(s).add(ce);
                subsetSum[s] += ce;
                solution(arr, vidx + 1, n, k, subsetSum, conessf, ans);
                ans.get(s).remove(ans.get(s).size() - 1);
                subsetSum[s] -= ce;
            }
            //to add in first empty subset
            else {
                ans.get(s).add(ce);
                subsetSum[s] += ce;
                solution(arr, vidx + 1, n, k, subsetSum, conessf + 1, ans);
                ans.get(s).remove(ans.get(s).size() - 1);
                subsetSum[s] -= ce;
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        // if k is equal to 1, then whole array is your answer 
        if (k == 1) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println("]");
            return;
        }
        //if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
        if (k > n || sum % k != 0) {
            System.out.println("-1");
            return;
        }
        int[] subsetSum = new int[k];
        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList < > ());
        }
        solution(arr, 0, n, k, subsetSum, 0, ans);
    }

}