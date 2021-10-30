import java.util.*;

public class Main {

    // This is a functional problem. You have to complete this function.
    // It takes as input an integer array. It should return
    // the required array.
    public static int[] sortedSquares(int[] A) {

        int[] narr = new int[A.length];
        int k = A.length - 1;

        int i = 0;
        int j = A.length - 1;

        while (i <= j) {
            if (A[i] * A[i] > A[j] * A[j]) {
                narr[k] = A[i] * A[i];
                i++;
            } 
            else {
                narr[k] = A[j] * A[j];
                j--;
            }
            k--;
        }

        return narr;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of array.
        int length = sc.nextInt();

        int[] arr = new int[length];

        // Input for elements of array.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = sortedSquares(arr);
        display(result);

    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}